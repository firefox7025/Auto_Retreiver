package main;

import com.google.gson.Gson;
import domain.Resource;
import domain.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import processing.Download;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EndPoints {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/_generatejson", method = RequestMethod.GET)
    public String reindex() throws MalformedURLException {
        final Gson gson = new Gson();
        List<Resource> resources = new ArrayList<>();
        Resource rone = new Resource();
        rone.setName("AMEX");
        rone.setUrl(new URL("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=AMEX&render=download"));
        resources.add(rone);

        Resource rtwo = new Resource();
        rtwo.setName("NYSE");
        rtwo.setUrl(new URL("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=NYSE&render=download"));
        resources.add(rtwo);

        Resource rthree = new Resource();
        rthree.setName("NASDAQ");
        rthree.setUrl(new URL("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=NASDAQ&render=download"));
        resources.add(rthree);

        Resources resources1 = new Resources();
        resources1.setResources(resources);

        return gson.toJson(resources1);
    }

    @RequestMapping(value = "/_generateobject", method = RequestMethod.GET)
    public Resources loadobject() {

        final Gson gson = new Gson();

        try {
            Resources resources = gson.fromJson(readFile("src/main/resources/resources.json", Charset.defaultCharset()), Resources.class);
            return resources;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Resources();

    }

    @RequestMapping(value = "/_parse", method = RequestMethod.GET)
    public void process() throws IOException, URISyntaxException {
        Resources loadobject = loadobject();
        for(Resource resource : loadobject.getResources()){
            new Download(resource);
        }
    }


    private static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}