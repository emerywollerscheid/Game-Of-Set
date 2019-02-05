/* Emery Wollerscheid
   Game of Set - Board
   Class contains Board Constructor,
   Board ArrayList, and methods for 
   interacting with the Board Object
*/

import java.util.*;

public class Board
{
   //Instance ArrayList containing ArrayList of BoardSquares
   private ArrayList<ArrayList<BoardSquare>> board = new ArrayList<ArrayList<BoardSquare>>();
   private final int STARTINGROWS = 3;
   private final int STARTINGCOLS = 4;
   
   /**Board Constructor
      Creates Board object containing
      an ArrayList of ArrayLists containing BoardSquare Objects
      @params Deck Object
      @returns Board Object
   */  
   public Board(Deck deck)
   {
      for (int h = 0; h < STARTINGROWS; h++)
      {   
          ArrayList<BoardSquare> newRow = new ArrayList<BoardSquare>();  
          for (int r = 0; r < STARTINGCOLS; r++)
          {
            BoardSquare square = new BoardSquare(deck.getTopCard(),h,r);
            newRow.add(square);
          }
          this.board.add(newRow);
      }
   }
   
   /**replaceCard Method replaces a specifed card on the board
      @params Card Object, integer row integer column
      @returns null
   */
   public void replaceCard(Card card, int row, int col)
   {
      ArrayList<BoardSquare> changeRow = board.get(row);
      BoardSquare newSquare = new BoardSquare(card,row,col);
      changeRow.set(col,newSquare);
      this.board.set(row,changeRow);
   }
   
   /**getBoardSquare Method returns specified 
      BoardSquare Object
      @params integer row, integer column
      @returns BoardSquare Object
   */
   public BoardSquare getBoardSquare(int row, int col)
   {
      ArrayList<BoardSquare> getSquares = this.board.get(row);
      BoardSquare thisSquare = getSquares.get(col);
      return thisSquare;
   }
   
   /**add3 Method adds an additional column
      of cards to the Board Object
      @params Deck Object
      @returns null
   */
   public void add3(Deck deck)
   {
      for (int g = 0; g < this.board.size(); g++)
      {
         BoardSquare newSquare;
         ArrayList<BoardSquare> addSquares = this.board.get(g);
         if (g == 0)
         {
            newSquare = new BoardSquare(deck.getTopCard(),g,numCols());
         }
         else
         {
            newSquare = new BoardSquare(deck.getTopCard(),g,numCols()-1);
         }
         addSquares.add(newSquare);
         this.board.set(g,addSquares);
      }
   }  
   
   /**getCard Method retrieves a Card Object
      from the Board Object
      @params integer row, integer column
      @returns Card Object
   */
   public Card getCard(int row, int col)
   {
      BoardSquare containsCard = getBoardSquare(row,col);
      Card getCard = containsCard.getCard();
      return getCard;
   }
   
   /** numRows Method returns Number of rows
       in the board
       @params null
       @returns int rows
   */
   public int numRows()
   {
      return this.board.size();
   }
   
   /** numCols Method returns Number of columns
       in the board
       @params null
       @returns int columns
   */
   public int numCols()
   {
      ArrayList<BoardSquare> colSize = this.board.get(0);
      return colSize.size();
   }
   
   /** toString Method displays the game board
       as a string in the command window 
       @params null
       @returns String board
   */
   @Override
   public String toString()
   {
      String board = "";
       for (int y = 0; y < numRows(); y++)
       {
         for(int d = 0; d < numCols(); d++)
         {
            Card card = getCard(y,d);
            String c = card.toString();
            board += c;
            board += " ";
         }
         board += "\n";
      }  
      return board;  
   }    
}