package test.configurationfailurepolicy;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassWithFailedBeforeMethodAndAfterMethodAfterGroup {

    private static boolean tearDown;
    private static boolean afterGroup;

    @BeforeClass
    public void beforeClass() {
        tearDown = false;
        afterGroup = false;
    }

    @BeforeMethod
    public void setupShouldFail() {
        throw new RuntimeException("Failing in setUp");
    }

    @Test(groups = "group1")
    public void test1() {

    }

    @AfterMethod
    public void tearDownShouldCall() {
        tearDown = true;
    }

    @AfterGroups(groups = "group1")
    public void afterGroup() {
        afterGroup = true;
    }

    static boolean afterMethodSuccess() {
        return tearDown;
    }

    static boolean afterGroupSuccess() {
        return afterGroup;
    }
}
