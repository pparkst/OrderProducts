package net.java.backEnd.order;

import java.math.BigDecimal;
import java.util.List;

import net.java.backEnd.product.Impl.ProductDAOImpl;

public interface OrderDAO {
    /**
     * 주문완료 시 주문상품 재고 조회
     * @param List<OrderItemDTO> items 주문 상품
     * @return boolean 요청 수량 주문 가능 여부
     */
    //public boolean orderAvailableStock(List<OrderItemVO> items);
    
    /**
     * 주문금액 도출
     * @param orderInfo
     * @return BigDecimal 총 주문금액
     */
    public BigDecimal renderOrderPrice(ProductDAOImpl productDao);
    /**
     * 주문데이터에 상품추가
     * @param OrderItemVO item 주문 상품
     */
    public void addOrderItem(OrderItemVO item);
    /**
     * 최종 주문하기
     * @return boolean 주문 결과
     */
    public boolean checkOut();
    /**
     * 주문 상품들 가져오기
     * @return List<OrderItemVO> 주문 상품리스트
     */
    public List<OrderItemVO> getOrderItems();
    /**
     * 주문 정보 가져오기
     * @return OrderInfoVO
     */
    public OrderInfoVO getOrderInfo();
}
