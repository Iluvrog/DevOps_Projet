#!/bin/sh


#Les couleurs que j'utilise
GOOD='\033[1;32m'	#GREEN
ERROR='\033[1;31m'	#RED
WARNING='\033[1;35m'	#PURPLE
VAR='\033[1;36m'	#CYAN
NC='\033[0m' # No Color




#La commande par défault
default="$0 -h"

name=default


demande() {
	read reponse
	if [ "$reponse" = "n" ]
	then
		exit 104
	fi 
	if [ "$reponse" = "o" ]
	then
		return
	fi 
	echo ${WARNING}"Seulement 'o' ou 'n'"${NC}
	demande
}



creer() {
	echo "Voulez-vous creer la branche "${VAR}$name${NC}" ? (o/n)"
	demande
	git checkout -b $name
	git branch --set-upstream-to=origin/main $name
}

supprimer() {
	echo "Voulez-vous supprimer la branche "${VAR}$name${NC}" ? (o/n)"
	demande
	git branch -D $name
}

if [ "$1" = "-c" ]
then
		
	name="$2"
	creer
			
fi

if [ "$1" = "-s" ]
then
		
	name="$2"
	supprimer
			
fi
