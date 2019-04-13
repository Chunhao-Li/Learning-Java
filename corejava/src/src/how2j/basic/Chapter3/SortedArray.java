package how2j.basic.Chapter3;

import java.util.ArrayList;
import java.util.List;

public class SortedArray {

    public static void selectionSort(ArrayList<Integer> numbers) {
//        List<Integer> numbers = List.copyOf(numbers);
        for (int i = 0; i < numbers.size()-1; i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                if (numbers.get(j) < numbers.get(i)) {
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(i));
                    numbers.set(i,tmp);
                }
            }
        }

//        return numbers;
    }

    public static void bubleSort(ArrayList<Integer> numbers) {
//        List<Integer> numbers = List.copyOf(numbers);
        for (int i =0; i < numbers.size(); i++) {
            for (int j = 0; j+1 < numbers.size()-i; j++) {
                if (numbers.get(j) > numbers.get(j+1)) {
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(j+1));
                    numbers.set(j+1,tmp);
                }
            }
        }
//        return numbers;
    }


    public static void main(String[] args) {
        int a [] = new int[]{18,62,68,82,65,9};


        // use selection to sort a
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }

        int count = a.length;
        //
        for (int i =0; i < a.length; i++) {
            for (int j = 0; j+1 < a.length-i; j++) {
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
        for (int i =0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    }

