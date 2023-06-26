<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="bg-login">
    <div class="login-form">
        <form action="" method="POST" style="margin-top: 30px;">
            <h1>Danh Sách Sản Ph.ẩm</h1>
            <c:if test="${danhSachSP.size()==0}">
                <h3>Không có tài khoản</h3>
            </c:if>
            <c:if test="${danhSachSP.size()!=0}">
                <table class="table table-bordered border-primary">
                    <thead  class="table-dark">
                    <tr>
                        <th scope="col">NAME</th>
                        <th scope="col">PRICE</th>
                        <th scope="col">IMAGE</th>
                        <th scope="col">CATEGORYID</th>
                        <th scope="col" colspan="3"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sp" items="${danhSachSP}">
                        <tr>
                            <td>${sp.name}</td>
                            <td>${sp.price}</td>
                            <td> <img src="data:image/jpeg;base64,${sp.image}" alt="car_image" style="height: 50px; width: 50px"  /></td>
                            <td>${sp.category.name}</td>
                            <td>
                                <a class="btn btn-danger" href="/admin/product/edit/${sp.id}">Edit</a>
                                <a class="btn btn-danger" href="/admin/product/delete/${sp.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </form>
        <div style="margin-top: 35px;margin-left: 20px">
            <a class="btn btn-primary" href="/admin/product/create" style="width: 100px">Create</a>
        </div>
    </div>
</div>