package src.cell.tower;

import src.cell.Cell;

/**
 * This class specifies the framework for tower template pattern.
 * Strong and weak tower classes will build off of this and provide implementation
 */
public abstract class BaseTower extends Tower{
    public BaseTower(Cell cell){
        super(cell);
        this.speed = 3;
        this.reloadLeft = 0;
    }

    /**
     * This method will shoot enemy when fully realoaded.
     */
    @Override
    public void attack() {
        if (this.getReloadLeft() <= 0){
            this.shoot();
            this.setReloadLeft(this.getSpeed());
        }
        else{
            this.reload();
        }
    }

    /**
    * This method will inflict damage to enemy
    */
    public abstract void shoot();
    
    /**
    * This method will stall the tower before shooting again
    */
    @Override
    public void reload() { 
        
    }

    /** 
    * Returns damage
    */
    @Override
    public double getDamage(){
        return this.damage;
    }

    /** 
    * Returns range 
    */
    @Override
    public int getRange(){
        return this.range;
    }

    /**
    * Returns speed
    */
    @Override
    public double getSpeed(){
        return this.speed;
    }

    /** 
    * Returns reloadLeft
    */
    @Override
    public double getReloadLeft(){
        return this.reloadLeft;
    }
    
    /* sets the damage
    * @param newDamage is used to replace previous tower damage value
    */
    @Override
    public void setDamage(double newDamage){
        this.damage = newDamage;
    }

    /* sets the attack range 
    * @param newRange is used to replace previous tower range value
    */
    @Override
    public void setRange(int newRange){
        this.range = newRange;
    }

    /* sets the attack speed 
    * @param newSpeed is used to replace previous tower speed value
    */
    @Override
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }

    /* sets the reload left
    * @param newReloadLeft is used to replace previous tower reload time left
    */
    @Override
    public void setReloadLeft(double newReloadLeft){
        this.reloadLeft = newReloadLeft;
    }

}