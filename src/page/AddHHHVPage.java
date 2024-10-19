package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddHHHVPage {
    private WebDriver driver;

    public AddHHHVPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectHHHV() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/a")).click();
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[6]/ul/li[1]/a")).click();
    }
    
    public void clickAddHHHVButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
    }
    
    public void clickUpdateHHHVButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]/a[1]")).click();
    }
    
    public void clickdeleteHHHV() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[5]/a[2]")).click();
    }
    
    public void clickokdeleteHHHV() {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }

    public void enterMa(String ma) {
        driver.findElement(By.id("id")).clear();
        driver.findElement(By.id("id")).sendKeys(ma);
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterSTT(String STT) {
        driver.findElement(By.id("level")).clear();
        driver.findElement(By.id("level")).sendKeys(STT);
    }

    public void clickSaveButton() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/button[2]")).click();
    }

    public void search(String keyword) {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input")).sendKeys(keyword);
    }
    
    public void clearName() {
        driver.findElement(By.id("name")).clear();
    }
    
    public void clearSTT() {
        driver.findElement(By.id("level")).clear();
    }
    
  //tìm kiếm
    public void searchHHHV(String ma) {
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        searchField.clear();
        searchField.sendKeys(ma);
    }
    
 // thống báo mã
    public void notification_ma() {
    	WebElement messageElement = driver.findElement(By.id("id-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    
 // thống báo tên
    public void notification_name() {
    	WebElement messageElement = driver.findElement(By.id("name-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
 // thống báo level
    public void notification_level() {
    	WebElement messageElement = driver.findElement(By.id("level-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    public void verifyHHHVDetails(String ma, String name, String STT) {
        // Lấy thông tin từ bảng sau khi tìm kiếm
        String actualMa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[2]")).getText();
        String actualName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[3]")).getText();
        String actualEmail = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[4]")).getText();
        // So sánh thông tin với dữ liệu nhập vào
        if (!actualMa.equals(ma) || !actualName.equals(name) || !actualEmail.equals(STT)) {
            System.out.println("Thông tin người dùng không chính xác!");
        } else {
            System.out.println("Thông tin người dùng chính xác.");
        }
    }
}

