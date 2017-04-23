<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mustache Enthusiast</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/mobile.css"/>" media="screen and (max-width : 568px)" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/mobile.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="../../resources/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../resources/css/mobile.css" media="screen and (max-width : 568px)"/>
    <script type="text/javascript" src="../../js/mobile.js"></script>--%>
</head>
<body>
<div id="header">
    <a href="index.html" class="logo">
        <img src="/McastLine/resources/css/ethernet.jpg" align="left" alt="" id="logo" about="logo">
    </a>
    <p></p>
    <ul id="navigation">
        <li class="selected">
            <a href="<c:url value="/main_index"/>">home</a>
        </li>
        <li>
            <a href="../../about.html">about</a>
        </li>
        <%--<li>
            &lt;%&ndash;<a href="/addLine.jsp">&ndash;%&gt;
            <a href="<c:url value="/addLine"/>">add line</a>
        </li>--%>
        <li>
            <a href="../../blog.html">blog</a>
        </li>
        <li>
            <%--<a href="../../contact.html">contact</a>--%>
            <a href="j_spring_security_logout">Logout</a>
        </li>

    </ul>
</div>
<div id="body">
    <div id="featured">
        <!--<img src="images/the-beacon.jpg" alt="">
        <div>
            <h2>the beacon to all mankind</h2>
            <span>Our website templates are created with</span>
            <span>inspiration, checked for quality and originality</span>
            <span>and meticulously sliced and coded.</span>
            <a href="blog-single-post.html" class="more">read more</a>
        </div>-->
    </div>
    <!--<ul>
        <li>
            <a href="gallery.html">
                <img src="images/the-father.jpg" alt="">
                <span>the father</span>
            </a>
        </li>
        <li>
            <a href="gallery.html">
                <img src="images/the-actor.jpg" alt="">
                <span>the actor</span>
            </a>
        </li>
        <li>
            <a href="gallery.html">
                <img src="images/the-nerd.jpg" alt="">
                <span>the nerd</span>
            </a>
        </li>
    </ul>-->
</div>
<div>
    <!--</div>
    <div>-->
    <table class="table" align="center" border="1" width="600" height="300">
        <caption>Line status.</caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Hostname</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">1</th>
            <td><p id="demo"></p></td>
            <td id="status"><p id="demo1"></p></td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td><p id="demo_rez"></p></td>
            <td id="status1"><p id="demo1_rez"></p></td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td><p id="adf"></p></td>
            <td id="status2"><p id="adf1"></p></td>
        </tr>
        </tbody>
    </table>

    <!--<input type="text" id="message"/>-->
    <center>
        <input value="Send" onclick="sendMessage();" type="submit" align="right">
    </center>
</div>
<div id="footer">
    <div>
        <p>&copy; 2017. All rights reserved.</p>
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


<script type="text/javascript">
    /*Создаем объект WebSocket и указываем путьь для подключения.
     Подключение произойдет сразу после создания компонента.*/
    var webSocket = new WebSocket("ws://localhost:8080/McastLine/websocket");
    var messages = document.getElementById("messages");
    var message = document.getElementById("message");
    //    обработчик события открытия соединения с сервером
    webSocket.onopen = function (message) {
        //messages.value+="Connection create \n";
        var json = JSON.parse(message.data);
        document.getElementById('countLine').innerHTML = json.countLine;
    }
    //    обработчик события закрытия соединения с сервером
    webSocket.onclose = function (message) {
        messages.value += "Connection close \n";
    }
    //    обработчик ошибки при работе с сокетом
    webSocket.onerror = function (message) {
        messages.value += "Error \n";
    }
    //    обработчик нажатия кнопки отправки сообщения
    function sendMessage() {
//        отправляем сообщения на сервер
        webSocket.send("a");
        //message.value += message.value + "\n";
        //message.value = "";
    }
    //  обработчик получения сообщения от сервера
    webSocket.onmessage=function (message) {
        // messages.value+="Message from server: " + message.data + "\n";

        var json = JSON.parse(message.data);
        if(json.hostname == "Test 1"){
            document.getElementById('demo').innerHTML = json.hostname;
            document.getElementById('demo1').innerHTML = json.status;
            if(json.status == true){
                document.getElementById('status').style.background = "green";
            }else{
                document.getElementById('status').style.background="red";
            }
        }else if(json.hostname == "ADF"){
            document.getElementById('adf').innerHTML = json.hostname;
            document.getElementById('adf1').innerHTML = json.status;
            if(json.status == true){
                document.getElementById('status2').style.background = "green";
            }else{
                document.getElementById('status2').style.background="red";
            }
        }
        else{
            document.getElementById('demo_rez').innerHTML = json.hostname;
            document.getElementById('demo1_rez').innerHTML = json.status;
            if(json.status == true) {
                document.getElementById('status1').style.background = "green";
            }else{
                document.getElementById('status1').style.background="red";
            }
        }
    }
</script>
</html>
