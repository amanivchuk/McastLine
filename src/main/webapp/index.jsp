<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.03.2017
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="utf-8"/>
    <title>Status line</title>
    <link href="/resources/css/style-index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="main" align="center">

    <div class="content">
        <p class="title"><span class="text"><img src="images/lib.png" width="76" height="77" hspace="10" vspace="10" align="middle"></span></p>
        <p class="title">Control line status</p>
        <p>&nbsp;</p>
    </div>

    <div class="login_div">
        <p class="title">Для входа введите свои данные:</p>
        <form class="login_form" name="username" action="index_run.html" <%--action="${pageContext.request.contextPath}/pages/main.jsp"--%> method="post">
            Login: <input type="text" name="username" value="" size="30">
            <input type="submit" value="Войти">
        </form>
    </div>

    <div class="footer">
         @2016
    </div>

</div>
</body>
</html>
