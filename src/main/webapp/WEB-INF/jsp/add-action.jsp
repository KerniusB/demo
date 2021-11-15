<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <form:form method="post" modelAttribute="action">
            <c:if test="${action.id == 0}">
                <p>Add new user:</p>
            </c:if>
            <div>
                <c:if test="${action.id != 0}">
                    <p>Update user with id: ${action.id}:</p>
                </c:if>
                <form:input path="id" type="hidden" required="required"/>
                <form:errors path="id"/>
            </div>
            <div>
                <form:label path="inOut">inOut</form:label>
                <form:input path="inOut" type="text" required="required"/>
                <form:errors path="inOut"/>
            </div>
            <div>
                <form:label path="date">date</form:label>
                <form:input path="date" type="text" required="required"/>
                <form:errors path="date"/>
            </div>
            <div>
                <form:label path="amount">amount</form:label>
                <form:input path="amount" type="text" required="required"/>
                <form:errors path="amount"/>
            </div>
            <div>
                <form:label path="cashRegister.id">cash register id</form:label>
                <form:input path="cashRegister.id" type="text" required="required"/>
                <form:errors path="cashRegister.id"/>
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