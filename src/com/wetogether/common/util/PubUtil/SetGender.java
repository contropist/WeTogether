package com.wetogether.common.util.PubUtil;

public class SetGender {
	public static final String GENDER_CODE_1 = "纯爷们";
	public static final String GENDER_CODE_2 = "女汉子";
	public static final String GENDER_CODE_6 = "未知";
	
	public static String setGender(Integer code){
		switch(code){
			case 1:
				return SetGender.GENDER_CODE_1;
			case 2:	
				return SetGender.GENDER_CODE_2;
			default:
				return SetGender.GENDER_CODE_6;
				
		}
			
	}
	
}
