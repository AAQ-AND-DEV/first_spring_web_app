package com.aaqanddev.jdnd.course1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    private int port;

    @Test
    public void test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver gDriver = new ChromeDriver();
        gDriver.get("http://localhost:" + this.port+"/animal");
        //getting google works, but getting localhost is experiencing a noConnection error
        //Exception in thread "main" org.openqa.selenium.WebDriverException: unknown error: net::ERR_CONNECTION_REFUSED
        //gDriver.get("http://google.com");


        for (int x = 0; x<5; x++){
            WebElement nameInput = gDriver.findElement(By.id("animalText"));
            nameInput.sendKeys("tiger");
            nameInput.submit();
            WebElement adjInput = gDriver.findElement(By.id("adjective"));
            adjInput.sendKeys("roaring");
            adjInput.submit();
            WebElement form = gDriver.findElement(By.id("submit"));
            form.submit();
        }
        WebElement conclMsg = gDriver.findElement(By.className("conclusionMessage"));
        //Thread.sleep(3000);
        System.out.println(conclMsg.getText());

        Thread.sleep(5000);
        gDriver.quit();
    }
}
