package com.interview;

public class SteamEngine implements Engine {

    public static final int BATCH_SIZE = 2;

    private boolean running;
    private int fuelLevel;
    private FuelType fuelType;
    private FuelType requiredFuelType;

    public SteamEngine(FuelType fuelType) {

        if(isRightFuelForTheEngine(requiredFuelType)) {
            this.requiredFuelType = requiredFuelType;
        }else{
            throw new IllegalArgumentException("Not a valid Fuel type to initialise the engine.");
        }
        running = false;
        fuelLevel = 0;
    }

    public void start() {
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void fill(FuelType fuelType, int fuelLevel) {
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

        return fuelType.equals(FuelType.COAL) ? 5.65 : 4.35;
    }

    public int getBatchSize() {
        return 0;
    }

    private boolean isRightFuelForTheEngine(FuelType fuelType){
        return fuelType.equals(FuelType.WOOD) || fuelType.equals(FuelType.COAL) ? true : false;
    }
}
