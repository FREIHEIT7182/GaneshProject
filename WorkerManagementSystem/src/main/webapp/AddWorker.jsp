<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: orange;
	border: 1px solid black;
	padding: 25px;
	background: linear-gradient(pink, skyblue);
	background-position: no-repeat;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	background-color: green;
}

a:active {
	text-decoration: underline;
}


</style>
<meta charset="ISO-8859-1">
<title>Department Client</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    function getAllWorkers() {
        $.getJSON("/workerManagementSystem/api/getAllWorkers", null, function(workers) {
             console.log(workers)
             st = ""
             for (var i = 0; i < workers.length; i++)
                 st += "<table><tr>" + workers[i].workerId + " , " + workers[i].firstName + " , " +workers[i].lastName+"</tr></table>";
                
             $("#workers").html(st);
         
         });
    }

 

 

 

    function createWorker() {
        // Make post request 
        $.ajax({
            url : "/workerManagementSystem/api/",
            type : "POST",
            success : function() {
                alert("Worker Details has been added successfully!")
            },
            error : function() {
                alert("Worker Details not added due to error!")
            },
            data : {
                "firstName" : $("#firstName").val(),
                "lastName" : $("#lastName").val(),
                "email" : $("#email").val(),
                "password" : $("#password").val(),
                "reTypePassword" : $("#reTypePassword").val(),
                 "phoneNumber" : $("#phoneNumber").val(),
                "skillType" : $("#skillType").val(),
                "yearsOfExperience" : $("#yearsOfExperience").val(),
                "address" : $("#address").val()          
            }
        });
    }
 

    function deleteProduct() {
        // Make DELETE request 
        $.ajax({
            url : "/rest/product/" + $("#productId").val(),
            type : "delete",
            success : function() {
                alert("Dept has been deleted successfully!")
            },
            error : function(xhr, s) {
                console.log("Status : " + s)
                msg = xhr.responseJSON.message
                console.log("Message : " + msg);
                alert("Dept was not deleted due to error : " + msg)
            }
        });
    }

 

    function getByProudctId() {
        $.ajax({
            url : "/rest/product/" + $("#productId").val(),
            type : "get",
            success : function(dept) {
                $("#productName").val(dept.productName),
                $("#productPrice").val(dept.productPrice)
              
            },
            error : function(xhr, s, msg) {
                error = xhr.responseJSON.message
                // console.log("Status : "  +  s)
                // console.log("Message : " + error)
                alert(error)
            }
        });
    }
    
    function updateProduct() {
        // Make PUT request 
        $.ajax({
            url : "/rest/product/" + $("#productId").val(),
            type : "put",
            success : function() {
                alert("Dept has been updated successfully!")
            },
            error : function() {
                alert("Dept was not updated due to error!")
            },
            data : {
                "productId" : $("#productId").val(),
                "productName" : $("#productName").val(),
                "productPrice" : $("#productPrice").val()
            }
        });
    }
    
    $(function () {

        var waiting = '<center><h3>Please Wait ...</h3></center>';

        $('#Pro-Hashtagh').click(function(){
            $("#Show-Id").html(waiting);
        });

    });
    
</script>
</head>

<body>

	<center>
		<h1 style="color: green">Product Registration</h1>
	</center>
 <a href="OrderReg.html" id="Pro-Hashtagh">Pro Hashtagh</a>";
 <div class="body" id="Show-Id">
</div>
 
	<h2>Add or Delete Student</h2>
	<pre>
    Enter firstName        <input type="text" id="firstName" /><br><br>
    Enter lastName       <input type="text" id="lastName" /><br><br>
    Enter email          <input type="text" id="email" /> <br><br>
    Enter password        <input type="text" id="password" /><br><br>
    Enter reTypePassword       <input type="text" id="reTypePassword" /><br><br>
    Enter phoneNumber          <input type="text" id="phoneNumber" /> <br><br>
    Enter skillType       <input type="text" id="skillType" /><br><br>
    Enter yearsOfExperience          <input type="number" id="yearsOfExperience" /> <br><br>
    Enter address        <input type="text" id="address" /><br><br>
  
  
    </pre>
	<p />

	<button onclick="getAllProductsId()">Get</button>
	<button onclick="updateProduct()">Update</button>
	<button onclick="createWorker()">Add</button>
	<button onclick="deleteProduct()">Delete</button>
	<pre>
                                                                     
     </pre>
	<hr />
	<button onclick="getAllWorkers()">Get All Products</button>
	<ul id="workers">
	</ul>

</body>
</html>
