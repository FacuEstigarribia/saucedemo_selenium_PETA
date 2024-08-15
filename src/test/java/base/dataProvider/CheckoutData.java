package base.dataProvider;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CheckoutData {

    @DataProvider(name = "checkOutData")
    public Object[][] readCsv() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/data/checkOutData.csv"),';');
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject=new Object[csvData.size()][4];
        for (int i=0;i<csvData.size();i++) {
            csvDataObject[i]=csvData.get(i);
        }
        return  csvDataObject;
    }
}
