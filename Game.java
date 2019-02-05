/* Emery Wollerscheid
   CS - 110
   Game of Set - Game Class
*/

import java.util.*;

public class Game
{
   //Initialize Game Objects
   private Board board;
   private Deck deck;
   private Card card;
   private ArrayList<BoardSquare> selected = new ArrayList<BoardSquare>();
   
   //Default Game Constructor
   //Intializes Deck, shuffles deck, and loads into Board 
   public Game() 
   {
      this.deck = new Deck();
      this.deck.shuffle();
      this.board = new Board(deck);  
   }
   
   /** outOfCards method accesses
       isEmpty method from Deck Class
       to return boolean value if the
       instance deck is empty or not
       @params: null
       @returns: boolean
   */
   public boolean outOfCards()
   {
      if (this.deck.isEmpty())
      {
         return true;  
      }
      else
      {
         return false;
      }
   }
   
   /** addToSelected method takes in the row
       and col of the user selected card
       and adds the selected card to the selected arraylist
       @params: int row, int col
       @returns: null      
   */   
   public void addToSelected(int row, int col)
   {
      BoardSquare boardSquare = this.board.getBoardSquare(row,col);
      this.selected.add(boardSquare);
   }
   
   /** numSelected method returns the
       number of cards selected at a given time
       @params: null
       @returns: int
   */
   public int numSelected()
   {
      return this.selected.size();
   }
      
   /** testSelected method checks to see
       if selected cards equal a set by accessing
       the isSet method from the card class
       @params: null
       @returns: null
   */  
   public void testSelected()
   {
      Card card1 = this.selected.get(0).getCard();
      Card card2 = this.selected.get(1).getCard();
      Card card3 = this.selected.get(2).getCard();
      if (card1.isSet(card1, card2, card3))
      {
         System.out.println("Set!");
         for (int i = 0; i < this.selected.size(); i++)
         {
            this.board.replaceCard(this.deck.getTopCard(), this.selected.get(i).getRow(), this.selected.get(i).getCol());            
         }
         this.selected.removeAll(this.selected);        
      }
      else
      {
         System.out.println("Not a Set");
         this.selected.removeAll(this.selected);
      }  
   }
   
   /** removeSelected method removes a specified
       card from the selected arraylist
       @params: int row, int col
       @returns: null
   */
   public void removeSelected(int row, int col)
   {
      BoardSquare targetRemove = this.board.getBoardSquare(row,col);
      for (int i = 0; i < this.selected.size(); i++)
      {
         if (this.selected.get(i).getRow() == targetRemove.getRow())
         {
            if (this.selected.get(i).getCol() == targetRemove.getCol())
            {
               this.selected.remove(i);
            }
         }
      }
      
   }
   
   /** add3 method calls
       add3 method from board class
       and applies to instance board
       @params: null
       @returns: null
   */
   public void add3()
   {
      this.board.add3(this.deck);
   }
   
   /** getSelected method returns
       Selected ArrayList contents
       @params: null
       @returns: ArrayList<BoardSquare> Selected
   */
   public ArrayList<BoardSquare> getSelected()
   {  
      return this.selected;
   }
   
   /** toString method calls
       toString method from Board Class
       and applies to instance Board board
       @params: null
       @returns: ArrayList<BoardSquare>
   */
   public String toString()
   {
      return this.board.toString();
   }
   
   /** getBoard method returns current board
       @params: null
       @returns: Board board
   */
   public Board getBoard()
   {
      return this.board;
   }
   
   /** cardsLeft method returns deck cardsLeft method
       @params: null
       @returns: Integer cardsLeft
   */
   public int cardsLeft()
   {
      return this.deck.cardsLeft();
   }
    
}