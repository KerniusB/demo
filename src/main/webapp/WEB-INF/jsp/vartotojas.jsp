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
        <c:forEach items="${vartotojai}" var="vartotojas">
            <tr>
                <td>${vartotojas.id}</td>
                <td>${vartotojas.name}</td>
                <td><a type="button" href="/update-vartotojas/${vartotojas.id}">UPDATE</a></td>
                <td><a type="button" href="/delete-vartotojas/${vartotojas.id}">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<%@ include file="common/footer.jspf" %>