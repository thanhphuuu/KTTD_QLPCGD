package statistical;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xemgiogv_term_BB {
	public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.findElement(By.id("details-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("proceed-link")).click();
        Thread.sleep(1000);
        String cookies = "HUTXqql9J2JJq8HPGzAbTMhSbJK4Ll3pY_3qY-0ioRd-kCNko33ZdVA0bSGhdnN5AwQZBdsE3huHxDrQjGIoo1NHFySYnkvwA822Qgu0PqTdd_jq-gBrpoySJRGr_Txv7WjphpAcIf3u3TkZT_UAoPVP7Lxk92QLomoyCCupOj0zSkMO9BI4Pqz2uzb1j9N3Ce3pF8ds0N0O_plqKeDPxa31Hg81LUoDlEk7ZkTGCRe5dNZLxMRdvcEDiqKcXMiVah9E3OSCuj-VMNXOaJ0sHH5AdIX1pzeaOjTu--lzyrfDh-G8I3sKC6HAop_idHgSDApbarRRobnfPxDV0Bi-_P18yBR0QrPXaC4YL9ZDC7pvm43HCDXXvC5_ZTJm_A4mG0TAqz7kprKTEbY5ouenhnGRgReED_iHdhXg4yUvi-GAHWsVkmLu7zIqAeubwiJv7GYXdh_mdFI0X9yoIpJ7F7hLhogbTPVlvl2Us0iCrl3qxNTpPdILw6zcypRsPje9M_CDXh9ZQVdB7oonelVMPzKbO2ipYZA-MDJsv8i6Wu0y6lDpqGmTEI_2YqXLJs83uy4pC7qQ3HuZAFka0L3thikYBnwzVTUZmjsK6GrS7x1IzQTudjBMwJqGjW3XxRx8UxaiQzVqqQlHFKuw_RIqzN12g5cQ97t_USBOh3ccq4BSKWPIM5AmiJm3tew_83hRW0QMP6YMpYgJW1lrD55tKfxf--Ne8nRDENf5dSTKsASIEyR6m8nhsZVHB53yx-APQ9qMIhV69lp2sykMYDKvqYwLprw0m_A1UnNP6_o4_BEubJ3qAaLCqmlGiwbb5pY5sc_Mxih2zu06zFhl5_8zilIHxeDFpASVdZyBMxEdo5m23YkvoZhvud95EPBrz2eZQ4x9RDn4nS4m4mzGxB4ToaUZIft428rsLes4z-J3bHtud8PtdzUxGE9pJOftMt_2AqH5J9Dqxs1sXw-wtanoMpttzkLFqeOdg3K0uFmonMYvAGGdViZpMOI4OUgGpaIfPdQU4siMrGSVktfz3mIZxOdeMJge_omZJB59kSC5ai8oWQ1hih2mbmAo5uh1LppNqlThu07XkMa4ZRiuPlPGdO2UoFTaQVfqV1US2Hed1iT-i-tQp4-DQ10DSsUsji-6DPZD7FfPdxOfVYBN12pysUSzUXUZRz-ugSQNmom-O3Msl9GkJvMcOOi3vpM5ZhmSEpRNmNkS8jXCJZiRx1-fF5Hq42dfxLjQMuJDWWFtuuQj0oGaXJCOy-yXiQDxs7NLTaZH88ZbpGSrzAElTcbbJNPbAvVIH0C_81biihllcyqC8LVjXxug-ZTvBtfP1fmPIHhOw9bvRuIDBz9AgpSKWp0PNNwHvSh9Nw9WvStEYRzxTljMCjhuFToMwYoNnce-JyfTn_i_vwJerptnqwFNykLrmrLtgF-FA1-FkJ0UVedpiw5Qsaaw9lPhGuaWxe20IE-UaFuWt2s31woCPjFuJA";
        driver.manage().addCookie(new Cookie(".AspNet.Cookies", cookies));
        driver.navigate().refresh();
        Thread.sleep(2000);
        // Chọn phần thống kê
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a")).click();
        Thread.sleep(2000);
        // Chọn xem số giờ giảng viên
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        // Chọn xem bảng biểu
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        // List để lưu trữ các đối tượng WebElement của thông tin thống kê
        List<WebElement> statisticElements = driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3] |"
        		+ " /html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4] |"
        		+ " /html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[5] |"
        		+ " /html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[6]"));

        // List chứa các kết quả mong đợi
        List<String> expectedStatistics = List.of("2174802010701", "5", "9", "270");

        // Biến để kiểm tra xem kết quả có chính xác không
        boolean isCorrect = true;

        // Lặp qua từng phần tử trong danh sách statisticElements
        for (int i = 0; i < statisticElements.size(); i++) {
            // Trích xuất thông tin thống kê từ mỗi phần tử
            String actualStatistic = statisticElements.get(i).getText();
            String expectedStatistic = expectedStatistics.get(i);

            // So sánh thông tin thống kê với kết quả mong đợi
            if (!actualStatistic.equals(expectedStatistic)) {
                System.out.println("Thông tin thống kê không chính xác:");
                System.out.println("Thực tế: " + actualStatistic);
                System.out.println("Mong đợi: " + expectedStatistic);
                isCorrect = false;
            }
        }

        // Kiểm tra và in ra kết quả chính xác hoặc không chính xác
        if (isCorrect) {
            System.out.println("Tất cả thông tin thống kê chính xác.");
        } else {
            System.out.println("Có thông tin thống kê không chính xác.");
        }

        // Đóng trình duyệt
        driver.quit();
	}
}
