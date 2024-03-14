// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.Calendar;
import java.util.InputMismatchException;

public class Product {
    private String productName;
    private Calendar saleDate;
    private double price;

    public Product(String sName, java.util.Calendar sDate, double price) {
        productName = sName;
        saleDate = sDate;
        this.price = price;

    }

    public String getProductName() {
        return productName;
    }

    public void setProjectName(String projectName) {
        this.productName = projectName;
    }

    public Calendar getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Calendar saleDate) {
        this.saleDate = saleDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            if (price >= 0)
                this.price = price;
            else throw new IllegalArgumentException("Price must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        int day = getSaleDate().get(Calendar.DAY_OF_MONTH);
        int month = getSaleDate().get(Calendar.MONTH) + 1;
        int year = getSaleDate().get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "Product [" + "productName=" + this.getProductName() + ", transactionDate=" + formattedDate + ", price=" + this.getPrice() + "]";
    }
}
