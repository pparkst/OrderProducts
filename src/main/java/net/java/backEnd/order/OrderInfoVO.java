package net.java.backEnd.order;

import java.util.*;

public class OrderInfoVO {
    private int no; //주문번호
    private List<OrderItemVO> items; //주문 상품리스트
    private int deliveryPrice; //배송비

    public OrderInfoVO(){
        this.deliveryPrice = 5000;
        this.items = new ArrayList<OrderItemVO>();
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<OrderItemVO> getItems() {
        return items;
    }

    public void addItems(OrderItemVO item) {
        this.items.add(item);
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    
}
