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

public class Update_heso {
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
    public void updateheso_success(String HSTV, String HSTA, String HSLT, String HSTH ) throws InterruptedException {
        updatePricePage.selectPrice();
        updatePricePage.selectHS();
        updatePricePage.selectUpdateHS();
        updatePricePage.enterhstv(HSTV);
        updatePricePage.enterhsta(HSTA);
        updatePricePage.enterhslt(HSLT);
        updatePricePage.enterhsth(HSTH);
        Thread.sleep(1000);
        updatePricePage.savebuttonhs();
        addUserPage.notification_success();
    }
    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_heso_QL.json");	
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_heso_QL");
        Object[][] data = new Object[addUserArray.size()][4];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String HSTA = (String) user.get("HSTA");
            String HSTV = (String) user.get("HSTV");
            String HSLT = (String) user.get("HSLT");
            String HSTH = (String) user.get("HSTH");
            data[i][0] = HSTA;
            data[i][1] = HSTV;
            data[i][2] = HSLT;
            data[i][3] = HSTH;
        }
        return data;
    }
    

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
