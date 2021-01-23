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
                    <a class="navbar-brand" href="/TestDigitalWeb">Test System</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav me-auto mb-2 mb-md-0">
                            <li class="nav-item active">
                                <a class="nav-link" aria-current="page" href="class">Class</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="student">Students</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="studentclass">Students - Class</a>
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
                <h1 class="mt-5">Classes  
                    <a title="New" href="class?accion=nuevo"><i class="far fa-file"></i></a>
                </h1>
                <h5>
                    <c:if test="${error!=null || error!=''}">
                        <p class="text-danger">${error}</p>
                    </c:if>
                </h5>

                <% if (request.getParameter("accion") == null || "grabarnuevo".equals(request.getParameter("accion")) || "grabarmod".equals(request.getParameter("accion")) || "eliminar".equals(request.getParameter("accion"))) {%> 
                <table class="table">
                    <tr>
                        <td scope="col">Code</td>
                        <td scope="col">title</td>
                        <td scope="col">Description</td>
                        <td scope="col">Options</td>
                    </tr>
                    <c:forEach items="${estudiantes}" var="product">
                        <tr>
                            <td><c:out value="${product.code}" /></td>
                            <td><c:out value="${product.title}" /></td>
                            <td><c:out value="${product.description}" /></td>
                            <td>
                                <a title="Edit" href="class?accion=modificar&id=${product.code}"><i class="fas fa-pen-alt"></i></a>
                                <a title="Remove" href="javascript:confirmarget('you sure?','class?accion=eliminar&id=${product.code}')"><i class="fas fa-trash-alt"></i></a>
                                <a title="View Students" href="class?accion=viewstudent&id=${product.code}"><i class="fas fa-calendar-week"></i></a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <%} else if ("nuevo".equals(request.getParameter("accion"))) {%> 

                <div class="container">
                    <form method="POST" action="class?accion=grabarnuevo">
                        <div class="form-group">
                            <label for="code">code</label>
                            <input type="text" class="form-control" id="code" placeholder="Enter id" name="code">
                        </div>
                        <div class="form-group">
                            <label for="title">title</label>
                            <input type="text" class="form-control" id="title" placeholder="Enter id" name="title">
                        </div>
                        <div class="form-group">
                            <label for="description">description</label>
                            <input type="text" class="form-control" id="description" placeholder="Enter id" name="description">
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <%} else if ("modificar".equals(request.getParameter("accion"))) {%> 

                <div class="container">
                    <form method="POST" action="class?accion=grabarmod">
                        <div class="form-group">
                            <label for="code">code</label>
                            <input type="text" disabled class="form-control" id="idx" placeholder="Enter id" name="idx" value="${modificame.code}">
                            <input type="hidden"  class="form-control" id="code" placeholder="Enter id" name="code" value="${modificame.code}">
                        </div>
                        <div class="form-group">
                            <label for="title">title</label>
                            <input type="text" class="form-control" id="title" placeholder="Enter id" name="title" value="${modificame.title}">
                        </div>
                        <div class="form-group">
                            <label for="description">first name</label>
                            <input type="text" class="form-control" id="description" placeholder="Enter id" name="description" value="${modificame.description}">
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <%} else if ("viewstudent".equals(request.getParameter("accion"))) {%> 
                <label for="id">Class</label>
                <div class="container">
                    <div class="form-group">
                        <input type="text" disabled class="form-control" id="idx" placeholder="Enter id" name="idx" value="${clase.code} - ${clase.title}">
                    </div>
                </div>
                <label for="id">Students</label>

                <table class="table">
                    <tr>
                        <td scope="col">Id</td>
                        <td scope="col">Last Name</td>
                        <td scope="col">First Name</td>
                    </tr>
                    <c:forEach items="${estudiantes}" var="product">
                        <tr>
                            <td><c:out value="${product.studentid}" /></td>
                            <td><c:out value="${product.lastname}" /></td>
                            <td><c:out value="${product.firstname}" /></td>
                        </tr>
                    </c:forEach>
                </table>
                <button id="backclass" class="btn btn-primary">back</button>


                <%}%> 

            </div>
        </main>

        <footer class="footer mt-auto py-3 bg-light">
            <div class="container">
                <span class="text-muted">Desarrollado por Joaquin Heredia Molina</span>
            </div>
        </footer>


        <script src="resources/assets/dist/js/bootstrap.bundle.min.js"></script>
        <script src="resources/assets/custom.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    </body>
</html>
