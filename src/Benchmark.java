public class Benchmark {
    public static boolean search_unsorted(int [] array, int key){
        for (int index = 0; index < array.length; index++){
            if (array[index] == key){
                return true;
            }
        }
        return false;
    }

    public static long timer(int [] array, int key, int iterations){
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            search_unsorted(array, key);
            long stopTime = System.nanoTime();
            totalTime += (stopTime - startTime);
        }
        return totalTime/iterations;
    }

}
