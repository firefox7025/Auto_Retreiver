package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xander on 12/11/2016.
 */
public class Market {

    public List<Company> companies = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Market{" +
                "companies=" + companies +
                '}';
    }
}

