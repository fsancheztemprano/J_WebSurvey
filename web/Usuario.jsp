<%--@elvariable id="usuario" type="dev.kurama.model.Usuario"--%>
<%--
  Created by IntelliJ IDEA.
  User: NarF
  Date: 02/12/2019
  Time: 4:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Usuario</title>
</head>
<body>
Usuario ${usuario.email}<br><br>
<c:choose>
    <c:when test="${empty usuario.respuestas}">Encuesta no Realizada"</c:when>
    <c:otherwise>Tu Encuesta:<br><br>
        <jsp:useBean id="source" class="dev.kurama.data.PreguntaDao"/>
        <c:forEach var="pregunta" items="${source.getPreguntas()}" varStatus="i">
            ${i.index} - Pregunta: ${pregunta.pregunta}<br>

            &nbsp;&nbsp;&nbsp;&nbsp;${usuario.respuestas.get(i.index).respuesta} - ${pregunta.opciones.get(usuario.respuestas.get(i.index).respuesta)}
            <br>
            <br>
        </c:forEach>
    </c:otherwise>
</c:choose>
<br><br>
<a href="/login">Volver</a>
</body>
</html>
