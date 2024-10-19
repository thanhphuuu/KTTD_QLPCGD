package TKB;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AddUserPage;

public class phancong {
    AddUserPage addUserPage;
    WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {
        phancong script = new phancong();
        script.run();
    }

    public void run() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-link"))).click();
        
        addUserPage = new AddUserPage(driver);
        addUserPage.cookies();
        
        // Chọn phần TKB
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/a")).click();
        // Chờ cho trang TKB được load hoàn toàn
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[4]/ul/li[2]/a"))).click();
        // Chọn môn học muốn phân công
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[9]/div[1]/button"))).click();
        // Chọn phân công
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/div/span/span[1]/span/span[1]"))).click();
        // Chọn xác nhận
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/button[1]"))).click();
        
        // Sau khi phân công, thêm các hành động tiếp theo tại đây (nếu có)
    }
}
