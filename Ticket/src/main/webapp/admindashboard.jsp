<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix ="c" %>
${user.tasks}
<table border="1">
    <tr>
        <td>Ticket ID</td>
        <td>Emp ID</td>
        <td>Emp Name</td>
        <td>Emp Mob</td>
        <td>Emp Email</td>
        <td>Category</td>
        <td>Issue</td>
        <td>Priority</td>
        <td>Status</td>
        <td>Action</td>
    </tr>

    <c:forEach var="task" items="${admin.task}">
    
        <tr>
            <td>${task.id}</td>
            <td>${task.empid}</td>
            <td>${task.empname}</td>
            <td>${task.empmob}</td>
            <td>${task.empmail}</td>
            <td>${task.category}</td>
            <td>${task.issue}</td>
            <td>${task.priority}</td>
            <td>${task.status}</td>
            <td>


                <button>
                    <a href="Status${admin.id}and${task.id}andstarted" style="text-decoration:none; color: black">Started</a>
                </button>
                <button>
                    <a href="Status${admin.id}and${task.id}andDone" style="text-decoration:none; color: black">Done</a>
                </button>
            </td>
        </tr>
        
    </c:forEach>
</table>
