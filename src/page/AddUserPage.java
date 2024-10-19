package page;


import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddUserPage {
    private WebDriver driver;

    // Constructor
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Phương thức chuyển đến trang quản lý người dùng
    public void cookies() {
    	String cookies = "HUTXqql9J2JJq8HPGzAbTMhSbJK4Ll3pY_3qY-0ioRd-kCNko33ZdVA0bSGhdnN5AwQZBdsE3huHxDrQjGIoo1NHFySYnkvwA822Qgu0PqTdd_jq-gBrpoySJRGr_Txv7WjphpAcIf3u3TkZT_UAoPVP7Lxk92QLomoyCCupOj0zSkMO9BI4Pqz2uzb1j9N3Ce3pF8ds0N0O_plqKeDPxa31Hg81LUoDlEk7ZkTGCRe5dNZLxMRdvcEDiqKcXMiVah9E3OSCuj-VMNXOaJ0sHH5AdIX1pzeaOjTu--lzyrfDh-G8I3sKC6HAop_idHgSDApbarRRobnfPxDV0Bi-_P18yBR0QrPXaC4YL9ZDC7pvm43HCDXXvC5_ZTJm_A4mG0TAqz7kprKTEbY5ouenhnGRgReED_iHdhXg4yUvi-GAHWsVkmLu7zIqAeubwiJv7GYXdh_mdFI0X9yoIpJ7F7hLhogbTPVlvl2Us0iCrl3qxNTpPdILw6zcypRsPje9M_CDXh9ZQVdB7oonelVMPzKbO2ipYZA-MDJsv8i6Wu0y6lDpqGmTEI_2YqXLJs83uy4pC7qQ3HuZAFka0L3thikYBnwzVTUZmjsK6GrS7x1IzQTudjBMwJqGjW3XxRx8UxaiQzVqqQlHFKuw_RIqzN12g5cQ97t_USBOh3ccq4BSKWPIM5AmiJm3tew_83hRW0QMP6YMpYgJW1lrD55tKfxf--Ne8nRDENf5dSTKsASIEyR6m8nhsZVHB53yx-APQ9qMIhV69lp2sykMYDKvqYwLprw0m_A1UnNP6_o4_BEubJ3qAaLCqmlGiwbb5pY5sc_Mxih2zu06zFhl5_8zilIHxeDFpASVdZyBMxEdo5m23YkvoZhvud95EPBrz2eZQ4x9RDn4nS4m4mzGxB4ToaUZIft428rsLes4z-J3bHtud8PtdzUxGE9pJOftMt_2AqH5J9Dqxs1sXw-wtanoMpttzkLFqeOdg3K0uFmonMYvAGGdViZpMOI4OUgGpaIfPdQU4siMrGSVktfz3mIZxOdeMJge_omZJB59kSC5ai8oWQ1hih2mbmAo5uh1LppNqlThu07XkMa4ZRiuPlPGdO2UoFTaQVfqV1US2Hed1iT-i-tQp4-DQ10DSsUsji-6DPZD7FfPdxOfVYBN12pysUSzUXUZRz-ugSQNmom-O3Msl9GkJvMcOOi3vpM5ZhmSEpRNmNkS8jXCJZiRx1-fF5Hq42dfxLjQMuJDWWFtuuQj0oGaXJCOy-yXiQDxs7NLTaZH88ZbpGSrzAElTcbbJNPbAvVIH0C_81biihllcyqC8LVjXxug-ZTvBtfP1fmPIHhOw9bvRuIDBz9AgpSKWp0PNNwHvSh9Nw9WvStEYRzxTljMCjhuFToMwYoNnce-JyfTn_i_vwJerptnqwFNykLrmrLtgF-FA1-FkJ0UVedpiw5Qsaaw9lPhGuaWxe20IE-UaFuWt2s31woCPjFuJA";
        driver.manage().addCookie(new Cookie(".AspNet.Cookies", cookies));
        driver.navigate().refresh();
    }
    
    // Phương thức chuyển đến trang quản lý người dùng
    public void navigateToUserManagementPage() {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[3]/a")).click();
    }
    
    //phương thức xóa người dùng
    public void clickdeleteuser() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[7]/a[2]")).click();
    }
    
    //phương thức xác nhận xóa người dùng
    public void clickokdeleteuser() {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();
    }
    
    // Phương thức chuyển đến trang quản lý người dùng
    public void clickUpdateUser() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[7]/a[1]")).click();
    }

    // Phương thức nhấn vào nút thêm người dùng
    public void clickAddUserButton() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/button")).click();
    }
    
    // Phương thức nhấn vào nút thêm người dùng
    public void clickCancelSave() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[1]")).click();
    }

    // Phương thức nhập mã số
    public void enterUserID(String ma) {
        WebElement userIDField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input"));
        userIDField.clear();
        userIDField.sendKeys(ma);
    }
    
    public void clearUserID() {
        WebElement userIDField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[1]/input"));
        userIDField.clear();
    }
    
    public void clearUserName() {
        WebElement userIDField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input"));
        userIDField.clear();
    }
    
    public void clearUserEmail() {
        WebElement userIDField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input"));
        userIDField.clear();
    }


    // Phương thức nhập tên
    public void enterUserName(String name) {
        WebElement userNameField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[2]/input"));
        userNameField.clear();
        userNameField.sendKeys(name);
    }
    

    // Phương thức nhập email
    public void enterUserEmail(String email) {
        WebElement userEmailField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[3]/input"));
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    // Phương thức chọn loại giảng viên
    public void selectLecturerType() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[1]/span[1]/span/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[4]/div/span[2]/span/span[2]/ul/li[2]")).click();
    }

    // Phương thức chọn role
    public void selectUserRole() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span[1]/span[1]/span/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[5]/div/span[2]/span/span[2]/ul/li[2]")).click();
    }

    // Phương thức nhấn nút lưu
    public void clickSaveButton() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div[7]/button[2]")).click();
    }

    // Phương thức tìm kiếm người dùng
    public void searchUser(String email) {
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/label/input"));
        searchField.clear();
        searchField.sendKeys(email);
    }
    
    public void click_okfail() {
        driver.findElement(By.xpath("/html/body/div[5]/div/div[6]/button[1]")).click();
    }
    
    
    public void notification_success() {
    	WebElement messageElement = driver.findElement(By.className("toast-message"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);;
    }
    
    public void notification_fail() {
    	  WebElement messageElement = driver.findElement(By.id("swal2-html-container"));
          String actualMessage = messageElement.getText();
          System.out.println(actualMessage);
    }
    
    public void notification_nottype() {
  	  WebElement messageElement = driver.findElement(By.id("type-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    
    public void notification_ma() {
    	  WebElement messageElement = driver.findElement(By.id("staff_id-error"));
          String actualMessage = messageElement.getText();
          System.out.println(actualMessage);
      }
    
    public void notification_name() {
  	  WebElement messageElement = driver.findElement(By.id("full_name-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    
    public void notification_notrole() {
  	  WebElement messageElement = driver.findElement(By.id("role_id-error"));
        String actualMessage = messageElement.getText();
        System.out.println(actualMessage);
    }
    
    public void notification_wrongemail() {
    	  WebElement messageElement = driver.findElement(By.id("email-error"));
          String actualMessage = messageElement.getText();
          System.out.println(actualMessage);
      }
    

    // Phương thức kiểm tra thông tin người dùng
    public void verifyUserDetails(String ma, String name, String email) {
        // Lấy thông tin từ bảng sau khi tìm kiếm
        String actualMa = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[2]")).getText();
        String actualName = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]")).getText();
        String actualEmail = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]")).getText();

        // So sánh thông tin với dữ liệu nhập vào
        if (!actualMa.equals(ma) || !actualName.equals(name) || !actualEmail.equals(email)) {
            System.out.println("Thông tin người dùng không chính xác!");
        } else {
            System.out.println("Thông tin người dùng chính xác.");
        }
    }
    
}
