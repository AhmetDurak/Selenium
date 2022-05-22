package com.Intro;


import org.testng.Assert;
import org.testng.annotations.*;


public class TestNG_Intro {
    @BeforeClass
    public void setUpClass(){
        // It runs once before all test
    }
    @AfterClass
    public void TearDownClass(){
        // It runs once after all test
    }
    @AfterMethod // It runs after every test
    public void tearDown(){
        System.out.println("After Method");
    }

    @BeforeMethod  // It runs before every test
    public void setUpMethod(){
        System.out.println("Before Method");
    }
    @Test
    public void test0(){
        //assertTrue(true);
        //assertEquals(1, 1);
        //Assert.fail();

        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void test1(){
        System.out.println("Test1");
        //Assert.fail();
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }




}
