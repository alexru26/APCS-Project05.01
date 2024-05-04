import java.util.Comparator;

/**
 * CountryComparator class that helps compare two different Country objects
 * @author Alex Ru
 * @version 05.12.24
 */
public class CountryComparator implements Comparator<Country> {
    private final boolean asc;
    private final int primaryCategoryTerm;
    private final int secondaryCategoryTerm;

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
     */
    public CountryComparator(boolean asc, int pTerm) {
        this.asc = asc;
        this.primaryCategoryTerm = pTerm;
        secondaryCategoryTerm = 0;
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
            String name1 = o1.getDataValue(0);
            String name2 = o2.getDataValue(0);
            if(name1.startsWith("The")) name1 = name1.substring(4);
            if(name2.startsWith("The")) name2 = name1.substring(4);
            res = (asc) ? name1.compareTo(name2) : -name1.compareTo(name2);
        }
        else if(primaryCategoryTerm == 1) {
            res = (asc) ? o1.getDataValue(1).compareTo(o2.getDataValue(1)) : -o1.getDataValue(1).compareTo(o2.getDataValue(1));
        }
        else {
            d1 = Double.valueOf(o1.getDataValue(primaryCategoryTerm));
            d2 = Double.valueOf(o2.getDataValue(primaryCategoryTerm));
            res = (asc) ? d1.compareTo(d2) : -d1.compareTo(d2);
        }
        if(res != 0) return res;
        // THIS IS MY EXTRA WHERE I USE MY SECONDARY CATEGORY TERM TO SORT COUNTRIES WITH SAME PRIMARY VALUE
        else {
            if(secondaryCategoryTerm == 0) {
                String name1 = o1.getDataValue(0).replace("The ", "");
                String name2 = o2.getDataValue(0).replace("The ", "");
                return (asc) ? name1.compareTo(name2) : -name1.compareTo(name2);
            }
            else if(secondaryCategoryTerm == 1) {
                return (asc) ? o1.getDataValue(1).compareTo(o2.getDataValue(1)) : -o1.getDataValue(1).compareTo(o2.getDataValue(1));
            }
            else {
                d1 = Double.valueOf(o1.getDataValue(secondaryCategoryTerm));
                d2 = Double.valueOf(o2.getDataValue(secondaryCategoryTerm));
                return (asc) ? d1.compareTo(d2) : -d1.compareTo(d2);
            }
        }
    }
}
