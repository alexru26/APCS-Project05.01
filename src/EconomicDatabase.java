import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * EconomicDatabase class that populates database, gets user input, sorts, and prints out data
 * @author Alex Ru
 * @version 05.05.24
 */
public class EconomicDatabase {
    private ArrayList<Country> database;
    private ArrayList<String> categories = new ArrayList<>(Arrays.asList("NA", "RE", "YR", "OS", "PR", "GI", "JE", "TB", "GS", "FH", "BF", "LF", "MF", "TF", "IF", "FF"));
    private double[] indices;
    private CountryComparator myComparator;
    private String primarySort, secondarySort;
    private boolean asc;
    //private String[] ;
    private String[] secondaryTerms;

    /**
     * Default constructor
     */
    public EconomicDatabase() {
        database = new ArrayList<>();
        myComparator = new CountryComparator();
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
//                database.add(new Country(line[0], line[1],
//                        Integer.parseInt(line[2]),
//                        Double.parseDouble(line[3]),
//                        Double.parseDouble(line[4]),
//                        Double.parseDouble(line[5]),
//                        Double.parseDouble(line[6]),
//                        Double.parseDouble(line[7]),
//                        Double.parseDouble(line[8]),
//                        Double.parseDouble(line[9]),
//                        Double.parseDouble(line[10]),
//                        Double.parseDouble(line[11]),
//                        Double.parseDouble(line[12]),
//                        Double.parseDouble(line[13]),
//                        Double.parseDouble(line[14]),
//                        Double.parseDouble(line[15]))
//                );
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
        String sort;
        String asc;
        String ssort;

        System.out.print("*** Welcome to the World Economic Freedom Database ***\n" +
                "+ Menu of search terms to use for sorting countries +\n" +
                "\tNA: Country Name\n" +
                "\tRE: Region\n" +
                "\tYR: Year\n" +
                "\tOS: Overall Score\n" +
                "\tIN: Specific Index\n");
        while(true) {
            System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
            sort = in.nextLine();
            if(sort.equals("Q")) return false;
            if(sort.equals("NA") || sort.equals("RE") || sort.equals("YR") || sort.equals("OS") || sort.equals("IN")) break;
        }
        if(sort.equals("IN")) {
            while(true) {
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
                sort = in.nextLine();
                String[] options = {"PR", "GI", "JE", "TB", "GS", "FH", "BF", "LF", "MF", "TF", "IF", "FF"};
                if(sort.equals("Q")) return false;
                else if(Arrays.asList(options).contains(sort)) break;
            }
        }
        if(categories.contains(sort)) {
            primarySort = sort;
        }
        else return false;

        while(true) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            asc = in.nextLine();
            if(asc.equals("A")) {
                this.asc = true;
                break;
            }
            else if(asc.equals("D")) {
                this.asc = false;
                break;
            }
        }

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
        while(true) {
            System.out.print("Enter your preferred secondary sort by index or leave blank for default (name): ");
            ssort = in.nextLine();
            if(sort.equals(ssort)) {
                continue;
            }
            else if(ssort.isEmpty() && !sort.equals("NA")) {
                secondarySort = "NA";
                return true;
            }
            else if(categories.contains(ssort)) {
                secondarySort = ssort;
                return true;
            }
        }

    }

    /**
     * Sorts database based on sort categories
     */
    public void sortDB() {
        myComparator = new CountryComparator(asc, categories.indexOf(primarySort), categories.indexOf(secondarySort));
        database.sort(myComparator);
    }

    /**
     * Prints each country in database
     */
    public void printDatabase() {
        for(Country country : database) {
            System.out.println(country);
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
