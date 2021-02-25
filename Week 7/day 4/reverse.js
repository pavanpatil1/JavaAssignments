
function reverse(){

    var Strings = document.getElementById("value").value;

    let r = "";
    for(let i=Strings.length - 1;i>=0;i--){
            r += Strings[i];
    }
    document.getElementById("output").innerHTML = "Reverse of String " + Strings + " = " + r;
    return false;

}
