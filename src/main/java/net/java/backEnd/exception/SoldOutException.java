package net.java.backEnd.exception;

/**
 * 재고부족 시 발생 Exception
 */
public class SoldOutException extends RuntimeException{
    public SoldOutException(String productName){
        super(String.format("\n주문하신 %s 상품의 재고가 부족합니다. \n다시 주문해주세요.", productName));
    }
}
