<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Div</title>
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
        function mdSwitch() {
            var mdValue = document.getElementById("md-area").value;
            var converter = new showdown.Converter();
            var html = converter.makeHtml(mdValue);
            document.getElementById("show-area").innerHTML = html;
        }
        function syncScroll() {
            const l=document.getElementById('md-area');
            const r=document.getElementById('show-area');
            let currentTab = 0;
            l.addEventListener('scroll', ()=>{
                if (currentTab !== 1) return;
            r.scrollTop = l.scrollTop * r.scrollHeight / l.scrollHeight;
        });
            r.addEventListener('scroll', ()=>{
                if (currentTab !== 2) return;
            l.scrollTop = r.scrollTop * l.scrollHeight / r.scrollHeight;
        });
            l.addEventListener('mouseover', ()=>{
                // 1 表示表示当前鼠标位于 .left元素范围内
                currentTab = 1;
            });
            r.addEventListener('mouseover', ()=>{
                // 2 表示表示当前鼠标位于 .right元素范围内
                currentTab = 2;
            });
        }
    </script>
</head>
<body>
<div id="pageDiv">
    <div id="leftDiv">
        <div id="leftBoxDiv">
            <div id="headImageDiv">

            </div>
        </div>
    </div>
    <div id="returnTop"  onclick="pageScroll()"></div>
    <div id="mainDiv">
        <div class="postBoxDiv">
            <div class="postBackgroundDiv">
                <div id="editTitleDiv">
                    <span style="font-size: 17px;float: left;padding-left:0px;">标题</span>
                    <input id="editTitle" name="title" form="posting" value=""/>
                    <span style="font-size: 17px;float: left;padding-left:15px;">作者</span>
                    <input id="editAuthor" name="author"  form="posting"  value=""/>

                    <input id="editDate" type="date" value="2019-01-01"/>
                    <span style="font-size: 17px;float: right;padding-right:15px;">时间</span>
                </div>
                <div id="editContentDiv">
                    <div id="area">
                        <table>
                            <tr>
                                <td>
                                    <textarea id="md-area" name="content"  form="posting" onkeyup="mdSwitch()"></textarea>
                                </td>
                                <td>
                                    <div id="show-area" ></div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
                <br/>
                <form action="posting" id="posting" method="post">
                    <input type="hidden" name="operation" value="posting">
                    <br/>
                    <input type="submit">
                </form>
            </div>
        </div>
        <div id="blogBottomDiv"></div>

    </div>
</div>

</body>
<script>
    syncScroll();
    mdSwitch();
</script>
</html>