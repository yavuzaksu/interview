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
    }

    @Test
    public void stop() {

    }

    @Test
    public void isRunning() {
    }

    @Test
    public void fill() {
    }

}
