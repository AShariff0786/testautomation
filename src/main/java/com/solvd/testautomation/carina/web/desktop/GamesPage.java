package com.solvd.testautomation.carina.web.desktop;

import com.solvd.testautomation.carina.web.common.GamesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = GamesPageBase.class)
public class GamesPage extends GamesPageBase{

    @FindBy(xpath = "//section[@class=\"GameDatePicker_gdp__6oMVv\"]")
    private ExtendedWebElement calendar;
    public GamesPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(calendar);
        setPageURL("/games");
    }


}
