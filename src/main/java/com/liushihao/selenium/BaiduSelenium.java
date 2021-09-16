package com.liushihao.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Random;

public class BaiduSelenium {

    public static void commonLogin(String id, String password) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "D:/File/Learn/Jar包/edgedriver_win64/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.baidu.com/");
        driver.manage().window().setSize(new Dimension(1200, 900));
        driver.manage().window().setPosition(new Point(1500, 200));

        Thread.sleep(2000);

        WebElement loginElement = driver.findElement(By.xpath("//*[@id=\"s-top-loginbtn\"]"));
        loginElement.click();

//        WebElement idLoginBtn = driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn"));
//        idLoginBtn.click();
        Random random = new Random();

        WebElement idInputBtn = driver.findElement(By.id("TANGRAM__PSP_11__userName"));
        for (int i = 0; i < id.length(); i++) {
            Thread.sleep(random.nextInt(1000));
            idInputBtn.sendKeys("" + id.charAt(i));
        }

        WebElement passwordInputBtn = driver.findElement(By.id("TANGRAM__PSP_11__password"));
        for (int i = 0; i < password.length(); i++) {
            Thread.sleep(random.nextInt(1000));
            passwordInputBtn.sendKeys("" + password.charAt(i));
        }

        WebElement loginBtn = driver.findElement(By.id("TANGRAM__PSP_11__submit"));
        loginBtn.click();
    }
}
