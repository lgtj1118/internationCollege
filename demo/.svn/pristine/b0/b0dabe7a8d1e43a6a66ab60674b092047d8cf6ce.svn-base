$(document).ready(function(){			
	var nowDate = new Date();
	var nowYear = nowDate.getFullYear();
	var lastYear = parseInt(nowYear)-1;
	var before = parseInt(lastYear)-1;
	var nextYear = parseInt(nowYear)+1;
	var nowuptext = lastYear+"-"+nowYear+"学年第一学期";//2014-2015
	var nowupvalue = lastYear+"01";
	var nowdowntext = lastYear+"-"+nowYear + "学年第二学期";
	var nowdownvalue = nowYear+"02";
	var lastuptext = before+"-"+lastYear+"学年第一学期";
	var lastupvalue = before+"01";
	var lastdowntext = before+"-"+lastYear+"学年第二学期";
	var lastdownvalue = lastYear+"02";
	var nextuptext = nowYear+"-"+nextYear+"学年第一学期";
	var nextupvalue = nowYear+"01";
	var nextdowntext = nowYear+"-"+nextYear+"学年第二学期";
	var nextdownvalue = nextYear+"02";
	var semester = document.getElementById("semester");
	var objOption=document.createElement("OPTION"); 
    var objOption1=document.createElement("OPTION");
    var objOption2=document.createElement("OPTION"); 
    var objOption3=document.createElement("OPTION"); 
    var objOption4=document.createElement("OPTION"); 
    var objOption5=document.createElement("OPTION"); 
    objOption.value=nowupvalue;   objOption.text=nowuptext;
    objOption1.value=nowdownvalue;  objOption1.text=nowdowntext;
    objOption2.value=lastupvalue;  objOption2.text=lastuptext;
    objOption3.value=lastdownvalue;  objOption3.text=lastdowntext;
    objOption4.value=nextupvalue;  objOption4.text=nextuptext;
    objOption5.value=nextdownvalue;  objOption5.text=nextdowntext;
    var month = nowDate.getMonth();
	var now;
	if (month > 9) {
		now = nowYear + "01";
	} else {
		now = nowYear + "02";
	}
	if(now==nowupvalue){
		semester.add(objOption2);
        semester.add(objOption3);
        semester.add(objOption);
        semester.options[semester.options.length-1].selected='selected';
        semester.add(objOption1);                
        semester.add(objOption4);
        semester.add(objOption5);        		
	}else if(now==nowdownvalue) {
		semester.add(objOption2);
        semester.add(objOption3);
        semester.add(objOption);        
        semester.add(objOption1); 
        semester.options[semester.options.length-1].selected='selected';
        semester.add(objOption4);
        semester.add(objOption5);
	}
        
    
})