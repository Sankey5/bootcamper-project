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
			self.preUpdatedGame = {};

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.clearGamesForm();
				self.fetchAllGames();
				});
			}

            // Helper update function
            self.clearGamesForm = function() {
                document.querySelectorAll("#add-game-form input").forEach( e => {
                    if(e.type === "text") {
                        e.value = null;
                    }
                });
            }

			self.toggleInlineUpdateForm = function(event) {
			    let parentElementScope = angular.element(event.target.parentElement.parentElement).scope();
			    parentElementScope.updatedElement = !parentElementScope.updatedElement;
			}

			self.setGameBeforeUpdate = function(currentGame) {
			    self.preUpdatedGame["name"] = currentGame.name;
			    self.preUpdatedGame["genre"] = currentGame.genre;
			}

			self.updateGame = (event, updatedGame) => {
			    if(self.preUpdatedGame["name"] === updatedGame["name"]
			    && self.preUpdatedGame["genre"] === updatedGame["name"]) {
			        return;
			    }

			    return MGL_Task1_Service.updateGame(updatedGame).then( function() {
			        self.toggleInlineUpdateForm(event);
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
