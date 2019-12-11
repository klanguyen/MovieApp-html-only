<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Movie</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-movie-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>New Movie</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <form:form action="save" modelAttribute="aMovie" enctype="multipart/form-data">
            <form:hidden path="id" value="${aMovie.id}"/>

            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><form:input path="name"/>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Overview</label></td>
                    <td><form:input path="overview"/>
                        <form:errors path="overview" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Genre</label></td>
                    <td>
                        <form:select path="genre" items="${genres}" itemLabel="name" itemValue="id">
                        </form:select>
                    </td>
                </tr>
                <!--<tr>
                    <td><label>Image</label></td>
                    <td><input type="file" name="donutImage"></td>
                </tr>-->
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>
    </div>
</div>
</body>
</html>
