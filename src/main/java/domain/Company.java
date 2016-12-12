package domain;

import java.net.URL;

/**
 * Created by Xander on 12/11/2016.
 */
public class Company {

    String Symbol;
    String Name;
    String LastSale;
    String MarketCap;
    String ADR_TSO;
    String IPOyear;
    String Sector;
    String Industry;
    String Summary_Quote;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastSale() {
        return LastSale;
    }

    public void setLastSale(String lastSale) {
        LastSale = lastSale;
    }

    public String getMarketCap() {
        return MarketCap;
    }

    public void setMarketCap(String marketCap) {
        MarketCap = marketCap;
    }

    public String getADR_TSO() {
        return ADR_TSO;
    }

    public void setADR_TSO(String ADR_TSO) {
        this.ADR_TSO = ADR_TSO;
    }

    public String getIPOyear() {
        return IPOyear;
    }

    public void setIPOyear(String IPOyear) {
        this.IPOyear = IPOyear;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getIndustry() {
        return Industry;
    }

    public void setIndustry(String industry) {
        Industry = industry;
    }

    public String getSummary_Quote() {
        return Summary_Quote;
    }

    public void setSummary_Quote(String summary_Quote) {
        Summary_Quote = summary_Quote;
    }

    @Override
    public String toString() {
        return "Company{" +
                "Symbol='" + Symbol + '\'' +
                ", Name='" + Name + '\'' +
                ", LastSale='" + LastSale + '\'' +
                ", Industry='" + Industry + '\'' +
                '}';
    }
}
