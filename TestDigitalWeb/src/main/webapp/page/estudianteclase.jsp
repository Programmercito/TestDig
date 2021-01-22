<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en" class="h-100">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.79.0">
        <title>Sistema demo para Digital Harbor</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sticky-footer-navbar/">



        <!-- Bootstrap core CSS -->
        <link href="resources/assets/dist/css/bootstrap.min.css" rel="stylesheet">

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="sticky-footer-navbar.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column h-100">

        <header>
            <!-- Fixed navbar -->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Sistema Test</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item active">
                                <a class="nav-link" aria-current="page" href="class">Clases</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="student">Estudiantes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="studentclass">Estudiantes - Clases</a>
                            </li>
                        </ul>

                    </div>
                </div>
            </nav>
        </header>

        <!-- Begin page content -->
        <main class="flex-shrink-0">
            <div class="container">
                <hr>
                <h1 class="mt-5">Busqueda</h1>
                <% if (request.getParameter("accion") == null || "buscar".equals(request.getParameter("accion"))) {%> 
                <div class="container">
                    <form method="GET" action="studentclass?accion=buscar">
                        <div class="form-group">
                            <label for="id">Code Student</label>
                            <input value="<%if (request.getParameter("id") != null) {
                                    out.println(request.getParameter("id"));
                                }%>" type="text" class="form-control" id="id" placeholder="Enter data" name="id">
                        </div>
                        <div class="form-group">
                            <label for="lastname">last name Student</label>
                            <input value="<%if (request.getParameter("lastname") != null) {
                                    out.println(request.getParameter("lastname"));
                                }%>" type="text" class="form-control" id="lastname" placeholder="Enter data" name="lastname">
                        </div>
                        <div class="form-group">
                            <label for="firstname">first name Student</label>
                            <input value="<%if (request.getParameter("firstname") != null) {
                                    out.println(request.getParameter("firstname"));
                                }%>" type="text" class="form-control" id="firstname" placeholder="Enter data" name="firstname">
                        </div>
                        <div class="form-group">
                            <label for="id">Code class</label>
                            <input value="<%if (request.getParameter("code") != null) {
                                    out.println(request.getParameter("code"));
                                }%>" type="text" class="form-control" id="code" placeholder="Enter data" name="code">
                        </div>
                        <div class="form-group">
                            <label for="lastname">Title Class</label>
                            <input value="<%if (request.getParameter("title") != null) {
                                    out.println(request.getParameter("title"));
                                }%>" type="text" class="form-control" id="title" placeholder="Enter data" name="title">
                        </div>
                        <div class="form-group">
                            <label for="firstname">Description Class</label>
                            <input value="<%if (request.getParameter("description") != null) {
                                    out.println(request.getParameter("description"));
                                }%>" type="text" class="form-control" id="description" placeholder="Enter data" name="description">
                        </div>
                        <button type="submit" class="btn btn-default">Buscar</button>
                    </form>
                </div>
                <table class="table">
                    <tr>
                        <td scope="col">Code Class</td>
                        <td scope="col">Title Class</td>
                        <td scope="col">Description Class</td>
                        <td scope="col">Student ID</td>
                        <td scope="col">First Name</td>
                        <td scope="col">Last Name</td>
                    </tr>
                    <c:set var = "codigo" value = ""/>
                    <c:forEach items="${busqueda}" var="bus">
                        <c:if test = "${codigo!=bus.code}">
                            <tr>
                                <td><c:out value="${bus.code}" /></td>
                                <td><c:out value="${bus.title}" /></td>
                                <td><c:out value="${bus.description}" /></td>     
                                <td></td>
                                <td></td>
                                <td></td>     
                            </tr>
                        </c:if>

                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>     
                            <td><c:out value="${bus.studentid}" /></td>
                            <td><c:out value="${bus.firstname}" /></td>
                            <td><c:out value="${bus.lastname}" /></td>
                        </tr>

                        <c:set var = "codigo" value = "${bus.code}"/>

                    </c:forEach>
                </table>
                <%}%> 

            </div>
        </main>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="container">
                <span class="text-muted">Desarrollado por Joaquin Heredia Molina</span>
            </div>
        </footer>


        <script src="resources/assets/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    </body>
</html>
