'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		var REST_SERVICE_URI = '/game';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			updateGame: updateGame,
			deleteGame: deleteGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + "/getAll").then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}

		function updateGame(newGame) {
		    console.log(newGame);
			return $http.put(REST_SERVICE_URI, newGame).then(function(response) {
					return response.data;
				}
			);
		}

        function deleteGame(gameId) {
            return $http.delete(REST_SERVICE_URI + "/" + gameId).then(function(response) {
                    return response.data;
                }
            );
        }

}]);
