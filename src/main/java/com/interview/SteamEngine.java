package com.interview;

public class SteamEngine implements Engine {

    private boolean running;
    private int fuelLevel;
    private FuelType requiredFuelType;
    private FuelType fuelType;

    public SteamEngine(FuelType requiredFuelType) {
        if(requiredFuelType.equals(FuelType.COAL) || requiredFuelType.equals(FuelType.WOOD)) {
            this.requiredFuelType = requiredFuelType;
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
        return  requiredFuelType;
    }
}
