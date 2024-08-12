'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service', function(MGL_Task1_Service) {
			var self = this;
			self.game = {
				id : '',
				name : '',
				genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}

            // Helper function
			self.updateForm = function(event) {
			    //console.log(event);
			    //console.log(event.target.parentElement.parentElement);
			    //console.log(angular.element(event.target.parentElement.parentElement).scope())
			    let parentElementScope = angular.element(event.target.parentElement.parentElement).scope();
			    parentElementScope.updatedElement = !parentElementScope.updatedElement;
			}

			self.updateGame = (event, updatedGame) => {
			    console.log(updatedGame)
			    return MGL_Task1_Service.updateGame(updatedGame).then( function() {
			        self.updateForm(event);
			        self.fetchAllGames();
			    })
			}

			self.deleteGame = (gameId) => {
                return MGL_Task1_Service.deleteGame(gameId).then( function() {
                    self.fetchAllGames();
                })
            }

			self.fetchAllGames();
		} ]);
