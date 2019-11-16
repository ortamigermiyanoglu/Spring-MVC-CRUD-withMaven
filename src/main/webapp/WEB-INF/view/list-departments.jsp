<%--
  Created by IntelliJ IDEA.
  User: sumutella
  Date: 11/2/2019
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">


    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>

    <title>Department CRUD</title>
</head>
<body style="width:80%; padding-right: 10%; padding-left: 10%; padding-top: 5%;">

<table  style="width:100%">
    <tr>
        <td style="padding-right: 10px">
            <button type="button"  onclick="window.location.href='add-department'" class="btn btn-primary btn-md">Add</button>

        </td>


        <td style="padding-right: 10px">
            <button type="button" onclick="
            var departmentIDCheckBoxes = document.getElementsByName('departmentID');
            for (var i = 0; i <departmentIDCheckBoxes.length ; i++) {
                if (departmentIDCheckBoxes[i].checked) {
                window.location.assign('update-department/'.concat(departmentIDCheckBoxes[i].value));
                }
            }
            "
                    class="btn btn-success btn-md">Update</button>
        </td>
        <td style="padding-right: 10px">
            <button type="button" onclick="
        var departmentCheckBoxes = document.getElementsByName('departmentID');
            for (var i = 0; i <departmentCheckBoxes.length ; i++) {
                if (departmentCheckBoxes[i].checked) {
                    if(confirm('Confirm if you want to delete this department')){
                                        window.location.assign('delete-department/'.concat(departmentCheckBoxes[i].value));
                    }
                }
            }
                " class="btn btn-danger btn-md">Delete</button>
        </td>


        <f:form action="search-department" method="post">
            <td style="padding-right: 10px">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                    <input type="text" class="form-control" name="deptName" placeholder="Department Name">
                </div>
            </td>
            <td style="padding-right: 10px">
                <select class="form-control form-control-md" name="manager-options">
                    <option value="0">Choose Manager</option>
                    <c:forEach var="managerKV" items="${managersMap}">
                        <option value="${managerKV.key}"><c:out value="${managerKV.value}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td style="padding-right: 10px">
                <select class="form-control form-control-md" name="location-options">
                    <option value="0">Choose Location</option>
                    <c:forEach var="locationKV" items="${locationsMap}">
                        <option value="${locationKV.key}"><c:out value="${locationKV.value}"/></option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
            </td
        </f:form>
    </tr>

</table>
<br>

<table id="example" class="display" style="width:100%">
    <thead>
    <tr>
        <th></th>
        <th>ID</th>
        <th>Name</th>
        <th>Manager</th>
        <th>Office</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>
                <input type="radio" value="${department.id}"  id="departmentID" name="departmentID"/>
            </td>
            <td>${department.id}</td>
            <td>${department.departmentName}</td>
            <c:set var = "managerId" value = "${department.managerId}"/>
            <td>${managersMap.get(managerId)}</td>
            <c:set var = "locationId" value = "${department.locationId}"/>
            <td>${locationsMap.get(locationId)}</td>

        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <th></th>
        <th>ID</th>
        <th>Name</th>
        <th>Manager</th>
        <th>Office</th>
    </tr>
    </tfoot>
</table>
</body>
</html>