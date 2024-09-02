<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>タスク一覧</h2>
        <ul>
            <c:forEach var="task" items="${tasks}"> <%-- var="task"のtaskは変数に指定してるだけ。そのあとのtasksはIndexServletで定義したもの --%>
                <li>
                    <a href="${pageContext.request.contextPath}/show?id=${task.id}"> <%-- ここから下のc:outまでのtaskは上の変数のやつ --%>
                        <c:out value="${task.id}" />
                    </a>
                    ：<c:out value="${task.content}" />
                </li>
            </c:forEach>
        </ul>

        <p><a href="${pageContext.request.contextPath}/new">新規タスクの投稿</a></p>

    </c:param>
</c:import>