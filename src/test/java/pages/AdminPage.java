package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage {
    private WebDriver driver;

    public AdminPage (WebDriver driver){
        this.driver = driver;
    }

    public void searchUsername(String username){
        WebElement usernameID = driver.findElement(By.xpath("//label[@class=\"oxd-label\"]/../following-sibling::div/input"));
        usernameID.sendKeys(username);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    public boolean isUserFound(String usernameExpected){
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"oxd-table-body\"]"));
        for (WebElement row:rows){
            String actualUsername = row.findElement(By.xpath("(//div[@role=\"cell\"])[2]/div")).getText();
            if(actualUsername.equalsIgnoreCase(usernameExpected)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
