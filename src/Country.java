/**
 * Country class that holds data of country
 * @author Alex Ru
 * @version 05.05.24
 */
public class Country {
    private String name, region;
    private int year;
    private double overallScore, propertyRights, governmentIntegrity, judicialEffectiveness, taxBurden, governmentSpending, fiscalHealth, businessFreedom, laborFreedom, monetaryFreedom, tradeFreedom, investmentFreedom, financialFreedom;
    private String[] data;

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
     * Constructor for class Country
     * @param name name
     * @param region region
     * @param year year
     * @param overallScore overall score
     * @param propertyRights property rights
     * @param governmentIntegrity government integrity
     * @param judicialEffectiveness judicial effectiveness
     * @param taxBurden tax burden
     * @param governmentSpending government spending
     * @param fiscalHealth fiscal health
     * @param businessFreedom business freedom
     * @param laborFreedom labor freedom
     * @param monetaryFreedom monetary freedom
     * @param tradeFreedom trade freedom
     * @param investmentFreedom investment freedom
     * @param financialFreedom financial freedom
     */
    public Country(String name, String region, int year, double overallScore, double propertyRights, double governmentIntegrity, double judicialEffectiveness, double taxBurden, double governmentSpending, double fiscalHealth, double businessFreedom, double laborFreedom, double monetaryFreedom, double tradeFreedom, double investmentFreedom, double financialFreedom) {
        this.name = name;
        this.region = region;
        this.year = year;
        this.overallScore = overallScore;
        this.propertyRights = propertyRights;
        this.governmentIntegrity = governmentIntegrity;
        this.judicialEffectiveness = judicialEffectiveness;
        this.taxBurden = taxBurden;
        this.governmentSpending = governmentSpending;
        this.fiscalHealth = fiscalHealth;
        this.businessFreedom = businessFreedom;
        this.laborFreedom = laborFreedom;
        this.monetaryFreedom = monetaryFreedom;
        this.tradeFreedom = tradeFreedom;
        this.investmentFreedom = investmentFreedom;
        this.financialFreedom = financialFreedom;
    }

    /**
     * Get name of Country
     * @return name of Country
     */
    public String getName() { return name; }
    /**
     * Get region of Country
     * @return region of Country
     */
    public String getRegion() { return region; }
    /**
     * Get year of Country
     * @return year of Country
     */
    public int getYear() { return year; }
    /**
     * Get overall score of Country
     * @return overall score of Country
     */
    public double getOverallScore() { return overallScore; }
    /**
     * Get property rights of Country
     * @return property rights of Country
     */
    public double getPropertyRights() { return propertyRights; }
    /**
     * Get government integrity of Country
     * @return government integrity of Country
     */
    public double getGovernmentIntegrity() { return governmentIntegrity; }
    /**
     * Get judicial effectiveness of Country
     * @return judicial effectiveness of Country
     */
    public double getJudicialEffectiveness() { return judicialEffectiveness; }
    /**
     * Get tax burden of Country
     * @return tax burden of Country
     */
    public double getTaxBurden() { return taxBurden; }
    /**
     * Get government spending of Country
     * @return government spending of Country
     */
    public double getGovernmentSpending() { return governmentSpending; }
    /**
     * Get fiscal health of Country
     * @return fiscal health of Country
     */
    public double getFiscalHealth() { return fiscalHealth; }
    /**
     * Get business freedom of Country
     * @return business freedom of Country
     */
    public double getBusinessFreedom() { return businessFreedom; }
    /**
     * Get labor freedom of Country
     * @return labor freedom of Country
     */
    public double getLaborFreedom() { return laborFreedom; }
    /**
     * Get monetary freedom of Country
     * @return monetary freedom of Country
     */
    public double getMonetaryFreedom() { return monetaryFreedom; }
    /**
     * Get trade freedom of Country
     * @return trade freedom of Country
     */
    public double getTradeFreedom() { return tradeFreedom; }
    /**
     * Get investment freedom of Country
     * @return investment freedom of Country
     */
    public double getInvestmentFreedom() { return investmentFreedom; }
    /**
     * Get financial freedom of Country
     * @return financial freedom of Country
     */
    public double getFinancialFreedom() { return financialFreedom; }

    public String[] getData() { return data; }

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
        return name + " " + region + " " + year + " " + overallScore;
    }
}
