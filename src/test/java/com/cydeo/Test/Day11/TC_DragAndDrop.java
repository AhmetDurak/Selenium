package com.cydeo.Test.Day11;

import com.Utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_DragAndDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.get().get(ConfigurationReader.get("dragAndDrop"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
        Driver.get().findElement(By.id("onetrust-accept-btn-handler")).click();

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.get().findElement(By.id("draggable"));
        WebElement target = Driver.get().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.get());
        Thread.sleep(1000);
        actions.dragAndDrop(smallCircle, target).perform();
        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String expectedResult = Driver.get().findElement(By.id("droptarget")).getText();
        Assert.assertEquals(expectedResult,"You did great!");

        Driver.get().navigate().refresh();
        Thread.sleep(2000);
        smallCircle = Driver.get().findElement(By.id("draggable"));
        target = Driver.get().findElement(By.id("droptarget"));
        actions.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(target)
                .pause(2000)
                .release()
                .perform();
    }
}
