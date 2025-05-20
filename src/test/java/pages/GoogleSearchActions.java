package pages;

import org.openqa.selenium.WebDriver;
import pageobjects.GoogleSearchPageObjects;

public class GoogleSearchActions {
    private WebDriver driver;
    private GoogleSearchPageObjects pageObjects;

    public GoogleSearchActions(WebDriver driver) {
        this.driver = driver;
        this.pageObjects = new GoogleSearchPageObjects(driver);
    }

    public void enterSearchTerm(String term) {
        pageObjects.searchBox.sendKeys(term);
        pageObjects.searchBox.submit();
    }
}