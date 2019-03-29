package application;

class Card {
	 // Variable declarations
	 int iValue; // Numeric value corresponding to card.
	 String value; // "A" "2" through "9" "T" "J" "Q" "K"
	 String suit; // "S" "H" "C" "D"

	 // Method declarations
	 public Card(int n) { // Constructor
	  int iSuit = n/13;
	  iValue = n%13+1;
	  switch(iSuit) {
	   case 0:
	    suit = "Spades";
	    break;
	   case 1:
	    suit = "Hearts";
	    break;
	   case 2:
	    suit = "Clubs";
	    break;
	   default:
	    suit = "Diamonds";
	  }
	  if(iValue == 1) value = "Ace";
	  else if(iValue == 10) value = "Ten";
	  else if(iValue == 11) value = "Jack";
	  else if(iValue == 12) value = "Queen";
	  else if(iValue == 13) value = "King";
	  else value = Integer.toString(iValue);
	  if(iValue>10) iValue = 10;
	 }

	 int getValue() {
	  return iValue;
	 }
	} // End of Card class