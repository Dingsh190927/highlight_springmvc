<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/29
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>HttpConverterMessage Demo</title>
</head>
<body>
<div id="resp"></div><input type="button" onclick="rep()"  value="请求"/>
<script type="text/javascript" src='<c:url value="assets/js/jquery.js"></c:url>'></script>
<script>
    function rep() {
        $.ajax({
            url: "convert",
            data: "1-dingshihe",
            type: "post",
            contentType: "application/x-wisely",
            success: function () {
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>
