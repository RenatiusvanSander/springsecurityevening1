<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Session Attributes in Spring MVC</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" 
            rel="stylesheet">
    </head>
    <body>
    	<div class="container">
    		<p>
    			<h3>Session Attributes Example</h3>
    		</p>
    	</div>
        <div class="container">
        	<br/>
        	<div class="row">
        				<a href="/sessionattributes/form" class="btn btn-sm btn-primary btn-block" role="button" 
										style="width: 10em;">Add New</a>
        	</div>
        	<br/>
        	<div class="row">
        		<div class="col card" style="padding: 1em;">
       				<div class="card-block">
       					<h5 class="card-title">TutorLessions List</h5>
						<table>
							<tbody>
								<tr>
								<th width="37.5%">Title</th>
									<th width="37.5%">Description</th>
									<th width="25%" >Create Date</th>
								</tr>
								<c:forEach var="tutorLessionItem" items="${tutorLessions}">
								<tr>
									<td>${tutorLessionItem.title}</td>
									<td>${tutorLessionItem.description}</td>
									<td>${tutorLessionItem.lessionDate}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
        </div>
    </body>
</html>