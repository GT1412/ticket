<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix ="c" %>
<html>
    <head>



        <title>helpdesk</title>



        <Style>
            button:hover
            
            
            {
             background-color: rgb(11, 12, 12);
            }
     
     
     
         </Style>
    </head>

    


    <body>
        WelCome ${user.name}
<button>
    <a href="logout" >Logout</a>
</button>

<br>
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

    <c:forEach var="task" items="${user.tasks}">
    
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
                    <a href="delete${task.id}" >Delete</a>
                </button>


            </td>
        </tr>
        
    </c:forEach>
</table>

<form action="add${user.id}" method="post">
    EmpID:<input type="number" name="empid"><br>
    Name:<input type="text" name="empname"><br>
    MobNo:<input type="text" name="MobNo"><br>
    Email:<input type="text" name="Email"><br>
    Category:<input type="text" name="Category"><br>
    Issue:<input type="text" name="issue"><br>
    Priority:<input type="number" name="priority"><br>
    <button>Add</button>
</form>
    </body>
</html>