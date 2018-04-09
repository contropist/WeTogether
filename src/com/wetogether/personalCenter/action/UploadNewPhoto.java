package com.wetogether.personalCenter.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wetogether.common.hibernate.pojos.Album;
import com.wetogether.common.hibernate.pojos.OriginalSignature;
import com.wetogether.common.hibernate.pojos.Photo;
import com.wetogether.common.hibernate.pojos.User;
import com.wetogether.common.util.CodeCst;
import com.wetogether.personalCenter.service.IPersonalCenterServices;

public class UploadNewPhoto extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private IPersonalCenterServices iPersonalCenterServices;
	private Integer albumId;
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	private HttpServletRequest request;
	private User sessionUser = (User)ActionContext.getContext().getSession().get(CodeCst.SESSION_USER_NAME);
	public String uploadPhoto() throws IOException{
		request = ServletActionContext.getRequest();
		for(int i = 0;i<file.size();i++){
			Photo p = new Photo();
			p.setPhotoName(fileFileName.get(i));
			Album a = new Album();
			a.setAlbumId(albumId);
			p.setAlbumId(a);
			p.setPhotoSrc(CodeCst.PHOTO_DEFAULT_URL);
			this.iPersonalCenterServices.addNewPhoto(p);
			p = this.iPersonalCenterServices.findDefaultUrlPhoto(albumId).get(0);
//	        File filelServer = new File(CodeCst.PHOTO_BASE_URL+"_"+albumId+"_"+p.getPhotoId()+".png");
//	        File fileLocal = new File(CodeCst.PHOTO_BASEPATH_LOCAL+"_"+albumId+"_"+p.getPhotoId()+".png");
			String basePath = request.getSession().getServletContext().getRealPath("")+"\\web\\img\\photo"; 
			System.out.println(basePath);
	        InputStream is = new FileInputStream(file.get(i));
            
            //得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
	        String fileName = fileFileName.get(i);
	        String [] strs = fileName.split("[.]");
	        String finalName ="photo_"+albumId+"_"+p.getPhotoId()+"."+strs[1]; 
            File destFile = new File(basePath,finalName);
            System.out.println(basePath+finalName);
            
            //把图片写入到上面设置的路径里
            OutputStream os = new FileOutputStream(destFile);
            byte[] buffer = new byte[400];
            int length  = 0 ;
            while((length = is.read(buffer))>0){
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            //这里可能需要再加一个存往本地的流。类似upload.jsp页面
            p.setPhotoSrc("/WeTogether/web/img/photo/"+finalName);
            this.iPersonalCenterServices.updatePhoto(p);
            OriginalSignature originalSignature = new OriginalSignature(); 
            String osContent="<span style='color:grey;'>上传了图片</span><br><br><img src=\""+p.getPhotoSrc()+"\" style=\"width:400px;height:360px;\">";
            System.out.println(osContent);
            originalSignature.setOsContent(osContent);
            this.iPersonalCenterServices.addNewOs(sessionUser,originalSignature );
			
		}
		                    
		
		            
		
		
		                     
		return SUCCESS;
	}

	public IPersonalCenterServices getiPersonalCenterServices() {
		return iPersonalCenterServices;
	}

	public void setiPersonalCenterServices(
			IPersonalCenterServices iPersonalCenterServices) {
		this.iPersonalCenterServices = iPersonalCenterServices;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
}
