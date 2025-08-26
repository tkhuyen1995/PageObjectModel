package utils;

import com.github.dockerjava.core.command.SaveImageCmdImpl;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {
    public static void captureSreenshot(WebDriver driver,String namePrefix){
        // Kiem tra driver co ho tro khong
        if (!(driver instanceof TakesScreenshot)){
            System.out.println("Driver Khong Ho Tro Chup Man Hinh");
        }

        //thuc hien thao tac chup man hinh va luu muc ao
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Tao Chuoi Tgian
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        //Tao Noi Luu File Hinh
        File destFile = new File("screenshot/" + namePrefix + "_" + timeStamp + ".png");

        try{
            Files.createDirectories(destFile.getParentFile().toPath());

            Files.copy(srcFile.toPath(),destFile.toPath());

            System.out.println("Da Chup Man Hinh");
        }catch(IOException e){
            System.out.println("Loi Luu Anh");
        }

    }
}
