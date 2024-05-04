import java.util.ArrayList;

/**
 * MergeSort class that helps sort country list
 * @author Alex Ru
 * @version 05.12.24
 */
public class MergeSort {
    private static ArrayList<Country> temp = new ArrayList<>();
    private static CountryComparator comparator = new CountryComparator();

    /**
     * Parameterized constructor
     * @param arr array to sort
     * @param comparator how to compare
     */
    public MergeSort(ArrayList<Country> arr, CountryComparator comparator) {
        temp.addAll(arr);
        this.comparator = comparator;
    }

    /**
     * Recursively sort list from l to r index (inclusive)
     * @param arr array to sort
     * @param l start index
     * @param r end index
     */
    public void sort(ArrayList<Country> arr, int l, int r) {
        if(r-l <= 1) {
            if(r > l && comparator.compare(arr.get(r), arr.get(l)) < 0) {
                Country temp = new Country(arr.get(r));
                arr.set(r, arr.get(l));
                arr.set(l, temp);
            }
        }
        else {
            int mid = (l+r)/2;
            sort(arr, l, mid);
            sort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    /**
     * Merge two parts of array
     * @param arr array to undergo merging
     * @param l start index
     * @param m middle index
     * @param r right index
     */
    public void merge(ArrayList<Country> arr, int l, int m, int r) {
        int i = l, j = m+1, k = l;
        while(i <= m && j <= r) {
            if(comparator.compare(arr.get(i), arr.get(j)) < 0) {
                temp.set(k, arr.get(i++));
            }
            else {
                temp.set(k, arr.get(j++));
            }
            k++;
        }
        while(i <= m) {
            temp.set(k++, arr.get(i++));
        }
        while(j <= r) {
            temp.set(k++, arr.get(j++));
        }
        for(k = l; k <= r; k++) {
            arr.set(k, temp.get(k));
        }
    }
}
