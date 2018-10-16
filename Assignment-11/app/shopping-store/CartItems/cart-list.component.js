'use strict';

angular.module('cartList').component('cartList', {

    templateUrl : 'CartItems/cart-list.template.html',
    controller : function CartListController($scope, $http) {

        var self = this;

        $http.get('http://localhost:3000/items').then(function(response){
            self.cartitems = response.data;
        });

        $scope.addItemToCart = function(item){
            $http({
                method: 'POST',
                url : 'http://localhost:3000/cart/',
                data : {
                    "id" : item.id,
                    "name" : item.name,
                    "price" : item.price,
                    "description" : item.description,
                    "imgUrl" : item.imgUrl,
                    "category" : item.category
                },
                dataType : 'json'
            });

            window.location.reload();
        };

    }
});