<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4" lang="en">
    <head>
        <title>Session Attributes in Spring MVC</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    	<div class="container">
    		<p>
    			<h3>Session Attributes Example</h3>
    		</p>
    	</div>
        <div class="container">
            <h5>Enter a TutorLession</h5>
                <form action="#" th:action="@{/sessionattributes/form}" th:object="${tutorLessionItem}" method="post">
                	<div class="input-group">
                	<input type="text" name="title" class="form-control" placeholder="tutorLession" required autofocus/>
                		<input type="text" name="description" class="form-control" placeholder="description here!"/>
                		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button class="btn btn-sm btn-primary form-control text-center" type="submit" style="max-width: 80px;">Create</button>
                	</div>
                </form>
        </div>
    </body>
</html>