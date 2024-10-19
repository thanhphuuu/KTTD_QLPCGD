package remuneration;

import org.testng.annotations.Test;

import page.AddUserPage;
import page.UpdatePricePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Update_price {
    WebDriver driver;
    AddUserPage addUserPage;
    UpdatePricePage updatePricePage;
    List<WebElement> statisticElements; 

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

    @Test(dataProvider = "dp", priority = 0)
    public void updateprice_success(String pr) throws InterruptedException {
        updatePricePage.selectPrice();
        updatePricePage.selectUpdatePrice();
        updatePricePage.enterprice(pr);
        Thread.sleep(1000);
        updatePricePage.savebutton();
        addUserPage.notification_success();
    }
    
    @Test(dataProvider = "dp", priority = 1)
    public void updateprice_noprice(String pr) throws InterruptedException {
        updatePricePage.selectPrice();
        updatePricePage.selectUpdatePrice();
        updatePricePage.clearprice();
        Thread.sleep(1000);
        updatePricePage.savebutton();
        updatePricePage.notification_price();
    }
    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_price_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("update_price_QL");
        Object[][] data = new Object[addUserArray.size()][1];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String pr = (String) user.get("pr");
            data[i][0] = pr;
        }
        return data;
    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
