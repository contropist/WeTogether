function startTime() {
	var today = new Date();
	var y = today.getFullYear();
	var d = today.getDay();
	var mon = today.getMonth();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	// add a zero in front of numbers<10
	m = checkTime(m);
	s = checkTime(s);
	mon = checkTime(mon);
	document.getElementById('dateButton').value = y + "年" + (mon+1) + "月" + (d+1)+"日";
	document.getElementById('timeButton').value = h + ":" + m + ":" + s;
	t = setTimeout('startTime()', 500);
}

function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}