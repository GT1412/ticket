<form action="adminlogin" >
    <h3> Username:<input type="text" name="username"></h3>
   <h3> Password:<input type="password" name="password"></h3> 
     <button [disable]="username==undefined">Login</button>


     <button>
        <a href="adminregister.jsp">Register Page</a>
    
    </button>
</form>
