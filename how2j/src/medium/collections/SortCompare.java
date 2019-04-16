package medium.collections;

import java.util.Arrays;
import java.util.List;

public class SortCompare {

    interface Sort{
        void sort();
        int[] values();
    }

    static class SelectionSort implements Sort{
        int numbers[];
        SelectionSort(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void sort() {
            for (int j = 0; j < numbers.length; j++){
                for (int i = j+1; i < numbers.length; i++) {
                    if(numbers[i]<numbers[j]){
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            return numbers;
        }
    }

    static class BubblingSort implements Sort {
        int[] numbers;
        BubblingSort(int [] numbers){
            this.numbers = numbers;
        }
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length; j++) {
                for (int i = 0; i < numbers.length-j-1; i++) {
                    if(numbers[i]>numbers[i+1]){
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }
                }
            }
        }
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }

    }

    static class TreeSort implements Sort {
        int[] numbers;
        Node n;
        TreeSort(int[] numbers) {
            n = new Node();
            this.numbers = numbers;
        }
        @Override
        public void sort() {
            for (int i : numbers) {
                n.add(i);
            }
        }

        @Override
        public int[] values() {
            List<Object> list = n.values();
            int[] sortedNumbers = new int[list.size()];
            for (int i = 0; i < sortedNumbers.length; i++) {
                sortedNumbers[i] = (Integer) (list.get(i));
            }
            return sortedNumbers;
        }
    }

    private static int[] performance(Sort algorithm, String type) {
        long start = System.currentTimeMillis();
        algorithm.sort();
        int sortedNumbers[] = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("%s sorted method, costs %d milliseconds", type, end-start);
        System.out.println();
        return sortedNumbers;
    }


    public static void main(String[] args) {
        int total = 40000;
        System.out.println("Initial length " + total + " array of random numbers");
        int[] originalNumbers = new int[total];
        for (int i = 0; i < originalNumbers.length; i++) {
            originalNumbers[i] = (int) (Math.random()*total);
        }
        System.out.println("Initialisation finished");
        System.out.println("---------use three algorithms to sort------");
        int[] use4sort;

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersBySelection = performance(new SelectionSort(use4sort), "Selection sort");

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByBubbling = performance(new BubblingSort(use4sort),"Bubbling sort" );

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByTree = performance(new TreeSort(use4sort),"Tree sort" );

        System.out.println("Result: whether they are the same arrays");
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersByTree);

        System.out.println("Result: whether the contents are the same");
        System.out.println(Arrays.equals(sortedNumbersByBubbling, sortedNumbersBySelection));
        System.out.println(Arrays.equals(sortedNumbersBySelection,sortedNumbersByTree ));


    }
}
