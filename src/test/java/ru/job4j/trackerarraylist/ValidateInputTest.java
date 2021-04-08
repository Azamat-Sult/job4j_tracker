package ru.job4j.trackerarraylist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> inputs = new ArrayList<>();
        inputs.add("one");
        inputs.add("1");
        Input in = new StubInput(inputs);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        List<String> inputs = new ArrayList<>();
        inputs.add("1");
        Input in = new StubInput(inputs);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputManyTimes() {
        Output out = new StubOutput();
        List<String> inputs = new ArrayList<>();
        inputs.add("1");
        inputs.add("1");
        inputs.add("1");
        Input in = new StubInput(inputs);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputNegativeNum() {
        Output out = new StubOutput();
        List<String> inputs = new ArrayList<>();
        inputs.add("-10");
        Input in = new StubInput(inputs);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-10));
    }
}