package com.interview;

public class SteamEngine extends AbstractEngine implements Engine {


    public SteamEngine(FuelType requiredFuelType) {
       super(requiredFuelType);
    }

    public double getBatchCost() {

        return fuelType.equals(FuelType.COAL) ? 5.65 : 4.35;
    }

    boolean isRightFuelForTheEngine(FuelType fuelType){
        return fuelType.equals(FuelType.WOOD) || fuelType.equals(FuelType.COAL) ? true : false;
    }

    public int getBatchSize() {
        return 2;
    }
}
