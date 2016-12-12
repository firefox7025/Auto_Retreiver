package processing;

import com.google.gson.Gson;
import domain.Company;
import domain.Resource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Xander on 12/11/2016.
 */
public class Download {

    public Download(Resource resource) throws IOException, URISyntaxException {
        CsvtoJson convertor = new CsvtoJson(resource.getUrl());
        File f = convertor.getReturned_file();

        Gson buildCompany = new Gson();
        Company[] founderArray = buildCompany.fromJson(readFile(f.getPath(), Charset.defaultCharset()), Company[].class);
        for(Company c : founderArray){
            System.out.println(c);
        }

    }


    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
