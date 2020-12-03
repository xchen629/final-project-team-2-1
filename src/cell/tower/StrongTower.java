package src.cell.tower;
import java.awt.Color;
/**
 * This class implements strong tower
 */

import java.awt.Color;
import java.util.Random;

import src.cell.Cell;
public class StrongTower extends BaseTower {

    public StrongTower(Cell cell){
        super(cell);
        this.damage = 2.0;
    }

    /**
     * This method will shoot enemy when fully realoaded.
     * Strong tower has 10% chance to shoot again
     */
    @Override
    public void shoot() {
        System.out.println("Strong tower shoots");
        Random  r = new Random(); 
        float roll = r.nextFloat();
        double max = .10;
        System.out.println(max + " " + roll);
        if (roll < max){
            System.out.println("Strong tower shoots again");
        }
    }

    /**
     * Draws strong tower as purple box
     */
    @Override
    public Color draw(){
        System.out.println("Purple Box on " + position.getLocation());
        return Color.CYAN;
    }
    
}