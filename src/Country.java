/**
 * Country class that holds data of country
 * @author Alex Ru
 * @version 05.12.24
 */
public class Country {
    private String name, region;
    private int year;
    private double overallScore, propertyRights, governmentIntegrity, judicialEffectiveness, taxBurden, governmentSpending, fiscalHealth, businessFreedom, laborFreedom, monetaryFreedom, tradeFreedom, investmentFreedom, financialFreedom;
    private String[] data;

    /**
     * Parameterized constructor
     * @param data list of data
     */
    public Country(String[] data) {
        this.data = data;
        name = data[0];
        region = data[1];
        year = Integer.parseInt(data[2]);
        overallScore = Double.parseDouble(data[3]);
        propertyRights = Double.parseDouble(data[4]);
        governmentIntegrity = Double.parseDouble(data[5]);
        judicialEffectiveness = Double.parseDouble(data[6]);
        taxBurden = Double.parseDouble(data[7]);
        governmentSpending = Double.parseDouble(data[8]);
        fiscalHealth = Double.parseDouble(data[9]);
        businessFreedom = Double.parseDouble(data[10]);
        laborFreedom = Double.parseDouble(data[11]);
        monetaryFreedom = Double.parseDouble(data[12]);
        tradeFreedom = Double.parseDouble(data[13]);
        investmentFreedom = Double.parseDouble(data[14]);
        financialFreedom = Double.parseDouble(data[15]);
    }

    /**
     * Copy constructor
     * @param other other Country object to copy
     */
    public Country(Country other) {
        this.name = other.name;
        this.region = other.region;
        this.year = other.year;
        this.overallScore = other.overallScore;
        this.propertyRights = other.propertyRights;
        this.governmentIntegrity = other.governmentIntegrity;
        this.judicialEffectiveness = other.judicialEffectiveness;
        this.taxBurden = other.taxBurden;
        this.governmentSpending = other.governmentSpending;
        this.fiscalHealth = other.fiscalHealth;
        this.businessFreedom = other.businessFreedom;
        this.laborFreedom = other.laborFreedom;
        this.monetaryFreedom = other.monetaryFreedom;
        this.tradeFreedom = other.tradeFreedom;
        this.investmentFreedom = other.investmentFreedom;
        this.financialFreedom = other.financialFreedom;
        this.data = other.data;
    }

    /**
     * Get specific data value
     * @param index index of value to return
     * @return specific data value
     */
    public String getDataValue(int index) { return data[index]; }

    /**
     * Checks if country is equal to other country based on name
     * @param other other object to check
     * @return if equal
     */
    public boolean equals(Object other) {
        if(other instanceof Country) {
            Country otherCountry = (Country) other;
            return otherCountry.name.equals(this.name);
        }
        return false;
    }

    /**
     * toString method
     * @return this Country as a string
     */
    public String toString() {
        return name + " " + region + " " + year + " " + overallScore + " ";
    }
}
