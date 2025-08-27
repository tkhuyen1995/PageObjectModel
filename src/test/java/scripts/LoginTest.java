package scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelReader;

import java.io.IOException;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData") // cung cap du lieu dau vao cho nhung @Test
    public Object[][] loginData() throws IOException {
        String filePath = "src/test/java/resources/AccountTest.xlsx";
        String sheetName = "sheet1";
        //tao bien so dong du lieu (khong co chua dong tieu de)
        int rowCount = 4;

        //tao mang 2 chieu de luu du lieu
        Object[][] data = new Object[rowCount][3];
        for(int i = 0; i < rowCount; i++){
            //lay du lieu cho username
            data[i][0] = ExcelReader.getCellData(filePath, sheetName, i+1,0);

            //lay du lieu cho password
            data[i][1] = ExcelReader.getCellData(filePath, sheetName, i+1,1);

            //expectedResult
            data[i][2] = ExcelReader.getCellData(filePath, sheetName, i+1,2);

        }
        return data;
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedResult){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);

        Boolean isLogged = driver.getCurrentUrl().contains("dashboard");
        System.out.println(isLogged);
        if(Boolean.parseBoolean(expectedResult) == isLogged){
            System.out.println("Pass");
        }else{
            System.out.println("False");
        }
    }
}
