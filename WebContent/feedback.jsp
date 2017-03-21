<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback - Instant Vomit Pills</title>
<link rel="stylesheet" type="text/css" href="stylesheet/style.css">
<link rel="stylesheet" href="./font-awesome/css/font-awesome.min.css">
</head>
    
    <body>
        <div class="center">
    		<div class="login-container">
           		<span class="subscription-label"><b>Subscribe to our newsletter:</b></span>
                <form action="Subscribe" method="POST">
                    <input id="email" name="email" type="email" placeholder="E-mail address" class="text-input email-input"/>
                    <input id="submit" name="submit" type="submit" value="Subscribe!" class="submit-button"/>
                </form>
            </div>
            
            <div class="image-holder">
                <div class="menu-container">
                    <a href="./index.html"><div class="menu-item">Homepage</div></a>
                    <a href="./buy-now.html"><div class="menu-item">Pre-order</div></a>
                    <a href="./variants.html"><div class="menu-item">Variants</div></a>
                    <a href="./feedback.html"><div class="menu-item">Feedback</div></a>  
                    <a href="./contact.html"><div class="menu-item">Contact</div></a>         
                </div>
                <img src="./images/main_image.png" style="visibility:hidden; width:100%; margin-bottom:-40px;">
            </div>
            
            <center><b>FEEDBACK</b></center>
            
            <!-- MESSAGES: START-->
            <div class="info-conatiner feedback-container">
            	${message}
            </div>
            <!-- MESSAGES: END-->
            
            <div class="send-message">
            	<form method="POST">
                    <span>Name: </span>
                    <input id="name" type="text" name="name" class="text-input" style="width: 20%;"/><br />
                    
                	<span>Message: </span>
                	<input id="message" type="text" name="message" class="text-input" style="width: calc(80% - 160px);"/>
                    <input type="submit" name="submit" value="Send" class="submit-button" style="width:150px"/>
                </form>
            </div>
            
            <div class="footer">
            Marcell Mis� � 2016
            </div>
        </div>
    </body>
</html>
