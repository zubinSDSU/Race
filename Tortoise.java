/**  Tortoise class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Tortoise extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Tortoise( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Tortoise( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Tortoise move characteristics: "slow & steady wins the race"
   *      increment x by 1 most of the time
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
       setX( getX( ) + 1 );
   }

   /** draw: draws the Tortoise at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     	g.setColor( new Color( 34, 139, 34 ) ); // dark green

     //body
     g.fillOval( startX - 30, startY, 25, 15 );

     //head
     g.fillOval( startX - 10, startY + 5,  15, 10 );

     //flatten bottom
      g.clearRect( startX - 30, startY + 11, 35, 4 );

     //feet
     g.setColor( new Color( 34, 139, 34 ) );  // brown
     g.fillOval( startX - 27, startY + 10,  5, 5 );
     g.fillOval( startX - 13, startY + 10, 5, 5 );

       if(isWinner == true) {
           morph(g);
       }

   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this tortoise moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }

   public void morph(Graphics g){
// tortoise grabs a drink
       g.setColor(Color.WHITE);
       g.fillRect( getX()-18, getY() -15,  8, 15 );
       g.setColor(Color.blue);
       g.fillRect( getX()-18, getY() -10,  8, 10 );
       g.setColor(Color.orange);
       g.fillRect( getX()-16, getY() -21,  1, 16 );

   }
}