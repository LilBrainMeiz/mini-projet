1. Ouvrez votre terminal selon votre système d'exploitation
2. Placez vous dans le répertoire contenant le code des applications
3. Executez la commande suivante: javac *.java -encoding utf-8
4. Vous pouvez désormais utilisez les deux applications

L'objectif est que vous puissiez vous créer votre propre bedetheque, nous vous autorisons un maximum de 10000 livres.

Pour saisir un livre dans votre bedeteque vous devez lancer l'application avec la commande java ControleurSaisie.
Une fois l'application lancer, il faut ajouter des ouvrages en écrivant dans les champs de texte et
avec les liste déroulante.

Quelques contraintes sont à respecter:
  - Les champs marquer d'une * sont obligatoires.
  - Le titre doit être une chaîne de caractères quelconque.
  - Tome doit être un entier positif si vous mettez autre chose, il sera considérer qu'il n'y a pas de numéros de tome.
  - La série est facultative
  
Une fois les information correct saisie appuyer sur Ajouter la BD.

Ajout d'éditeur, de séries et d'auteurs au liste déroulante:
Ajouter dans les fichiers correspondant ( editeur.txt, série.txt, auteur.txt ) ce que vous souhaiter ajouter dans les liste déroulante.


Pour consulter votre liste de BD que vous avez mis dans votre bedetheque vous devez utiliser l'application d'état. Cette dernière vous permet de consulter votre bedetheque sous différents états:
  -Pour afficher la base de donnée triée selon titre des ouvrages avec un ordre naturel 
  -Pour afficher la base de donnée triée par Éditeurs et Séries.
  -Pour afficher tous les ouvrages d'un auteurs, qu'il soit scénariste et/ou dessinateur.

Pour lancer l'application pour les états vous devez saisir dans votre terminal ou vous avez compilé vos fichier .java, la commande suivante: java ControleurEtat.
Il vous sera alors proposé de choisir l'affichage que vous souhaitez parmis ceux proposé précédemment.

À savoir que vous pouvez lancer les deux applications simultanément, sans vous souciez de l'ordre, de la même manière que vous pouvez ne pas les lancer en même temps si vous le souhaitez.

Si vous voulez créer plusieurs bedetheque, faites un copier coller de vos fichiers .class que vous aurez générez après compilation, puis relancer les applications. 
Si vous souhaitez supprimer votre bedetheque, vous pouvez supprimer le fichier appeler sortie.txt, lors de votre prochaine bedetheque vous pouvez procédez comme d'habitude.
