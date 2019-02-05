/* Emery Wollerscheid
   Game of Set - Deck Class
   Contains constructor for the Deck
   which will hold 81 Card objects
*/

import java.util.*;

public class Deck
{
   //Instance Variables
   private final static int MAX_CARDS = 81;
   private final static int MAX_ATTS = 3;
   private ArrayList<Card> deck = new ArrayList<Card>();
   
   /**Deck Constructor creates Deck Object
      containing cards
      @params null
      @returns Object Deck    
   */  
   public Deck()
   {
      for (int shape = 0; shape < MAX_ATTS; shape++)
      {
         for(int color = 0; color < MAX_ATTS; color++)
         {
            for(int number = 0; number < MAX_ATTS; number++)
            {
               for(int shading = 0; shading < MAX_ATTS; shading++)
               {
                  Card card = new Card(shape,color,number,shading);
                  this.deck.add(card);
               }
            }
         }
      }
   }
   
   /** Shuffle method randomly places
       Card objects within the deck ArrayList
       @params null
       @returns null
   */
   public void shuffle()
   {
      int randNum;
      Random r = new Random();
      for (int i = 0; i < MAX_CARDS; i++)
      {
         randNum = r.nextInt(MAX_CARDS);
         Card temp = deck.get(randNum);
         Card swap = deck.get(i);
         this.deck.set(randNum,swap);
         this.deck.set(i,temp);
      }
      
    }
    
    /** toString Method uses Card Class toString
        to display every card in the deck
        @params null
        @returns String deckString 
    */
    public String toString()
    {
      String deckString = "";
      for (int i = 0; i < deck.size(); i++)
      {
         deckString += deck.get(i).toString() + "\n";
      }
      return deckString;    
    }
    
    /**isEmpty method determines 
       if the deck contains any cards
       @params null
       @returns boolean 
    */
    public boolean isEmpty()
    {
      if (this.deck.size() == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
    }
   
    /** getTopCard method returns card
        at deck index 0
        @params null
        @returns Card Object
    */
    public Card getTopCard()
    {
      Card topCard;
      topCard = this.deck.get(0);
      this.deck.remove(0);
      return topCard;
    }
    
    public int cardsLeft()
    {
      return this.deck.size();
    }                      
}    