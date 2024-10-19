package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTermPage {
    private WebDriver driver;

    // Constructor
    public AddTermPage(WebDriver driver) {
        this.driver = driver;
    }

    // Phương thức chọn Học kỳ và Ngành
    public void selectTerm() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(2000);
    }

    // Phương thức chọn thêm Học kỳ
    public void clickAddTermButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);
    }
    
    // Phương thức chọn update Học kỳ
    public void clickUpdateTermButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr[1]/td[9]/a[1]")).click();
        Thread.sleep(2000);
    }

    // Phương thức nhập Mã số
    public void enterCode(String HK) {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input")).sendKeys(HK);
    }    
    // Phương thức chọn năm bắt đầu
    public void selectstartyear() {
        driver.findElement(By.id("select2-start_year-container")).click();
        driver.findElement(By.id("select2-start_year-result-ay3l-2026")).click();

    }

    // Phương thức nhập Tuần bắt đầu
    public void enterStartWeek(String TBD) {
        driver.findElement(By.id("start_week")).clear();
        driver.findElement(By.id("start_week")).sendKeys(TBD);
    }

    // Phương thức chọn ngày bắt đầu
    public void selectStartDate() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/input[2]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[19]")).click();
    }

    // Phương thức nhập Tiết tối đa
    public void enterMaxLesson(String TTD) {
        driver.findElement(By.id("max_lesson")).clear();
        driver.findElement(By.id("max_lesson")).sendKeys(TTD);
    }

    // Phương thức nhập Lớp tối đa
    public void enterMaxClass(String LTD) {
        driver.findElement(By.id("max_class")).clear();
        driver.findElement(By.id("max_class")).sendKeys(LTD);
    }

    // Phương thức lưu
    public void clickSaveButton() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
        Thread.sleep(2000);
    }

    // Phương thức nhấn OK
    public void clickOkButton() {
        driver.findElement(By.xpath("//button[@class='swal2-confirm btn btn-primary']")).click();
    }
    
    // Phương thức tìm kiếm học kỳ
    public void searchTerm(String HK) {
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        searchField.clear();
        searchField.sendKeys(HK);
    }
    // thống báo ID 
    public void notification_ID() {
    	WebElement messageElement = driver.findElement(By.id("id-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    } 
    // thống báo ID 
    public void notification_date() {
    	WebElement messageElement = driver.findElement(By.id("start_date-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    // thống báo năm kết thúc
    public void notification_endyear() {
    	WebElement messageElement = driver.findElement(By.id("end_year-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    // thống báo tuần bắt đầu
    public void notification_startweek() {
    	WebElement messageElement = driver.findElement(By.id("start_week-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    // thống báo tiết tối đa
    public void notification_lesson() {
    	WebElement messageElement = driver.findElement(By.id("max_lesson-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    // thống báo tiết tối đa
    public void notification_class() {
    	WebElement messageElement = driver.findElement(By.id("max_class-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    
    public void verifyTermDetails(String HK) {
        // Lấy thông tin từ bảng sau khi tìm kiếm
        String actualMa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div/div/table/tbody/tr/td[1]")).getText();
        // So sánh thông tin với dữ liệu nhập vào
        if (!actualMa.equals(HK)) {
            System.out.println("Thông tin người dùng không chính xác!");
        } else {
            System.out.println("Thông tin người dùng chính xác.");
        }
    }
    
}
