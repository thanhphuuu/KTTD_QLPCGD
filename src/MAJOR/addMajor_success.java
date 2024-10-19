package MAJOR;

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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class addMajor_success {
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
    public void AddMajor_success(String ma, String name, String TVT) throws InterruptedException {
    	addMajorPage.selectmajor();
    	addMajorPage.selectaddmajor();
    	addMajorPage.enterMajorID(ma);
    	Thread.sleep(1000);
        addMajorPage.enterMajorName(name);
        Thread.sleep(1000);
        addMajorPage.enterMajorAbbreviation(TVT);
        Thread.sleep(1000);
        addMajorPage.selectProgramType();
        addMajorPage.clickSaveButton();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/form/div[5]/button[2]")).click();
        Thread.sleep(1000);
        addMajorPage.searchTerm(ma);
        Thread.sleep(1000);
        addMajorPage.verifyMajorDetails(ma, name, TVT);
    }
    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_major_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_major");
        Object[][] data = new Object[addUserArray.size()][3];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String ma = (String) user.get("MA");
            String name = (String) user.get("name");
            String TVT = (String) user.get("TVT");
            data[i][0] = ma;
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
