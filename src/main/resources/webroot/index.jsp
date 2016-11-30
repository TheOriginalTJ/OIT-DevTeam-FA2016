<!DOCTYPE html>
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
                      action="http://localhost:8080/ClassAllocation/schedule" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="custom-file">
                            <input type="file" id="schedule" name="schedule" class="custom-file-input" required>
                            <span class="custom-file-control"></span>
                        </label>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Start from Previous Schedule</button>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</nav>


<ul class="nav nav-tabs" role="tablist">
    <li class="nav-item active">
        <a class="nav-link active" data-toggle="tab" href="#multiple" role="tab">Add Multiple Classes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#single" role="tab">Add Single Class</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#delete" role="tab">Edit Class</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" data-toggle="tab" href="#classrooms" role="tab">Classrooms</a>
    </li>
</ul>


<div class="tab-content">
    <div id="multiple" class="tab-pane fade in active">
        <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/multiple"
              enctype="multipart/form-data">
            <div class="form-group">
                <div class="row">
                    <h1></h1>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-5">
                        <label class="custom-file">
                            <input type="file" id="file_name" name="file_name" class="custom-file-input" required>
                            <span class="custom-file-control"></span>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-md-4 col-md-offset-5">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </div>
        </form>
        <h1> </h1>
        <center><h5>Example TXT (Separated by tabs)</h5></center>
        <center><img src="exampleTXT.png" alt="Example TXT (Separated by tabs)" style="width:1250px;"><center>
        <a class="btn btn-default" href="http://localhost:8080/ClassAllocation/ExampleTXT.txt" download>
            Download Example TXT File</a>
    </div>


    <div id="single" class="tab-pane fade">
        <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/single">
            <div class="row">
                <h1></h1>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                       <label for="course_number">Course Number</label>
                        <input type="text" id="course_number" name="course_number" class="form-control" placeholder="Ex: COSC120"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_section">Course Section</label>
                        <input type="text" id="course_section" name="course_section" class="form-control" placeholder="Ex: 01"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_name">Course Name</label>
                        <input type="text" id="course_name" name="course_name" class="form-control" placeholder="Ex: Computer Science 1"
                               required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                        <label for="instructor">Instructor ID</label>
                        <input type="text" id="instructor" name="instructor" class="form-control" placeholder="Ex: 123456" required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_days">Course Meeting Days</label>
                        <input type="text" id="course_days" name="course_days" class="form-control" placeholder="Ex: -M-W-F-"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="number_of_slots">Number of Available Slots</label>
                        <input type="text" id="number_of_slots" name="number_of_slots" class="form-control"
                               placeholder="Ex: 32" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                    <label for="start_time">Start Time</label>
                        <input type="text" id="start_time" name="start_time" class="form-control" placeholder="Ex: 920"
                               required>
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="end_time">End Time</label>
                        <input type="text" id="end_time" name="end_time" class="form-control" placeholder="Ex: 1030"
                               required>
                    </div>
                </div>
            </div>
            <div class="row">
                <center><h3>Required Features</h3></center>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-5">
                    <div class="form-group form-group-sm">
                        <div class="col-md-5">
                            <select class="form-control" id="chairs" name="chairs">
                                <option>Individual Seating</option>
                                <option>Group Seating</option>
                            </select>
                        </div>
                        <label class="control-label" for="chairs">Seating Type</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="whiteboard" value="">White Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="chalkBoard" value="">Chalk Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="computerLaptop" value="">Built-in Computer/Laptop</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="soundSystem" value="">Built-in Sound System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="cd" value="">CD Player</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="dvd" value="">DVD Player</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="dataVideoProjector" value="">Data/Video Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="hearingAssisted" value="">Hearing Assisted System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="visualOptimizer" value="">Visual Optimizer</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="laptopConnectivity" value="">Laptop Connectivity</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="networkConnection" value="">Network Connections</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="overhearProjector" value="">Overhead Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="podium" value="">Podium</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="projectorScreen" value="">Projector Screen</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" name="tvMonitors" value="">TV/Monitors</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" name="piano" value="">Piano</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <h1></h1>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-5">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div id="delete" class="tab-pane fade">
        <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/delete">
            <div class="row">
                <h1></h1>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="form-group">
                        <label for="discipline_delete">Discipline</label>
                        <input type="text" id="discipline_delete" name="discipline_delete" class="form-control" placeholder="Ex: COSC">
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="course_number_delete">Course Number</label>
                        <input type="text" id="course_number_delete" name="course_number_delete" class="form-control"
                               placeholder="Ex: COSC120">
                    </div>
                </div>
                <div class="col-md-2 col-md-offset-2">
                    <div class="form-group">
                        <label for="instructor_delete">Instructor ID</label>
                        <input type="text" id="instructor_delete" name="instructor_delete" class="form-control" placeholder="Ex: 123456">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <h1></h1>
                </div>
                <div class="row">
                    <div class="col-md-4 col-md-offset-5">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div id="classrooms" class="tab-pane fade">
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item active">
                <a class="nav-link active" data-toggle="tab" href="#add" role="tab">Add Classroom</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-toggle="tab" href="#edit" role="tab">Edit Classroom</a>
            </li>
        </ul>
        <div class="tab-content">
            <div id="add" class="tab-pane fade in active">
                <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/addClassroom">
                    <div class="row">
                        <h1></h1>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-3">
                            <div class="form-group">
                                <label for="building">Building</label>
                                <input type="text" id="building" name="building" class="form-control"
                                       placeholder="Ex: SB"
                                       required>
                            </div>
                        </div>
                        <div class="col-md-2 col-md-offset-2">
                            <div class="form-group">
                                <label for="classroom_number">Classroom Number</label>
                                <input type="text" id="classroom_number" name="classroom_number" class="form-control"
                                       placeholder="Ex: 165" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <center><h3>Classroom Features</h3></center>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-3">
                            <div class="form-group form-group-sm">
                                <div class="col-md-5">
                                    <input class="form-control" type="text" id="chairs_add" name="chairs_add" placeholder="Ex: 30">
                                </div>
                                <label class="control-label" for="chairs_add">Number of Chairs</label>
                            </div>
                        </div>
                        <div class="col-md-2 col-md-offset-2">
                            <div class="form-group form-group-sm">
                                <div class="col-md-5">
                                    <input class="form-control" type="text" id="desks_add" name="desks_add" placeholder="Ex: 30">
                                </div>
                                <label class="control-label" for="desks_add">Number of Desks</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <div class="checkbox">
                                <label><input type="checkbox" name="whiteboard" value="">White Board</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="chalkBoard" value="">Chalk Board</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="computerLaptop" value="">Built-in Computer/Laptop</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="soundSystem" value="">Built-in Sound System</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="cd" value="">CD Player</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <div class="checkbox">
                                <label><input type="checkbox" name="dvd" value="">DVD Player</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="dataVideoProjector" value="">Data/Video Projector</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="hearingAssisted" value="">Hearing Assisted System</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="visualOptimizer" value="">Visual Optimizer</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="laptopConnectivity" value="">Laptop Connectivity</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <div class="checkbox">
                                <label><input type="checkbox" name="networkConnection" value="">Network Connections</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="overhearProjector" value="">Overhead Projector</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="podium" value="">Podium</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="projectorScreen" value="">Projector Screen</label>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" name="tvMonitors" value="">TV/Monitors</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <div class="checkbox">
                                <label><input type="checkbox" name="piano" value="">Piano</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <h1></h1>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-md-offset-5">
                                <button type="submit" class="btn btn-default">Add Classroom</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div id="edit" class="tab-pane fade">
                <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/editClassroom">
                    <div class="row">
                        <h1></h1>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-3">
                            <div class="form-group">
                                 <label for="building_edit">Building</label>
                                <input type="text" id="building_edit" name="building_edit" class="form-control"
                                       placeholder="Ex: SB">
                            </div>
                        </div>
                        <div class="col-md-2 col-md-offset-2">
                            <div class="form-group">
                            	<label for="classroom_number_edit">Classroom Number</label>
                                <input type="text" id="classroom_number_edit" name="classroom_number_edit" class="form-control"
                                       placeholder="Ex: 165">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <h1></h1>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-md-2 col-md-offset-5">
                                <button type="submit" class="btn btn-default">Search for Classroom</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"
        integrity="sha384-THPy051/pYDQGanwU6poAc/hOdQxjnOEXzbT+OuUAFqNqFjL+4IGLBgCJC3ZOShY"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.2.0/js/tether.min.js"
        integrity="sha384-Plbmg8JY28KFelvJVai01l8WyZzrYWG825m+cZ0eDDS1f7d/js6ikvy1+X+guPIB"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js"
        integrity="VjEeINv9OSwtWFLAtmc4JCtEJXXBub00gtSnszmspDLCtC0I4z4nqz7rEFbIZLLU" crossorigin="anonymous"></script>
</body>
</html>

