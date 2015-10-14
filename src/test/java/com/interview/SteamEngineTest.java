package com.interview;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SteamEngineTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();


    @Test
    public void construction() {

        Engine engine = new SteamEngine(FuelType.WOOD);
        assertThat(engine.isRunning(), is(false));
        assertThat(engine.getFuelLevel(), is(0));
        assertThat(engine.getRequiredFuelType(), is(FuelType.WOOD));

    }

    @Test
    public void constructionWithWrongFuel() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type to initialise the engine."));
        Engine engine = new SteamEngine(FuelType.DIESEL);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type to initialise the engine."));
        engine = new SteamEngine(FuelType.PETROL);

    }

    @Test
    public void calculateCostPerBatch(){
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 0);
        assertThat(engine.getBatchCost(), is(4.35));


        engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 0);
        assertThat(engine.getBatchCost(), is(5.65));

    }

    @Test
    public void startBad() {
        Engine engine = new SteamEngine(FuelType.WOOD);
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(equalTo("Not able to start engine."));
        engine.start();
    }

    @Test
    public void start() {
        Engine engine = new SteamEngine(FuelType.COAL);
        engine.fill(FuelType.COAL, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
    }

    @Test
    public void stop() {
        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
        engine.stop();
        assertThat(engine.isRunning(), is(false));
    }

    @Test
    public void isRunning() {

        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
        engine.stop();
        assertThat(engine.isRunning(), is(false));
    }

    @Test
    public void fillWithWrongFuel() {

        Engine engine = new SteamEngine(FuelType.WOOD);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type to fill the engine."));
        engine.fill(FuelType.DIESEL, 50);

        engine = new SteamEngine(FuelType.COAL);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type to fill the engine."));
        engine.fill(FuelType.PETROL, 50);


    }

    @Test
    public void fillBoundries() {

        Engine engine = new SteamEngine(FuelType.WOOD);
        engine.fill(FuelType.WOOD, 100);
        assertThat(engine.getFuelLevel(), is(100));
        engine.fill(FuelType.WOOD, 0);
        assertThat(engine.getFuelLevel(), is(0));
        engine.fill(FuelType.WOOD, 103);
        assertThat(engine.getFuelLevel(), is(100));
        engine.fill(FuelType.WOOD, -3);
        assertThat(engine.getFuelLevel(), is(0));
    }

}
