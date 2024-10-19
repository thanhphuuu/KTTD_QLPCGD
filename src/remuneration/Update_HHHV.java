package remuneration;


import org.testng.annotations.Test;

import page.AddHHHVPage;
import page.AddUserPage;

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

public class Update_HHHV {
    WebDriver driver;
    AddUserPage addUserPage;
    AddHHHVPage addHHHVPage;
    List<WebElement> statisticElements; // Khai báo List<WebElement> ở cấp độ class

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        driver = new ChromeDriver();
        addUserPage = new AddUserPage(driver);
        addHHHVPage = new AddHHHVPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        addUserPage.cookies();

    }

    @Test(dataProvider = "dp", priority = 0)
    public void addHHHV_success(String name, String STT) throws InterruptedException {
    	addHHHVPage.selectHHHV();
    	addHHHVPage.clickUpdateHHHVButton();
        Thread.sleep(1000);
        addHHHVPage.enterName(name);
        Thread.sleep(1000);
        addHHHVPage.enterSTT(STT);
        addHHHVPage.clickSaveButton();
        Thread.sleep(2000);    
        addUserPage.notification_success();
    }
    
    @Test(dataProvider = "dp", priority = 1)
    public void addHHHV_noname(String name, String STT) throws InterruptedException {
    	addHHHVPage.selectHHHV();
    	addHHHVPage.clickUpdateHHHVButton();
    	addHHHVPage.clearName();
        Thread.sleep(1000);
        addHHHVPage.enterSTT(STT);
        addHHHVPage.clickSaveButton();
        Thread.sleep(2000);    
        addHHHVPage.notification_name();
    }
    
    @Test(dataProvider = "dp", priority = 2)
    public void addHHHV_nolevel(String name, String STT) throws InterruptedException {
    	addHHHVPage.selectHHHV();
    	addHHHVPage.clickUpdateHHHVButton();
    	addHHHVPage.enterName(name);
        Thread.sleep(1000);
        addHHHVPage.clearSTT();
        addHHHVPage.clickSaveButton();
        Thread.sleep(2000);    
        addHHHVPage.notification_level();
    }
    
    @Test(dataProvider = "wr", priority = 3)
    public void addHHHV_wronglevel(String name, String STT) throws InterruptedException {
    	addHHHVPage.selectHHHV();
    	addHHHVPage.clickUpdateHHHVButton();
    	addHHHVPage.enterName(name);
        Thread.sleep(1000);
        addHHHVPage.enterSTT(STT);
        addHHHVPage.clickSaveButton();
        Thread.sleep(2000);    
        addHHHVPage.notification_level();
    }
    

    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://update_hh_hv_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("update_hh_hv_QL");
        Object[][] data = new Object[addUserArray.size()][2];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String name = (String) user.get("name");
            String STT = (String) user.get("STT");
            data[i][0] = name;
            data[i][1] = STT;
        }
        return data;
    }
    
    @DataProvider(name = "wr")
    public Object[][] readJson_wwr() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_hh_hv_wrong_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_hh_hv_wrong_QL");
        Object[][] data = new Object[addUserArray.size()][2];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String name = (String) user.get("name");
            String STT = (String) user.get("STT");
            data[i][0] = name;
            data[i][1] = STT;
        }
        return data;
    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}