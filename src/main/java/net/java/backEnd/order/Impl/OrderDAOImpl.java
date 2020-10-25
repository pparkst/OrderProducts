package net.java.backEnd.order.Impl;

import java.math.BigDecimal;
import java.util.List;

import net.java.backEnd.order.OrderDAO;
import net.java.backEnd.order.OrderInfoVO;
import net.java.backEnd.order.OrderItemVO;
import net.java.backEnd.product.ProductVO;
import net.java.backEnd.product.Impl.ProductDAOImpl;
import net.java.backEnd.service.OrderService;

public class OrderDAOImpl implements OrderDAO {

    private OrderInfoVO orderInfo = new OrderInfoVO();
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private OrderService service;

    public OrderDAOImpl() {
        service = OrderService.getInstance();
    }

    /**
     * 주문 체크
     * @return String res
     */
    public String orderCheck() {
        String res = "";
        if (orderInfo.getItems().size() < 1) {
            res = "주문하신 상품이 없습니다";
        } else {
            res = "";
        }
        return res;
    }

    @Override
    public void addOrderItem(OrderItemVO item) {
        boolean already = false;
        for (OrderItemVO orderedItem : orderInfo.getItems()) {
            if (item.getProductNo() == orderedItem.getProductNo()) {
                orderedItem.setOrderStock(orderedItem.getOrderStock() + item.getOrderStock());
                already = true;
            }
        }

        if (!already) {
            orderInfo.addItems(item);
        }

    }

    @Override
    public boolean checkOut() {
        return service.orderComplete(orderInfo);
    }

    @Override
    public List<OrderItemVO> getOrderItems() {
        return orderInfo.getItems();
    }

    @Override
    public BigDecimal renderOrderPrice(ProductDAOImpl productDao) {
        BigDecimal totalPrice = new BigDecimal(0);
        BigDecimal kitPrice = new BigDecimal(0);

        for (OrderItemVO item : orderInfo.getItems()) {
            ProductVO prd = productDao.getProduct(item.getProductNo());
            BigDecimal price = prd.getPrice();

            price = price.multiply(new BigDecimal(item.getOrderStock()));

            if(prd.getType() == 1){
                kitPrice = kitPrice.add(price);
            }

            totalPrice = totalPrice.add(price);
        }

        if (orderInfo.getDeliveryPrice() > 0 && kitPrice.compareTo(new BigDecimal(50000)) >= 0){
            orderInfo.setDeliveryPrice(0);
        }

        return totalPrice;
    }

    @Override
    public OrderInfoVO getOrderInfo() {
        return orderInfo;
    }
    
}
