<html>
    <head>
    <Title>helpdesk</Title>

    <Style>
       button:hover
    
       
       {
        background-color: rgb(6, 25, 25);
       }



    </Style>
    



    </head>
    <h1 style="color: rgb(5, 5, 5);" style="background-color:rgb(1, 1, 1);font-family: 'Times New Roman', Times, serif;" >Helpdesk (MVC)</h1>

    <body>

        <form action="login" method="post">
           <h3 style="color: rgb(10, 4, 4);"> Username:<input type="text" name="username"></h3>
          <h3 style="color: rgb(9, 4, 4);"> Password:<input type="password" name="password"></h3> 
            <button [disable]="username==undefined">Login</button>


            <button>
                <a href="register.jsp">Register Page</a>
            
            </button>

            <br><br>
        </form>
    </body>
</html>