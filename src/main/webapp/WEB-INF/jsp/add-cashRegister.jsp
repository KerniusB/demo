<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="cashRegister">
        <c:if test="${cashRegister.id == null}">
            <p>Add new user:</p>
        </c:if>
        <div>
            <c:if test="${cashRegister.id != null}">
                <p>Update user with id: ${cashRegister.id}:</p>
            </c:if>
            <form:input path="id" type="hidden" required="required"/>
            <form:errors path="id"/>
        </div>
        <div>
            <form:label path="name">Name</form:label>
            <form:input path="name" type="text" required="required"/>
            <form:errors path="name"/>
        </div>
        <button type="submit">OK</button>
    </form:form>
    <c:if test="${errorMessage != null}">
        <div>
            ${errorMessage}
        </div>
    </c:if>
</div>

<%@ include file="common/footer.jspf" %>