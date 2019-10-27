<%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2019/10/27
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
<script> window.setInterval("location='${url}'",3000); </script>
<h2>${message}</h2>
<br/>
<p style="text-indent: 2em; margin-top: 60px;">
    系统将在 <span id="time">3</span> 秒钟后自动跳转至首页，如果未能跳转，<a href="${url}" title="点击访问">请点击</a>。</p>
<script type="text/javascript">
    delayURL();
    function delayURL() {
        var delay = document.getElementById("time").innerHTML;
        var t = setTimeout("delayURL()", 1000);
        if (delay > 0) {
            delay--;
            document.getElementById("time").innerHTML = delay;
        } else {
            clearTimeout(t);
            window.location.href = "${url}";
        }
    }
</script>
</body>
</html>
