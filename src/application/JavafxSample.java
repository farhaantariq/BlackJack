package application;

import java.io.File;
import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;


public class JavafxSample extends Application {

	Text moneyField = new Text();
	Text winner = new Text();
	String filename = "";
	HBox playerSide1 = new HBox();
	HBox dealerSide1 = new HBox();
	
  
 
   @Override     
   public void start(Stage primaryStage) throws Exception { 
   
      //Creating Blackjack instance
      BlackJackGame game = new BlackJackGame();
           
      //creating a Group object 
      Group group = new Group();
      
      winner.setDisable(true);
      //creating placeholder for dealer and player with vbox
      Label dealerLabel = new Label("Dealer : ");
      dealerLabel.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD,  50));
      dealerLabel.setTextFill(Color.web("#000000"));
      Label playerLabel = new Label("Player : ");
      playerLabel.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD,  50));
      playerLabel.setTextFill(Color.web("#000000"));
      
      Text welcome = new Text();
      Text welcome1 = new Text();
      DropShadow ds = new DropShadow();
	   ds.setOffsetY(3.0f);
	   ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	   welcome.setEffect(ds);
	   welcome.setCache(true);
	   welcome.setX(10.0f);
	   welcome.setY(270.0f);
	   welcome.setFill(Color.web("#01579B"));
	   welcome.setText("BlackJack Application");
	   welcome.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 102));
	   
	   FadeTransition ft = new FadeTransition(Duration.millis(500), welcome);
	   ft.setFromValue(1.0);
	   ft.setToValue(0.3);
	   ft.setCycleCount(4);
	   ft.setAutoReverse(true);
	 
	   ft.play();
	 
	   welcome1.setEffect(ds);
	   welcome1.setCache(true);
	   welcome1.setX(10.0f);
	   welcome1.setY(270.0f);
	   welcome1.setFill(Color.web("#01579B"));
	   welcome1.setText("Panda Group");
	   welcome1.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 102));
	   
	   FadeTransition ft1 = new FadeTransition(Duration.millis(500), welcome1);
	   ft1.setFromValue(1.0);
	   ft1.setToValue(0.3);
	   ft1.setCycleCount(4);
	   ft1.setAutoReverse(true);
	 
	   ft1.play();
	   dealerSide1.getChildren().addAll(welcome);
	   playerSide1.getChildren().addAll(welcome1);
      VBox vbCards = new VBox();
      vbCards.setSpacing(15);
      vbCards.setPadding(new Insets(150, 0, 0, 50));
      vbCards.getChildren().addAll(dealerLabel,dealerSide1,playerLabel,playerSide1);
      
      //Retrieving the observable list object 
      ObservableList list = group.getChildren(); 
       
      //Setting the text object as a node to the group object 
      list.add(getUi_text("BlackJack Application \n Panda Group"));
      list.add(getUi_logo("https://www.trios.com/career/Images/Logo.jpg"));
      list.add(moneyLeft(game.money));
      list.add(betBlock(game));
      list.add(vbCards);
       
      //Creating a Scene by passing the group object, height and width   
      Scene scene = new Scene(group ,1200, 800); 
      
      //setting color to the scene 
      scene.setFill(Color.web("#4CAF50"));
      
      //Setting the title to Stage. 
      primaryStage.setTitle("BlackJack Application"); 
   
      //Adding the scene to Stage 
      primaryStage.setScene(scene); 
       
      //Displaying the contents of the stage 
      primaryStage.show(); 
   }    
   
   public static void main(String args[]){          
      launch(args);     
   }
   
   public Text getUi_text(String applicationName) {
   
    //Creating a Text object 
      Text text = new Text(); 
       
      //Setting font to the text 
      text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 50)); 
        
      //setting the position of the text 
      text.setX(50); 
      text.setY(60);  
      
      // Setting font color
      text.setFill(Color.WHITE);
      
      //Setting the Stroke  
      text.setStrokeWidth(2); 
      
      // Setting the stroke color
      text.setStroke(Color.BROWN);
      
      //Setting the text to be added.
      text.setText(applicationName);
      
      return text;       
   
   }
   
   public ImageView getUi_logo(String logo) {
//Creating an image 
      Image image = new Image(logo); 
             
      //Setting the image view 
      ImageView imageView = new ImageView(image); 

      //Setting the position of the image 
      imageView.setX(824); 
      imageView.setY(10);  

      //setting the fit height and width of the image view 
      imageView.setFitHeight(87);
      imageView.setFitWidth(326); 

      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true);
      
      return imageView;

   }
   
   public HBox moneyLeft(int money) {
   
//Creating Money Label
      
      //Showing Money Left
      moneyField.setText("You have $"+Integer.toString(money)+".");
      moneyField.setFill(Color.web("#DCEDC8"));
      moneyField.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 42));
      
      // HBox for Money
      HBox HbMoney = new HBox();
      HbMoney.setSpacing(10);
      HbMoney.setPadding(new Insets(250, 0, 0, 880));
      HbMoney.getChildren().addAll(moneyField);
      
      return HbMoney;

   
   }
   
   public VBox betBlock(BlackJackGame game) {
	  //Creating BET Label
	  
      Label betLabel = new Label("Place Your Bet");
      betLabel.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 32));
      betLabel.setTextFill(Color.web("#CDDC39"));
      
      //Creating BET textfield 
      TextField betField = new TextField();
      
      
      // Submit Bet Button
      Button btn_Bet = new Button("BET");
      btn_Bet.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      
      
      // Submit Hit Button
      Button btn_Hit = new Button("HIT");
      btn_Hit.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      
      // Submit Stay Button
      Button btn_Stay = new Button("Stay");
      btn_Stay.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
      btn_Hit.setVisible(false);
      btn_Stay.setVisible(false);
      // Submit Bet Action
      btn_Bet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	winner.setText(" ");
                if (
                    (betField.getText() != null && !betField.getText().isEmpty()) 
                    && (Integer.parseInt(betField.getText()) <= game.money 
                    && Integer.parseInt(betField.getText()) > 0 )
                ) {
                btn_Bet.setVisible(false);
                btn_Hit.setVisible(true);
                btn_Stay.setVisible(true);
                playerSide1.getChildren().clear();
                dealerSide1.getChildren().clear();
                game.bet = Integer.parseInt(betField.getText());
                betLabel.setText("Bet for $"+ Integer.toString(game.bet) +" is set !!!");
                moneyField.setText("You have $"+Integer.toString(game.money - game.bet)+".");
                
                
                String[][] result = game.initialDeal();
                String Show1 = " ";
                for(int i = 0; i < 2; i++)
                Show1 += result[0][i] + " // ";
                dealerSide1.getChildren().add(showCards(game, false, false)); 
                Show1 = " ";
                for(int i = 0; i < 2; i++)
                Show1 += result[1][i] + " // ";
                playerSide1.getChildren().add(showCards(game, true, false));
                if(game.playersHand.blackjack())
                	{
                		dealerSide1.getChildren().clear();
                		dealerSide1.getChildren().add(showCards(game, false, true));
                		showResultsFinal (game, btn_Bet, btn_Hit, btn_Stay, betField, betLabel);              
                	}
                } 
                else
                {
                	betLabel.setText("Cound not place bet sorry");
                }
            }
        });
      //. Stay button clicked
      btn_Stay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            btn_Bet.setVisible(false);
            
            // check for blackjack and score under 22
            do
            {
            	game.dealersHand.addCard(game.deck.deal());
            	dealerSide1.getChildren().clear();
            	dealerSide1.getChildren().add(showCards(game, false, false));          	
            }while((game.dealersHand.mustHit()));
            
            dealerSide1.getChildren().clear();
        	dealerSide1.getChildren().add(showCards(game, false, true));
            showResultsFinal (game, btn_Bet, btn_Hit, btn_Stay, betField, betLabel);
            
            }
        });
      
      //Hit button Clicked
      btn_Hit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            btn_Bet.setVisible(false);
            
            // check for blackjack and score under 22
            boolean flag = true;
            if(game.playersHand.under(22) && !game.playersHand.blackjack())
            {
            	game.playersHand.addCard(game.deck.deal());
            	playerSide1.getChildren().clear();
            	playerSide1.getChildren().add(showCards(game, true, false));
            	if(!game.playersHand.under(22)) flag = false;
            }
            if(!flag)
            {
            	dealerSide1.getChildren().clear();
            	dealerSide1.getChildren().add(showCards(game, false, true));
                showResultsFinal (game, btn_Bet, btn_Hit, btn_Stay, betField, betLabel);                
            }
         }
      });
      
      //Hbox for hit stay buttons
      HBox HbButtons = new HBox();
      HbButtons.setSpacing(10);
      HbButtons.getChildren().addAll(btn_Hit, btn_Stay);
      HbButtons.setAlignment(Pos.CENTER);
      
      // VBox for BET
      VBox vbButtons = new VBox();
      vbButtons.setSpacing(10);
      vbButtons.setPadding(new Insets(300, 0, 0, 900));
      vbButtons.getChildren().addAll(betLabel, betField,btn_Bet , HbButtons, winner);
            
      return vbButtons;

   }
   
   //Function to Dispaly card images
   public HBox showCards(BlackJackGame game, boolean player, boolean result)
   {
	   int num;
	   String value;
	   char suite;
	   
	   if(player)
	   {
		   num = game.playersHand.numCards;
		   
	   }
	   else
	   {
		   num = game.dealersHand.numCards;
		   
	   }
		   
	   HBox hboxShow = new HBox();
	   for(int i = 0; i < num; i++)
       {
       		if(player)
       		{
       			value = game.playersHand.cards[i].value;
       			suite = game.playersHand.cards[i].suit.charAt(0);
       		}
       		else
       		{
       			value = game.dealersHand.cards[i].value;
       			suite = game.dealersHand.cards[i].suit.charAt(0);
       		}
       		if(!player && i==0 && !result)
		    {
		    	filename = "purple_back.png";
		    }
       		else
       		{
       			switch(value) {
       	       	case "Ace":
       	       		filename = "A";
       	       		break;
       	       	case "Ten":
       	       		filename = "10";
       	       		break;
       	       	case "Jack":
       	       		filename = "J";
       	       		break;
       	       	case "Queen":
       	       		filename = "Q";
       	       		break;
       	       	case "King":
       	       		filename = "K";
       	       		break;
       	       	default:
       	       		filename = value;
       	       		break;
       	       	}
       	       	filename = filename + suite + ".png";
       		}
       	   Image input = new Image(new File("images/" + filename).toURI().toString());
           ImageView imageView = new ImageView(input);
           imageView.setFitWidth(150);
           imageView.setPreserveRatio(true);
           hboxShow.setSpacing(5);
           hboxShow.getChildren().add(imageView);
           
       }
	   return hboxShow;       
   }
   
   //Function to show results
   public void showResultsFinal (BlackJackGame game, Button btn_Bet, Button btn_Hit, Button btn_Stay, TextField betField, Label betLabel ) {
	   DropShadow ds = new DropShadow();
	   ds.setOffsetY(3.0f);
	   ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
	   winner.setEffect(ds);
	   winner.setCache(true);
	   winner.setX(10.0f);
	   winner.setY(270.0f);
	   winner.setFill(Color.web("#01579B"));
	   winner.setText(game.showResults());
	   winner.setFont(Font.font("Edwardian Script ITC", FontWeight.BOLD, 52));
	   
	   FadeTransition ft = new FadeTransition(Duration.millis(500), winner);
	   ft.setFromValue(1.0);
	   ft.setToValue(0.3);
	   ft.setCycleCount(4);
	   ft.setAutoReverse(true);
	 
	   ft.play();
	   
       btn_Bet.setVisible(true);
       btn_Hit.setVisible(false);
       btn_Stay.setVisible(false);
       betField.setText(Integer.toString(game.bet));  
       betLabel.setText("Place Your Bet");
       moneyField.setText("You have $"+Integer.toString(game.money)+".");
       game.playersHand = new Hand();
       game.dealersHand = new Hand();
       
   }
  
} 
