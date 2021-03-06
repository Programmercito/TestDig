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
        <link href="resources/assets/css/sticky-footer-navbar.css" rel="stylesheet">
    </head>
    <body class="d-flex flex-column h-100">

        <header>
            <!-- Fixed navbar -->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="/TestDigitalWeb">Evaluate System</a>
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
                <h1 class="mt-5">Students  
                    <a title="New" href="student?accion=nuevo"><i class="far fa-file"></i></a>
                </h1>
                <h5>
                    <c:if test="${error!=null || error!=''}">
                        <p class="text-danger">${error}</p>
                    </c:if>
                </h5>

                <% if (request.getAttribute("accion") == null 
                        || "grabarnuevo".equals(request.getAttribute("accion")) 
                        || "grabarmod".equals(request.getAttribute("accion")) 
                        || "eliminar".equals(request.getAttribute("accion")) 
                       ) {%>  
                <table class="table">
                    <tr>
                        <td scope="col">Id</td>
                        <td scope="col">Last Name</td>
                        <td scope="col">First Name</td>
                        <td scope="col">Options</td>
                    </tr>
                    <c:forEach items="${estudiantes}" var="product">
                        <tr>
                            <td><c:out value="${product.studentid}" /></td>
                            <td><c:out value="${product.lastname}" /></td>
                            <td><c:out value="${product.firstname}" /></td>
                            <td>
                                <a title="edit" href="student?accion=modificar&id=${product.studentid}"><i class="fas fa-pen-alt"></i></a>
                                <a title="Delete" href="javascript:confirmarget('you sure?','student?accion=eliminar&id=${product.studentid}')"><i class="fas fa-trash-alt"></i></a>
                                <a title="View Class" href="student?accion=viewclass&id=${product.studentid}"><i class="fas fa-calendar-week"></i></a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <%} else if ("nuevo".equals(request.getAttribute("accion"))) {%> 

                <div class="container">
                    <form method="POST" action="student?accion=grabarnuevo">
                        <div class="form-group">
                            <label for="id">id</label>
                            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
                        </div>
                        <div class="form-group">
                            <label for="lastname">last name</label>
                            <input type="text" class="form-control" id="lastname" placeholder="Enter id" name="lastname">
                        </div>
                        <div class="form-group">
                            <label for="firstname">first name</label>
                            <input type="text" class="form-control" id="firstname" placeholder="Enter id" name="firstname">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
                <hr>
                <%} else if ("modificar".equals(request.getAttribute("accion"))) {%> 

                <div class="container">
                    <form method="POST" action="student?accion=grabarmod">
                        <div class="form-group">
                            <label for="id">id</label>
                            <input type="text" disabled class="form-control" id="idx" placeholder="Enter id" name="idx" value="${modificame.studentid}">
                            <input type="hidden"  class="form-control" id="id" placeholder="Enter id" name="id" value="${modificame.studentid}">
                        </div>
                        <div class="form-group">
                            <label for="lastname">last name</label>
                            <input type="text" class="form-control" id="lastname" placeholder="Enter id" name="lastname" value="${modificame.lastname}">
                        </div>
                        <div class="form-group">
                            <label for="firstname">first name</label>
                            <input type="text" class="form-control" id="firstname" placeholder="Enter id" name="firstname" value="${modificame.firstname}">
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

                <%} else if ("viewclass".equals(request.getAttribute("accion"))) {%> 

                <label for="id">Student</label>
                <div class="container">
                    <hr>
                    <a title="New class" href="student?accion=nuevoclass&id=${student.studentid}"><i class="far fa-file"></i></a> ADD class to list
                    <hr>
                    <div class="form-group">
                        <input type="text" disabled class="form-control" id="idx" placeholder="Enter id" name="idx" value="${student.studentid} - ${student.firstname} ${student.lastname}">
                    </div>
                </div>
                <label for="id">Class</label>
                <table class="table">
                    <tr>
                        <td scope="col">Code</td>
                        <td scope="col">title</td>
                        <td scope="col">Description</td>
                        <td scope="col">Options</td>
                    </tr>
                    <c:forEach items="${clases}" var="product">
                        <tr>
                            <td><c:out value="${product.code}" /></td>
                            <td><c:out value="${product.title}" /></td>
                            <td><c:out value="${product.description}" /></td>
                            <td><a title="Delete" href="javascript:confirmarget('you sure?','student?accion=deleterel&student=${student.studentid}&class=${product.code}')"><i class="fas fa-trash-alt"></i></a></td>


                        </tr>
                    </c:forEach>
                </table>
                <button id="backstudent" class="btn btn-primary">back</button>
                <%} else if ("nuevoclass".equals(request.getAttribute("accion"))) {%> 

                <div class="container">
                    <form method="POST" action="student?accion=grabarclass">
                        <div class="form-group">
                            <label for="id">Student</label>
                            <input type="text" disabled class="form-control" id="idx" placeholder="Enter id" name="idx" value="${student.studentid} - ${student.firstname} ${student.lastname}">
                            <input type="hidden"  class="form-control" id="id" placeholder="Enter id" name="id" value="${student.studentid}">
                        </div>
                        <div class="form-group">
                            <label for="class">Class</label>
                            <select name="clase"  class="form-select">
                                <c:forEach items="${clases}" var="product">
                                    <option value='${product.code}'>${product.code} ${product.title}-${product.description}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <hr>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>


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
