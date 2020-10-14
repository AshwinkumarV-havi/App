<?php
$db_host='54.84.152.81';
$db_user='root';
$db_passwd='root';
$db_name='votedb';
$dbh = mysqli_connect($db_host,$db_user,$db_passwd,$db_name) or die("Error connecting to the database");
echo"connection is success";

$crttb= "CREATE TABLE login ( uid VARCHAR(13) PRIMARY KEY, password VARCHAR(30) NOT NULL, profile TINYINT NOT NULL,voted BOOLEAN)";#
$result=mysqli_query($dbh,$crttb) or die("Error in query"); echo " login table created";
$crttb= "CREATE TABLE student ( uid VARCHAR(13) PRIMARY KEY, name VARCHAR(30) NOT NULL, section VARCHAR(7) NOT NULL)";
$result=mysqli_query($dbh,$crttb) or die("Error in query"); echo "student table created";
$crttb= "CREATE TABLE candidate ( cid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, cname VARCHAR(30) NOT NULL, section VARCHAR(7) NOT NULL, votecount INT NULL, photo BLOB NULL, manifesto BLOB NULL)";
$result=mysqli_query($dbh,$crttb) or die("Error in query"); echo "candidate table created";
?>
