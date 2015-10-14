package com.interview;

public class InternalCombustionEngine implements Engine{

    private boolean running;
    private int fuelLevel;
    private FuelType fuelType;

    public InternalCombustionEngine(FuelType fuelType) {

        if(fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL)) {
            this.fuelType = fuelType;
        }else{
            throw new IllegalArgumentException("Not a valid Fuel type.");
        }

        running = false;
        fuelLevel = 0;
    }

    public void start() {
        if (fuelLevel > 0 && fuelType.equals(fuelType)) {
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

    public FuelType getFuelType() {
        return  fuelType;
    }

    public double getRunningCost() {
        return fuelType.equals(FuelType.PETROL) ? 9.0 : 12.0;
    }
}
