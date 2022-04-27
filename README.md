# Projet DevOps

![Coverage](.github/badges/jacoco.svg)

Fonctionnalités :

    Notre bibliothète permet la création de Dataframe, soit à partir d'arguments donnés en paramètre, soit à partir d'un fichier CVS.
    Une fois le Dataframe créé, il est possible de ne sélectionner que certaines lignes à partir de leur numéro
    ou certaines colonnes à partir de leur index.
    Il est bien évidemment possible d'afficher le Dataframe en entier mais aussi de ne choisir d'afficher que les n premières ou dernières lignes.


Choix des outils :

    Nous avons choisi d'utilisé Github pour notre projet car nous connaissions déjà cet outil.
    Nous avons utilisé maven pour les options permettantla compilation, les tests ainsi que l'exécution du code car maven reste peux verbeux et plus simple à utiliser que d'autre options.
    Nous utilisé JUnit 5 pour nos jeux de tests car nous étions habitué à cette bibliothèque.

Workflow :

    à compléter

Pull request :

    Nous avons mis en place un système de pull request assez simple,
    dès qu'une demande était faite de merge, si les tests du workflow était bon, il devenait possible de merge et ce même pour le créateur de la pull request.

Feedback :

    Personnelement, je trouve que git, malgré ses avantages, restent parfois flou et source d'erreur si utilisé sous forme de ligne de commande, cependant, il n'a pas ses problèmes utilisé avec un IDE
    Maven à certe l'avantage d'être peux verbeux, il reste parfois flou dans ses messages d'erreurs.
    JUnit reste simple et efficace dès l'instant où on a compris la logique derière.