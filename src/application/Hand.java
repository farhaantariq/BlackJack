package application;

class Hand {
	 // Variable declarations
	 int numCards;
	 Card cards[];
	 static int MaxCards = 12;

	 //Method declarations
	 public Hand() { // Constructor
	  numCards = 0;
	  cards = new Card[MaxCards];
	 }

	 void addCard(Card c) {
	  cards[numCards] = c;
	  numCards++;
	  
	 }

	 String[][] show(boolean isDealer,boolean hideFirstCard) {
		 String[][] returnCards = new String[2][2];
		 //System.out.println(numCards);
	  if(isDealer) {
		  for(int i = 0;i<numCards;++i) {
			  returnCards[0][i] = cards[i].value + " of " + cards[i].suit;
			  
			  }
	  }
	  else {
		  for(int i = 0;i<numCards;++i) {
			  returnCards[1][i] = cards[i].value + " of " +cards[i].suit;
			  
			  }
	  }
	  return returnCards;
	 }

	boolean blackjack() {
	 if(numCards == 2) {
	  if(cards[0].iValue == 1 && cards[1].iValue == 10) return true;
	  if(cards[1].iValue == 1 && cards[0].iValue == 10) return true;
	 }
	 return false;
	}

	boolean under(int n) {
	 int points = 0;
	 for(int i = 0;i<numCards;++i) points += cards[i].iValue;
	 if(points<n) return true;
	 else return false;
	}

	int bestScore() {
	 int points = 0;
	 boolean haveAce = false;
	 for(int i = 0;i<numCards;++i) {
	  points += cards[i].iValue;
	  if(cards[i].iValue == 1) haveAce = true;
	 }
	 if(haveAce) {
	  if(points+10 < 22) points += 10;
	 }
	 return points;
	}

	boolean mustHit() {
	 if(bestScore()<17) return true;
	 else return false;
	}

	 boolean busted() {
	  if(!under(22)) return true;
	  else return false;
	 }
	} // End of Hand class
