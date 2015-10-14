package com.interview;


public interface Engine {

    void start() ;
    void stop();
    boolean isRunning();
    void fill(FuelType fuelType, int fuelLevel);
    int getFuelLevel() ;
    FuelType getFuelType() ;

}
