<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>MyBlog</title>
    <script src="js/showdown.min.js"></script>
    <link href="css/Mweb.css" rel="stylesheet" type="text/css" />
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        function pageScroll(){
            window.scrollBy(0,-30);
            scrolldelay = setTimeout('pageScroll()',1);
            var sTop=document.documentElement.scrollTop+document.body.scrollTop;
            if(sTop==0) clearTimeout(scrolldelay);
        }
        function mdSwitch(show_id) {
            var mdValue = document.getElementById(show_id).innerText;
            var converter = new showdown.Converter();
            var html = converter.makeHtml(mdValue);
            document.getElementById(show_id).innerHTML = html;
        }
    </script>
</head>
<body>
    <div id="pageDiv">
        <div id="leftDiv">
			<div id="leftBoxDiv">
				<div id="headImageDiv">
                    <img id="headImage" src="images/head.png" >
                </div>
			</div>
        </div>
        <div id="returnTop" onclick="pageScroll()">
            <img style="border: 3px solid #ddd" src="images/returnTop.png" >
        </div>
        <div id="mainDiv">
            <c:forEach items="${requestScope.list}" var="post" varStatus="id">
                <div class="postBoxDiv">
                    <div class="postBackgroundDiv">
                        <div class="postInfoDiv">
                            <span style="font-size: 17px; line-height: normal;">${post.author}</span><br>
                            <span style="font-size: 17px; line-height: normal;"><fmt:formatDate value="${post.date}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        </div>
                        <div class="postTitleDiv">
                            <a class="titleA" href="page?id=${post.id}">${post.title}</a>
                        </div>
                        <div class="postContentDiv">
                            <c:set var="x_n" value="<%=\"\n\"%>"/>
                            <span id="content_${post.id}" >${fn:replace(post.content, x_n, '<br/>')}</span>
                        </div>
                    </div>
                </div>
                <script>mdSwitch("content_${post.id}")</script>
            </c:forEach>
            <div id="blogBottomDiv"></div>
        </div>
    </div>

</body>
</html>