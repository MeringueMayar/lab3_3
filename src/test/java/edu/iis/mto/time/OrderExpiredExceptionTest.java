/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.time;

import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author karko
 */
public class OrderExpiredExceptionTest {

    private OrderItem orderItem = new OrderItem();

    @Test(expected = OrderExpiredException.class)
    public void testConfirmMethodAfter24HoursTriggersOrderExpiredException() {
        Order spiedOrder = Mockito.spy(new Order());
        Mockito.doReturn(25).when(
                spiedOrder).getHoursBetweenSubmitionDateAndConfirmationDate();

        spiedOrder.addItem(orderItem);
        spiedOrder.submit();
        spiedOrder.confirm();
    }
}
