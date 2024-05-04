import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * EconomicDatabase class that populates database, gets user input, sorts, and prints out data
 * @author Alex Ru
 * @version 05.12.24
 * I ADDED AN EXTRA BY ACCIDENT
 * Check getSearchCriteria and CountryComparator
 */
public class EconomicDatabase {
    private ArrayList<Country> database;
    private final ArrayList<String> categories = new ArrayList<>(Arrays.asList("NA", "RE", "YR", "OS", "PR", "GI", "JE", "TB", "GS", "FH", "BF", "LF", "MF", "TF", "IF", "FF"));
    private CountryComparator myComparator;
    private String primarySort, secondarySort;
    private boolean asc;

    /**
     * Default constructor
     */
    public EconomicDatabase() {
        database = new ArrayList<>();
        myComparator = new CountryComparator();
        primarySort = "";
        secondarySort = "";
    }

    /**
     * Populates database with countries from IEF_2024_data.csv
     */
    public void populateDatabase() {
        Scanner in;
        try {
            in = new Scanner(new File("IEF_2024_data.csv"));
            String[] line;
            while(in.hasNextLine()) {
                line = in.nextLine().split(",");
                database.add(new Country(line));
            }
            in.close();
        } catch(Exception e) { e.printStackTrace(); }
    }

    /**
     * Get search categories, asc, and store into fields
     * @return true if successful and false if quit
     */
    public boolean getSearchCriteria() {
        Scanner in = new Scanner(System.in);
        String asc;
        String ssort;
        boolean primary = true;

        System.out.print("*** Welcome to the World Economic Freedom Database ***\n" +
                "+ Menu of search terms to use for sorting countries +\n" +
                "\tNA: Country Name\n" +
                "\tRE: Region\n" +
                "\tYR: Year\n" +
                "\tOS: Overall Score\n" +
                "\tIN: Specific Index\n");
        System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
        primarySort = in.nextLine().toUpperCase();
        if(primarySort.equals("Q") || !(primarySort.equals("NA") || primarySort.equals("RE") || primarySort.equals("YR") || primarySort.equals("OS") || primarySort.equals("IN"))) return false;
        System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
        asc = in.nextLine().toUpperCase();
        if(asc.equals("A")) this.asc = true;
        else if(asc.equals("D")) this.asc = false;
        else return false;
        if(primarySort.equals("IN")) {
            System.out.print("\nSearch term selected specific index, please select the index value to display:\n" +
                    "\tPR: Property Rights\n" +
                    "\tGI: Government Integrity\n" +
                    "\tJE: Judicial Effectiveness\n" +
                    "\tTB: Tax Burden\n" +
                    "\tGS: Government Spending\n" +
                    "\tFH: Fiscal Health\n" +
                    "\tBF: Business Freedom\n" +
                    "\tLF: Labor Freedom\n" +
                    "\tMF: Monetary Freedom\n" +
                    "\tTF: Trade Freedom\n" +
                    "\tIF: Investment Freedom\n" +
                    "\tFF: Financial Freedom\n");
            System.out.print("Enter your preferred sort by index or 'Q' to quit: ");
            secondarySort = in.nextLine().toUpperCase();
            ArrayList<String> options = new ArrayList<>(Arrays.asList("PR", "GI", "JE", "TB", "GS", "FH", "BF", "LF", "MF", "TF", "IF", "FF"));
            if(secondarySort.equals("Q") || !options.contains(secondarySort)) return false;
            primary = false;
        }

        // EXTRA THAT I MADE ACCIDENTALLY BECAUSE I DIDN'T UNDERSTAND THE GUIDELINES
        // I DON'T WANT TO DELETE MY HARD WORK
        // I thought that secondary sort meant how to sort countries if they have the same value for the primary category
        String sort = (primary) ? primarySort : secondarySort;
        System.out.print("Enter 'Y' if you want to add a secondary sort category and 'N' if not: ");
        String secondary = in.nextLine().toUpperCase();
        if(secondary.equals("Y")) {
            System.out.print("+ Menu of search terms to use for sorting countries +\n" +
                    "\tNA: Country Name\n" +
                    "\tRE: Region\n" +
                    "\tYR: Year\n" +
                    "\tOS: Overall Score\n" +
                    "\tIN: Specific Index\n" +
                    "\tPR: Property Rights\n" +
                    "\tGI: Government Integrity\n" +
                    "\tJE: Judicial Effectiveness\n" +
                    "\tTB: Tax Burden\n" +
                    "\tGS: Government Spending\n" +
                    "\tFH: Fiscal Health\n" +
                    "\tBF: Business Freedom\n" +
                    "\tLF: Labor Freedom\n" +
                    "\tMF: Monetary Freedom\n" +
                    "\tTF: Trade Freedom\n" +
                    "\tIF: Investment Freedom\n" +
                    "\tFF: Financial Freedom\n");
            System.out.print("Enter your preferred secondary sort by index or leave blank for default (name): ");
            ssort = in.nextLine();
            if(ssort.isEmpty()) ssort = "NA";
            if(categories.contains(ssort)) {
                myComparator = new CountryComparator(this.asc, categories.indexOf(sort), categories.indexOf(ssort));
                return true;
            }
            else return false;
        }
        else if(secondarySort.equals("N")) {
            myComparator = new CountryComparator(this.asc, categories.indexOf(sort));
            return true;
        }
        else return false;
    }

    /**
     * Sorts database based on sort categories
     */
    public void sortDB() {
        MergeSort mySorter = new MergeSort(database, myComparator);
        mySorter.sort(database, 0, database.size() - 1);
    }

    /**
     * Prints each country in database
     */
    public void printDatabase() {
        for(Country country : database) {
            System.out.print(country);
            if(!secondarySort.isEmpty()) System.out.println(country.getDataValue(categories.indexOf(secondarySort)));
            else System.out.println();
        }
    }

    /**
     * Main entry point of EconomicDatabase class
     * @param args command line arguments if necessary
     */
    public static void main(String[] args) {
        EconomicDatabase db = new EconomicDatabase();
        db.populateDatabase();

        while (db.getSearchCriteria()) {
            db.sortDB();
            db.printDatabase();
        }
    }
}
