/* Emery Wollerscheid
   CS - 110
   CardPane Class
*/

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

public class CardPane extends VBox
{
   //Instance Objects and Variables
   private BoardSquare bSquare;
   private boolean selected;   
   private int row;
   private int col;
   
   //For Hatchpattern
   private static Image img;
   private static ImagePattern hatchPattern;
   
   //Javafx Attribute Variables
   private Paint line;
   private Paint fill;
   private int numShapes;
   private static final int HEIGHT = 150;
   private static final int WIDTH = 75;
   
   public CardPane(BoardSquare bSquare)
   {
      super();
      setPrefSize(HEIGHT,WIDTH);      
      
      setMaxHeight(HEIGHT);
      setMaxWidth(WIDTH);
      
      setMinHeight(HEIGHT);
      setMinWidth(WIDTH);
      
      setAlignment(Pos.CENTER);
      
      this.setStyle("-fx-background-color: white;" + "-fx-border-width: 2;" + "-fx-border-color: black;");
      
      try
      {
         img = new Image("hatch.png");
         hatchPattern = new ImagePattern(img);
      }
      
      catch(IllegalArgumentException e)
      {
         System.out.println("Image not found.");
      }
      
      this.row = bSquare.getRow();
      this.col = bSquare.getCol();
      this.selected = false;
      
      Card card = bSquare.getCard();
      
      if (card.getColor() == 0)
      {
         this.line = Color.RED;
      }
      else if (card.getColor() == 1)
      {
         this.line = Color.PURPLE;
      }
      else if (card.getColor() == 2)
      {
         this.line = Color.GREEN;
      }
      
      if (card.getShading() == 0)
      {
         this.fill = line;
      }
      else if (card.getShading() == 1)
      {
         this.fill = hatchPattern;
      }
      else if (card.getShading() == 2)
      {
         this.fill = Color.WHITE;
      }
      
      if (card.getNumber() == 0)
      {
         this.numShapes = 1;
      }
      else if (card.getNumber() == 1)
      {
         this.numShapes = 2;
      }
      else if (card.getNumber() == 2)
      {
         this.numShapes = 3;
      }
      
      if (card.getShape() == 0)
      {
         drawEllipse();
      }
      
      else if (card.getShape() == 1)
      {
         drawSquiggle();
      }
      
      else if(card.getShape() == 2)
      {
         drawDiamond();
      }                
      
   }
 
   /** getBoardSquare method returns 
       the current BoardSquare object
       @params: null
       @returns: BoardSquare bSquare
   */
   public BoardSquare getBoardSquare()
   {
      return bSquare;
   }
   
   /** getRow method returns integer row
       @params: null
       @returns: Integer row
   */
   public int getRow()
   {
      return this.row;
   }
   
   /** getCol method returns integer column
       @params: null
       @returns: Integer column
   */   
   public int getCol()
   {
      return this.col;
   }
   
   /** isSelected method returns Boolean selected
       @params: null
       @returns: Boolean selected
   */
   public boolean isSelected()
   {
      return this.selected;
   }
   
   /** setSelected method sets Boolean selected to specified boolean
       @params: boolean bool
       @returns: null
   */
   public void setSelected(boolean bool)
   {
      this.selected = bool;
   }
   
   /** drawEllipse method draws an ellipse
       within CardPane based on the color, shade, and number
       @params: null
       @returns: null
   */
   public void drawEllipse()
   {
      Ellipse e;
      for(int i = 0; i < this.numShapes; i++)
      {
         e = new Ellipse();
         e.setRadiusX(20.0);
         e.setRadiusY(10.0);
         e.setStroke(this.line);
         e.setFill(this.fill);
         getChildren().add(e);
      }
   }
   
   /** drawSquiggle method draws a rectangle
       within CardPane based on the color, shade, and number
       @params: null
       @returns: null
   */
   public void drawSquiggle()
   {
      Rectangle r;
      for (int i = 0; i < this.numShapes; i++)
      {
           r = new Rectangle();
           r.setHeight(20);
           r.setWidth(50);
           r.setStroke(this.line);
           r.setFill(this.fill);
           getChildren().add(r);
      }
   }
   
   /** drawDiamond method draws a diamond shape
       within the CardPane based on the color, shade, and number
       @params: null
       @returns: null
   */
   public void drawDiamond() // rectangle acceptable
   {
      Polygon p;
      for (int i = 0; i < this.numShapes; i++)
      {
         p = new Polygon();
         p.getPoints().addAll(new Double[]{
            10.0, 20.0,
            30.0, 10.0, 
            50.0, 20.0, 
            30.0, 30.0});
         p.setFill(this.fill);
         p.setStroke(this.line);
         getChildren().add(p);
      }
   }
}
   
   
      
      
      
      
      