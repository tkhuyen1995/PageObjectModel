package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;

public class AddEmployee {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try{
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(5000);

            //lop loginpage
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("Admin","admin123");
            Thread.sleep(3000);
            System.out.println("Login Success");

            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.goToPIMPage();
            Thread.sleep(3000);
            System.out.println("Pim Page Login");

            AddEmployeePage addEmployeePage = new AddEmployeePage(driver);
            addEmployeePage.goToEmployeePage();
            System.out.println("Success");
            Thread.sleep(3000);

            String firstName = "Testing";
            String lastName = "Automation";
            String empId = addEmployeePage.addNewEmployee(firstName,lastName);
            System.out.println("Them thanh cong");
            Thread.sleep(10000);

            Boolean isVerify = addEmployeePage.verifyNewEmployee(firstName,lastName,empId);
            if (isVerify){
                System.out.println("Matched");
            }else {
                System.out.println("not matched");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }finally {
            driver.quit();
        }
    }
}
