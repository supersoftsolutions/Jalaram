<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>
<head>
<title>Jalaram</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="AdminResources/css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="AdminResources/css/style.css" rel='stylesheet' type='text/css' />
<link href="AdminResources/css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="AdminResources/css/font.css" type="text/css"/>
<link href="AdminResources/css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="AdminResources/css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="AdminResources/css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="AdminResources/js/jquery2.0.3.min.js"></script>
<script src="AdminResources/js/raphael-min.js"></script>
<script src="AdminResources/js/morris.js"></script>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
         $(function() {
            $( "#date" ).datepicker({

         
/*                   defaultDate:+1	,
 */               dateFormat:"yy-mm-dd",
               altField: "#day",
               altFormat: "D"
            });
           // $( "#datepicker-3" ).datepicker("setDate", "1");  

         }); 
         </script>
         
     <!--     <script>
function myFunction() {
  var x = document.getElementById("rate");
  var y = document.getElementById("kg");
  
  var t=x.value*y.value;
  document.getElementById("total").value =t;
}
</script> -->

   <script>
		function getSelectValue()
		{
			var selectedValue = document.getElementById("name").value;
			//var a = dropdown1.options[dropdown1.selectedIndex].value;
			var selectedValue1 = document.getElementById("charges");
			selectedValue1.value=(selectedValue);
			console.log(selectedValue1.value);
		}
</script> 


 <script>
		function getSelectValue1()
		{
			var selectedValue = document.getElementById("name1").value;
			//var a = dropdown1.options[dropdown1.selectedIndex].value;
			var selectedValue1 = document.getElementById("charges1");
			selectedValue1.value=(selectedValue);
			console.log(selectedValue1.value);
		}
</script> 

 <!-- <script type="text/javascript">  
     $(document).ready(function() {                                       
        $("#name").live("change", function() {
          $("#charges").val($(this).find("option:selected").attr("value"));
        })
     });                                     
</script>  -->

</head>
<body>
<!--sidebar end-->
<!--main content start-->
<jsp:include page="Header.jsp"></jsp:include>
<section id="main-content">


<div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Add Charges
                            
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <f:form class="cmxform form-horizontal " modelAttribute="data" id="signupForm" method="post" action="" novalidate="">
                                	<f:hidden path="regular_orderid" />
                                
                                      <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Transport Type</label>
                                        <div class="col-lg-6">
     							<f:select path="" class="custom-select form-control" required="">
                                     			<f:option value="local">Local</f:option>
                                            	<f:option value="khaman">Out side</f:option>
                                     
                                            </f:select>
                                        </div>
                                    </div>
                                    
                                            <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Transport Name</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="" class="custom-select form-control" required="" id="name" onchange="getSelectValue();">
     							        <f:options items="${list}" itemLabel="Name" itemValue="charges"/>
                                     		
                                            </f:select>
                                        </div>
                                    </div>
                                  <%--   
                                      <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Transport Name</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="" class="custom-select form-control" required="" id="changes">
     							        <f:options items="${list}" itemLabel="charges" itemValue="transportid"/>
                                     		
                                            </f:select>
                                        </div>
                                    </div> --%>
                                    
                                    
                             <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Transport Charges</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control"  type="text" id="charges" name="charges" value="" required="required"/>
                                        </div>
                                    </div> 
                                 
                                    
                                  <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Labour Name</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="" class="custom-select form-control" required="" id="name1" onchange="getSelectValue1();">
     							        <f:options items="${plist}" itemLabel="Name" itemValue="charges"/>
                                     		
                                            </f:select>
                                        </div>
                                    </div>
                                    
                                        <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Labour Charges</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" value="" type="text" id="charges1" required="required"/>
                                        </div>
                                    </div>
                                    
                                     	<div class="form-group ">
									<label for="mon" class="control-label col-lg-3">Kg
										</label>
									<div class="col-lg-6">
										<f:input class=" form-control" id="kg" path="kg" type="text" onkeyup="myFunction()"
											required="required" />
									</div>
								</div>
                                    
                                 
                                  
                                    
                      <div class="table-responsive">
      <table class="table table-striped b-t b-light" id="id1">
        <thead>
          <tr>
          <!--   <th style="width:20px;">
              <label class="i-checks m-b-none">
                <input type="checkbox"><i></i>
              </label>
            </th> -->
            <th>Name</th> 
             <th>Charge</th>
           
           	
            
            <th style="width:30px;"></th>
          </tr>
        </thead>
         <tbody>
         
                                        <c:forEach items="${clist}" var="x">
                                        <tr>
                                            
                                            
                                     <td>${x.l_name}</td> 
                                     <td>${x.l_charge}</td> 
                                           
                                            
<%--       <td height="30px" width="30px"> <a href="delete_expense.html?id=${x.ID}">Delete</a></td> 
 --%>                                           
      <!--    <td>       -->
          <%--  <button class="btn btn-primary" type="submit" onclick="showPopupWindow(); setAttributes(${question.id}, 0>Save</button> --%> 
<%--            <button onclick="showPopupWindow(); setAttributes(${x.ID}, 0)">Reply</button>
 --%>       <!--   </td>                                  -->
                                            
                                                </tr>
                                        </c:forEach>
                                      </tbody>

      </table>
      
      
    </div>
    
    				  <div class="form-group">
                                        <div class="col-lg-offset-5 col-lg-6">
                                            <button class="btn btn-primary" type="submit">Save</button>
                                        </div>
                                    </div>
                                   
                                </f:form>
                                
                                
                            </div>

	</div>
	
	               
    
	</section>
	</div>
	</div>
 <!-- footer -->
	<jsp:include page="Footer.jsp"></jsp:include>	  
  <!-- / footer -->

<!--main content end-->
</section>
<script src="AdminResources/js/bootstrap.js"></script>
<script src="AdminResources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="AdminResources/js/scripts.js"></script>
<script src="AdminResources/js/jquery.slimscroll.js"></script>
<script src="AdminResources/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="AdminResources/js/jquery.scrollTo.js"></script>
<!-- morris JavaScript -->	
<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2015 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2015 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2015 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2015 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2016 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2016 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2016 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2016 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2017 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
			
			],
			lineColors:['#eb6f6f','#926383','#eb6f6f'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
<!-- calendar -->
	<script type="text/javascript" src="AdminResources/js/monthly.js"></script>
	<script type="text/javascript">
		$(window).load( function() {

			$('#mycalendar').monthly({
				mode: 'event',
				
			});

			$('#mycalendar2').monthly({
				mode: 'picker',
				target: '#mytarget',
				setWidth: '250px',
				startHidden: true,
				showTrigger: '#mytarget',
				stylePast: true,
				disablePast: true
			});

		switch(window.location.protocol) {
		case 'http:':
		case 'https:':
		// running on a server, should be good.
		break;
		case 'file:':
		alert('Just a heads-up, events will not work when run locally.');
		}

		});
	</script>
	<!-- //calendar -->
</body>
</html>