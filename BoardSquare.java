/* Emery Wollerscheid
   Game of Set - BoardSquare
   Class contains BoardSquare constructor
   private variables, and methods for 
   interacting with instance variables
*/

public class BoardSquare
{
   //Instance Variables
   private int row;
   private int col;
   private Card card;
   
   /** BoardSquare Constructor
       creates BoardSquare object containing
       a Card Object
       @params Object Card, integer row, integer col
       @returns Object BoardSquare
   */
   public BoardSquare(Card card, int row, int col)
   {
      this.card = card;
      this.row = row;
      this.col = col;
   }
   
   /** getRow Method returns
       BoardSquare row position
       @params null
       @returns integer row
   */
   public int getRow()
   {
      return this.row;
   }
  
   /** setRow Method changes the
       value of the row variable
       @params integer row
       @returns null
   */
   public void setRow(int row)
   {
      this.row = row;
   }   
   
   /** getCol Method returns the
       BoardSquare column position
       @params null
       @returns integer col
   */
   public int getCol()
   {
      return this.col;
   }
   
   /** setCol Method changes the
       value of the col variable
       @params integer row
       @returns null
   */
   public void setCol(int col)
   {
      this.col = col;
   }
   
   /** getCard Method returns the
       Card object stored within
       the BoardSquare object
       @params null
       @returns Card Object
   */
   public Card getCard()
   {
      return this.card;
   }
   
   /** setCard Method changes the
       Card object stored within
       the BoardSquare object
       @params Card Object
       @returns null
   */
   public void setCard(Card card)
   {
      this.card = card;
   }
   
   /** toString Method uses Card clas
       toString and applies to getCard
       Method to return String of specified card
       @params: null
       @returns: String 
   */    
   public String toString()
   {
      return this.getCard().toString();
   }
   
}