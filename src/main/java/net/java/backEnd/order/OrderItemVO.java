package net.java.backEnd.order;

public class OrderItemVO {
    private int productNo; //주문 상품번호
    private String productName; //주문 상품명
    private int orderStock; //주문 수량

    public OrderItemVO(int productNo, String productName, int orderStock) {
        this.productNo = productNo;
        this.productName = productName;
        this.orderStock = orderStock;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderStock() {
        return orderStock;
    }

    public void setOrderStock(int orderStock) {
        this.orderStock = orderStock;
    }
    
}
