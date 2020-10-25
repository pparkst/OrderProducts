package net.java.backEnd.product;

import org.junit.Test;

import net.java.backEnd.product.Impl.ProductDAOImpl;

import static org.junit.Assert.*;

import java.util.List;

public class ProductDAOImplTest {
    ProductDAOImpl productDAO = new ProductDAOImpl();
    @Test public void testAvailableStock(){
        assertFalse("상품 주문 가능 재고조회 오류", productDAO.availableStock(99999, 9999999)); 
    }

    @Test public void testGetProduct(){
        ProductVO prd = productDAO.getProduct(99999);
        assertNotNull("상품 조회 오류", prd);
    }

    @Test public void testGetProductList(){
        List<ProductVO> prdList = productDAO.getProductList();

        assertTrue("상품 리스트 불러오기 오류", prdList.size() > 0);
    }
}
