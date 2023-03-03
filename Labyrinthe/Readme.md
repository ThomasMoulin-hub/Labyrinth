Des d'interfaces ne servent pas car ce sont des objets qui existent déjà (ex : HashMap)

Fonctionalités du logiciel :
- créer un nouveau labyrinthe vierge
- changer un labyrithe depuis un fichier correctement formaté
- enregistrer un labyrinthe dans un fichier
- résoudre un labyrinthe en utilisant l'algorithme de Dijkstra et afficher le résultat
- lorsqu'un fichier est modifié et que l'on souhaite créer un nouveau labyrithe, en ouvrir un, ou quitter l'application, une fenêtre de confirmation s'ouvre demandant si l'on souhaite sauvegarder les modifications
- changer le type d'une ou plusieurs cases en sélectionnant avec la souris le type de case à appliquer en :
  - cliquant une fois unique sur la case à changer
  - faisant un cliquer-glisser sur les cases à changer  
- annuler la dernière action avec Ctrl+Z ou le bouton "Annuler" dans le menu "Edition" (toujours pas parfaitement fonctionnel, il faut parfois cliquer deux fois sur le bouton pour que l'action soit annulée parfois)
- racourcis clavier pour les actions les plus courantes :
  - Ctrl+O pour ouvrir un fichier
  - Ctrl+Z pour annuler la dernière action
  - Ctrl+N pour créer un nouveau fichier
  - Ctrl+S pour sauvegarder
  - Ctrl+Maj+S pour enregistrer sous
- zoom et dézoom possiblent avec : 
  - Ctrl+Molette
  - Ctrl+ + ou Ctrl+ -
  - utilisation du pavé tactile comme sur un téléphone
- mise en place d'un zoom par défaut qui permet de voir l'ensemble du labyrinthe avec le bouton "Zoom par défaut" dans le menu "Affichage"
- indication de la position du départ et de l'arrivée si elles sont présentes et mais en dehors de l'écran
- possibilité de naviguer dans le labyrinthe avec :
  - les scrollbars sur les cotés
  - molette pour les déplacements verticaux 
  - Maj+molette pour les déplacements horizontaux
- la vitesse de défilement du labyrinthe est adaptée à la taille des hexagones
- explication de l'utilisation du logiciel dans le menu "Aide" 

Ce qu'il reste à implémenter :
- pouvoir changer la taille d'un labyrinthe
- pouvoir changer le nom d'un labirynthe (et donc le nom du fichier)
- pouvoir déplacer des parties du labyrinthe en selectionnant avec la souris et en faisant glisser