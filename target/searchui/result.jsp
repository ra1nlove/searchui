<%--
  Created by IntelliJ IDEA.
  User: rain
  Date: 17-4-11
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="shortcut icon" href="resources/img/favicon.ico" type="image/x-icon" />
    <title>Psyduck</title>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" />
    <link href="resources/css/result.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");

%>
<div id="container">
    <div id="hd" class="ue-clear">
        <div class="logo"></div>
        <div class="inputArea">
            <input type="text" class="searchInput" id="keywords" />
            <input type="button" class="searchButton" onclick="searchMsgIn()" />
        </div>
    </div>

    <div class="resultArea">
        <p class="resultTotal">
            <span class="info">找到约&nbsp;<span class="totalResult" id="totalResult"></span>&nbsp;条结果，共约<span class="totalPage" id="totalPage"></span>页</span>

        </p>
        <div class="resultList">


        </div>
        <!-- 分页 -->
        <div class="pagination ue-clear"></div>

    </div>

        </div><!-- End of main -->
    </div><!--End of bd-->
</div>

<div id="foot">Copyright &copy;ra1nlove.cn 版权所有 </div>
</body>
<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/searchui.js"></script>
<script type="text/javascript" src="resources/js/result.js"></script>
<script type="text/javascript" src="resources/js/pagination.js"></script>
<script>
    $(document).ready(function() {
        keyword = '<%=request.getParameter("keywords") %>';
        $("#keywords").val(keyword);
        $.ajax({
          url:"/get?keyword="+keyword+"&page=0",
          type:"get",
          success: function(data,status,jqxhr){
            showResults(data.pages);
              showPage(data.total,0);

          },
          error:function(jqxhr,status,errorMsg){
            alert("Status: "+status+" Error: "+errorMsg);
          }
        });


    });
</script>
</html>
