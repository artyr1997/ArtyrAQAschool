package lesson04;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "MyDataProvider", parallel = true)
    public  Object [][] aDataprovider(){
        return new Object[][]{
                {"fisrt"},
                {"second"}
        };
    }

    @Test(dataProvider = "MyDataProvider", threadPoolSize = 3)
    public void aSimpleTest (String param){
        System.out.println(param);
    }

}
