package com.liushihao.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 刘世豪
 * @description Selenium学习
 */
public class ZhihuSelenium {

    public static void main(String[] args) throws InterruptedException {
        wechatLogin();
    }

    public static void commonLogin(String id, String password) throws InterruptedException {

        EdgeDriver driver = getWindows();

        // 设置sleep方便观察
        Random random = new Random();
        Thread.sleep(2000);

        // 定位到密码登录框
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/form/div[1]/div[2]")).click();

        try {
            // 输入账号
            WebElement userNameElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/form/div[2]/div/label/input"));
            for (int i = 0; i < id.length(); i++) {
                // 随机睡眠0-1秒
                Thread.sleep(random.nextInt(1000));
                // 逐个输入用户名
                userNameElement.sendKeys("" + id.charAt(i));
            }
            // 输入用户名后随机睡眠0-3秒
            Thread.sleep(random.nextInt(3000));

            // 输入密码
            WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/form/div[3]/div/label/input"));
            for (int i = 0; i < password.length(); i++) {
                // 随机睡眠0-1秒
                Thread.sleep(random.nextInt(1000));
                passwordElement.sendKeys("" + password.charAt(i));
            }
            Thread.sleep(random.nextInt(3000));

            WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[1]/div/form/button"));
            loginBtn.click();

            Actions actions = new Actions(driver);
            WebElement moveBtn = driver.findElement(By.xpath("/src/main/webapp/html/body/div[4]/div[2]/div/div/div[2]/div/div[2]/div[2]/span"));
            // 移动滑块元素并悬停, 不能超过框的长度, 负责异常
            actions.clickAndHold(moveBtn);
            actions.moveByOffset(258, 0).perform();
            actions.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(300000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        driver.close();
    }

    public static void wechatLogin() throws InterruptedException {

        // 获取浏览器窗口
        EdgeDriver driver = getWindows();

        // 找到微信登录按钮并点击, 这时会出现新窗口, 需要切换到新窗口
        WebElement wechatBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div[3]/span[2]/button[1]"));
        wechatBtn.click();

        // 先把当前窗口的句柄保存起来, 登录成功后需要跳转回来
        String home = driver.getWindowHandle();

        // 获取窗口句柄集合
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(driver.getTitle());

        // 遍历集合
        for (String windowHandle : windowHandles) {
            // 如果窗口标题是微信登录则切换到此窗口
            if ("微信登录".equals(driver.switchTo().window(windowHandle).getTitle())) {
                // 再次睡眠20s, 等待扫码登录
                Scanner scanner = new Scanner(System.in);
                System.out.println("扫码完成后输入任意字符");
                scanner.nextLine();

                // 扫码完成后, 跳转回主窗口
                driver.switchTo().window(home);
            }
        }

        // 设置sleep方便观察
        Random random = new Random();
        Thread.sleep(2000);

//        driver.quit();
    }

    private static EdgeDriver getWindows(){
        // edgeDriver服务地址
        System.setProperty("webdriver.edge.driver", "D:/File/Learn/Jar包/edgedriver_win64/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.zhihu.com/signin?next=%2F");
        driver.manage().window().setSize(new Dimension(1200, 900));
        driver.manage().window().setPosition(new Point(1500, 200));
        return driver;
    }
}
