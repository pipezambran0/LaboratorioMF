<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion del Curso</title>
    </head>
    <body>
        <h1>Informacion del Curso</h1>
        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Codigo del Curso</td>
                    <td><input type="text" name="codCurso" value="${course.codCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre del Curso</td>
                    <td><input type="text" name="nombreCurso" value="${course.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Creditos</td>
                    <td><input type="text" name="numCreditosCurso" value="${course.numCreditosCurso}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestreCurso" value="${course.semestreCurso}" /></td>
                </tr>
                <tr>
                    <td>Estudiantes Admitidos</td>
                    <td><input type="text" name="numEstudAdmitidosCurso" value="${course.numEstudAdmitidosCurso}" /></td>
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
            <th>Codigo del Curso</th>
            <th>Nombre del Curso</th>
            <th>Creditos</th>
            <th>Semestre</th>
            <th>Estudiantes Admitidos</th>
                <c:forEach items="${allCourses}" var="cur">
                <tr>
                    <td>${cur.codCurso}</td>
                    <td>${cur.nombreCurso}</td>
                    <td>${cur.numCreditosCurso}</td>
                    <td>${cur.semestreCurso}</td>
                    <td>${cur.numEstudAdmitidosCurso}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
