import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.saucedemo.selenium.utils.PageUtils;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.Assert.*;
public class PageTest extends BaseTest {

    @Test
    public void testAllElementsPresent() {
        List<WebElement> elements = getDriver().findElements(By.className("expected-class"));

        // Verificar si todos los elementos tienen texto esperado
        boolean allElementsHaveText = PageUtils.verifyElementsPresent(elements,
                element -> !element.getText().isEmpty());

        assertTrue(allElementsHaveText, "Not all elements have the expected text.");
    }

    @Test
    public void testCountElements() {
        List<WebElement> elements = getDriver().findElements(By.className("form_group"));

        // Count how many element has a specific class
        long count = PageUtils.countElements(elements,
                element -> element.getAttribute("class").contains("form_group"));

        assertEquals(count, 5, "The count of elements with the expected class is incorrect.");
    }
}
