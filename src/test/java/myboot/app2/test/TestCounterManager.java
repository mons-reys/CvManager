package myboot.app2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import myboot.app2.model.Counter;
import myboot.app2.services.BadCounter;
import myboot.app2.services.CounterManager;

@SpringBootTest
public class TestCounterManager {

    @Autowired
    public CounterManager cm;

    @Test
    public void testCounterManager() {
        cm.createCounter("C1", 10);
        Counter c = cm.getCounter("C1");
        assertEquals(Integer.valueOf(10), c.getValue());
    }
    
   /* @Test
   public void testDoubleSave() {
    	Counter c1 = new Counter("C2", 30);
    	Counter c2 = new Counter("C2", 20);
        cm.doubleSave(c1, c2);
        Counter c3 = cm.getCounter("C2");
        assertEquals(Integer.valueOf(20), c3.getValue());
    }*/
    
    /*@Test
    public void testCreateValidCounter() throws BadCounter {
         cm.createValidCounter("C5", -30);
         Counter c5 = cm.getCounter("C5");
         assertEquals(Integer.valueOf(-30), c5.getValue());
     }*/
    
    /*@Test
    public void testCreateValidCounter2() throws BadCounter {
         cm.createCounter2("C5", -20);;
         Counter c5 = cm.getCounter("C5");
         assertEquals(Integer.valueOf(-20), c5.getValue());
     }*/
    /*@Test
    public void testCreateValidCounter2() throws BadCounter {
        cm.removeAndCreateCounter("C5", -20);
        Counter c5 = cm.getCounter("C5");
         assertEquals(Integer.valueOf(-20), c5.getValue());
     }
    
    
    @Test
    public void testGetValidCounter() {
         Counter c5 = cm.getCounter("C5");
         assertEquals(Integer.valueOf(-30), c5.getValue());
     }
    
    @Test
    public void getCounterValue() {
         Integer c5 = cm.getCounterValue("C1");
         assertEquals(Integer.valueOf(10), c5);
     }*/
    
    @Test
    public void getCounterValue2() {
         Integer value = cm.getCounterValue2("C1");
         assertEquals(Integer.valueOf(10), value);
     }
}