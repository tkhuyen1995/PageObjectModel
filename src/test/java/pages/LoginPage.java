package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver; //Webdriver thao tac voi trinh duyet

    //constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Ham thuc hien dang nhap
    public void login(String username,String password){
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
}
