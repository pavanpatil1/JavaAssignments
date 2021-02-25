function output(){

    var output = document.getElementById("input").value;

    
    if(output == ""){
        document.getElementById("showout").innerHTML = "Please enter value here";
        return false;
    }
    else{
        document.write(typeOf(output));
        document.write(output);
        alert(output);
        console.log(output);
        return false;
    }
    
}