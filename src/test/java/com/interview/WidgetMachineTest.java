package com.interview;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WidgetMachineTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void produceWidgetsSteamWood() {

        WidgetMachine machine = new WidgetMachine();
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);
        double cost = machine.produceWidgets(engine, 100);
        assertThat(cost,  is(56.55));
        assertThat(engine.isRunning(),  is(false));

        engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 5);
        cost = machine.produceWidgets(engine, 34);
        assertThat(cost,  is(17.4));
        assertThat(engine.isRunning(),  is(false));

    }

    @Test
    public void produceWidgetsSteamCoal() {

        WidgetMachine machine = new WidgetMachine();
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 80);
        double cost = machine.produceWidgets(engine, 10);
        assertThat(cost,  is(5.65));
        assertThat(engine.isRunning(),  is(false));

        engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 100);
        cost = machine.produceWidgets(engine, 100);
        assertThat(cost,  is(73.45));
        assertThat(engine.isRunning(),  is(false));


    }

    @Test
    public void produceWidgetCombustionPetrol() {

        WidgetMachine machine = new WidgetMachine();
        Engine engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 67);
        double cost = machine.produceWidgets(engine, 101);
        assertThat(cost,  is(117.0));
        assertThat(engine.isRunning(),  is(false));

        engine = new InternalCombustionEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 1);
        cost = machine.produceWidgets(engine, 0);
        assertThat(cost,  is(0.0));
        assertThat(engine.isRunning(),  is(false));

    }

    @Test
    public void produceWidgetCombustionDiesel() {

        WidgetMachine machine = new WidgetMachine();
        Engine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 80);
        double cost = machine.produceWidgets(engine, 10);
        assertThat(cost,  is(24.0));
        assertThat(engine.isRunning(),  is(false));


    }



}
