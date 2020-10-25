package net.java.backEnd.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import net.java.backEnd.order.Impl.OrderDAOImpl;
import net.java.backEnd.product.Impl.ProductDAOImpl;

public class OrderDAOImplTest {
    OrderDAOImpl orderDAO = new OrderDAOImpl();
    @Test public void testOrderCheck(){
        assertEquals("주문 상품 체크 오류", "주문하신 상품이 없습니다", orderDAO.orderCheck());
    }

    @Test public void testAddOrderItem(){
        OrderInfoVO orderInfo = orderDAO.getOrderInfo();
        int orderItemLen = orderInfo.getItems().size();

        OrderItemVO orderItem = new OrderItemVO(99999, "TEST 상품", 1);
        orderDAO.addOrderItem(orderItem);
        int afterOrderItemLen = orderInfo.getItems().size();

        assertTrue("주문에 상품 추가 오류", orderItemLen < afterOrderItemLen);
    }

    @Test public void testGetOrderItems(){
        assertNotNull("주문 아이템 NULL 오류", orderDAO.getOrderItems());
    }

    @Test public void testRenderOrderPrice(){
        ProductDAOImpl productDAO = new ProductDAOImpl();

        boolean res = (new BigDecimal(0).equals(orderDAO.renderOrderPrice(productDAO)) ? true: false);

        assertTrue("주문금액 계산 오류",  res);
    }

    @Test public void testGetOrderInfo(){
        assertNotNull("주문 정보 NULL 오류 ", orderDAO.getOrderInfo());
    }
}
