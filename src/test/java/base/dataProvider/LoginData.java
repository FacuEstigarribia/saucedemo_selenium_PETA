package base.dataProvider;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.io.IOException;
import java.util.List;
public class LoginData {


    @DataProvider(name = "userDetails")
    public static Object[][] readCsv() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/loginData.csv"),';');
        List<String[]> csvData=csvReader.readAll();
        Object[][] csvDataObject=new Object[csvData.size()][3];
        for (int i=0;i<csvData.size();i++) {
            csvDataObject[i]=csvData.get(i);
        }
        return  csvDataObject;
    }


}
