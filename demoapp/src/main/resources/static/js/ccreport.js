$(document).ready(function(){
	
	// CC Report Graph Function
	var cc_report_canvas;
	
	function showCCReport() {
		$("#cc_report_canvas").hide();
		$("#cc_report_spinner").show();
		var cc_report_ctx = document.getElementById('cc_report_canvas');
	    if(cc_report_canvas != undefined) {
	        
	    	cc_report_canvas.destroy(); 
	    }
	    var labelList;
	    var countList;
	    var datasetList = []
	    
	    var sector = $("#sector-select option:selected").val();
	    console.log("sector :"+sector)
	    if(sector == "sector1")
	    {
	    	labelList = ["s1-Account1","s1-Account2","s1-Account3"];
	    	countList = [50,10,22];
	    	var obj = {
	    		label: "causecode count",
                data: countList,
                backgroundColor: "#4e73df",
                maxBarThickness: 100,
	    	};
	    	datasetList.push(obj);
	    	$("#cc_report_x").text("account");
	    }
	    else if(sector == "sector2")
	    {
	    	labelList = ["s2-Account1","s2-Account2","s2-Account3","s2-Account4"];
	    	countList = [5,31,14,8];
	    	var obj = {
	    		label: "causecode count",
                data: countList,
                backgroundColor: "#4e73df",
                maxBarThickness: 100,
	    	};
	    	datasetList.push(obj);
	    	$("#cc_report_x").text("account");
	    }
	    else if(sector == "sector3")
	    {
	    	labelList = ["s3-Account1","s3-Account2","s3-Account3","s3-Account4","s3-Account5","s3-Account5"];
	    	countList = [12,25,5,31,14,8];
	    	var obj = {
	    		label: "causecode count",
                data: countList,
                backgroundColor: "#4e73df",
                maxBarThickness: 100,
	    	};
	    	datasetList.push(obj);
	    	$("#cc_report_x").text("account");
	    }
	    else if(sector == "all" || sector == "-1")
	    {
	    	labelList = ["sector1","sector2","sector3"];
	    	var obj1 =  {label:"s1-Account1",data:[50,0,0],backgroundColor:"#00876c"};
	    	var obj2 =  {label:"s1-Account2",data:[10,0,0],backgroundColor:"#89bf77"};
	    	var obj3 =  {label:"s1-Account3",data:[22,0,0],backgroundColor:"#fff18f"};
	    	var obj4 =  {label:"s2-Account1",data:[0,5,0],backgroundColor:"#00876c"};
	    	var obj5 =  {label:"s2-Account2",data:[0,31,0],backgroundColor:"#89bf77"};
	    	var obj6 =  {label:"s2-Account3",data:[0,14,0],backgroundColor:"#fff18f"};
	    	var obj7 =  {label:"s2-Account4",data:[0,8,0],backgroundColor:"#f59b56"};
	    	var obj8 =  {label:"s3-Account1",data:[0,0,12],backgroundColor:"#00876c"};
	    	var obj9 =  {label:"s3-Account2",data:[0,0,25],backgroundColor:"#89bf77"};
	    	var obj10 = {label:"s3-Account3",data:[0,0,5],backgroundColor:"#fff18f"};
	    	var obj11 = {label:"s3-Account4",data:[0,0,31],backgroundColor:"#f59b56"};
	    	var obj12 = {label:"s3-Account5",data:[0,0,14],backgroundColor:"#d43d51"};
	    	datasetList.push(obj1);
	    	datasetList.push(obj2);
	    	datasetList.push(obj3);
	    	datasetList.push(obj4);
	    	datasetList.push(obj5);
	    	datasetList.push(obj6);
	    	datasetList.push(obj7);
	    	datasetList.push(obj8);
	    	datasetList.push(obj9);
	    	datasetList.push(obj10);
	    	datasetList.push(obj11);
	    	datasetList.push(obj12);
	    	$("#cc_report_x").text("sector");
	    }
	    
	    /*
	    $.ajax({
		    async: false,
		    type: "GET",
		    url: "/cc_report/all",
		    dataType: "json",
		    success: function (response) {
		        accountList = response["accountList"];
		        countList = response["countList"];
		        console.log("Inside AJAX : accountList - "+accountList);
		    }
		});
		*/
	    
	    cc_report_canvas = new Chart(cc_report_ctx, {
	       type: 'bar',
	       data: {
	           labels:labelList,
	           datasets: datasetList
	       },
	       options: {
	  	        scales: {
	  	        	xAxes: [{
	  	        		stacked:true,
	  	        		maxBarThickness: 50,
	  	            }],
	  	            yAxes: [{
	  	            	stacked:true,
	  	                ticks: {
	  	                    beginAtZero: true,
	  	                    maxTicksLimit: 6,
	  	                }
	  	            }]
	  	        },
	  	        responsive: true,
	  	    	maintainAspectRatio: false,
	  	    	legend: {
	  	    		display: false
	  	    	},
	  	    }
	    });
	    
	    $("#cc_report_spinner").hide();
	    $("#cc_report_canvas").show();
	}
	
	function showDonutChart()
	{
		var ctx = document.getElementById("myPieChart");
		var myPieChart = new Chart(ctx, {
		  type: 'doughnut',
		  data: {
		    labels: ["Direct", "Referral", "Social"],
		    datasets: [{
		      data: [55, 30, 15],
		      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
		      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
		      hoverBorderColor: "rgba(234, 236, 244, 1)",
		    }],
		  },
		  options: {
		    maintainAspectRatio: false,
		    tooltips: {
		      backgroundColor: "rgb(255,255,255)",
		      bodyFontColor: "#858796",
		      borderColor: '#dddfeb',
		      borderWidth: 1,
		      xPadding: 15,
		      yPadding: 15,
		      displayColors: false,
		      caretPadding: 10,
		    },
		    legend: {
		      display: false
		    },
		    cutoutPercentage: 80,
		  },
		});
	}
	
	$("#sector-select").change(function () {
		showCCReport();
	});
	
	function randomHexColor()
	{
		return '#'+Math.floor(Math.random()*16777215).toString(16);
	}
	
	showCCReport();
	showDonutChart();
});