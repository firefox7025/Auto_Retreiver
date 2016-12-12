package processing;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Xander on 12/11/2016.
 */
public class CsvtoJson {

    public String path;
    public File returned_file;


    public File getReturned_file() {
        return returned_file;
    }


    public CsvtoJson(File input) throws IOException {
        List<Map<?, ?>> data = readObjectsFromCsv(input);
        File temp = File.createTempFile("temp-json", ".tmp");
        writeAsJson(data, temp);
        returned_file = temp;
    }

    public CsvtoJson(URL url) throws IOException {
        File f = File.createTempFile("tempfile" + System.currentTimeMillis(), ".temp");
        FileUtils.copyURLToFile(url, f);
        List<Map<?, ?>> data = readObjectsFromCsv(f);
        File temp = File.createTempFile("temp-file-name.json", ".tmp");
        f.delete();
        writeAsJson(data, temp);
        returned_file = temp;
    }

    private static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

        return mappingIterator.readAll();
    }

    private static void writeAsJson(List<Map<?, ?>> data, File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, data);
    }

}
