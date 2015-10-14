package com.interview;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class InternalCombustionEngineTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();


    @Test
    public void construction() {

        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        assertThat(engine.isRunning(), is(false));
        assertThat(engine.getFuelLevel(), is(0));
        assertThat(engine.getFuelType(), is(FuelType.DIESEL));

    }

    @Test
    public void constructionWithWrongFuel() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type."));
        Engine engine = new InternalCombustionEngine(FuelType.WOOD);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(equalTo("Not a valid Fuel type."));
        engine = new InternalCombustionEngine(FuelType.COAL);

    }

    @Test
    public void startBad() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(equalTo("Not able to start engine."));
        engine.start();
    }

    @Test
    public void start() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
    }

    @Test
    public void stop() {
        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
        engine.stop();
        assertThat(engine.isRunning(), is(false));
    }

    @Test
    public void isRunning() {

        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        engine.start();
        assertThat(engine.isRunning(), is(true));
        engine.stop();
        assertThat(engine.isRunning(), is(false));
    }

    @Test
    public void fill() {

        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 50);
        assertThat(engine.getFuelType(), is(FuelType.DIESEL));
        assertThat(engine.getFuelLevel(), is(50));
    }

    @Test
    public void fillBoundries() {

        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        engine.fill(FuelType.DIESEL, 100);
        assertThat(engine.getFuelLevel(), is(100));
        engine.fill(FuelType.DIESEL, 0);
        assertThat(engine.getFuelLevel(), is(0));
        engine.fill(FuelType.DIESEL, 103);
        assertThat(engine.getFuelLevel(), is(100));
        engine.fill(FuelType.DIESEL, -3);
        assertThat(engine.getFuelLevel(), is(0));
    }

}
