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
   function fun(){
var t = document.getElementById("Name");
t.style.display = 'block';
    }
    </script>
</head>
<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Paytm</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>QA Login</h2>
                <p>Please enter your email and password</p>
            </div>
            <form id="Login">
             <div class="form-group">
                                <input type="Name" class="form-control" id="Name" placeholder="Name" style="display:none;">
                            </div>
                <div class="form-group">
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                </div>
                <div class="forgot">
                    <a href="#">Forgot password?</a> or  <a href="#">Signup</a>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
                or
                <button type="submit" class="btn btn-primary" onclick=fun();>Signup</button>
            </form>
        </div>
        <p class="botto-text"> Payments QA</p>
    </div></div></div>


</body>
</html>