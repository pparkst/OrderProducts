package net.java.backEnd.context;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DbconnTest {
    dbconn conn = new dbconn();
    @Test public void testContext(){
        assertTrue("DB 연결 체크", conn.Context());
    }
    
}
