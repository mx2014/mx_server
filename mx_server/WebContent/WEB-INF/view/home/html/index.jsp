<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title></title>
<script type="text/javascript" src="<%=basePath%>home/js/jquery.js"></script>
</head>

<body>
	<a href="index2?user_name=zxc&iphone_type=1&login_ip=lkj&mac_adress=poi"> simple</a><button onclick="simple()">simple</button><br/>  
<a href="simple1?name=text&age=28"> simple1</a><button onclick="simple1()">simple1</button><br/>  
<script type="text/javascript">  
function simple(){  
  $.getJSON("test",{"name":"nameJsonTest","age":"100"},  
    function(){});  
}    
function simple1(){    
  $.getJSON("test1",  
    {"name":"nameJsonTest","age":"100","phone":"120"},  
    function(){});  
}


</script>

${login}
</body>
</html>