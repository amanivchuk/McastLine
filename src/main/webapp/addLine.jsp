<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.03.2017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new line</title>
    <link href="../css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">


    <div class="header">
        <div class="logo">
            <img src="../images/library.png" alt="Логотип" name="logo" />

        </div>
        <div class="descr">
            <h3>Добавить новую линию для контроля</h3>
        </div>
    </div>
    <div class="center-form">
        <form method="post" action="selectForm.do">
            <div class="form-group">
                <label>Hostname</label>
                <input type="text" name="hostname" class="form-control" id="hostname" placeholder="Enter hostname">
            </div>
            <div class="form-group">
                <label>ip socket</label>
                <input type="text" name="ipsocket" class="form-control" id="ipsocket" placeholder="Enter ip socket">
            </div>
            <div class="form-group">
                <label>port socket</label>
                <input type="text" name="portsocket" class="form-control" id="portsocket" placeholder="Enter port socket">
            </div>
            <div class="form-group">
                <label>ip multicast</label>
                <input type="text" name="ipmcast" class="form-control" id="ipmulticast" placeholder="Enter ip multicast">
            </div>
            <div class="form-group">
                <label>port multicast</label>
                <input type="text" name="portmcast" class="form-control" id="portmulticast" placeholder="Enter port multicast">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox">Check me out
                </label>
            </div>
            <button type="submit" class="submitForm">Submit</button>
        </form>

    </div>
</body>
</html>
