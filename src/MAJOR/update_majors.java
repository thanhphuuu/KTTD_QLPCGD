package MAJOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.AddMajorPage;
import page.AddUserPage;

import java.util.concurrent.TimeUnit;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class update_majors {
    WebDriver driver;
    AddUserPage addUserPage;
    AddMajorPage addMajorPage;
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
    public void UpdateMajor_success(String name, String TVT) throws InterruptedException {
    	addMajorPage.selectmajor();
    	addMajorPage.selectupdatemajor();
    	Thread.sleep(1000);
        addMajorPage.enterMajorName(name);
        Thread.sleep(1000);
        addMajorPage.enterMajorAbbreviation(TVT);
        Thread.sleep(1000);
        addMajorPage.selectProgramType();
        addMajorPage.clickSaveButton();
        addUserPage.notification_success();
    }
    
    @Test(dataProvider = "dp", priority = 1)
    public void UpdateMajor_noname(String name, String TVT) throws InterruptedException {
    	addMajorPage.selectmajor();
    	addMajorPage.selectupdatemajor();
    	addMajorPage.clearName();
        Thread.sleep(1000);
        addMajorPage.enterMajorAbbreviation(TVT);
        Thread.sleep(1000);
        addMajorPage.selectProgramType();
        addMajorPage.clickSaveButton();
        addMajorPage.notification_name();
    }
    
    @Test(dataProvider = "dp", priority = 2)
    public void UpdateMajor_noTVT(String name, String TVT) throws InterruptedException {
    	addMajorPage.selectmajor();
    	addMajorPage.selectupdatemajor();
    	addMajorPage.enterMajorName(name);
        Thread.sleep(1000);
        addMajorPage.clearTVT();
        Thread.sleep(1000);
        addMajorPage.selectProgramType();
        addMajorPage.clickSaveButton();
        addMajorPage.notification_shortname();
    }
    
    @Test(dataProvider = "dp", priority = 3)
    public void UpdateMajor_wrongTVT(String name, String TVT) throws InterruptedException {
    	addMajorPage.selectmajor();
    	addMajorPage.selectupdatemajor();
    	addMajorPage.enterMajorName(name);
        Thread.sleep(1000);
        addMajorPage.enterMajorAbbreviation(TVT);
        Thread.sleep(1000);
        addMajorPage.selectProgramType();
        addMajorPage.clickSaveButton();
        addMajorPage.notification_shortname();
    }

    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://update_major_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("update_major");
        Object[][] data = new Object[addUserArray.size()][2];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String name = (String) user.get("name");
            String TVT = (String) user.get("TVT");
            data[i][0] = name;
            data[i][1] = TVT;
        }
        return data;
    }
    @DataProvider(name = "wr")
    public Object[][] readJson_wr() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_major_wrong_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_major_wrong");
        Object[][] data = new Object[addUserArray.size()][2];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String name = (String) user.get("name");
            String TVT = (String) user.get("TVT");
            data[i][1] = name;
            data[i][2] = TVT;
        }
        return data;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
