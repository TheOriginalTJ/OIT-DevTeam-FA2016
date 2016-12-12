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
  
  <script src="https://code.jquery.com/jquery-1.12.3.js"></script>
   <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
   <script src=" https://cdn.datatables.net/buttons/1.2.3/js/dataTables.buttons.min.js"></script>
  
  

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

<%@ page import="java.util.List" %>
<script>
var table;
</script>

<table id="table1" class="table table-striped">
                <thead>
                						
                <tr>
                    <th>Building:</th>
                    <th>Room Number:</th>
                    <th>Edit:</th>
                    <th>Slots:</th>
                    <th>getSeatingType:</th>
                    <th>getCb_whiteboard:</th>
                    <th>getCb_chalkboard:</th>
                    <th>getCb_computer:</th>
                    <th>getCb_soundsystem:</th>
                    <th>getCb_cdplayer:</th>
                    <th>getCb_dvdplayer:</th>
                    <th>getCb_videoprojector:</th>
                    <th>getCb_hearingassisted:</th>
                    <th>getCb_visualoptimizer:</th>
                    <th>getCb_laptopconnectivity:</th>
                    <th>getCb_networkconnections:</th>
                    <th>getCb_overheadprojector:</th>
                    <th>getCb_podium:</th>
                    <th>getCb_projectorscreen:</th>
                    <th>getCb_monitors:</th>
                    <th>getCb_piano:</th>
                    
                </tr>
                </thead>

                <tbody>

                <%
                	GUI_Dev.Resource res = new GUI_Dev.Resource();
 					List<OIT_Dev.Classroom> filtered = res.filteredRoom.getFilteredList();
 					
                    for(int i=0; i<filtered.size(); i++){
                %>

                <tr id="<%=i%>">
                    <td><%=filtered.get(i).getBuilding()%>
                    </td>
                    <td><%=filtered.get(i).getRoomnum()%>
                    </td>
                    <td><a onclick="edit(<%=i%>);">Edit</a></td>
                    <td><%= filtered.get(i).getSeats()%>
                    </td>
                    <td><%= filtered.get(i).getSeatingtype()%>
                    </td>
                    <td><%= filtered.get(i).isWhiteboard()%>
                    </td>
                    <td><%= filtered.get(i).isChalkboard()%>
                    </td>
                    <td><%= filtered.get(i).isComputer()%>
                    </td>
                    <td><%= filtered.get(i).isSoundsystem()%>
                    </td>
                    <td><%= filtered.get(i).isCdplayer()%>
                    </td>
                    <td><%= filtered.get(i).isDvdplayer()%>
                    </td>
                    <td><%= filtered.get(i).isVideoprojector()%>
                    </td>
                    <td><%= filtered.get(i).isHearingassisted()%>
                    </td>
                    <td><%= filtered.get(i).isVisualoptimizer()%>
                    </td>
                    <td><%= filtered.get(i).isLaptopconnectivity()%>
                    </td>
                    <td><%= filtered.get(i).isNetworkconnections()%>
                    </td>
                    <td><%= filtered.get(i).isOverheadprojector()%>
                    </td>
                    <td><%= filtered.get(i).isPodium()%>
                    </td>
                    <td><%= filtered.get(i).isProjectorscreen()%>
                    </td>
                    <td><%= filtered.get(i).isMonitors()%>
                    </td>
                    <td><%= filtered.get(i).isPiano()%>
                    </td>
                    
                </tr>
                <% }
                %>
                </tbody>
            </table>
            
            <script>
            
            	function edit(id){
            		document.getElementById('single').style.display = 'block';
            		document.getElementById('table1').style.display = 'none';  
            		
            		document.getElementById("oldName").value = table.row(id).data()[0];
            		document.getElementById("oldNum").value = table.row(id).data()[1];
            		
            		document.getElementById("building").value = table.row(id).data()[0];
            		document.getElementById("classroom_number").value = table.row(id).data()[1];
            		document.getElementById("number_of_slots_classroom").value = table.row(id).data()[3];
            		
            		if(table.row(id).data()[4]=="group" || table.row(id).data()[4]=="Group Seating"){
            			 $("#chairs").val("Group Seating");
            		}
            		if(table.row(id).data()[4]=="individual" || table.row(id).data()[4]=="Individual Seating"){
            			 $("#chairs").val("Individual Seating");
            		}
            		if(table.row(id).data()[5]=="true"){
            			document.getElementById("whiteboard").checked = true;	
            		}
            		if(table.row(id).data()[6]=="true"){
            			document.getElementById("chalkBoard").checked = true;	
            		}
            		if(table.row(id).data()[7]=="true"){
            			document.getElementById("computerLaptop").checked = true;	
            		}
            		if(table.row(id).data()[8]=="true"){
            			document.getElementById("soundSystem").checked = true;	
            		}
            		if(table.row(id).data()[9]=="true"){
            			document.getElementById("cd").checked = true;	
            		}
            		if(table.row(id).data()[10]=="true"){
            			document.getElementById("dvd").checked = true;	
            		}
            		if(table.row(id).data()[11]=="true"){
            			document.getElementById("dataVideoProjector").checked = true;	
            		}
            		if(table.row(id).data()[12]=="true"){
            			document.getElementById("hearingAssisted").checked = true;	
            		}
            		if(table.row(id).data()[13]=="true"){
            			document.getElementById("visualOptimizer").checked = true;	
            		}
            		if(table.row(id).data()[14]=="true"){
            			document.getElementById("laptopConnectivity").checked = true;	
            		}
            		if(table.row(id).data()[15]=="true"){
            			document.getElementById("networkConnection").checked = true;	
            		}
            		if(table.row(id).data()[16]=="true"){
            			document.getElementById("overhearProjector").checked = true;	
            		}
            		if(table.row(id).data()[17]=="true"){
            			document.getElementById("podium").checked = true;	
            		}
            		if(table.row(id).data()[18]=="true"){
            			document.getElementById("projectorScreen").checked = true;	
            		}
            		if(table.row(id).data()[19]=="true"){
            			document.getElementById("tvMonitors").checked = true;	
            		}
            		if(table.row(id).data()[10]=="true"){
            			document.getElementById("piano").checked = true;	
            		}
            		
            	}
            	
            	
            	
            	
            	
            	$(document).ready(function () {
                    table = $('#table1').DataTable({
        				"paging":   false,
       					 "ordering": false,
        				"info":     false,
        				"searching": false,
        				 dom: 'Bfrtip',
        				buttons: [
           				 {
                		text: 'Return to home page',
                		action: function ( e, dt, node, config ) {
                			window.location.href='index.jsp';
                		}
            			}
        				]
   					 });
   					 
   					 for(var i=3; i<=20; i++){
   					 	table.column( i ).visible(false,false);
   					 }
               });
               
            </script>
            
            
            
            
            
         <div id="single">
        <form class="form-horizontal" role="form" method="POST" action="http://localhost:8080/ClassAllocation/edit">
            <div class="row">
                <h1></h1>
            </div>
            <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <div class="form-group">
                                <label for="building">Building</label>
                                <input type="text" id="building" name="building" class="form-control"
                                       placeholder="Ex: SB" pattern="[A-Za-z0-9]{1,5}"
                                       required>
                            </div>
                        </div>
                        <div class="col-md-2 col-md-offset-2">
                            <div class="form-group">
                                <label for="classroom_number">Classroom Number</label>
                                <input type="text" id="classroom_number" name="classroom_number" class="form-control"
                                       placeholder="Ex: 165" pattern="[A-Za-z0-9]{1,7}" required>
                            </div>
                        </div>
                         <div class="col-md-2 col-md-offset-2">
                   		 	<div class="form-group">
                        		<label for="number_of_slots_classroom">Number of Available Seats</label>
                        		<input type="text" id="number_of_slots_classroom" name="number_of_slots_classroom" class="form-control"
                               	placeholder="Ex: 32" pattern="[0-9]{1,3}" required>
                    		</div>
                		</div>
                    </div>
                    <div class="row">
                        <center><h3>Classroom Features</h3></center>
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
                        <label><input type="checkbox" id="whiteboard" name="whiteboard" value="">White Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="chalkBoard" name="chalkBoard" value="">Chalk Board</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="computerLaptop" name="computerLaptop" value="">Built-in Computer/Laptop</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="soundSystem" name="soundSystem" value="">Built-in Sound System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="cd" name="cd" value="">CD Player</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" id="dvd" name="dvd" value="">DVD Player</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="dataVideoProjector" name="dataVideoProjector" value="">Data/Video Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="hearingAssisted" name="hearingAssisted" value="">Hearing Assisted System</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="visualOptimizer" name="visualOptimizer" value="">Visual Optimizer</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="laptopConnectivity" name="laptopConnectivity" value="">Laptop Connectivity</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" id="networkConnection" name="networkConnection" value="">Network Connections</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="overhearProjector" name="overhearProjector" value="">Overhead Projector</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="podium" name="podium" value="">Podium</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="projectorScreen" name="projectorScreen" value="">Projector Screen</label>
                    </div>
                </div>
                <div class="col-md-2">
                    <div class="checkbox">
                        <label><input type="checkbox" id="tvMonitors" name="tvMonitors" value="">TV/Monitors</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 col-md-offset-1">
                    <div class="checkbox">
                        <label><input type="checkbox" id="piano" name="piano" value="">Piano</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <h1></h1>
                </div>
                <div class="row">
                <input hidden type="hidden" id="oldName" name="oldName" class="form-control">
                <input hidden type="hidden" id="oldNum" name="oldNum" class="form-control">
                
                    <div class="col-md-2 col-md-offset-2">
                        <button type="button" class="btn btn-default" onclick="cancel();">Cancel</button>
                    </div>
                    <div class="col-md-2 col-md-offset-1">
                        <button type="submit" class="btn btn-default" name="submit">Submit Changes</button>
                    </div>
                    <div class="col-md-2 col-md-offset-1">
                        <button type="submit" class="btn btn-default" name="delete">Delete Class</button>
                    </div>
                </div>
                
                <script>
                	function cancel(){
                		document.getElementById('table1').style.display = 'table';
            			document.getElementById('single').style.display = 'none'; 
            			
            			document.getElementById("whiteboard").checked = false;	
            			document.getElementById("chalkBoard").checked = false;	
            			document.getElementById("computerLaptop").checked = false;
            			document.getElementById("soundSystem").checked = false;	
            			document.getElementById("cd").checked = false;
            			document.getElementById("dvd").checked = false;
            			document.getElementById("dataVideoProjector").checked = false;
            			document.getElementById("hearingAssisted").checked = false;	
            			document.getElementById("visualOptimizer").checked = false;	
            			document.getElementById("laptopConnectivity").checked = false;
            			document.getElementById("networkConnection").checked = false;
            			document.getElementById("overhearProjector").checked = false;	
            			document.getElementById("podium").checked = false;	
            			document.getElementById("projectorScreen").checked = false;	
            			document.getElementById("tvMonitors").checked = false;	
            			document.getElementById("piano").checked = false;	
            	
                	}
                	
                	
                </script>
            </div>
        </form>
    </div>
            
    <script>
    window.onload = function(){
   		document.getElementById('single').style.display = 'none';  
    }
   
    </script>    

</body>
</html>
        