package login;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class addUser_cancel {

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

    @Test(dataProvider = "userData", priority = 1)
    public void addUser_Cancel(String ma, String name, String email) throws InterruptedException {
    	addUserPage.navigateToUserManagementPage();
        addUserPage.clickAddUserButton();
        Thread.sleep(1000);
        addUserPage.enterUserID(ma);
        Thread.sleep(1000);
        addUserPage.enterUserName(name);
        Thread.sleep(1000);
        addUserPage.enterUserEmail(email);
        Thread.sleep(1000);
        addUserPage.selectLecturerType();
        addUserPage.selectUserRole();
        Thread.sleep(1000);
        addUserPage.clickCancelSave();
        Thread.sleep(1000);
        addUserPage.searchUser(email);
        Thread.sleep(1000);
        System.out.println("người dùng không có trong hệ thống");
    }

    @DataProvider(name = "userData")
    public Object[][] provideUserData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_user_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_user_QL");
        Object[][] data = new Object[addUserArray.size()][3];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String ma = (String) user.get("MA");
            String name = (String) user.get("name");
            String email = (String) user.get("email");
            data[i][0] = ma;
            data[i][1] = name;
            data[i][2] = email;
        }
        return data;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
