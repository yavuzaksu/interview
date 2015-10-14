package com.interview;

public class InternalCombustionEngine  extends AbstractEngine implements Engine{


    public InternalCombustionEngine(final FuelType requiredFuelType) {

       super(requiredFuelType);
    }


    public double getBatchCost() {
        return fuelType.equals(FuelType.PETROL) ? 9.0 : 12.0;
    }


    boolean isRightFuelForTheEngine(FuelType fuelType){
        return fuelType.equals(FuelType.PETROL) || fuelType.equals(FuelType.DIESEL) ? true : false;
    }

    public int getBatchSize() {
      return 0;
    }
}
