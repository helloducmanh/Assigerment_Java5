<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<div class="bg-login">
    <div class="login-form">
        <form action="" method="POST" style="margin-top: 30px;">
            <h1>Danh Sach Category</h1>
            <c:if test="${cateList.size()==0}">
                <h3>Không có category</h3>
            </c:if>
            <c:if test="${cateList.size()!=0}">
                <table class="table table-bordered border-primary">
                    <thead  class="table-dark">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="cate" items="${cateList}">
                        <tr>
                            <td>${cate.id}</td>
                            <td>${cate.name}</td>
                            <td>
                                <a class="btn btn-danger" href="/admin/category/edit/${cate.id}">Edit</a>
                                <a class="btn btn-danger" href="/admin/category/delete/${cate.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <div style="margin-top: 35px;margin-left: 20px">
                <a class="btn btn-primary" href="/admin/category/create" style="width: 100px">Create</a>
            </div>
        </form>

    </div>
</div>