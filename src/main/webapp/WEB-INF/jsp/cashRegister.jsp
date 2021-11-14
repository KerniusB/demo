<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cashRegisters}" var="cashRegister">
            <tr>
                <td>${cashRegister.id}</td>
                <td>${cashRegister.name}</td>
                <td><a type="button" href="/update-cashRegister/${cashRegister.id}">UPDATE</a></td>
                <td><a type="button" href="/delete-cashRegister/${cashRegister.id}">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<%@ include file="common/footer.jspf" %>