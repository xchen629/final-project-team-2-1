package src.cell.enemy;

import src.board.Board;
import src.board.iterator.CellList;
import src.board.iterator.IteratorInterface;
import src.cell.Cell;
import src.cell.CellComponent;

/**
 * This class specifies the framework for enemy.
 * Enemies will additionally contain health.
 */
public abstract class EnemyPrototype extends CellComponent implements Cloneable {

    protected double health;
    protected double speed;
    protected CellList<Cell> pathCellList;
    protected IteratorInterface<Cell> cellPathIterator;

    /**
     * New initialized enemy outside of board
     */
    public EnemyPrototype() {}

    /**
     * New initialized enemy inside of board
     * @param position on board
     */
    public EnemyPrototype(Cell position) {super(position);}
    /**
     * This method will allow the object to move from current cell to another
     */

    /** 
    * Sets the Iterator List
    * @param Iterator path list
    */
    public void setCellPathIterator(CellList<Cell> pathCellList) {
        this.pathCellList = pathCellList;
    }

    /** 
     * Return Iterator for iterating the Cell path
     */
    public IteratorInterface<Cell> getCellPathIterator() {
        return this.cellPathIterator;
    }

    /** 
     * Removes the enemy if dead and
     * add gold for kill
     */
    public void removeIfDead(){
        if (this.getHealth() <= 0){
            Board.getBoardInstance().setGold(Board.getBoardInstance().getGold() + 20);
            Board.getBoardInstance().remove(this);
            this.getPosition().remove(this);            
            System.out.println("Enemy is dead");
            this.position = null;
            while(this.getCellPathIterator().hasNext()) {
                this.getCellPathIterator().next();
            }


        }
    }

     /** 
     * Subract 1 from board's life after enemy passes through the path
     */
    public void removeIfFinishPath() {
        if (this.getPosition() != null)
        {
            this.getPosition().remove(this);
            this.position = null;
            System.out.println("enemy escapes");
            var board = Board.getBoardInstance();
            board.setHealth(board.getHealth() - 1);
            System.out.println("enemy escapes. It will be removed from board enemy list");
            System.out.println("before enemy removal. Enemy num is " + board.getEnemyList().size());
            board.remove(this);
            System.out.println("after enemy removal. Enemy num is " + board.getEnemyList().size());
        }
    }

    /** Enemy moves up the path */
    public abstract boolean move();

    /** Returns health */
    public abstract double getHealth();

     /** Returns health */
    public abstract void setHealth(double newHealth);

    /* This method will be used to clone/create copies of enemy objects */
    public abstract EnemyPrototype clone();

    /* Returns speed*/
    public double getSpeed(){
        return speed;
    }

    /* Sets new speed */
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /**
     * Returns hash code
     */
    public int hashCode(){
        int hash = 0;
        hash += (this.health == 0 ? 0: Double.valueOf(this.health).hashCode());
        hash += (this.speed == 0 ? 0: Double.valueOf(this.speed).hashCode());
        hash += (this.position == null ? 0 : this.position.hashCode());
        return hash;
    }
    
    /**
     * Compare objects based on health, speed
     * @param other to compare
     */
    public boolean equals(Object other){
        if (other == null) {return false;}
        else if (this == other) {return true;}
        else if (other instanceof EnemyPrototype){
            EnemyPrototype otherObj = (EnemyPrototype) other;
            if (this.getHealth() == otherObj.getHealth()
                &&  this.getSpeed() == otherObj.getSpeed())
                {
                    return true;
                }
        }
        return false;
    }

    /**
     * Returns object as string representation.
     */
    public String toString(){
        if (this.position != null)
        {
            String returnString = "Enemy at: x: " + this.position.getX() + " y: " + this.position.getY(); 
            returnString = returnString + " Health: " + this.getHealth();
            returnString = returnString + " Speed: " + this.speed;
            return returnString;
        }
        else return "";
        
    }

}