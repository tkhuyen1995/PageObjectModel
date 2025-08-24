package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {
    private WebDriver driver;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public String fullNameForm(){
        WebElement firstName = driver.findElement(By.name("fisrtName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        return firstName.getAttribute("value").trim() + " " + lastName.getAttribute("value").trim();
    }

    public Boolean verifyFullName(String expectedFullName){
        String actualFullName = driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getAttribute("value").trim();
        return expectedFullName.equals(actualFullName);
    }
}
