<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del Estudiante</title>
    </head>
    <body>
        <h1>Informacion del Estudiante</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo del Estudiante</td>
                    <td><input type="text" name="codEstudiante" value="${student.codEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombreEstudiante" value="${student.nombreEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Apellido</td>
                    <td><input type="text" name="apellidoEstudiante" value="${student.apellidoEstudiante}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestreEstudiante" value="${student.semestreEstudiante}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Codigo del Estudiante</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Semestre</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.codEstudiante}</td>
                    <td>${stud.nombreEstudiante}</td>
                    <td>${stud.apellidoEstudiante}</td>
                    <td>${stud.semestreEstudiante}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
