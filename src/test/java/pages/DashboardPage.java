package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    //constructor
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToPIMPage(){
        driver.findElement(By.xpath("//span[text()=\"PIM\"]")).click();
    }

    public void goToAdminPage(){
        driver.findElement(By.xpath("//span[text()=\"Admin\"]")).click();
    }

    public void goToMyInfoPage(){
        driver.findElement(By.xpath("//span[text()=\"My Info\"]")).click();
    }
}
