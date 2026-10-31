package com.craftad;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CraftAdHomeCheck {

    public static void main(String[] args) {
        // Create a fresh Chrome window that Selenium can control.
        WebDriver driver = new ChromeDriver();

        try {
            // Open the real CraftAd frontend, not its API documentation.
            driver.get("https://craftad-frontend.vercel.app/");

            // Give the page up to 10 seconds to show its main heading.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement heading = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

            // Read the heading text so the check can compare it with what we expect.
            String actualHeading = heading.getText().trim();
            String expectedHeading = "Real trades. Clear prices.";

            // Stop with a clear failure message if the wrong page or heading appeared.
            if (!expectedHeading.equals(actualHeading)) {
                throw new AssertionError("Expected heading '" + expectedHeading
                        + "' but found '" + actualHeading + "'.");
            }

            // Print a success message when the homepage heading matches.
            System.out.println("PASS: CraftAd homepage opened and the heading matched.");
        } finally {
            // Close the browser even if the check fails, so it is not left running.
            driver.quit();
        }
    }
}
