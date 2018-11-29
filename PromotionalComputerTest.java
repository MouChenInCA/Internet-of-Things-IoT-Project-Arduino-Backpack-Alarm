/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotionalComputer;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mou Chen
 */
public class PromotionalComputerTest {
    
    PromotionalComputer validPromotionalComputer;
            
    public PromotionalComputerTest() {
    }
            
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validPromotionalComputer = new PromotionalComputer(5, 233, 999, "Dell", LocalDate.of(2015,Month.MARCH,10));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdNumber method, of class PromotionalComputer.
     */
    @Test
    public void testGetIdNumber() {
        int expResult = 5;
        int result = validPromotionalComputer.getIdNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdNumber method, of class PromotionalComputer.
     */
    @Test
    public void testSetIdNumber() {
        validPromotionalComputer.setIdNumber(122);
        int result = validPromotionalComputer.getIdNumber();
        assertEquals(122,result);  
    }
    
    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetIdNumberInvalid()
    
    {
        try
        {
           validPromotionalComputer.setIdNumber(-5);
            fail("The setIdNumber method with an empty argument should have triggered an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Test of getStock method, of class PromotionalComputer.
     */
    @Test
    public void testGetStock() {
        int expResult = 233;
        int result = validPromotionalComputer.getStock();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStock method, of class PromotionalComputer.
     */
    @Test
    public void testSetStock() {
        validPromotionalComputer.setStock(122);
        int result = validPromotionalComputer.getStock();
        assertEquals(122,result);  
    }

    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetStockInvalid()
    {
        try
        {
           validPromotionalComputer.setStock(-2);
            fail("The setStock method with an empty argument should have triggered an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetStockInvalid2()
    {
        try
        {
           validPromotionalComputer.setStock(600);
            fail("The setStock method with an empty argument should have triggered an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of getPrice method, of class PromotionalComputer.
     */
    @Test
    public void testGetPrice() {
        int expResult = 999;
        int result = validPromotionalComputer.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class PromotionalComputer.
     */
    @Test
    public void testSetPrice() {
        validPromotionalComputer.setPrice(422);
        int result = validPromotionalComputer.getPrice();
        assertEquals(422,result); 
    }
    
    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetPriceInvalid()
    {
        try
        {
           validPromotionalComputer.setPrice(-500);
            fail("The setPrice method with an empty argument should have triggered an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getBrand method, of class PromotionalComputer.
     */
    @Test
    public void testGetBrand() {
        String expResult = "Dell";
        String result = validPromotionalComputer.getBrand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetBrand() {
        validPromotionalComputer.setBrand("Micro");
        String result = validPromotionalComputer.getBrand();
        assertEquals("Micro",result); 
    }
    
    /**
     * Test of setBrand method, of class PromotionalComputer.
     */
    @Test
    public void testSetBrandInvalid()
    {
        //String brand = "";
        try
        {
           validPromotionalComputer.setBrand("");
            fail("The setBrand method with an empty argument should have triggered an exception.");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test of getManufactureDate method, of class PromotionalComputer.
     */
    @Test
    public void testGetManufactureDate() {
        LocalDate expResult = LocalDate.of(2015, Month.MARCH, 10);
        LocalDate result = validPromotionalComputer.getManufactureDate();
        assertEquals(expResult, result);
    }
    


    /**
     * Test of getYear method, of class PromotionalComputer.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 3;
        int result = validPromotionalComputer.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setManufactureDate method, of class PromotionalComputer.
     */
    @Test
    public void testSetManufactureDate() {
        LocalDate manufactureDate = LocalDate.of(2016, Month.DECEMBER, 1);
        validPromotionalComputer.setManufactureDate(manufactureDate);
        assertEquals(manufactureDate, validPromotionalComputer.getManufactureDate());
    }
   
     /**
     * Test of SetManufactureDate method, of class PromotionalComputer.
     */
    @Test
    public void testSetManufactureDateInvalid()
    {
        LocalDate manufactureDate = LocalDate.of(1888, Month.DECEMBER, 1);
        try{
        validPromotionalComputer.setManufactureDate(manufactureDate);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of SetManufactureDate method, of class PromotionalComputer.
     */
    @Test
    public void testSetManufactureDateInvalid2()
    {
        LocalDate manufactureDate = LocalDate.of(2030, Month.DECEMBER, 1);
        try{
        validPromotionalComputer.setManufactureDate(manufactureDate);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Test of getDiscount method, of class PromotionalComputer.
     */
    @Test
    public void testGetDiscount() {
        System.out.println("getDiscount");
        int expResult = 323;
        int result = validPromotionalComputer.getDiscount();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPriceNow method, of class PromotionalComputer.
     */
    @Test
    public void testGetPriceNow() {
        System.out.println("getPriceNow");
        int expResult = 676;
        int result = validPromotionalComputer.getPriceNow();
        assertEquals(expResult, result);
        
    }
    
}
