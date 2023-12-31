package com.solvd.testautomation.carina.web.mobile;

import com.solvd.testautomation.carina.web.common.PlayerPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PlayerPageBase.class)
public class PlayerPage extends PlayerPageBase {

    public PlayerPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

}
