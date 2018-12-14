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
$(function(){
  $("#header").load("header.html");
  $("#footer").load("footer.html");
});


function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "ajax_info.txt", true);
  xhttp.send();
}

</script>
</head>
<body>
<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Paytm</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <h2>QA Login</h2>
                <p>Please enter Details to register as user</p>
            </div>
            <form id="Login">

                <div class="form-group">

                    <input type="name" class="form-control" id="inputName" placeholder="Name" style="visibility: hidden;">

                </div>
                <div class="form-group">


                    <input type="email" class="form-control" id="inputEmail" placeholder="Email Address">

                </div>

                <div class="form-group">

                    <input type="password" class="form-control" id="inputPassword" placeholder="Password">

                </div>
                <div class="forgot">
                    <a href="#">Create account</a> or <a href="reset.html">Forgot password?</a>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>

            </form>
        </div>
        <p class="botto-text"> Payments QA</p>
    </div></div></div>


</body>
</body>
</html>