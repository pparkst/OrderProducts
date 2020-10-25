package net.java.backEnd.service;

// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.OutputStreamWriter;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.sql.SQLException;

import net.java.backEnd.context.dbconn;
import net.java.backEnd.exception.SoldOutException;
import net.java.backEnd.order.OrderInfoVO;
import net.java.backEnd.order.OrderItemVO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class OrderService {
    public OrderInfoVO orderInfo;
    private static OrderService instance = new OrderService();

    public static OrderService getInstance(){
        return instance;
    }

    private OrderService(){
        this.orderInfo = new OrderInfoVO();
    }

    //#region
    // public boolean orderComplete(OrderInfoVO orderInfo){
    //     this.orderInfo = orderInfo;

    //     BufferedWriter buffWriter = null;

    //     try{
    //         FileOutputStream fos = new FileOutputStream(new File((System.getProperty("user.dir") + "\\data\\tbl_productsTemp.csv")));
    //         buffWriter = new BufferedWriter(new OutputStreamWriter(fos));

    //         String temp = "\"상품번호\", \"종류\", \"상품명\", \"판매가격 (원)\", \"재고수\"";
    //         buffWriter.write(temp, 0, temp.length());

    //         ProductDAOImpl productDAO = new ProductDAOImpl();

    //         for(ProductVO prd : productDAO.getProductList()){
    //             int stock = prd.stockCnt;
    //             for(OrderItemVO orderItem : orderInfo.getItems()){
    //                 if(prd.getNo() == orderItem.getProductNo()){
    //                     stock -= orderItem.getOrderStock();
    //                 }
    //             }
    //             buffWriter.newLine();
    //             String row = "\"" + prd.getNo() + "\",\""+ (prd.getType() == 0 ? "EVENT\",\"" : "PRODUCT\",\"") + prd.getName() + "\",\"" + prd.price + "\",\"" + stock + "\"";
    //             buffWriter.write(row, 0, row.length());
    //         }            
    //         buffWriter.close();
    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }

    //     //데이터 재고 차감
    //     //주문 완료 시 주문정보 리턴
    //     //재고 부족시 SoldOut Exception
       
    //     return true;

    // }
    //#endregion
    
    /**
     * 최종 주문처리
     * @param OrderInfoVO orderInfo 주문정보
     * @return boolean 주문결과
     */
    public boolean orderComplete(OrderInfoVO orderInfo){
        this.orderInfo = orderInfo;
        boolean res = false;

        dbconn con = new dbconn();
        String connectionUrl = con.PRODUCT_RDS_URL;
        ResultSet rs = null;
        int resCode = -1;
        String tempName = "";

        try (Connection context = DriverManager.getConnection(connectionUrl); 
            CallableStatement stmt = (CallableStatement)context.prepareCall("{call PROC_SP_PRODUCT_ISSUE(?,?) }");) {
                context.setAutoCommit(false);

                for(OrderItemVO item : orderInfo.getItems()){
                    stmt.setInt(1, item.getProductNo());
                    stmt.setInt(2, item.getOrderStock());
                    rs = stmt.executeQuery();
                    
                    rs.next();

                    resCode = rs.getInt("Res");
                    
                    //System.out.println(rs.getInt("Res") > 0 ? "success" : "Fail");

                    if(resCode > 0){
                        res = true;
                    }else if(resCode == -1){
                        res = false;
                        throw new SQLException();
                    }else{
                        res = false;
                        tempName = item.getProductName();
                        throw new SoldOutException(item.getProductName());
                    }
                }

                if(res){
                    context.commit();
                }

                    stmt.close();
                    context.close();

            }catch(SoldOutException e){
                e.printStackTrace();
                //throw e;
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }

        return res;
    }

}
