package net.java.backEnd.service;

// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import net.java.backEnd.context.dbconn;
import net.java.backEnd.product.ProductVO;

public class ProductService {
    private Map<String, ProductVO> products;

    private static ProductService instance = new ProductService();

    public static ProductService getInstance(){
        return instance;
    }

    /**
     * 상품 DATA 불러오기
     */
    //#region
    // private ProductService(){
    //     this.products = new HashMap<String, ProductVO>();

    //     BufferedReader buffReader = null;
    //     try{
    //         buffReader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "\\data\\tbl_products.csv"));

    //         String line = "";
    //         int row = 0;
            
    //         while((line = buffReader.readLine()) != null){
    //             if(row > 0){
    //                 String[] checkStr = line.split("");
    //                 int cnt = 0;
    //                 for(String str : checkStr){
    //                     if(str.equals(",")){
    //                         cnt+=1;
    //                     }
    //                 }

    //                 String[] rowData = line.replaceAll("\"", "").split(",");
    //                 int no;
    //                 String type;
    //                 String name;
    //                 long price;
    //                 int stockCnt;

    //                 int idx = 0;

    //                 no = Integer.parseInt(rowData[0].trim());
    //                 type = rowData[1].trim();
                    
    //                 String tempName = "";
    //                 for(int i = 2; i < 2 + (cnt - 3); ++i){
    //                     tempName += rowData[i] + ",";
    //                     idx = i;
    //                 }

    //                 name = tempName.substring(1, tempName.length()-1);
    //                 price = Long.parseLong(rowData[idx+1].trim());
    //                 stockCnt = Integer.parseInt(rowData[idx+2].trim());
                    
    //                 ProductVO product = new ProductVO(no, type, name, price, stockCnt);                  
    //                 this.addProduct(product);
    //             }

    //             row +=1; 
    //         }
    //     }catch(FileNotFoundException e){
    //         e.printStackTrace();
    //     }catch(IOException e){
    //         e.printStackTrace();
    //     }finally{
    //         try{
    //             if(buffReader != null){
    //                 buffReader.close();
    //             }
    //         }catch(IOException e){
    //             e.printStackTrace();
    //         }
    //     }
    // }
    //#endregion

    /**
     * 상품 DATA 불러오기
     */
    private ProductService(){
        this.products = new HashMap<String, ProductVO>();

        dbconn con = new dbconn();
        String connectionUrl = con.PRODUCT_RDS_URL;

        try (Connection context = DriverManager.getConnection(connectionUrl); Statement stmt = context.createStatement();) {
            String SQL = "SELECT * FROM tbl_Products (NOLOCK)";
            ResultSet rs = stmt.executeQuery(SQL);
            
            while (rs.next()) {
                int no = rs.getInt("no");
                String type = rs.getString("type");
                String name = rs.getString("name");
                BigDecimal price = new BigDecimal(rs.getString("price"));
                int stock = rs.getInt("stockCnt");

                ProductVO product = new ProductVO(no, type, name, price, stock);
                
                addProduct(product);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Map에 상품 add 
     * @param ProductVO product 상품 Entity
     */
    private void addProduct(ProductVO product){
        this.products.put(Integer.toString(product.getNo()), product);
    }

    /**
     * 상품 리스트 Map Return
     */
    public Map<String, ProductVO> getProducts(){
        return this.products;
    }
    
}
