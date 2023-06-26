<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<center><h1>Quan ly hoa don</h1></center>
<form:form action="/hoadon/hienthi" method="post" modelAttribute="search">
    Ngay tao:
    <div>
        From:
        <form:input path="fromDate" placeholder="dd/MM/yyyy"/>
    </div>
    <div>
        To:
        <form:input path="toDate" placeholder="dd/MM/yyyy"/>
    </div>
    <button type="submit">Search</button>
</form:form>
<hr>
<table>
    <thead>
    <tr>

        <th>ma HD</th>
        <th>Ma KH</th>
        <th>Nguoi lap</th>
        <th>Ngay tao</th>
        <th>Ghi chu</th>
        <th>Trang thai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHD}" var="hd">
        <tr>
        <td>${hd.mahoadon}</td>
        <td>${hd.nguoimua.makhachhang}</td>
        <td>${hd.nguoilap}</td>
        <td>${hd.ngaylap}</td>
        <td>${hd.ghichu}</td>
        <td>${hd.trangthai}</td>
        <td><a href="/hoadon/detail/${hd.mahoadon}">Detail</a>
            <a href="/hoadon/remove/${hd.mahoadon}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    function confirmDelete() {
        if (confirm("Bạn có chắc muốn xoá?")) {
            return true;
        } else {
            return false;
        }
    }
</script>