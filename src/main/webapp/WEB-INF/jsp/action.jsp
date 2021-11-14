<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>inOut</th>
            <th>date</th>
            <th>amount</th>
            <th>cash register id</th>
            <th>cash register name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${actions}" var="action">
            <tr>
                <td>${action.id}</td>
                <td>${action.inOut}</td>
                <td>${action.date}</td>
                <td>${action.amount}</td>
                <td>${action.cashRegister.id}</td>
                <td>${action.cashRegister.name}</td>
                <td><a type="button" href="/update-action/${action.id}">UPDATE</a></td>
                <td><a type="button" href="/delete-action/${action.id}">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<%@ include file="common/footer.jspf" %>