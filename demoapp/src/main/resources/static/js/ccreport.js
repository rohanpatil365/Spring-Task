$(document).ready(function(){
	
	// CC Report Graph Function
	var cc_report_canvas;
	function showCCReport() {
		$("#cc_report_spinner").show();
		
		var cc_report_ctx = document.getElementById('cc_report_canvas');
	    if(cc_report_canvas != undefined) {
	        
	    	cc_report_canvas.destroy(); 
	    }
	    var accountList;
	    var countList;
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
	    
	    console.log("Outside AJAX : accountList - "+accountList);
	    
	    cc_report_canvas = new Chart(cc_report_ctx, {
	       type: 'bar',
	       data: {
	           labels:accountList,
	           datasets: [
	               {
	                   label: "Count",
	                   data: countList,
	                   backgroundColor: "#4e73df",
	                   maxBarThickness: 100,
	               }
	           ]
	       },
	       options: {
	  	        scales: {
	  	        	xAxes: [{
	  	        		maxBarThickness: 50,
	  	            }],
	  	            yAxes: [{
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
	
	showCCReport();
	showDonutChart();
});