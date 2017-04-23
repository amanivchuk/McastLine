<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact - Mustache Enthusiast</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="resources/css/mobile.css" media="screen and (max-width : 568px)">
    <script type="text/javascript" src="js/mobile.js"></script>
</head>
<body>
<div id="header">
    <a href="WEB-INF/views/index.html" class="logo">
        <img src="/McastLine/resources/css/ethernet.jpg" alt="">
    </a>
    <ul id="navigation">
        <li>
            <a href="<c:url value="/main_index"/>">home</a>
        </li>
        <li>
            <a href="about.html">about</a>
        </li>
        <li>
            <a href="<c:url value="/addLine"/>">add line</a>
        </li>
        <li>
            <a href="blog.html">blog</a>
        </li>
        <li class="selected">
            <a href="j_spring_security_logout">Logout</a>
        </li>
    </ul>
</div>
<div id="body">
    <h1><span>let's keep in touch</span></h1>
    <form method="post" action="selectForm.do">
        <input type="text" name="hostname" class="form-control" id="hostname" placeholder="Enter hostname">
        <input type="text" name="ipsocket" class="form-control" id="ipsocket" placeholder="Enter ip socket">
        <input type="text" name="portsocket" class="form-control" id="portsocket" placeholder="Enter port socket">
        <input type="text" name="ipmcast" class="form-control" id="ipmulticast" placeholder="Enter ip multicast">
        <input type="text" name="portmcast" class="form-control" id="portmulticast" placeholder="Enter port multicast">
        <button type="submit" class="submitForm">Submit</button>
    </form>
    <!--<form action="contact.html">
        <input type="text" name="fname" id="fname" value="name">
        <input type="text" name="address" id="address" value="address">
        <input type="text" name="email" id="email" value="email">
        <input type="text" name="phone" id="phone" value="phone number">
        <textarea name="message" id="message">message</textarea>
        <input type="submit" name="send" id="send" value="send">
    </form>-->
</div>
<div id="footer">
    <div>
        <p>&copy; 2023 by Mustacchio. All rights reserved.</p>
        <ul>
            <li>
                <a href="http://freewebsitetemplates.com/go/twitter/" id="twitter">twitter</a>
            </li>
            <li>
                <a href="http://freewebsitetemplates.com/go/facebook/" id="facebook">facebook</a>
            </li>
            <li>
                <a href="http://freewebsitetemplates.com/go/googleplus/" id="googleplus">googleplus</a>
            </li>
            <li>
                <a href="http://pinterest.com/fwtemplates/" id="pinterest">pinterest</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
