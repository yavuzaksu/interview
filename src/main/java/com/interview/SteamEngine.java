package com.interview;

public class SteamEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType fuelType;

    public SteamEngine(FuelType fuelType) {
        if(fuelType.equals(FuelType.COAL) || fuelType.equals(FuelType.WOOD)) {
            this.fuelType = fuelType;
        }else{
            throw new IllegalArgumentException("Not a valid Fuel type.");
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

    public FuelType getFuelType() {
        return  fuelType;
    }

    public double getRunningCost() {

        return fuelType.equals(FuelType.COAL) ? 5.65 : 4.35;
    }
}
