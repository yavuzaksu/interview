package com.interview;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InternalCombustionEngineTest {

    @Test
    public void construction() {

        InternalCombustionEngine engine = new InternalCombustionEngine(FuelType.DIESEL);
        assertThat(engine.isRunning(), is(false));
        assertThat(engine.getFuelLevel(), is(0));
        assertThat(engine.getFuelType(), is(FuelType.DIESEL));

    }

    @Test
    public void start() {
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
