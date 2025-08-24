package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {
    private WebDriver driver;

    public MyInfoPage(WebDriver driver){
        this.driver = driver;
    }

    public String fullNameForm(){
        String firstName = driver.findElement(By.name("firstName")).getAttribute("value").trim();
        String lastName = driver.findElement(By.name("lastName")).getAttribute("value").trim();
        return firstName + " " + lastName;
    }

    public String getDisplayFullName(){
        return driver.findElement(By.cssSelector(".oxd-userdropdown-name")).getText().trim();
    }

    public void setFirstName(String firstname){
        WebElement firstnameInput = driver.findElement(By.name("firstName"));
//        firstnameInput.clear(); truong hop ly tuong
        firstnameInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        firstnameInput.sendKeys(Keys.chord(Keys.DELETE));
        firstnameInput.sendKeys(firstname);
    }
}
