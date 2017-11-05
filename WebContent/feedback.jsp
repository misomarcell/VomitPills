<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback - Instant Vomit Pills</title>
<link rel="stylesheet" type="text/css" href="stylesheet/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
                    <div style="margin-bottom:5px;">
                        <div style="width:100px;float:left;">Name: </div>
                        <input id="name" type="text" name="name" class="text-input" value="${name}" style="width: 200px;" autocomplete="off"/>
                   	</div>
                    
                    <div style="margin-bottom:5px;">
                        <div style="width:100px;float:left;">Message: </div>
                        <input id="message" type="text" name="message" class="text-input" style="width: 540px;" maxlength="100" autocomplete="off"/>
                   	</div>
                    <input type="submit" name="submit" value="Send" class="submit-button" style="width:212px;margin-left:100px;"/>
                </form>
            </div>
            
            <div class="footer">
            Marcell Misó © 2016
            </div>
        </div>
    </body>
</html>
