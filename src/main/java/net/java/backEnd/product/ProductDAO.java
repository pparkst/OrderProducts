package net.java.backEnd.product;

import java.util.List;

public interface ProductDAO {
    /**
     * 상품번호로 상품리스트에서 상품 조회
     * @param int no 상품번호
     * @return ProductDTO 상품
     */
    abstract public ProductVO getProduct(int productNo);
    /**
     * 전체 상품리스트 조회
     * @return List<ProductDTO> 상품 리스트
     */
    abstract public List<ProductVO> getProductList();
    /**
     * 상품의 재고 수량 체크
     * @param int productNo 상품번호
     * @param int stock 주문수량
     * @return
     */
    abstract public boolean availableStock(int productNo, int stock);
}
 