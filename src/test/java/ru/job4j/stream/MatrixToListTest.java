package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void convertMatrixToList() {
        Integer[][] existArray = new Integer[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> expectArray = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        MatrixToList obj = new MatrixToList();
        assertThat(expectArray, is(obj.convert(existArray)));
    }
}