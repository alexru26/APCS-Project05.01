import java.util.Comparator;

/**
 * CountryComparator class that helps compare two different Country objects
 * @author Alex Ru
 * @version 05.05.24
 */
public class CountryComparator implements Comparator<Country> {
    private boolean asc;
    private int primaryCategoryTerm;
    private int secondaryCategoryTerm;

    /**
     * Default constructor
     */
    public CountryComparator() {
        this.asc = true;
        this.primaryCategoryTerm = 0;
        this.secondaryCategoryTerm = 0;
    }

    /**
     * Parameterized constructor
     * @param asc default listing order
     * @param pTerm primary category sort term
     * @param sTerm secondary category sort term
     */
    public CountryComparator(boolean asc, int pTerm, int sTerm) {
        this.asc = asc;
        this.primaryCategoryTerm = pTerm;
        this.secondaryCategoryTerm = sTerm;
    }

    private void changePrimarySortCategory(int sortCategory) {
        this.primaryCategoryTerm = sortCategory;
    }

    /**
     * Returns -int if o1<o2, 0 if o1==o2, and +int if o1>o2
     * @param o1 the first object to be compared
     * @param o2 the second object to be compared
     * @return if o1 is less than, equal, or greater than o2
     */
    public int compare(Country o1, Country o2) {
        Double d1, d2;
        int res;
        if(primaryCategoryTerm == 0) {
            String name1 = o1.getData()[0];
            String name2 = o2.getData()[0];
            if(name1.startsWith("The")) name1 = name1.substring(4);
            if(name2.startsWith("The")) name2 = name1.substring(4);
            res = (asc) ? name1.compareTo(name2) : -name1.compareTo(name2);
        }
        else if(primaryCategoryTerm == 1) {
            res = (asc) ? o1.getData()[1].compareTo(o2.getData()[1]) : -o1.getData()[1].compareTo(o2.getData()[1]);
        }
        else {
            d1 = Double.valueOf(o1.getData()[primaryCategoryTerm]);
            d2 = Double.valueOf(o2.getData()[primaryCategoryTerm]);
            res = (asc) ? d1.compareTo(d2) : -d1.compareTo(d2);
        }
        if(res != 0) return res;
        else {
            if(secondaryCategoryTerm == 0) {
                String name1 = o1.getName().replace("The ", "");
                String name2 = o2.getName().replace("The ", "");
                return (asc) ? name1.compareTo(name2) : -name1.compareTo(name2);
            }
            else if(secondaryCategoryTerm == 1) {
                return (asc) ? o1.getData()[1].compareTo(o2.getData()[1]) : -o1.getData()[1].compareTo(o2.getData()[1]);
            }
            else {
                d1 = Double.valueOf(o1.getData()[secondaryCategoryTerm]);
                d2 = Double.valueOf(o2.getData()[secondaryCategoryTerm]);
                return (asc) ? d1.compareTo(d2) : -d1.compareTo(d2);
            }
        }
    }
        /*
        int diff;
        Double d1, d2;
        if(primaryCategoryTerm.equals("NA")) return (asc) ? o1.getName().compareTo(o2.getName()) : -o1.getName().compareTo(o2.getName());
        else if(primaryCategoryTerm.equals("RE")) {
            return (asc) ? o1.getRegion().compareTo(o2.getRegion()) : -o1.getRegion().compareTo(o2.getRegion());
        }
        d2 = switch (primaryCategoryTerm) {
            case "YR" -> {
                d1 = (double) o1.getYear();
                yield (double) o2.getYear();
            }
            case "OS" -> {
                d1 = o1.getOverallScore();
                yield o2.getOverallScore();
            }
            case "PR" -> {
                d1 = o1.getPropertyRights();
                yield o2.getPropertyRights();
            }
            case "GI" -> {
                d1 = o1.getGovernmentIntegrity();
                yield o2.getGovernmentIntegrity();
            }
            case "JE" -> {
                d1 = o1.getJudicialEffectiveness();
                yield o2.getJudicialEffectiveness();
            }
            case "TB" -> {
                d1 = o1.getTaxBurden();
                yield o2.getTaxBurden();
            }
            case "GS" -> {
                d1 = o1.getGovernmentSpending();
                yield o2.getGovernmentSpending();
            }
            case "FH" -> {
                d1 = o1.getFiscalHealth();
                yield o2.getFiscalHealth();
            }
            case "BF" -> {
                d1 = o1.getBusinessFreedom();
                yield o2.getBusinessFreedom();
            }
            case "LF" -> {
                d1 = o1.getLaborFreedom();
                yield o2.getLaborFreedom();
            }
            case "MF" -> {
                d1 = o1.getMonetaryFreedom();
                yield o2.getMonetaryFreedom();
            }
            case "TF" -> {
                d1 = o1.getTradeFreedom();
                yield o2.getTradeFreedom();
            }
            case "IF" -> {
                d1 = o1.getInvestmentFreedom();
                yield o2.getInvestmentFreedom();
            }
            case "FF" -> {
                d1 = o1.getFinancialFreedom();
                yield o2.getFinancialFreedom();
            }
            default -> throw new IllegalStateException("Unexpected value: " + primaryCategoryTerm);
        };
        diff = d1.compareTo(d2);
        return (asc) ? diff : -diff;
    }
    */
}
