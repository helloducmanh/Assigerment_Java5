<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<center><h1>Update</h1></center>
<form:form modelAttribute="item">
    <div>
        Ma hoa don:
        <form:input path="mahoadon"/>
        <form:errors path="mahoadon"/>
    </div>
    <div>
        Ma KH:
        <form:select path="nguoimua.makhachhang">
            <form:options items="${listKH}" itemValue="makhachhang" itemLabel="makhachhang"/>
        </form:select>
        <form:errors path="nguoimua.makhachhang"/>
    </div>
    <div>
        Nguoi lap:
        <form:input path="nguoilap"/>
        <form:errors path="nguoilap"/>
    </div>
    <div>
        Ghi chu:
        <form:input path="ghichu"/>
        <form:errors path="ghichu"/>
    </div>
    <div>
        Trang thai:
        Chua thanh toan <form:radiobutton path="trangthai" value="0" checked="true"/>
        Da thanh toan <form:radiobutton path="trangthai" value="1"/>
    </div>
    <button type="submit" formaction="/hoadon/update/${item.mahoadon}">Update</button>

</form:form>