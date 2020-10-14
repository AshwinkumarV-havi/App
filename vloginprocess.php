<?php
SESSION_START();
include("vconnect.php");
if($con==false)
echo "connection error".mysqli_connect_error($con);
if($_SERVER["REQUEST_METHOD"]=="POST")
{
  $username=$_POST['uname'];
  $pass=$_POST['pwd'];
  $_SESSION['user']=$username;
  $sql = "SELECT * FROM login where uid='$username'";
  if($res = mysqli_query($con, $sql))
  {
    if(mysqli_num_rows($res) > 0)
    {
      while ($row = mysqli_fetch_array($res))
      {
        if($row['password']!=$pass)
        {
          echo"password is not matching";
        }
        else
        {
          if($row['profile']==0)
          {
            header('location:vadmin.php');
          }
          if(($row['profile']==1) && ($row['voted']==0))
          {
            header('location:vvote.html');
          }
          else
          {
            echo "you are alreday voted.. Thank You!";
          }
          if(($row['profile']==2)&& ($row['voted']==0))
          {
            header('location:vcandidate.php');
          }
          if(($row['profile']==2)&& ($row['voted']!=0))
          {
            header('location:vresult.php');
          }
        }
      }
    }
    else
    {
      echo"wrong user name";
    }
  }
  else echo"query can't execute";
  mysqli_free_result($res);
}
?>
