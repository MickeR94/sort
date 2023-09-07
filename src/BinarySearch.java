public class BinarySearch {
    public static boolean binarySearch(int [] array,int key) {
        int first = 0; //första index in arrayen --> första "sidan" i telefonboken
        int last = array.length - 1; //sista sidan i arrayen
        while(true) {
            //jump to the middle
            int index = (first + last)/2;

            if(array[index] == key) {
                //System.out.println("Key found!");
                return true;
            }

            else if(array[index] < key && index < last) {
                //The indexposition holds something that is less than we're looking for,
                //so this should become our new first page
                //first = array[index]; felaktig uppdatering av första pos. 6/9
                first = index + 1;
            }
            else if(array[index] > key && index > first) {
                //The indexposition holds something that is more than we're looking for,
                //so this should become our new last page
                last = index - 1;
            }
            // Why do we land here? What should we do?
            else {
                //System.out.println("Key was not found");
                return false;
            }
        }

    }
}