package org.example;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TrianglePuzzleTest {
    private WebDriver driver;

    @Test
    public void testTrianglePuzzle() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");

        // Инициализация драйвера Chrome
        driver = new ChromeDriver();

        // Открытие страницы с головоломкой
        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        // Проверка наличия кнопки "Я сдаюсь" и ее клик
        WebElement giveUpButton = driver.findElement(By.xpath("//button[text()='Я сдаюсь']"));
        Assert.assertTrue(giveUpButton.isDisplayed(), "Кнопка 'Я сдаюсь' не найдена на странице");
        giveUpButton.click();

        // Проверка наличия ссылки "Ссылка на ответы"
        WebElement answersLink = driver.findElement(By.linkText("Ссылка на ответы"));
        Assert.assertTrue(answersLink.isDisplayed(), "Ссылка на ответы не найдена на странице");

        // Проверка наличия кнопки "Спрятать ответы"
        WebElement hideAnswersButton = driver.findElement(By.xpath("//button[text()='Спрятать ответы']"));
        Assert.assertTrue(hideAnswersButton.isDisplayed(), "Кнопка 'Спрятать ответы' не найдена на странице");

        // Вывод успешного выполнения
        if (answersLink.isDisplayed() && hideAnswersButton.isDisplayed()) {
            System.out.println("Успешно выполнено");
        }

        // Завершение сеанса браузера
        driver.quit();
    }
}
