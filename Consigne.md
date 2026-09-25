## 1) Maintient dans la voie
    * Extérieur rond point
        - faire un StaticBody3D "Trottoir" avec une Box
    * Allonger voiture selon son axe des x :
        - aide au maintien
    * Eviter que la voiture stoppe quand elle touche le rond point
        - utiliser les Groupes
            - tout ce qui est circulant
                - faut que la voiture reparte (quand la voiture devant et repartie) : Gr groupeVoiture
            - tout ce qui est urbain (trop toir, rond point, blabla) 
                - => faut pas que la voiture s'arrete : Gr groupeUrbain  
    * Ajouter une force radiale qui ramène ou éloigne comme un élastique la voiture (R=7)

## 2) Rendu
    * Détails des voitures 
        - Ajouter des roues au minimum
    * Couleurs des objets
        - Rond point vert, 
        - Voiture en rouge
        - Roue en noir
        - trottoir en gris

## 3) Gestion de l'arrêt des voitures
    * seule la voiture de derrière doit s'arreter
    * Une voiture ne peut redémarrer que quand la voiture de devant et repartie
        - Signal OnBodyExited

## 4) Analyse de l'emergence
    * Caracteriser les bouchons
        - nb voitures vs fluidité
            * Diagramme en x=nb voiture / en y=taille bouchon
            * Remarquer la survenue soudaine du bouchon
        - vitesse et sens du bouchon
        - etc
    * simulations pour quantifier les parametres


## 5) Diagrammes des mecanismes

## 6) Choix des sujets à (1, 2, 3 etudiants)