<%--
  Created by IntelliJ IDEA.
  User: rain
  Date: 17-4-11
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="shortcut icon" href="resources/img/favicon.ico" type="image/x-icon" />
  <title>Psyduck</title>
  <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
  <link href="resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container">
  <div id="bd">
    <div id="main">
      <h1 class="title">
        <div class="logo large"></div>
      </h1>

      <div class="inputArea" >
        <input type="text" class="searchInput" required id="keywords" />
        <button type="button" class="searchButton" onclick="searchMsg();"></button>

      </div>

    </div><!-- End of main -->
  </div><!--End of bd-->

  <div class="foot">
    <div class="wrap">
      <div class="copyright">Copyright &copy;rain1ove.cn 版权所有  </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/searchui.js">

</script>
</html>
