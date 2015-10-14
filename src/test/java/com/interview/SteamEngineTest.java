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
        assertThat(engine.getFuelType(), is(FuelType.WOOD));

    }

    @Test
    public void constructionWithWrongFuel() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type."));
        Engine engine = new SteamEngine(FuelType.DIESEL);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type."));
        engine = new SteamEngine(FuelType.PETROL);

    }

    @Test
    public void calculateCostPerBatch(){
        Engine engine = new SteamEngine(FuelType.WOOD);
        assertThat(engine.getBatchCost(), is(4.35));
        engine = new SteamEngine(FuelType.COAL);
        assertThat(engine.getBatchCost(), is(5.65));

    }

    @Test
    public void startBad() {
        fail();
    }

    @Test
    public void start() {
        fail();
    }

    @Test
    public void stop() {
        fail();
    }

    @Test
    public void isRunning() {

        fail();
    }

    @Test
    public void fill() {

        fail();
    }

    @Test
    public void fillBoundries() {

        fail();
    }

}
