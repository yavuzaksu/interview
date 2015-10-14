package com.interview;

public class SteamEngine extends AbstractEngine implements Engine {

    public static final int BATCH_SIZE = 2;

    public SteamEngine(FuelType requiredFuelType) {
       super(requiredFuelType);
    }

    public double getBatchCost() {

        return fuelType.equals(FuelType.COAL) ? 5.65 : 4.35;
    }

    boolean isRightFuelForTheEngine(FuelType fuelType){
        return fuelType.equals(FuelType.WOOD) || fuelType.equals(FuelType.COAL) ? true : false;
    }
}
