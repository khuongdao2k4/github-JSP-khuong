<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sinh viên </title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
    </style>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<table>
    <tr>
        <th>Mã sinh viên</th>
        <th>Họ và tên</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.fullName}</td>
            <td>${student.phone}</td>
            <td>${student.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>