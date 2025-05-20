package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPageObjects {
    @FindBy(name = "q")
    public WebElement searchBox;

    public GoogleSearchPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}