/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class SnowMan extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public SnowMan( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public SnowMan( String rID, int rX, int rY )
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
        //Snowman slips if he moves too fast
        int move =  rand.nextInt( 50) + 1;
        if(move > 40){
            setX(getX() -10);}
            else{
                setX(getX() + 5);
            }
        }


    /** draw: draws the Tortoise at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startY = getY( );
        int startX = getX( );

        // tail
        g.setColor( Color.WHITE );
        g.fillOval( startX , startY,  20, 20 ) ;

        //body
        g.setColor( Color.WHITE );
        g.fillOval( startX+3, startY-12 ,  15,  15 );

        g.fillOval( startX+6, startY-20 ,  10,  10 );

        g.setColor( Color.ORANGE );
        g.fillRect(startX+12, startY-17, 10, 3 );





            if(isWinner == true){
                morph(g);

    }


        //head
       // g.fillOval( startX - 13, startY + 2, 13, 8 );
       // g.fillOval( startX - 13, startY - 8, 8, 28 );

        //flatten bottom
       // g.clearRect( startX - 37, startY + 15, 32, 5 );


    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this tortoise moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 90;
    }

    public void morph (Graphics g){
        //snowman gets a brown hat
        g.setColor(new Color(161, 113, 0));
        g.fillRect(getX()+5, getY()-21, 10, 2);
        g.fillRect(getX()+7, getY()-23, 7, 2);


    }
}