function validate(){  
    var name=document.f1.name.value;  
    var desc=document.f1.desc.value; 
    var price = document.f1.price.value; 
    var files = document.f1.image.files;
    var dates = document.f1.date.value;
    var img = document.forms['f1']['image'];
    var validExt = ["jpeg","png","jpg"];
    var status=false;  
      


    if(name.length<1){  
        document.getElementById("nameloc").innerHTML=  
        "Please enter Product name";  
        status=false;  
    }
    else{  
        document.getElementById("nameloc").innerHTML="";  
            if(name.length<1 && name.length>70){
            document.getElementById("nameloc").innerHTML="Length of Product name is Greater than 1 and less than 70 Character";  
            }
    }  


    if(desc.length<1){  
        document.getElementById("passwordloc").innerHTML=  
        "Please enter Description";  
        status=false;  
    }
    else{  
        document.getElementById("passwordloc").innerHTML="";  
       
        if(desc.length > 200){
            document.getElementById("nameloc").innerHTML="Length of Input is Greater than 1 and less than 200 Character";  

        }

    }  


    if(price.length < 1) {
        document.getElementById("priceloc").innerHTML=" Please Enter Price";  
        status=false;  
        
    }
    else{
        document.getElementById("priceloc").innerHTML="";  
            if(document.getElementById("price").value < 0){
                document.getElementById("priceloc").innerHTML=" Price Should be Greater than 0";  
                status=false;  
            }
    
    }


    if(files.length == 0) {
        document.getElementById("imageloc").innerHTML=" Please Select File";  
        status=false;  
    }
    else{
        document.getElementById("imageloc").innerHTML="";
 
        var pos_of_dot = img.value.lastIndexOf('.')+1;
        
        var img_ext = img.value.substring(pos_of_dot);
        console.log(img_ext);
        var result = validExt.includes(img_ext);
        if(result == false){
            document.getElementById("imageloc").innerHTML="File Must be JPG,JPEG,PNG";  
        }
        else{
            if(parseFloat(img.files[0].size/(1024*1024)) >= 2){
                 document.getElementById("imageloc").innerHTML="File size is less than 2 mb";  
                return false;
            }
        }


        }



    if(dates.length < 1) {
        document.getElementById("dateloc").innerHTML=" Please Select Date";  
        status=false;  
    }
    else{

        document.getElementById("dateloc").innerHTML="";  
        var q = new Date();
        var m = q.getMonth();
        var d = q.getDay();
        var y = q.getFullYear();

        var date = new Date(y,m,d);
        mydate = new Date(dates);
        var getDay = date.getTime();
        console.log(getDay);
        var getDate1 = mydate.getTime();
        console.log(getDate1);
        
        if(getDay < getDate1){
            document.getElementById("dateloc").innerHTML=" Manufacturing date is not Greater than or equal to Current date";  
            return false;
        }
       
    }


    return status;  
    }  