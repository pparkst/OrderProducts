package net.java.backEnd.thread;

import org.junit.Test;

import net.java.backEnd.exception.SoldOutException;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    @Test public void threadOrderTest(){
        boolean res = false;
        CountDownLatch cl = new CountDownLatch(32);
        ExecutorService executorService = null;
        try{
            ThreadA threadA = new ThreadA();
            ThreadA threadB = new ThreadA();
            threadA.setCountDownLatch(cl);
            threadB.setCountDownLatch(cl);

            executorService = Executors.newCachedThreadPool();
            Future<?> future = executorService.submit(threadA);
            future = executorService.submit(threadB);
            Object result = future.get();

            cl.await(20, TimeUnit.SECONDS);
        }catch(Exception e){
            if(e.getCause().toString().contains("SoldOutException")){
                res = true;
            }
        }finally{
            assertTrue("SoldOutException 발생 오류", res);
        }
        
    }
}
