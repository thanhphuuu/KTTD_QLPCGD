package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMajorPage {
    private WebDriver driver;

    // Constructor
    public AddMajorPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //Chọn ngành
    public void selectmajor() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/ul/li[2]/a")).click();
    }
    
    //update ngành
    public void selectupdatemajor() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[1]")).click();
    }
    
    //Cthêm ngành
    public void selectaddmajor() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
    }
    
    // Method to enter major ID
    public void enterMajorID(String ma) {
        WebElement majorIDField = driver.findElement(By.id("id"));
        majorIDField.clear();
        majorIDField.sendKeys(ma);
    }
    //Clear name
    public void clearName() {
    	driver.findElement(By.id("name")).clear();
    }

    // Method to enter major name
    public void enterMajorName(String name) {
        WebElement majorNameField = driver.findElement(By.id("name"));
        majorNameField.clear();
        majorNameField.sendKeys(name);
    }

    // Method to enter major abbreviation
    public void enterMajorAbbreviation(String TVT) {
        WebElement majorAbbreviationField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input"));
        majorAbbreviationField.clear();
        majorAbbreviationField.sendKeys(TVT);
    }
    
    //Clear name
    public void clearTVT() {
    	driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input")).clear();
    }

    // Method to select program type
    public void selectProgramType() {
        driver.findElement(By.id("select2-program_type-container")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[1]")).click();
    }

    // Method to click on save button
    public void clickSaveButton() {
    	driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[5]/button[2]")).click();

    }
    
    public void clickdeletemajor() {
    	driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[6]/a[2]")).click();
    }
    
    public void clickokdeletemajor() {
    	driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }
    //tìm kiếm
    public void searchTerm(String ma) {
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        searchField.clear();
        searchField.sendKeys(ma);
    }
    // thống báo ID 
    public void notification_ID() {
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
    // thống báo tên vt
    public void notification_shortname() {
    	WebElement messageElement = driver.findElement(By.id("abbreviation-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    // thống báo ct
    public void notification_program() {
    	WebElement messageElement = driver.findElement(By.id("program_type-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    
    public void verifyMajorDetails(String ma, String name, String TVT) {
        // Lấy thông tin từ bảng sau khi tìm kiếm
        String actualMa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[2]")).getText();
        String actualName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[3]")).getText();
        String actualEmail = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[4]")).getText();
        // So sánh thông tin với dữ liệu nhập vào
        if (!actualMa.equals(ma) || !actualName.equals(name) || !actualEmail.equals(TVT)) {
            System.out.println("Thông tin người dùng không chính xác!");
        } else {
            System.out.println("Thông tin người dùng chính xác.");
        }
    }
}

