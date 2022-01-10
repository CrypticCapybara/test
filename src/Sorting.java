import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Sorting {
    private static final int size = 100000;
    private static final int range = 1000;

    public static void main(String[] args) {
        //bubble sort
        Integer[] unsortedBubble = getRandomNumbers();
        //System.out.println("unsorted array: "+ Arrays.toString(unsortedBubble));
        bubbleSort(unsortedBubble);
        //System.out.println("bubble sorted array: "+Arrays.toString(unsortedBubble));
        Integer[] unsortedBubbleDemo = getRandomNumbers();
        bubbleSortDemo(unsortedBubbleDemo);

        //selection sort
//        Integer[] unsortedSelection = getRandomNumbers();
//        //System.out.println("\nunsorted array: "+Arrays.toString(unsortedSelection));
//        Integer[] sortedSelection = selectionSort(unsortedSelection);
//        //System.out.println("selection sorted array: "+Arrays.toString(sortedSelection));
//
//        //insertion sort
//        Integer[] unsortedInsertion = getRandomNumbers();
////        System.out.println("\nunsorted array: "+Arrays.toString(unsortedInsertion));
//        Integer[] sortedInsertion = insertionSort(unsortedInsertion);
//        System.out.println("insertion sorted array: "+Arrays.toString(sortedInsertion));


    }

    private static Integer[] insertionSort(Integer[] array) {
        int count = 0;
        System.out.print("insertion sort \n time complexity - best: O(n) worst: O(n^2) \nloading");
        Instant start = Instant.now();

        for (int i = 1; i < size; ++i) {
            count++;
            if(count == size/50) {
                System.out.print(".");
                count = 0;
            }

            Integer next = array[i];
            Integer currentIndex = i - 1;

            while(currentIndex >= 0 && array[currentIndex] > next){
                //shift right
                array[currentIndex+1] = array[currentIndex];
                currentIndex--;
            }
            array[currentIndex+1] = next;
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime Elapsed Insertion Sort: "+timeElapsed.getSeconds()+" seconds\n");
        return array;
    }
    private static Integer[] selectionSort(Integer[] unsorted){
        int count = 0;
        System.out.print("selection sort \n time complexity - best:O(n^2) worst: O(n^2) \nloading");
        Instant start = Instant.now();
        Integer[] sorted = new Integer[size];
        //iterate through unsorted, find minimum
        Integer minimum = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < size; i ++){
            count++;
            if(count == size/50) {
                System.out.print(".");
                count = 0;
            }
            for(int k = 0; k < size; k ++){
                if(unsorted[k] < minimum){
                    minimum = unsorted[k];
                    minIndex = k;
                }
            }
            unsorted[minIndex] = Integer.MAX_VALUE;
            sorted[i] = minimum;
            minimum = Integer.MAX_VALUE;
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime Elapsed Selection Sort: "+timeElapsed.getSeconds()+" seconds\n");
        return sorted;
    }

    private static void bubbleSort(Integer[] array){
        int count = 0;
        System.out.print("Bubble sort \n time complexity - best: O(n) worst: O(n^2) \nloading");
        Instant start = Instant.now();
        for(int k = 0; k < size; k++){
            count++;
            if(count == size/50) {
                System.out.print(".");
                count = 0;
            }
            for(int i = 1; i < size-k; i++){
                if(array[i-1] > array[i]){
                    //swap
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime Elapsed Bubble Sort: "+timeElapsed.getSeconds()+" seconds\n");
    }

    private static void bubbleSortDemo(Integer arr[]) {
        int count = 0;
        System.out.print("Bubble sort demo \n time complexity - best: O(n) worst: O(n^2) \nloading");
        Instant start = Instant.now();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            count++;
            if(count == size/50) {
                System.out.print(".");
                count = 0;
            }

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime Elapsed Bubble Sort: "+timeElapsed.getSeconds()+" seconds\n");
    }

    private static void bubbleSortReverse(Integer[] array){
        Instant start = Instant.now();
       for(int k = 0; k < size; k++){
            for(int i = 1; i < size-k; i++){
                if(array[i-1] < array[i]){
                    //swap
                    int temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time Elapsed Bubble Sort: "+timeElapsed.getSeconds());
    }


    public static Integer[] getRandomNumbers(){
        Random rand = new Random();
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = rand.nextInt(range);
        }
        return nums;
    }
}
