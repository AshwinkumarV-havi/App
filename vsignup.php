<?php
include("vconnect.php");
if($con==false)
echo "connection error".mysqli_connect_error($con);
if($_SERVER["REQUEST_METHOD"]=="POST")
{
  $uid=$_POST["uname"];
  $pwd=$_POST["cpsd"];
  $ins = "INSERT INTO login(uid,password,profile,voted) VALUES ('$uid','$pwd',1,0)";
  $result = mysqli_query($con,$ins) or die("Error querying the database");
  echo "operation success, pls refresh your database";
}
?>
