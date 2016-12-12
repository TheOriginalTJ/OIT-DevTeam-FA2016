<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>Classroom Allocation</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Classroom Allocation</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <form class="form-inline" role="form" method="POST"
                      action="http://localhost:8080/ClassAllocation/exit" enctype="multipart/form-data">
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Terminate Program</button>
                    </div>
                </form>
            </li>
        </ul>
   </div>
</nav>




<div class="row">
	<h1 class="text-center">Your schedule has been created</h1>
</div>
<div class="row">
<form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/download">
	<div class="col-md-3 col-md-offset-4">
	<input type="text" id="dir" name="dir" class="form-control"
                                       placeholder="Input full path of directory to save" required>
		 
	</div>
	<button type="submit" class="btn btn-default" name="submit">Download schedule</button>
</form>
</div>
<div class="row">
<h1></h1>
</div>
<div class="row">
<h1></h1>
</div>
<div class="row">
<h1></h1>
</div>
<div class="row">
<h1></h1>
</div>
<div class="row">
<h1></h1>
</div>

<div class="row">
	<div class="col-md-4 col-md-offset-5">
		<a href="index.jsp" class="btn btn-default btn-lg" role="button">Return to home page</a>
	</div>
</div>


</body>
</html>