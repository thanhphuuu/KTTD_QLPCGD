package MAJOR;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.AddMajorPage;
import page.AddUserPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteMajor_success {
	WebDriver driver;
    AddUserPage addUserPage;
    AddMajorPage addMajorPage;
    List<WebElement> statisticElements;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        driver = new ChromeDriver();
        addUserPage = new AddUserPage(driver);
        addMajorPage = new AddMajorPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        addUserPage.cookies();   
    }

    @Test(dataProvider = "dp", priority = 0)
    public void deleteMajor(String ma) throws InterruptedException{
    	addMajorPage.selectmajor();
    	addMajorPage.searchTerm(ma);
    	addMajorPage.clickdeletemajor();
    	Thread.sleep(1000);
    	addMajorPage.clickokdeletemajor();
    	Thread.sleep(1000);
    	addUserPage.notification_success();
    }
    
    @Test(dataProvider = "dp", priority = 1)
    public void delete(String ma) throws InterruptedException{
    	addMajorPage.selectmajor();
    	addMajorPage.clickdeletemajor();
    	Thread.sleep(1000);
    	addMajorPage.clickokdeletemajor();
    	Thread.sleep(1000);
    	addUserPage.notification_fail();
    }
    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://delete_major_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("delete_major_QL");
        Object[][] data = new Object[addUserArray.size()][1];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String ma = (String) user.get("ma");
            data[i][0] = ma;
        }
        return data;
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

