<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-10-25
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>bookList.jsp</title>
    <style>
        table, th, td {
            border: 1px solid #bcbcbc;
        }
        table {
            width: 600px;
            height: 200px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 200px;
        }
        tr, td {
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>번호</th>
        <th>도서명</th>
        <th>저자</th>
        <th>가격</th>
        <th>출판사</th>
    </tr>
    <%-- items 는 반복대상 (BookController 에서 가져옴) --%>
    <%-- 책 제목을 클릭하면 /book 이라는 주소로 클릭한 책의 bookId를 전달
        /book>bookId=1

        문제)
        1. /book 주소를 처리하는 Controller 메서드 정의
        2. findBook.jsp 에 해당 책 정보 출력

            --%>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>
                <a href="/book?bookId=${book.bookId}">${book.bookName}</a>
            </td>
            <td>${book.bookAuthor}</td>
            <td>${book.bookPrice}</td>
            <td>${book.bookPublisher}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
