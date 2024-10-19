package login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("proceed-link")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("OpenIdConnect")).click();
        Thread.sleep(1000);
        
        // Đọc email và password từ file
        String[] credentials = readCredentialsFromFile("login");
        String email = credentials[0];
        String password = credentials[1];
        
        // Nhập email và click next
        driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[2]/div[2]/div/input[1]")).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(1000);
        // Nhập password và đăng nhập
        driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[5]/div/div/div/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input")).click();
        Thread.sleep(1000);
    }

    // Phương thức để đọc email và password từ file văn bản
    private static String[] readCredentialsFromFile(String filePath) {
        String[] credentials = new String[2];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Đọc email và password từ file
            credentials[0] = br.readLine(); // Đọc email
            credentials[1] = br.readLine(); // Đọc password
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }
}
