<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	margin-top: -40px;
	}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
  margin-left: 600px;
}

/* Add padding to container elements */
.container {
    padding: 16px;
    text-align:center;
    margin-left: 50px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
     
    }
}
</style>

<body>

<form action="LStoreCustomer" method="post"  enctype="multipart/form-data" style="
    margin-top:  -70px;     margin-left: -30px;
">
  <div class="container">
   
    <br><br><br><br><br><br><br><br>
    <h3>Click a Selfie!</h3>
   
           <input type="file" name="file" value="file" style="margin-left:70px;">
    
       
 <br><br>
   
   
      <button type="submit" name="submit" value="signupbtn" class="signupbtn" style="width:250px; height: 40px;    margin-left: 18px;margin-top: 10px;   -webkit-box-shadow: 6px 5px 24px white;
  -moz-box-shadow: 6px 5px 24px white;
  box-shadow: 6px 5px 24px black;">Send Photo</button>
    
    </div>
  
</form>
<br><br>
<form action="https://getyourfood.azurewebsites.net/" >
	<button type="submit" style=" width:250px; height: 40px; margin-left: 55px;margin-top: 100px;   -webkit-box-shadow: 6px 5px 24px white;
  -moz-box-shadow: 6px 5px 24px white;box-shadow: 6px 5px 24px black;
  background-color: #A9A9A9;"> HOME PAGE</button>	
	</form>

</body>
</html>
