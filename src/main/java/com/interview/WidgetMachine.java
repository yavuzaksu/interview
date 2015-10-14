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
        int batch = 0;
        int batchCount = 0;
        double costPerBatch = engine.getBatchCost();


        while ( batch < quantity) {
            batch = batch + engine.getBatchSize();
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
