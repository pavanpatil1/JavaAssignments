function validateform(){

    var input1=document.myform.finput.value;  
    var input2=document.myform.sinput.value;  

    if (input2=="" || input1 == ""){  
        document.getElementById("validate").innerHTML = "Please Provide input";
        return false;  
      }
     
    else if(input1 == "pavanp" && input2 == "1234"){
 
        window.location = "profile.html";
        
        // document.getElementById("logindiv").style.display = 'none';
     
        // document.getElementById("forminside").style.display = 'block';
        return false;

    }  
    else{
        document.getElementById("validate").innerHTML = "Invalid username Password";
        return false;
    }
   



}


function profilevalidate(){
    var name=document.formss.name.value;  
    var address=document.formss.address.value; 
    var date = document.formss.date.value;
    var phone = document.formss.number.value;

    
    if (name=="" || address == "" || phone == "" || date.length < 1){  
        document.getElementById("profile").innerHTML = "Please Provide input";
        return false;  
      }

      var letters = /^[A-Za-z]+$/;

      if(!name.match(letters)){
        document.getElementById("profile").innerHTML = "Name is Only Alphabet";
        return false;  
      }

      if(address.length < 5 || address.length > 50){
        document.getElementById("profile").innerHTML = "Address is greater than 5 and less than 50 character";
        return false;  
      }

    if(phone.length < 10 || phone.length > 10){
        document.getElementById("profile").innerHTML = "Length of Phone number is 10";
        return false;
    }
    
    else {
        document.getElementById("profile").innerHTML = "Form Ready to submit";
        return false;
        
    }


}