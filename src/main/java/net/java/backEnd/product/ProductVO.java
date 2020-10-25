package net.java.backEnd.product;

import java.math.BigDecimal;

public class ProductVO {
    public int no; //상품번호
    public int type; //종류 (0 : 이벤트, 1 : 상품)
    public String name; //상품명
    public BigDecimal price; //판매가
    public int stockCnt; //재고 수량

    public ProductVO(int no, String type, String name, BigDecimal price, int stockCnt) {
        this.no = no;
        this.type = (type.equals("EVENT") ? prdType.EVENT.getType() : prdType.PRODUCT.getType());
        this.name = name;
        this.price = price;
        this.stockCnt = stockCnt;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockCnt() {
        return stockCnt;
    }

    public void setStockCnt(int stockCnt) {
        this.stockCnt = stockCnt;
    }

}

enum prdType {
    EVENT(0),
    PRODUCT(1);

    private final int type;

    prdType(int type) {
        this.type = type;
    }

    public int getType() { return type; }
}