/* Emery Wollerscheid
   Game of Set - Card Class
   Builds a Set Card to be placed
   in a deck
*/

public class Card
{
   //General Attributes
   private int shape;
   private int color;
   private int number;
   private int shading;
   
   //Shape Attributes
   private final int OVAL = 0;
   private final int SQUIGGLES = 1;
   private final int DIAMONDS = 2;
   
   //Color Attributes
   private final int RED = 0;
   private final int PURPLE = 1;
   private final int GREEN = 2;
   
   //Number Attributes
   private final int ONE = 0;
   private final int TWO = 1;
   private final int THREE = 2;
   
   //Shading Attributes
   private final int SOLID = 0;
   private final int STRIPED = 1;
   private final int OUTLINED = 2;
   
   /** Card Constructor
       Creates Card object
       @params integer shape, integer color, integer number, integer shading
       @returns Object Card
   */
   public Card(int shape, int color, int number, int shading)
   {
      this.shape = shape;
      this.color = color;
      this.number = number;
      this.shading = shading;
   }
   
   /** toString method evaluates
       Card enumerated Attributes
       and returns String Value
       @params null
       @returns String
   */
   @Override
   public String toString()
   {
      String cardValue ="";
      
      if (getNumber() == 0)//Number
      {
         cardValue += "1";
      }
      
      else if (getNumber() == 1)
      {
         cardValue += "2";
      }
      
      else if (getNumber() == 2)
      {
         cardValue += "3";
      }
      
      cardValue += "_";
      
      if (getColor() == 0)//Color
      {
         cardValue += "RED";
      }
      
      else if (getColor() == 1)
      {
         cardValue += "PURPLE";
      }
      
      else if (getColor() == 2)
      {
         cardValue += "GREEN";
      }
      
      cardValue += "_";
      
      if (getShape() == 0)//Shape
      {
         cardValue += "OVAL";
      }
      
      else if (getShape() == 1)
      {
         cardValue += "SQUIGGLES";
      }
      
      else if (getShape() == 2)
      {
         cardValue += "DIAMONDS";
      }
      
      cardValue += "_";
      
      if (getShading() == 0)//Shading
      {
         cardValue += "SOLID";
      }
     
      else if (getShading() == 1)
      {
         cardValue += "STRIPED";
      }
      
      else if (getShading() == 2)
      {
         cardValue += "OUTLINED";
      }
      
      return cardValue; 
   }
   
   /** getShape Method returns
       Card shape attribute
       @params null
       @returns integer shape
   */
   public int getShape()
   {
      return this.shape;
   }
   
   /** getColor Method returns
       Card color attribute
       @params null
       @returns integer shape
   */
   public int getColor()
   {
      return this.color;
   }
   
   /** getNumber Method returns
       Card number attribute
       @params null
       @returns integer number
   */
   public int getNumber()
   {
      return this.number;
   }
   
   /** getShading Method returns
       Card shading attribute
       @params null
       @returns integer shade
   */
   public int getShading()
   {
      return this.shading;
   }
   
   /** isSet Method compares three cards 
       and determines if they complete a set
       @params: Card c1, Card c2, Card c3
       @returns Boolean Value
   */
   public boolean isSet(Card c1, Card c2, Card c3)
   {
            
      if (!((c1.getColor() == c2.getColor()) && (c2.getColor() == c3.getColor())
         || (c1.getColor() != c2.getColor()) && (c2.getColor() != c3.getColor()) && (c1.getColor() != c3.getColor())))
      {
         return false;
      }
      
      if (!((c1.getNumber() == c2.getNumber()) && (c2.getNumber() == c3.getNumber())
          || (c1.getNumber() != c2.getNumber()) && (c2.getNumber() != c3.getNumber()) && (c1.getNumber() != c3.getNumber())))
      {
         return false;
      }
      
      if (!((c1.getShading() == c2.getShading()) && (c2.getShading() == c3.getShading()) 
         || (c1.getShading() != c2.getShading()) && (c2.getShading() != c3.getShading()) && (c1.getShading() != c3.getShading())))
      {
         return false;
      }
      
      if (!((c1.getShape() == c2.getShape()) && (c2.getShape() == c3.getShape()) 
         || (c1.getShape() != c2.getShape()) && (c2.getShape() != c3.getShape()) && (c1.getShape() != c3.getShape())))
      {
         return false;
      }
      
      return true;
   }
}