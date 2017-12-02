<html>
<link rel="stylesheet" href="../webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<script src="../webjars/jquery/2.1.4/jquery.min.js"></script>
<script>
var hf1;
var hf2;
$(document).ready(function() {
	var base_url = window.location.href.substr(0, window.location.href.indexOf('Dental')+7);
    $('#f2').attr('src',base_url+'AppointmentsDates');
    $('#f1').attr('src',base_url+'TmpAppointments');
   
    //$("f2").contents().find("body").onclick = function() { alert('hhjgh') };
})
  function resizeIframe() {
	iframeLoaded('f1');
	iframeLoaded('f2');
  }
  
function iframeLoaded(x) {
	var y =($(window).width()-20);
	var y1 = y/3
    var iFrameID = document.getElementById(x);
    var maxH = document.getElementById('f1').contentDocument.body.scrollHeight ;
    var maxW = document.getElementById('f1').contentDocument.body.scrollWidth ;
      
    if(iFrameID) {
          // here you can make the height, I delete it first, then I make it again
          iFrameID.height = "";
          
          if(x==='f1')
        	{
        	  	iFrameID.width = "";
              	iFrameID.width = ((y1*2)) + "px";
              	hf1 = document.getElementById('f1').contentDocument.body.scrollHeight ;
              	iFrameID.height = hf1;
        	}
          else if(x==='f2')
        	{
        	  	iFrameID.width = "";
              	iFrameID.width = y1+ "px";
              	hf2 = document.getElementById('f1').contentDocument.body.scrollHeight ;
              	iFrameID.height = hf2;
        	}
    }
}  
	var x1;
	var x2 ;
	var x1p;
	var x2p;
setInterval(function(){
	 x1 = window[0].document.getElementById("tableId").rows.length;
	 x2 = window[1].document.getElementById("tableId").rows.length;
	if (x1 !== x1p||x2 !== x2p)
		{
			resizeIframe();
			x1p = x1;
			x2p = x2;
		}
}, 200);
//window.setInterval("reloadIFrame();", 30);

// function reloadIFrame() {
//  document.getElementById('f4').contentWindow.document.location.reload();
// }

</script>
<head>
    <title>Temporary Appointments</title>
</head>
<body onresize="resizeIframe()" onload="resizeIframe()">

<iframe  id="f1" onload="iframeLoaded('f1')" scrolling="no" >
</iframe>
<!--  </div> -->

<!--  <div class="embed-responsive embed-responsive-16by9"> -->
<iframe  id="f2" onload="iframeLoaded('f2')" scrolling="no">
</iframe>
<!--  </div> -->
</body>
</html>