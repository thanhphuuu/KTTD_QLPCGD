package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdatePricePage {
	private WebDriver driver;

    public UpdatePricePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void selectPrice() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[2]/a")).click();
    }
    
    public void selectHS() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/ul/li[2]/a")).click();
    }
    
    public void selectUpdateHS() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div/table/tbody/tr/td[5]/a")).click();
    }
    
    public void selectUpdatePrice() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[3]/a")).click();
    }
    
    public void enterprice(String pr) {
    	driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys(pr);
    }
    
    public void enterhsta(String HSTA) {
    	driver.findElement(By.id("foreign_coefficient")).clear();
        driver.findElement(By.id("foreign_coefficient")).sendKeys(HSTA);
    }
    public void enterhstv(String HSTV) {
    	driver.findElement(By.id("vietnamese_coefficient")).clear();
        driver.findElement(By.id("vietnamese_coefficient")).sendKeys(HSTV);
    }
    public void enterhslt(String HSLT) {
    	driver.findElement(By.id("theoretical_coefficient")).clear();
        driver.findElement(By.id("theoretical_coefficient")).sendKeys(HSLT);
    }
    public void enterhsth(String HSTH) {
    	driver.findElement(By.id("practice_coefficient")).clear();
        driver.findElement(By.id("practice_coefficient")).sendKeys(HSTH);
    }
    
    public void savebuttonhs() {
    	driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[3]/button[2]")).click();
    }
    
    public void clearprice() {
    	driver.findElement(By.id("price")).clear();
    }
    
    public void savebutton() {
    	driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[3]/button[2]")).click();
    }
    public void deletebutton() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/table/tbody/tr[1]/td[3]/a[2]")).click();
    }
    public void okbutton() {
    	driver.findElement(By.xpath("/html/body/div[4]/div/div[6]/button[1]")).click();
    }
    
    // thống báo mã
    public void notification_price() {
    	WebElement messageElement = driver.findElement(By.id("price-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    
}