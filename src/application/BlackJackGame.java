package application;

import java.io.DataInputStream;
import java.io.IOException;
import javafx.scene.control.TextArea;

class BlackJackGame {
	 // Variable declarations
	 int bet;
	 int money;
	 Deck deck = new Deck();
	 Hand playersHand = new Hand();
	 Hand dealersHand = new Hand();
	 DataInputStream keyboardInput;
	 String[][] returnCards = new String[2][2];

	 // Method declarations
	 public BlackJackGame() { // Constructor
	  bet = 0;
	  money = 1000;
	  deck = new Deck();
	  keyboardInput = new DataInputStream(System.in);
	 }

	
		 
	 String[][] initialDeal() {
		  //System.out.println("New hand...");
		  for(int i = 0;i<2;++i) {
		   playersHand.addCard(deck.deal());
		   dealersHand.addCard(deck.deal());
		  }
		  returnCards[0] = dealersHand.show(true,true)[0];
		  returnCards[1] = playersHand.show(false,false)[1];
		 
		  
		 	  return returnCards;
		 }

	  String playerWins() {
	  money += bet;
	  return "Player Wins..";
	 }

	 String dealerWins() {
	  money -= bet;
	  return "Dealer Wins..";
	  
	 }

	 String tie() {
	  return "Tie...";
	 }

	  String showResults() {
	  if(playersHand.busted() && dealersHand.busted()) return "Tie...";
	  else if(playersHand.busted()) {
		  money -= bet;
		  return "Dealer Wins..";
	  }
	  else if(dealersHand.busted()) {
		  money += bet;
		  return "Player Wins..";
	  }
	  else if(playersHand.bestScore() > dealersHand.bestScore()) {
		  money += bet;
		  return "Player Wins..";
	  }
	  else if(playersHand.bestScore() < dealersHand.bestScore()) {
		  money -= bet;
		  return "Dealer Wins..";
	  }
	  else	  return "Tie...";
	 }
	} // End of BlackJackGame class
