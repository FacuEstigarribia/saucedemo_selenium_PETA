package base.dataProvider;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ItemsData {
    @DataProvider(name = "itemsDetail")
    public static Object[][] readCsv() throws IOException {
        String csvFile = System.getProperty("user.dir") + "/src/test/resources/data/itemsData.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> allRows = csvReader.readAll();
//            // Opcional: Si el CSV tiene encabezados, salta la primera línea
//            if (!allRows.isEmpty() && allRows.get(0).length > 0 && allRows.get(0)[0].equals("ProductName")) {
//                allRows.remove(0);
//            }
            // Convert List<String[]> to Object[][]
            Object[][] data = new Object[1][];
            data[0] = new Object[]{allRows.stream().map(row -> row[0]).toArray(String[]::new)};
            return data;
        }
    }
}
