package net.java.backEnd.service;

import org.junit.Test;
import static org.junit.Assert.*;
import net.java.backEnd.product.ProductVO;

import java.util.Map;

public class ProductServiceTest {
    ProductService service = ProductService.getInstance();
    @Test public void testGetProductToRDS() {
        Map<String,ProductVO> productList = service.getProducts();
        assertTrue("상품리스트가 존재하지않음", productList.size() > 0);
    }
}
