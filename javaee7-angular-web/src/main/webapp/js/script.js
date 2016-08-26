var app = angular.module('myApp', []);

app.controller('mainController', function($scope, $http) {
	$scope.user = {
		name: '',
		email: ''
	};

	$http.get('http://localhost:8080/jee-angular/rest/user/list').then(function(response) {
		$scope.list = response.data;
	});

	$scope.save = function() {
		$http.post('http://localhost:8080/jee-angular/rest/user/save', $scope.user).then(function(response) {
			$scope.list.push(response.data);
		});
	};

	$scope.delete = function(index) {
		$http.delete('http://localhost:8080/jee-angular/rest/user/delete/' + index).then(function(response) {
			$scope.list.splice(index, 1);
		});
	};

});