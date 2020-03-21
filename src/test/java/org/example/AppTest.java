package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.example.App;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Input: number of input 3
     * 10 x 200g
     * 3 x 400g
     * 100 x 1000g
     * Output: number of box 2
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int[] orders = new int[3];
        orders[0] = 10 * App.volumeOf200g;
        orders[1] = 3 * App.volumeOf400g;
        orders[2] = 100 * App.volumeOf1000g;
        assertEquals(2, App.calculateBox(orders, orders.length, App.volumeOfBox));
    }
}
