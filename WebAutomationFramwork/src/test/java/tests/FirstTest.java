package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;

public class FirstTest extends BaseTest {

    private FirstPage page;

    @BeforeMethod
    public void beforeMethod(){
        page = new FirstPage(driver);
    }

    @Test
    public void first_test(){
        visit(getData("url"));
        page.clickOnElement();
    }
}
