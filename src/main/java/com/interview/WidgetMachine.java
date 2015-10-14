package com.interview;

public class WidgetMachine {


    public double produceWidgets(Engine engine, int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(engine, quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(Engine engine, int quantity) {
        int batch = engine.getBatchSize();
        int batchCount = 0;
        double costPerBatch = engine.getBatchCost();


        while ( batch < quantity) {
            batch = batch + 8;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
