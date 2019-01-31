<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="css/basic.css">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script>
    function userStatus(){
        http.getResponse();
        document.getElementsById = "userStatus.jsp";
    }
    </script>
</head>
<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Paytm</h1>
    <div class="login-form" id = "main-form">
        <div class="main-div">
            <div class="panel" >
                <h2>login</h2>
                <p>Please enter your email and password</p>
            </div>
            <form id="Login" action="${pageContext.request.contextPath}/signup" method="post">
             <div class="form-group">
                                <input type="Name" name="name" class="form-control" id="Name" placeholder="Name">
                            </div>
                <div class="form-group">
                    <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email Address">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                </div>
                <input type="submit" class="btn btn-primary" onclick="userStatus()"></input>
            </form>
        </div>
        <p class="botto-text"> test</p>
    </div></div></div>


</body>
</html>