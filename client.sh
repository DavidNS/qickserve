#!/bin/bash

COLOR_GREEN='\e[32m'
COLOR_BLUE='\e[34m'
COLOR_RED='\e[31m'
COLOR_CLEAR='\e[0m'


QIKSERVE_ENDPOINT="http://localhost:8080"
WIREMOCK_ENDPOINT="http://localhost:8081"



BASKET_ID=""

mainMenu(){
	echo -ne "Main menu:

$COLOR_GREEN 1 $COLOR_CLEAR Create new basket
$COLOR_GREEN 2 $COLOR_CLEAR Add item to basket
$COLOR_GREEN 3 $COLOR_CLEAR Checkout current basket
$COLOR_GREEN 4 $COLOR_CLEAR Get checkouts
$COLOR_GREEN 0 $COLOR_CLEAR Exit
"

	echo ""
	echo "Chose an option: "
	read input
	case $input in
		1)
			createBasket;
			mainMenu;;
		2)
			itemSelectionMenu;
			mainMenu;;
		3)
			checkoutBasket;
			mainMenu;;
		4)
			getCheckouts; mainMenu;;
		0)
			exit 0 ;;
		*)
			echo "Invalid option: $a"; mainMenu;;
	esac
	
}

createBasket(){
	echo "Creating basket..."
	BASKET_ID=$(curl -sX POST $QIKSERVE_ENDPOINT/baskets | jq '.basketID')
	if [ -z "$BASKET_ID" ] ; then
		echo -e "${COLOR_RED}Error creating basket${COLOR_CLEAR}"
	else
		echo "Created new basktet with id: $BASKET_ID"
	fi
}

itemSelectionMenu(){
	if [ -z "$BASKET_ID" ] ; then
		echo "Not basket created yet"
		createBasket
	fi
	if [ ! -z "$BASKET_ID" ] ; then
		productsJson=$(curl $WIREMOCK_ENDPOINT/products 2>/dev/null)
		ids=($(jq .[].id <<< $productsJson))
		
		echo ""
		echo "Avaible products:"
		echo ""
		
		length=${#ids[@]}
		length=$(($length-1))
		range=$(seq 0 $length)
		
		for index in $range ; do
			echo "-------------------------"
			echo -e "Index: $COLOR_GREEN $index $COLOR_CLEAR"
			name=$(jq .[$index].name <<< $productsJson)
			price=$(jq .[$index].price <<< $productsJson)
			echo "ID: "${ids[index]}
			echo "Name: "$name
			echo "Price: "$price
		done
		
		echo ""
		echo "Select index:"
		
		rangeArray=($range)
		
		read input
		if [[ " ${rangeArray[*]} " =~ " ${input} " ]]; then
			echo "Adding item to basket..."
			itemID=${ids[input]}
			contentTypeHeadder="Content-Type: application/json"
			bodyJson="{ \"itemID\" : $itemID }"
			result=$(curl -X POST -H "$contentTypeHeadder" -d "$bodyJson" $QIKSERVE_ENDPOINT/baskets/$BASKET_ID/items 2>/dev/null)
			echo "Current basket status:"
			echo ""
			echo $result
			echo ""
		else
			echo "Not valid input"
		fi
	fi
}

checkoutBasket(){
	if [ -z "$BASKET_ID" ] ; then
		echo  -e "${COLOR_RED}Not basket created yet${COLOR_CLEAR}"
	else
		echo "Chechout current basket..."
		result=$(curl  $QIKSERVE_ENDPOINT/baskets/$BASKET_ID/checkout 2>/dev/null)
		BASKET_ID=""
		echo "Checkout info: "
		echo ""
		echo $result
		echo ""
	fi
}

getCheckouts(){
	echo "Enter the checkout id:"
	read input
	echo "Trying to retrieve checkout info..."
	result=$(curl  $QIKSERVE_ENDPOINT/checkouts/$input 2>/dev/null)
	echo "Checkout response: "
	echo ""
	echo $result
	echo ""
	
}


# Call the menu function
mainMenu
