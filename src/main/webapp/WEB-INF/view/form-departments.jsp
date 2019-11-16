<%--
  Created by IntelliJ IDEA.
  User: sumutella
  Date: 11/3/2019
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

    <title>Department Form</title>
</head>
<body style="width:80%; padding-right: 10%; padding-left: 10%; padding-top: 5%;">



<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <a onclick="window.location.href='${pageContext.request.contextPath}/department/list-departments'" class="float-right btn btn-outline-primary mt-1">Back To List</a>
                    <h4 class="card-title mt-2">Department Form</h4>
                </header>
                <article class="card-body">
                    <f:form action="${pageContext.request.contextPath}/department/save-department" modelAttribute="department" method="post">
                        <f:hidden path="id"/>
                        <c:set var = "managerID" value = "${department.managerId}"/>
                        <c:set var = "locationID" value = "${department.locationId}"/>
                        <div class="form-group">
                            <label>Department Name</label>
                            <f:input path="departmentName" name="department-name" type="text" class="form-control" placeholder=""/>
                            <f:errors path="departmentName"></f:errors>

                        </div> <!-- form-group end.// -->

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label>Manager</label>
                                <f:select path="managerId" class="form-control" name="manager-options">
                                    <c:if test="${empty managerIDCB}">
                                        <option value="" selected>Choose a Manager</option>
                                    </c:if>
                                    <c:forEach var="manager" items="${eligibleToManageMap}">
                                        <c:choose>
                                            <c:when test="${manager.key == managerIDCB}">
                                                <option value="${department.managerId}" selected>${eligibleToManageMap.get(managerIDCB)}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${manager.key}"><c:out value="${manager.value}"/></option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </f:select>
                                <f:errors path="managerId"></f:errors>

                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row.// -->
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label>Office</label>
                                <f:select path="locationId" class="form-control" name="location-options">
                                    <c:if test="${empty locationIDCB}">
                                        <option value="" selected>Choose a Location</option>
                                    </c:if>
                                    <c:forEach var="location" items="${locationsMap}">
                                        <c:choose>
                                            <c:when test="${location.key == locationIDCB}">
                                                <option value="${department.locationId}" selected>${locationsMap.get(locationID)}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${location.key}"><c:out value="${location.value}"/></option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </f:select>
                            </div> <!-- form-group end.// -->
                        </div> <!-- form-row.// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Submit  </button>
                        </div> <!-- form-group// -->
                    </f:form>
                </article> <!-- card-body end .// -->
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->

</div>
<!--container end.//-->



</body>
</html>