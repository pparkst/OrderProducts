package net.java.backEnd.product.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.java.backEnd.product.ProductDAO;
import net.java.backEnd.product.ProductVO;
import net.java.backEnd.service.ProductService;

public class ProductDAOImpl implements ProductDAO {

    Map<String, ProductVO> prdMap;
    List<ProductVO> products;

    public ProductDAOImpl(){
        ProductService service = ProductService.getInstance();
        this.prdMap = service.getProducts();

        this.products = new ArrayList<ProductVO>();
    }

    @Override
    public boolean availableStock(int productNo, int stock) {
        return this.getProduct(productNo).getStockCnt() >= stock;
    }

    @Override
    public ProductVO getProduct(int productNo) {
        return this.prdMap.get(Integer.toString(productNo));
    }

    @Override
    public List<ProductVO> getProductList() {
        Set<Map.Entry<String, ProductVO>> productEntries = this.prdMap.entrySet();

        for(Map.Entry<String, ProductVO> prdEntry : productEntries){
            this.products.add(prdEntry.getValue());
        }

        return this.products;
    }
    
}
