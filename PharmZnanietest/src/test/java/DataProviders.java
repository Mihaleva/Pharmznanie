import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by mihaleva on 08.04.2016.
 */
public class DataProviders {
    @DataProvider(name = "LoginPass")
    public static Object[][] createData1() {
        return new Object[][]{
                {"9139875583", "105034"},
                {"4225339181", "qwerty"},
                // {  "7650227158", "qwerty"}
        };
    }

    @DataProvider(name = "Registration")
    public static Object[][] createData2() {
        return new Object[][]{
                {"Auto", "Test", "Paris", "qwerty", "qwerty@fg.yu", "Apt"},
                {"авто", "тест", "Москва", "qwerty", "qwerty@fg.yu", "!@#$%^&*()_+=-0/.,;:<> "},
                {"Auto авто", "Test тест", "Paris Москва", "qwerty", "qwerty@fg.yu", "аптека () \"fhfhf\" '1263729'"}
        };
    }

    @DataProvider(name = "ErrorLongRegistration")
    public static Object[][] createData3() {
        return new Object[][]{
                {"алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр", "алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр", "алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр", "алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр", "алалеалалегвдытарвдуоатвралалегвдеытарвдуоатвргвдытарвдуоатвр"}
        };
    }


    @DataProvider(name = "ErrorShortRegistration")
    public static Object[][] createData4() {
        return new Object[][]{
                {"a", "a", "a"},
                {"л", "л", "л"}
        };
    }

    @DataProvider(name = "ErrorRegistration")
    public static Object[][] createData5() {
        return new Object[][]{
                {"!@#$%^&*()_", "!@#$%^&*()_", "12345", "qwerty"},
                {"12345", "12345", "!@#$%^&*()_","12345"},
                {"12gfgds", "123fgd", "!@#кап$%^&*()_","!@#$%^"},
                {"12ывпыа5", "12авпва5", "!@#$dfhd%^&*()_","qwerty@"},
                {"12''//5", "12//''345", "!@#$453%^&*()_","qwerty fh@yh.f"},
                {"1вап2dghd2345", "123dfgыыа45", "!@#$%^&*()_","@ghd.gh"},
                {"1234sdg133#%#%'''/.,,5", "12dtr./';][po345", "!@#$%^&*()_","qwerty@gfh"},
        };
    }


    @DataProvider(name = "ErrorLoginPass")
    public static Object[][] createData6() {
        return new Object[][]{
                {"913987353", "qwertyuiop"},
                {"9139875583", "qwertytyu"},
                {"9139875583", ""},
                {"", "qwerty"},
                {"913987558", "qwerty"},
                {"913987558", "qwert"}
        };
    }


}
