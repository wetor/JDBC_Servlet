<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Div</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        function pageScroll(){
            window.scrollBy(0,-30);
            scrolldelay = setTimeout('pageScroll()',1);
            var sTop=document.documentElement.scrollTop+document.body.scrollTop;
            if(sTop==0) clearTimeout(scrolldelay);
        }
    </script>
</head>
<body>
    <div id="pageDiv">
        <div id="leftDiv">
			<div id="leftBoxDiv">
				<div id="headImageDiv"></div>
			</div>
        </div>
        <div id="mainTopDiv"></div>
        <div id="returnTop" onclick="pageScroll()"></div>
        <div id="mainDiv">
            <c:forEach items="${requestScope.list}" var="post" varStatus="id">
                <div class="postBoxDiv">
                    <div class="postBackgroundDiv">
                        <div class="postInfoDiv">
                            <span style="font-size: 17px; ">${post.author}</span><br>
                            <span style="font-size: 17px; "><fmt:formatDate value="${post.date}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        </div>
                        <div class="postTitleDiv">
                            <a class="titleA" href="page?id=${post.id}">${post.title}</a>
                        </div>

                        <div class="postContentDiv">
                            <span style="font-size: 25px; ">${post.content}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div id="mainBottomDiv"></div>
        </div>
    </div>

</body>
</html>