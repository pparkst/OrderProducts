package net.java.backEnd.thread;

import java.util.concurrent.CountDownLatch;

import net.java.backEnd.exception.SoldOutException;
import net.java.backEnd.order.OrderItemVO;
import net.java.backEnd.order.Impl.OrderDAOImpl;
import net.java.backEnd.service.OrderService;

public class ThreadA extends Thread{
    OrderService service = OrderService.getInstance();
    CountDownLatch cl;

    public void run() throws SoldOutException{

        for(int i = 0; i < 16; i++){
            OrderDAOImpl orderDAO = new OrderDAOImpl();
            OrderItemVO orderItem = new OrderItemVO(99998, "Thread TEST 상품", 1);
            orderDAO.addOrderItem(orderItem);
            boolean res = service.orderComplete(orderDAO.getOrderInfo());
            if(!res){
                throw new SoldOutException("Thread TEST 상품_1_1");
            }
            cl.countDown();
        }
        
    }

    public void setCountDownLatch(CountDownLatch cl){
        this.cl = cl;
    }
}
