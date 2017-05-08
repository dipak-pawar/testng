package test.configurationfailurepolicy;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassWithFailedBeforeMethodAndAfterMethodWithAlwaysRunTrue {

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

    @AfterMethod(alwaysRun = true)
    public void tearDownShouldCall() {
        tearDown = true;
    }

    // alwaysRun won't work for groups from documentation. Used it to test this functionality.
    @AfterGroups(groups = "group1", alwaysRun = true)
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
