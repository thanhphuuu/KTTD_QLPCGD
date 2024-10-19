package term_major;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AddTermPage;
import page.AddUserPage;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class add_terms {
    WebDriver driver;
    AddUserPage addUserPage;
    AddTermPage addTermPage;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        driver = new ChromeDriver();
        addUserPage = new AddUserPage(driver);
        addTermPage = new AddTermPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        addUserPage.cookies();   
    }

    @Test(dataProvider = "dp", priority = 0)
    public void addTerm_success(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
        addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        Thread.sleep(1000);
        addTermPage.enterCode(HK);
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.selectStartDate();
        Thread.sleep(1000);
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.clickSaveButton();
        addUserPage.notification_success();
        Thread.sleep(1000);
        addTermPage.searchTerm(HK);
        Thread.sleep(1000);
        addTermPage.verifyTermDetails(HK);
    }
    
    @Test(dataProvider = "dp", priority = 1)
    public void addTerm_noID_date(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
        addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.clickSaveButton();
        Thread.sleep(2000);
        addTermPage.notification_ID();
        addTermPage.notification_date();
    }
    
    @Test(dataProvider = "wr", priority = 2)
    public void addTerm_wrongId(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
        addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        addTermPage.enterCode(HK);
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.selectStartDate();
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.clickSaveButton();
        Thread.sleep(2000);
        addTermPage.notification_ID();
    }
       
    @Test(dataProvider = "max", priority = 3)
    public void addTerm_maxweek_lesson_class(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
        addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        addTermPage.enterCode(HK);
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.notification_startweek();
        addTermPage.notification_lesson();
        Thread.sleep(2000);
    }
    
    @Test(dataProvider = "min", priority = 4)
    public void addTerm_minweek_lesson_class(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
        addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        addTermPage.enterCode(HK);
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.notification_startweek();
        addTermPage.notification_lesson();
        Thread.sleep(2000);
    }
    @Test(dataProvider = "dp", priority = 5)
    public void addTerm_duplicated(String HK,String TBD , String TTD, String LTD) throws InterruptedException {
    	addTermPage.selectTerm();
        addTermPage.clickAddTermButton();
        Thread.sleep(1000);
        addTermPage.enterCode(HK);
        Thread.sleep(1000);
        addTermPage.enterStartWeek(TBD);
        Thread.sleep(1000);
        addTermPage.selectStartDate();
        Thread.sleep(1000);
        addTermPage.enterMaxLesson(TTD);
        Thread.sleep(1000);
        addTermPage.enterMaxClass(LTD);
        Thread.sleep(1000);
        addTermPage.clickSaveButton();
        addUserPage.notification_fail();
        Thread.sleep(1000);
        addTermPage.searchTerm(HK);
        Thread.sleep(1000);
        addTermPage.verifyTermDetails(HK);
    }
    
    @DataProvider(name = "dp")
    public Object[][] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_term_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_term");
        Object[][] data = new Object[addUserArray.size()][4];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String HK = (String) user.get("HK");
            String TBD = (String)user.get("TBD");
            String TTD = (String) user.get("TTD");
            String LTD = (String) user.get("LTD");
            data[i][0] = HK;
            data[i][1] = TBD;
            data[i][2] = TTD;
            data[i][3] = LTD;
        }
        return data;
    }
    
    @DataProvider(name = "wr")
    public Object[][] readJson_wr() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_term_wrong_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_term_wrong");
        Object[][] data = new Object[addUserArray.size()][4];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String HK = (String) user.get("HK");
            String TBD = (String)user.get("TBD");
            String TTD = (String) user.get("TTD");
            String LTD = (String) user.get("LTD");
            data[i][0] = HK;
            data[i][1] = TBD;
            data[i][2] = TTD;
            data[i][3] = LTD;
        }
        return data;
    }
    
    @DataProvider(name = "max")
    public Object[][] readJson_high() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_term_max_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_term_max");
        Object[][] data = new Object[addUserArray.size()][4];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String HK = (String) user.get("HK");
            String TBD = (String)user.get("TBD");
            String TTD = (String) user.get("TTD");
            String LTD = (String) user.get("LTD");
            data[i][0] = HK;
            data[i][1] = TBD;
            data[i][2] = TTD;
            data[i][3] = LTD;
        }
        return data;
    }
    
    @DataProvider(name = "min")
    public Object[][] readJson_min() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("d://add_term_min_QL.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray addUserArray = (JSONArray) jsonObject.get("add_term_min");
        Object[][] data = new Object[addUserArray.size()][4];
        for (int i = 0; i < addUserArray.size(); i++) {
            JSONObject user = (JSONObject) addUserArray.get(i);
            String HK = (String) user.get("HK");
            String TBD = (String)user.get("TBD");
            String TTD = (String) user.get("TTD");
            String LTD = (String) user.get("LTD");
            data[i][0] = HK;
            data[i][1] = TBD;
            data[i][2] = TTD;
            data[i][3] = LTD;
        }
        return data;
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
