function validateform(){  
    var input1=document.myform.finput.value;  
    var input2=document.myform.sinput.value;  

    if (input2=="" || input1 == ""){  
      document.getElementById("sum").innerHTML = "Please Provide Valid input";
      return false;  
    }
   
    else if(input1 < 0 || input2 < 0){
        document.getElementById("sum").innerHTML = "Number is greater than equal to 0";
        return false;  
    }
   
    else{
        var input3 = parseInt(input1) + parseInt(input2);
        document.getElementById("sum").innerHTML= "Sum of " + input1  + " and " + input2 +  " = " +  input3;
        return false;
    }

    }
      