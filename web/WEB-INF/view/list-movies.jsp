<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Movie Library</h2>

        <button class="add-button" onclick="window.location.href='showAddMovieForm';return false;">
            Add Movie
        </button>

    </div>
</div>

<form:form method="GET" action="search">
    Search movies <input type="search" name="searchTerm">
    <input type="submit" value="Search" class="add-button">
</form:form>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>Genre</th>
                <th>Name</th>
                <th>Ovierview</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempMovie" items="${movies}">
                <c:url var="updateLink" value="/movie/showUpdateMovieForm">
                    <c:param name="movieId" value="${tempMovie.id}"/>
                </c:url>

                <c:url var="deleteLink" value="/movie/delete">
                    <c:param name="movieId" value="${tempMovie.id}"/>
                </c:url>

                <tr>
                    <td>${tempMovie.genre.description}</td>
                    <td>${tempMovie.name}</td>
                    <td>${tempMovie.overview}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        &nbsp;|&nbsp;
                        <a href="${deleteLink}"
                           onclick="if(!confirm('Are you sure?')) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>
