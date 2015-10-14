package com.interview;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WidgetMachineTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void produceWidgets() {

        WidgetMachine machine = new WidgetMachine();
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(equalTo("Not able to start engine."));
        int w = machine.produceWidgets(10);

    }

}
