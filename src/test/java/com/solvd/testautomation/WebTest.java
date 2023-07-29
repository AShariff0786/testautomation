package com.solvd.testautomation;

import com.solvd.testautomation.carina.web.common.AllPlayersPageBase;
import com.solvd.testautomation.carina.web.common.GamesPageBase;
import com.solvd.testautomation.carina.web.common.HomePageBase;
import com.solvd.testautomation.carina.web.common.LoginPageBase;
import com.solvd.testautomation.carina.web.common.NewsPageBase;
import com.solvd.testautomation.carina.web.common.PlayerPageBase;
import com.solvd.testautomation.carina.web.common.ProfilePageBase;
import com.solvd.testautomation.carina.web.common.SpecificTeamPageBase;
import com.solvd.testautomation.carina.web.common.TeamsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.report.testrail.TestRailCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


@MethodOwner(owner = "AShariff0786")
public class WebTest implements IAbstractTest {


    @BeforeTest
    @Test(testName = "Test Login" , description = "Test the ability to login to a web page.")
    public void testLogin(){
        HomePageBase homePage =  initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        //checks if user is already logged in
        List<WebElement> loginButton = getDriver().findElements(By.xpath("//a[@href='/account/sign-in']"));
        if(loginButton.size() > 0) {
            LoginPageBase loginPage = homePage.openLoginPage();
            loginPage.assertPageOpened();
            homePage = loginPage.login();
            homePage.assertPageOpened();
        }

        ProfilePageBase profilePage = homePage.openProfilePage();
        profilePage.assertPageOpened();
    }

    @Test(testName = "Test Games Page" , description = "Test ability to get to Games page from home page.")
    public void testGamesPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        GamesPageBase gamesPageBase = homePage.openGamesPage();
        gamesPageBase.assertPageOpened();
    }

    @Test(testName = "Test Team Page" , description = "Checks the ability to goto a specific team page.")
    public void testTeamPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        TeamsPageBase teamsPageBase = homePage.openTeamsPage();
        teamsPageBase.assertPageOpened();

        SpecificTeamPageBase knicks = teamsPageBase.openSpecificTeam("knicks");
        knicks.assertPageOpened();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(knicks.readTeamName(), "New York Knicks");

        SpecificTeamPageBase warriors = teamsPageBase.openSpecificTeam("nets");
        warriors.assertPageOpened();
        softAssert.assertEquals(warriors.readTeamName(), "Brooklyn Nets");

    }

    @Test(testName = "Test News Page" , description = "Checks Latest News and Display News Related to Searched Term")
    public void testNewsPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        NewsPageBase newsPage = homePage.openNewsPage();
        newsPage.assertPageOpened();
        newsPage.openSearchedNews("Pelicans");
    }

    @Test(testName = "Test Specific Player Page" , description = "Checks Stats of the Searched Player")
    public void testSpecificPlayerPage(){
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        homePage.assertPageOpened();

        AllPlayersPageBase allPlayersPage = homePage.openAllPlayersPage();
        allPlayersPage.assertPageOpened();

        PlayerPageBase curryPage = allPlayersPage.openSpecificPlayer("curry");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(curryPage.readName(), "Seth");

    }

}
