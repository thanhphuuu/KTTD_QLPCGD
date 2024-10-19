package remuneration;

import org.testng.annotations.Test;

import page.AddUserPage;
import page.UpdatePricePage;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class delete_price {
	WebDriver driver;
    AddUserPage addUserPage;
    UpdatePricePage updatePricePage;
    List<WebElement> statisticElements; // Khai báo List<WebElement> ở cấp độ class

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        driver = new ChromeDriver();
        addUserPage = new AddUserPage(driver);
        updatePricePage = new UpdatePricePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        addUserPage.cookies();
    }
    
    @Test(priority = 0)
    public void DeletePrice() throws InterruptedException {
    	updatePricePage.selectPrice();
    	updatePricePage.deletebutton();
    	Thread.sleep(1000);
    	updatePricePage.okbutton();
    	Thread.sleep(1000);
    	addUserPage.notification_success();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
