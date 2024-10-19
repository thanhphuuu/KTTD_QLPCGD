package login;

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

import page.AddUserPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class delete_users {
    WebDriver driver;
    AddUserPage addUserPage;
    List<WebElement> statisticElements;
    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        driver = new ChromeDriver();
        addUserPage = new AddUserPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/User");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        addUserPage.cookies();
    }

    @Test(priority = 1)
    public void deleteUse_fail() throws InterruptedException{
    	addUserPage.navigateToUserManagementPage();
    	Thread.sleep(1000);
    	addUserPage.clickdeleteuser();
    	Thread.sleep(1000);
    	addUserPage.clickokdeleteuser();
    	Thread.sleep(1000);
    	addUserPage.notification_fail();
    	Thread.sleep(1000);
    }
    @Test(dataProvider = "dp",priority = 0)
    public void deleteUse_success(String email) throws InterruptedException{
    	addUserPage.navigateToUserManagementPage();
    	Thread.sleep(1000);
    	addUserPage.searchUser(email);
    	Thread.sleep(1000); 
    	addUserPage.clickdeleteuser();
    	Thread.sleep(1000); 
    	addUserPage.clickokdeleteuser();	
    	Thread.sleep(1000); 	
    	addUserPage.notification_success();
    }
    
    @DataProvider(name = "dp")
    public Object[][] provideUserData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://delete_user_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("delete_user_QL");
        Object[][] data = new Object[addUserArray.size()][1];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String email = (String) user.get("email");
            data[i][0] = email;
        }
        return data;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}