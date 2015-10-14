package com.interview;


public abstract class  AbstractEngine {

    protected boolean running;
    protected int fuelLevel;
    protected FuelType fuelType;
    protected FuelType requiredFuelType;


    abstract boolean isRightFuelForTheEngine(FuelType fuelType);

    public AbstractEngine(FuelType requiredFuelType) {
        if(isRightFuelForTheEngine(requiredFuelType)) {
            this.requiredFuelType = requiredFuelType;
        }else{
            throw new IllegalArgumentException("Not a valid Fuel type to initialise the engine.");
        }
        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {

        if(isRightFuelForTheEngine(fuelType)) {
            this.fuelType = fuelType;
        }else{
            throw new IllegalArgumentException("Not a valid Fuel type to fill the engine.");
        }

        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        }
        else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        }
        else {
            this.fuelLevel = 0;
        }

    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public FuelType getRequiredFuelType() {
        return  requiredFuelType;
    }
    public FuelType getFuelType() {
        return  fuelType;
    }
}
