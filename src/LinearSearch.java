import java.util.Random;

public class LinearSearch {

    //search method to go through an array looking for a specific key
    public static boolean search(int [] array, int key){
        for (int index = 0; index < array.length; index++){
            if (array[index] == key){
                return true;
            }
        }
        return false;
    }

    //generate a sorted array
    public static int[] randomSorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int index = 0; index < n ; index++) {
            nxt += rnd.nextInt(10) + 1;
            array[index] = nxt;
        }
        return array;
    }

    //generate random unsorted array
    public static int[] randomUnsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for (int index = 0; index < n ; index++) {

            array[index] = rnd.nextInt(5*n)+1;
        }
        return array;
    }
}