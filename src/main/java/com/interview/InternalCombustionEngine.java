package com.interview;

public class InternalCombustionEngine implements Engine{

    public static final int BATCH_SIZE = 0;

    private boolean running;
    private int fuelLevel;
    private FuelType fuelType;
    private FuelType requiredFuelType;

    public InternalCombustionEngine(final FuelType requiredFuelType) {

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

        this.fuelType = fuelType;
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

    public double getBatchCost() {
        return fuelType.equals(FuelType.PETROL) ? 9.0 : 12.0;
    }



    private boolean isRightFuelForTheEngine(FuelType fuelType){
        return fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL) ? true : false;
    }
}
