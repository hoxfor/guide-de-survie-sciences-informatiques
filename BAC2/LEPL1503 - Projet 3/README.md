# Correction des tâches INGInious (et astuces)

## Contenu
Vous retrouverez ici les exos[^1] (2020-2021) à réaliser de la semaine 1 à la semaine 6 dans le cadre du cours 
LEPL1503. En bas de ce readme se trouvent aussi quelques infos sur des outils à utiliser et des conseils pour le projet à réaliser.

[^1]: Sauf les exos sur les bitwise qui ne sont pas obligatoires.

## Organisation des fichiers

Les exos sont regroupés par semaine (S1, S2, etc...) et ne contient que le code à remplir pour INGInious (pas de fichiers de compilation, etc...).


## *Pas de copier-coller svp*

1. Vous risquez de vous faire chopper et être sanctionné.
2. Vous apprendrez pas comment résoudre le type d'exo que vous avez copié.

# Infos pratiques et astuces

## Installer CUnit

CUnit est une librairie qui permet de réaliser des tests unittaires qui se révèleront indispensable pour assurer la
bonne qualité de votre projet. Installer et maitriser cette librairie est donc capital.

### Sur Ubuntu / Debian

1. Utiliser la commande ci-dessous pour mettre apt à jour :


`sudo apt-get update`

2. Installer CUnit avec la commande magique suivante :

`sudo apt-get install libcunit1 libcunit1-doc libcunit1-dev`

### Sur Windows

1. Aller sur une VM / Linux subsytem for windows / installer une distro linux.
2. Suivre l'étape au dessus (sur ubuntu / debian).

## Installer Valgrind

Valgrind est un outil libre permettant de vérifier si on a des fuites de mémoire dans son programme,
lui aussi est (très) important à maitriser.

### Sur Ubuntu / Debian

`sudo apt update`

`sudo apt install valgrind`

## Réaliser un projet lisible pour vous même et les reviews

1. Utiliser des headers, ça allège vos fichiers et c'est plus lisble
2. Écrire des commentaires dès qu'on ajoute une fonction ou un bout de code, ça permet de pas devoir tout faire d'un coup.
et celui qui fera votre review aura pas besoin de lire chaque ligne de code pour comprendre ce qu'il fait.
3. Tester l'entièreté de son code pour éviter des mauvaises surprises.
4. Faire des tests valgrind pour éviter d'avoir un memory leak de 16 Go à la remise du projet.
5. Effacer les print, j'suis tombé sur des "Matthieu a un ptit zgeg" et "Louis est un pd" et ça fait pas.
trop sérieux (bon j'ai quand même ri mais pas les profs).
6. Enjoy !



