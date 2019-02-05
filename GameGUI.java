/* Emery Wollerscheid
   CS - 110
   Game of Set - GameGUI Class
*/

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

public class GameGUI extends Application
{
   private Stage primaryStage;
   private Scene scene;
   private Game game;
   private GridPane gridpane;
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      //Intialize GameGUI instance objects and Variables
      this.gridpane = new GridPane();
      this.game = new Game();
      
      //Make boardGUI
      this.makeBoard();
      
      //Clean Up GridPane
      gridpane.setHgap(10);
      gridpane.setVgap(10);
      gridpane.setAlignment(Pos.CENTER);
      
      //Make and display scene and stage
      scene = new Scene(gridpane,515,550);
      primaryStage.setTitle("Game of Set by Emery Wollerscheid");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   
   /** makeBoard method creates board from current game, then uses the CardPane
       class to populate the GUI with the image of the cards. Then buttons and cardsRemaining are
       added into the final row
       @params: null
       @returns: null
   */  
   private void makeBoard()
   {
      Board gameBoard = game.getBoard();
      gridpane.getChildren().clear();
      
      for(int i = 0; i < gameBoard.numRows(); i++)
      {
         for (int z = 0; z < gameBoard.numCols(); z++)
         {
             CardPane cardPane = new CardPane(gameBoard.getBoardSquare(i,z));
             cardPane.setOnMouseClicked(this::cardPaneSelected);
             gridpane.add(cardPane,z,i);
          }
      }
      
      //Intialize Buttons
      Button exit = new Button("Exit");
      Button newGame = new Button("New Game");
      Button add3 = new Button("Add 3");
      
      //Cards remaining code
      String cardsLeft = "Cards Left\n";
      int remaining = game.cardsLeft();
      cardsLeft += Integer.toString(remaining);
      
      //Create labels
      Label remaingingCards = new Label(cardsLeft);
      
      //Assign Button event handlers
      exit.setOnAction(this::exit);
      newGame.setOnAction(this::newGame); 
      add3.setOnAction(this::add3);
      
      //Add Buttons and Label to last row of Gridpane      
      gridpane.add(exit,0,4);
      gridpane.add(newGame,1,4);
      gridpane.add(add3,2,4);  
      gridpane.add(remaingingCards,3,4);
      
      //Align for aesthetic 
      gridpane.setHalignment(exit,HPos.CENTER);
      gridpane.setHalignment(newGame,HPos.CENTER);
      gridpane.setHalignment(add3,HPos.CENTER);
      gridpane.setHalignment(remaingingCards,HPos.CENTER);
      
   }
   
   /** selectedCardPane handles mouse click on a cardpane
       marks cardPane selected if not selected and vice versa
       if selected change background color
       if three cards are selected, test for set, 
       if set replace cards and remove from selectedArray
       if not set remove cards from array and un-highlight
   */
   private void cardPaneSelected(MouseEvent ME)
   {
      CardPane cardPane = (CardPane)(ME.getSource());
      
      if(cardPane.isSelected() == false && game.numSelected() < 3)
      {
         cardPane.setSelected(true);
         cardPane.setStyle("-fx-background-color: gold;" + "-fx-border-width: 2;" + "-fx-border-color: black;"); //Highlight background yellow
         game.addToSelected(cardPane.getRow(),cardPane.getCol());//Add to ArrayList selected
      }
      
      else if (cardPane.isSelected() == true)
      {
         cardPane.setSelected(false);
         cardPane.setStyle("-fx-background-color: white;" + "-fx-border-width: 2;" + "-fx-border-color: black;"); //Un-highlight background
         game.removeSelected(cardPane.getRow(),cardPane.getCol());//Remove from ArrayList selected
      }
      
      if(game.numSelected() == 3)
      {
         game.testSelected();
         this.makeBoard();
      }
      
   }
   
   /** add3 event handler
       if button is pressed, add3 method is applied to game object
       boardGUI is redrawn to account for the new column in the board object
       @params: ActionEvent AE
       @returns: null
   */
   private void add3(ActionEvent AE)
   {
      Board boardSize = this.game.getBoard();
      int cols = boardSize.numCols();
      if(cols < 6 && game.cardsLeft() >= 3)
      {
         this.game.add3();
         this.makeBoard();
      }
   }
   
   /** exit event handler
       If exit button is pressed program terminates
       @params: ActionEvent AE
       @returns: null
   */ 
   private void exit(ActionEvent AE)
   {
      Platform.exit();
   }
   
   /** newGame event handler
       re-intializes game object and
       calls makeBoard method with updated board object
       @params: ActionEvent AE
       @returns: null
   */   
   private void newGame(ActionEvent AE)
   {
      game = new Game();
      this.makeBoard();
   }   
}