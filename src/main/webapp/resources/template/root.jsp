<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

  <head>
	  <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="/resources/include/assets/js/bootstrap.min.js"></script>
	    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	    <script src="/resources/include/admin/assets/js/vendor/holder.min.js"></script>
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <script src="/resources/include/admin/assets/js/ie10-viewport-bug-workaround.js"></script>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="/resources/include/js/chk.js"></script>
	<link rel="stylesheet" href="/resources/include/css/bootstrap.css" />
	<script src="/resources/include/js/bootstrap.min.js"></script>
  
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title><tiles:insertAttribute name="title"/></title>
    <link rel="stylesheet" href="/resources/include/assets/css/main.css" />
   <script>
    $(function(){
    	$("#loding").hide();
    	$("#searchbtn").click(function(){
    		
    		var keyword=$("#keyword").val();
    	    var parm="keyword="+keyword;
    	    if(keyword==null || keyword==""){
    	    	alert("키워드를 입력해주세요!");
    	    	return;
    	    }
    	    
    		
    		 $.ajax({
				 url:"/whale/search.do",
				 data:parm,
				 success:function(data){
					 
					
					 $("#wordimg").append("<img src=/output/cloud_"+keyword+".png />");
				 },beforeSend:function(){
				       
					  $('.wrap-loading').removeClass('display-none');
				    }
				    ,complete:function(){
				       $('.wrap-loading').addClass('display-none');
				 
				    }
				 
				    
				 
			 })
    		
    		
    	})
    
    	
    	
    	
    })
   
   
   </script>
   
  
   
<style type="text/css" >
body{
    height:100%;
    width:100%;
}

.wrap-loading{ /*화면 전체를 어둡게 합니다.*/
    position: fixed;
    left:0;
    right:0;
    top:0;
    bottom:0;
    background: rgba(0,0,0,0.2); /*not in ie */
    filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000', endColorstr='#20000000');    /* ie */
    
}
    .wrap-loading div{ /*로딩 이미지*/
        height: 100px;
        width:100px;
        position: relate;
        margin: 300px auto;
        
    }
    .display-none{ /*감추기*/
        display:none;
    }
   </style>
  </head>
<body>
   
		<!-- Banner -->
			<section id="banner">
			 <div class="row">
		      <div class="col-sm-10">
				
		 
		      
		      <div class="col-sm-5 col-sm-offset-5">
			<h1>Whalede ${result}</h1>
				<p>이슈를 한번에 한글 워드 클라우드 서비스</p>
			<form id="searchform">
			<input type="text" class="form-control" id="keyword" name="keyword" />
			<input type="button" class="btn btn-default" id="searchbtn" name="searchbtn" value="search"/>
			</form>
			
			  </div>
			  </div>
			
			</section>
			

		<!-- One -->
			<section id="one" class="wrapper">
				<div class="inner">
					
						  <tiles:insertAttribute name="body"/>
					
				</div>
			</section>


		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<div class="flex">
						<div class="copyright">
							&copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
						</div>
						<ul class="icons">
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-linkedin"><span class="label">linkedIn</span></a></li>
							<li><a href="#" class="icon fa-pinterest-p"><span class="label">Pinterest</span></a></li>
							<li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>
						</ul>
					</div>
				</div>
			</footer>
            <div class="wrap-loading display-none">
              <div>
              <img src="/resources/include/images/loading.gif"  height= "70" width="70" alt="" />
              </div>
            </div>
   
   
  
	
    
  
</body>
</html>