/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotionalComputer;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Mou Chen 200385734
 */
public class PromotionalComputer {
   

    private int idNumber, stock, price;
    private String brand;
    private LocalDate manufactureDate;

    public PromotionalComputer(int idNumber, int stock, int price, String brand, LocalDate manufactureDate) {
        setIdNumber(idNumber);
        setStock(stock);
        setPrice(price);
        setBrand(brand);
        setManufactureDate(manufactureDate);
    }

    
    /**
     * 
     * @return the idNumber of book
     */
    public int getIdNumber() {
        return idNumber;
    }
    
    
    /**
     * set the idNumber number and validate it.
     * @param idNumber 
     */
    public void setIdNumber(int idNumber) {
        if (idNumber > 0)
            this.idNumber = idNumber;
        else
            throw new IllegalArgumentException("ID Number  must be greater than 0");
    }


    /**
     * 
     * @return the number of stock.
     */
    public int getStock() {
        return stock;
    }
    
    /**
     * validate the # of stock and it should be between 0-500.
     * @param stock 
     */
    public void setStock(int stock) {
        if ( stock >= 0 && stock<=500)
            this.stock = stock;
        else
            throw new IllegalArgumentException("stock  must be between 0-500");
    }

    
    /**
     * 
     * @return the price of computer.
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * validate the price of computer should > 0.
     * @param price 
     */
    public void setPrice(int price) {
        if (price > 0)
            this.price = price;  
        else
            throw new IllegalArgumentException("price must be greater than  0");
    }

    /**
     * 
     * @return brand name
     */
    public String getBrand() {
        return brand;
    }
    
    /**
     * The name of the brand should be words start with upper case letter.
     * @param brand 
     */
    public void setBrand(String brand) {       
        if (brand.matches("[A-Z][a-z]*"))
            this.brand = brand;
        else
            throw new IllegalArgumentException("Brand name must start with an upper case letter");
    }



    public LocalDate getManufactureDate() {
        return manufactureDate;
    }
    
    /**
     * This method returns the year of product based on the date of manufacture passed in as an argument
     * @param manufactureDate
     */
    private int getYear(LocalDate manufactureDate)
    {
        return Period.between(manufactureDate, LocalDate.now()).getYears();
    }
    
    public int getYear()
    {
        return getYear(manufactureDate); 
    }
    
    /**
     * This method validates that the computer is 0-6 years and sets the
     * manufactureDate instance variable
     * @param manufactureDate - a LocalDate object describing the date the computer was made
     */
    public void setManufactureDate(LocalDate manufactureDate) {
        int year = getYear(manufactureDate);
        if (year >= 0 && year <=6 )
            this.manufactureDate = manufactureDate;
        else throw new IllegalArgumentException("computer must be made in 6 years ");
    }
    
    
    /**
     * This method returns the discount based on the year after manufacture and stock .
     * @param stock
     * @param price
     * @return 
     */
    private int getDiscount(int stock ,int price)
    {
        int year = getYear(manufactureDate);
        int discount=(int) Math.ceil(price*(year*0.03+ stock*0.001));
        return discount;
    }

    public int getDiscount()
    {
        return getDiscount(stock , price); 
    }
    
        /**
     * This method returns the pprice now based on the discount.
     * @param birthday 
     */
    private int getPriceNow(int price,int stock)
    {
        
        int priceNow = price-getDiscount(stock,price);
        return priceNow;
    }
    
    public int getPriceNow()
    {
        return getPriceNow( price,stock); 
    }
    
    
}
    

