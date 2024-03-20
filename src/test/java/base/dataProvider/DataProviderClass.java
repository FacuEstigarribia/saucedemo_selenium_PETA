package base.dataProvider;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class DataProviderClass {

    @DataProvider(name = "searchProvider")
    public static Object[][] readCsv(Method m) throws IOException {
        String login = "loginData.csv";
        String checkout = "checkOutData.csv";
        CSVReader csvReader;

        if(m.getName().equalsIgnoreCase("testLogin")){
            csvReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/" +login ),';');
        }else {
            csvReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/" + checkout ),';');
        }

        List<String[]> csvData=csvReader.readAll();
        Object[][] csvDataObject=new Object[csvData.size()][3];
        for (int i=0;i<csvData.size();i++) {
            csvDataObject[i]=csvData.get(i);
        }

        return  csvDataObject;
    }
}
