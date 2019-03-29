package application;

import java.util.Random;

class Deck {
	 // Variable declarations
	 int cards[]; // Array of 52 cards
	 int topCard; // 0-51 (counter of card in deck)
	 Random random;

	 // Method declarations
	 public Deck() { // Constructor
	  cards = new int[52];
	  for(int i = 0;i<52;++i) cards[i] = i;
	  topCard = 1;
	  random = new Random();
	  shuffle();
	 }

	 public void shuffle() {
	  // Repeat 52 times
	  for(int i = 0;i<52;++i) {
	   // Randomly exchange two cards in the deck.
	   int j = randomCard();
	   int k = randomCard();
	   int temp = cards[j];
	   cards[j] = cards[k];
	   cards[k] = temp;
	  }
	 }

	 int randomCard() {
	  int r = random.nextInt();
	  if(r<0) r = 0-r;
	  return r%52;
	 }

	 Card deal() {
	  if(topCard>51) {
	   shuffle();
	   topCard = 0;
	  }
	  Card card = new Card(cards[topCard]);
	  topCard++;
	  return card;
	 }
	} // End of Deck class