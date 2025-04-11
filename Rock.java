/**  Tortoise class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Rock extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Rock( )
    {
        super( );
        setRandAndSpeed();
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Rock( String rID, int rX, int rY )
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
        //Rock basically has a random chance of winning without moving.
        int move =  rand.nextInt( 10000) + 1;
        if(move == 545){
            setX(getX() + 400);


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
        if(isWinner == false) {
            g.setColor(new Color(30, 30, 30));
            g.fillRect(startX, startY, 20, 10);
            ;

            //body
            g.setColor(Color.DARK_GRAY);
            g.fillRect(startX + 2, startY - 8, 15, 10);

            g.setColor(new Color(150, 150, 150));
            g.fillRect(startX + 5, startY - 16, 10, 10);
        }

        //g.fillOval( startX+6, startY-20 ,  10,  10 );

        //g.setColor( Color.ORANGE );
        //g.fillRect(startX+12, startY-17, 10, 3 );

        //head
        // g.fillOval( startX - 13, startY + 2, 13, 8 );
        // g.fillOval( startX - 13, startY - 8, 8, 28 );

        //flatten bottom
        // g.clearRect( startX - 37, startY + 15, 32, 5 );



        if(this.isWinner){
            morph(g);
        }

    }

    private void setRandAndSpeed( ) {
        // percentage of time (between 90 - 99%) that this tortoise moves each turn
        rand = new Random( );
        speed = rand.nextInt( 10 ) + 90;
    }
    @Override
    public void morph ( Graphics g ){
        //rock turns into rock man
        g.setColor(Color.DARK_GRAY);
        g.fillRect( getX()-5, getY()+5,  20,   20);
        g.fillRect( getX()+20, getY()+5,  20,   20);
        g.fillRect( getX()+8, getY()-30,  20,   40);
        g.setColor(new Color(150, 150, 150));
        g.fillRect( getX()-8, getY()-20,  20,   20);
        g.fillRect( getX()+23, getY()-20,  20,   20);
    }
}