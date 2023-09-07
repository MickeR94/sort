import java.util.Random;

//Denna hade läraren angett. Använd den istället för Benchmark klassen
//Flytta över main till vanliga main metoden
//Unsorterd och sorted array är klara, jobba på binary search från nu

class Bench {

    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            LinearSearch.search(array, indx[i]);
        }
    }
    

   private static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	   BinarySearch.binarySearch(array, indx[i]);
	    }
    }


    /*private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }
        return array;
    }*/


    private static int[] keys(int loop, int n) {
        Random rnd = new Random();
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }
        return indx;
    }


    public static void main(String[] arg) {

        int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%20s%20s%20s\n", "n", "linear sorted", "linear unsorted", "binary search");
        for ( int n : sizes) {

            int loop = 10000;

            int[] array = LinearSearch.randomSorted(n);
            int[] arrayUnsorted = LinearSearch.randomUnsorted(n);
            int[] indx = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%20.0f", (min/loop));

	    min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		    long t0 = System.nanoTime();
		    linear(arrayUnsorted, indx);
		    long t1 = System.nanoTime();
		    double t = (t1 - t0);
		    if (t < min)
		        min = t;
	        }

	    System.out.printf("%20.0f" , (min/loop));

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%20.0f\n", (min/loop));
        }
    }
}