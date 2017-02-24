 	
var auth="";
$(function(){
		 var auth="${login.auth}"
		 
		 logincheck()    
		 $("#btn").click(function(){
		 alert("로그인")
		     $("#loginform").attr({
		    	 "method":"post",
		    	  "action":"/member/login.do"
		    	 	    	 
		     })
		     $("#loginform").submit();
		 
		 })
	    
		/*  
		 $("#btn").click(function(){
			 var id=$("userid").val();
			 var pw=$("userpw").val();
			 var param="?userid="+id+"&userpw="+pw
			 $.ajax({
				 url : "admin2/login.do",
				 type: "post",
				 data: param,
				 success:function(data){
					 if(data=="success")
					 alert("로그인 성공")	 
					 
				 }, error:function(jqXHR, textStatus, errorThrown){
			            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
			            self.close();
			     }
				 
				 
			 })
			  
			 
		 })
		 */
		 
		 
	 })
	 
	 
	 
	 function logincheck(){
		 var login="${login.auth}";
		 if(login=="false"){
			 alert("로그인 실패 했습니다.")
		 }
		 if(login=="true"){
			 $("#loginform").hide();
			 $("#loginpo").text("${login.username}님 로그인 성공")
		 }
		 
	 }
	 
