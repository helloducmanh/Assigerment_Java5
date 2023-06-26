<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="bg-login">
    <div class="login-form">
        <form action="" method="POST" style="margin-top: 30px;">
        <h1>Danh Sách Tài Khoản</h1>
        <c:if test="${danhSachAc.size()==0}">
              <h3>Không có tài khoản</h3>
        </c:if>
        <c:if test="${danhSachAc.size()!=0}">
        <table class="table table-bordered border-primary">
            <thead  class="table-dark">
            <tr>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Fullname</th>
                <th scope="col">Email</th>
                <th scope="col" colspan="3"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="account" items="${danhSachAc}">
            <tr>
                <td>${account.username}</td>
                <td>${account.password}</td>
                <td>${account.fullname}</td>
                <td>${account.email}</td>
                <td>
                    <a class="btn btn-danger" href="/admin/account/edit/${account.username}">Edit</a>
                    <a class="btn btn-danger" href="/admin/account/delete/${account.username}">Delete</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:if>
        </form>
        <div style="margin-top: 35px;margin-left: 20px">
            <a class="btn btn-primary" href="/admin/account/create" style="width: 100px">Create</a>
        </div>
    </div>
</div>