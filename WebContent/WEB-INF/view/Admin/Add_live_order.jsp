<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
         
         <script>
function myFunction() {
  var x = document.getElementById("rate");
  var y = document.getElementById("kg");
  
  var t=x.value*y.value;
  document.getElementById("total").value =t;
}
</script>

   <script type="text/javascript">
     
     function getsubcategory()
     {
    	 var cat=document.getElementById("caterers_name");
    	 
    	//alert("in fun");
   
    	removesubcategory();
    	 
    	 var http =new XMLHttpRequest();
    	 
    	 http.onreadystatechange=function()
    	 {
    		 //alert("in ajax");
    		 
    		 if(http.readyState==4)
    			 {
    			//	alert("in if");
    			
    			 	var jsn=JSON.parse(http.responseText);
 
    			 //	alert(jsn);
    		     
    			 	for(var i=0;i<jsn.length;i++)
    		    		 {
    		    	
    				 	//	alert("in for");
    		    	 	
		    		    	 var opt=document.createElement("option");
		    				 opt.value=jsn[i].subcategoryId;
		    				 opt.text=jsn[i].subcategoryName;
		    				 document.form.subCategoryid.options.add(opt);
	    		    	 }
    			 }

    		
    	 }
    	 
    	 
    	 http.open("get","JsonSubCategory.htm?caterers_name="+cat.value,true);
    		http.send();
    }
     
     function removesubcategory()
	 	{
	 		var removeSubCategory=document.form.rate.options.length;
	 			
	 		for(i=removeSubCategory-1;i>=0;i--)
	 			{
	 				alert(i);
	 				document.form.subCategoryid.options[i].remove();
	 			}
	 	}
     </script>

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
                            Add Live Order
                            
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <f:form class="cmxform form-horizontal " modelAttribute="data" id="signupForm" method="post" action="insert_live_order.html" novalidate="">
                                <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Catereres Name</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="caterers_name" class="custom-select form-control" required="">
     							        <f:options items="${clist}" itemLabel="Name" itemValue="Name"/>
                                     			
                                            </f:select>
                                        </div>
                                    </div>
                                      
                                    
                                      
                                    
                                     <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Product Name</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="product" class="custom-select form-control" id="name" required="">
     							        <f:options items="${list}" itemLabel="Product_name" itemValue="Product_name"/>
                                     		
                                            </f:select>
                                        </div>
                                    </div>
                                    
                                     <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Address</label>
                                        <div class="col-lg-6">
                                            <f:input class=" form-control" path="address" name="Address" type="text" required="required"/>
                                        </div>
                                    </div>
                                    
                                          <div class="form-group ">
                                        <label for="priority" class="control-label col-lg-3">Time</label>
                                        <div class="col-lg-6">
                                            <!--  <input class=" form-control" id="address1" name="address1" type="text">-->
     							<f:select path="time" class="custom-select form-control" required="">
                                     			<f:option value="morning">Morning</f:option>
                                            	<f:option value="evening">Evening</f:option>
                                            	
                                            		
                                            </f:select>
                                        </div>
                                    </div>
                                    
                                        <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Date</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="date" name="date" type="text" required="required"/>
                                        </div>
                                    </div>
                                    
                                        <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Kg</label>
                                        <div class="col-lg-6">
                                            <f:input class=" form-control" path="kg" name="Kg" type="text" required="required" id="kg" onkeyup="myFunction()"/>
                                        </div>
                                    </div>
                                    
                                       <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Rate</label>
                                        <div class="col-lg-6">
                                            <f:input class=" form-control" path="rate" name="rate" type="text" required="required" id="rate" onkeyup="myFunction()"/>
                                        </div>
                                    </div>
                                    
                                       <div class="form-group ">
                                        <label for="mon" class="control-label col-lg-3">Total</label>
                                        <div class="col-lg-6">
                                            <f:input class=" form-control" path="total" name="total" readonly="true" type="text" required="required" id="total"/>
                                        </div>
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