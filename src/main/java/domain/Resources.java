package domain;

import java.util.List;

/**
 * Created by Xander on 12/11/2016.
 */
public class Resources {

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    List<Resource> resources;

    @Override
    public String toString() {
        return "Resources{" +
                "resources=" + resources +
                '}';
    }
}
