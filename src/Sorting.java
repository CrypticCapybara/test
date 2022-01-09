import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class Sorting {
    private static final int size = 75000;
    private static final int range = 1000;

    public static void main(String[] args) {
        //bubble sort
        Integer[] unsortedBubble = getRandomNumbers();
        //System.out.println("unsorted array: "+ Arrays.toString(unsortedBubble));
        bubbleSort(unsortedBubble);
        //System.out.println("bubble sorted array: "+Arrays.toString(unsortedBubble));

        //selection sort
        Integer[] unsortedSelection = getRandomNumbers();
        //System.out.println("\nunsorted array: "+Arrays.toString(unsortedSelection));
        Integer[] sortedSelection = selectionSort(unsortedSelection);
        //System.out.println("selection sorted array: "+Arrays.toString(sortedSelection));


    }

    private static Integer[] selectionSort(Integer[] unsorted){
        int count = 0;
        System.out.print("selection sort \nloading");
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
        System.out.print("Bubble sort \nloading");
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
