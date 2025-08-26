package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ScreenShotUtil;

import java.io.IOException;
import java.time.Duration;

public class AddEmployee extends BaseTest {
//    public static void main(String[] args) {
        // beforeMethod || afterMethod: truoc xu ly va sau xu ly
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        WebDriver driver = DriverFactory.getDriver();
//        try{
//            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//            Thread.sleep(5000);
//
//            //lop loginpage
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.login("Admin","admin123");
//            Thread.sleep(3000);
//            System.out.println("Login Success");
//
//            DashboardPage dashboardPage = new DashboardPage(driver);
//            dashboardPage.goToPIMPage();
//            Thread.sleep(3000);
//            System.out.println("Pim Page Login");
//
//            AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
//            addEmployeePage.goToEmployeePage();
//            System.out.println("Success");
//            Thread.sleep(3000);
//
////            String firstName = "Testing";
////            String lastName = "Automation";
//            String filePath = "src/test/java/resources/AddEmployeeTesting.xlsx";
//            String firstName = ExcelReader.getCellData(filePath,"sheet1",1,0);
//            String lastName = ExcelReader.getCellData(filePath,"sheet1",1,1);
//            String empId = addEmployeePage.addNewEmployee(firstName,lastName);
//            System.out.println("Them thanh cong");
//            Thread.sleep(10000);
//
//            Boolean isVerify = addEmployeePage.verifyNewEmployee(firstName,lastName,empId);
//            if (isVerify){
//                System.out.println("Matched");
//            }else {
//                System.out.println("not matched");
//            }
//        } catch (Exception e) {
//            System.out.println("Lỗi: " + e.getMessage());
//            ScreenShotUtil.captureSreenshot(driver,"AddEmployee");
//        }finally {
//            driver.quit();
//        }
//    }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        @Test
        public void AddEmployee() throws IOException {
            //cho o input username san sang
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            //lop loginpage
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin","admin123");
            System.out.println("Login Success");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("//span[text()=\"PIM\"]")));
            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.goToPIMPage();
            System.out.println("Pim Page Login");

            AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
            addEmployeePage.goToEmployeePage();
            System.out.println("Success");

//            String firstName = "Testing";
//            String lastName = "Automation";
            String filePath = "src/test/java/resources/AddEmployeeTesting.xlsx";
            String firstName = ExcelReader.getCellData(filePath,"sheet1",1,0);
            String lastName = ExcelReader.getCellData(filePath,"sheet1",1,1);
            String empId = addEmployeePage.addNewEmployee(firstName,lastName);
            System.out.println("Them thanh cong");

            Boolean isVerify = addEmployeePage.verifyNewEmployee(firstName,lastName,empId);
            if (isVerify){
                System.out.println("Matched");
            }else {
                System.out.println("not matched");
            }
        }
}
