

var app = angular.module('myApp',["ngRoute"]);


app.controller('formController', function($scope, $http) {

    var config = {headers:  {
        
        'Accept': 'application/json;',
        "X-Testing" : "testing"
    }
};


$scope.pname = null;
$scope.pmob = null;
$scope.bdate = null;

$scope.myFunc = function(pname,pmob,bdate) {

    

var data = {

    pname: pname,

    pmob: pmob,

    bdate: bdate

};


$http.post('http://localhost:8282/store', data, config)
   .then(
       function(response){
         $scope.msg = "data not saved";
       }, 
       function(response){
        $scope.msg = "data saved Sucessfully";
       }
    );

};




$scope.show = function(){
    
    $scope.IsHiddenss = true;
    $scope.IsHidden = true;
            $scope.ShowHide = function () {
              
                $scope.IsHidden = $scope.IsHidden ? false : true;
            }





    $http.get("http://localhost:8282/alldata",config)
  .then(function(response) {
      $scope.data = response.data;
      console.log(response.data);
  });
}



$scope.ref = function(){
    window.location.reload();
}


        var date = new Date;
        var month= date.getMonth()+1;
        $scope.dates = date.getFullYear() + "-0" +  month  +  "-" +  date.getDate();
      




});
