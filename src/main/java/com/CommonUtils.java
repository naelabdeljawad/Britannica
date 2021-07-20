package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CommonUtils {

    /**
     * Click on element by JS executor
     */
    public static void clickByJS(WebElement element, WebDriver chromeDriver) {
        JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Convert noisy string number to double
     *
     * @param number
     * @return
     */
    public static double getDoubleFromNoisyString(String number) {
        return Double.valueOf(number.replaceAll("[^\\d\\.]", ""));
    }

    /**
     * Sleep
     *
     * @param millisecs
     */
    public static void sleep(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * getCurrentTimeAndDate
     *
     * @return
     */
    public static String getCurrentTimeDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    /**
     * getRandomNumber
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * getRandomString
     *
     * @param len
     * @return
     */
    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

}
