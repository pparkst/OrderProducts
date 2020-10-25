package net.java.backEnd.service;

import org.junit.Test;

import net.java.backEnd.order.OrderInfoVO;
import net.java.backEnd.order.OrderItemVO;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService service = OrderService.getInstance();
    @Test public void testOrderComplete(){
        OrderInfoVO orderInfo = new OrderInfoVO();
        OrderItemVO orderItem = new OrderItemVO(99999, "TEST 상품", 1);
        orderInfo.addItems(orderItem);

        assertTrue("TEST 상품 구매 실패", service.orderComplete(orderInfo)); 
    }
}
