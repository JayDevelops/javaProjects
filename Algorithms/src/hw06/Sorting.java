/*
* Methods:
*   All methods in the class will be implementations of the sorting algorithms introduced in the lecture notes, taken from pseudocode to real code.
*   Insertion Sort
*
*   Bubble Sort
*
*   Selection Sort
*
*   Merge Sort
*
*   Quick Sort
*
*   Counting Sort
*
*   Radix Sort
*
*
* */
package hw06;

import java.util.ArrayList;

public final class Sorting {

    //  Default constructor but no body
    private Sorting() { }


    //  insertionSort() inserts elements in the correct position
    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
        //  Get the list size and store it as an int below
        int size = list.size();

        //  Iterate through the list and do the insertion sort algorithm
        for (int i = 0; i < size; i++) {
            //  Store the temp variable
            E temp = list.get(i);
            int j = i;

            //  Come back to this one below
            while(j > 0 && temp.compareTo(list.get(j - 1)) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }

            //  Set the temp variable to the j place now
            list.set(j, temp);
        }
    }

    //  bubbleSort() will swap adjacent pairs until the list is sorted, this is the optimized algorithm
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
        //  Get the list size and store it as an int below
        int size = list.size();

        for (int i = 1; i < size - 1; i++) {
            boolean swapped = false;    //  Will keep track if elements have been swapped

            for (int j = 0; j < size - 2; j++) {
                //  Get the previous and next element of the array list below, simplifies if statement
                E currElem = list.get(j);
                E nextElem = list.get(j + 1);

                //  If the current element is greater than the next element then swap them
                if(currElem.compareTo(nextElem) > 0) {
                    list.set(j, nextElem);
                    list.set(j + 1, currElem);
                    swapped = true;
                }
            }

            //  If it's not swapped then break nested for loop
            if(!swapped) {
                break;
            }
        }
    }

    //  selectionSort() will find the minimum value then swap value with the current position until the whole list is sorted with the minimum values
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        //  Get the list size and store it as an int below
        int size = list.size();

        for (int i = 0; i < size - 1; i++) {
            int min = i;
            
            for (int j = i + 1; j < size; j++) {
                E minimumElem = list.get(min);  //  Get the minimum element
                E nextElem = list.get(j);   //  Get the next element to the minimum element

                if(nextElem.compareTo(minimumElem) < 0) {
                    min = j;    //  Set the minimum index to j
                }

                //  Set at index "i" with the minimum value now
                list.set(i, list.get(min));
            }
        }
    }

    //  mergeSort() will break up the middle from left to right lists and repeatedly do this and merge again with a sorted list
    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
        int mid;    //  Middle of the array as a number
        int listSize = list.size(); //  Get the list size of the passed array list

        if(listSize > 1) {
            //  If list size is greater than 1, then divide by half
            mid = (listSize - 1) / 2;
            ArrayList<E> leftList = new ArrayList<E>(); //  empty left list which will be populated

            //  Populate the left side of the list up until the middle
            for (int i = 0; i < mid + 1; i++) {
                leftList.add(list.get(i));
            }

            //  Use recursion to split up the left side until listSize is equal to 1
            mergeSort(leftList);


            //  Do the same thing with the right side now but after the middle
            ArrayList<E> rightList = new ArrayList<E>();

            //  Populate the right side of the list from the middle to the end
            for (int i = mid + 1; i < listSize; i++) {
                rightList.add(list.get(i));
            }

            //  Use recursion to split up the right side until the listSize is equal to 1
            mergeSort(rightList);

            //  Finally, merge the entire array again below
            merge(leftList, rightList, list);
        }
    }

    //  quickSort() will find the max pivot and use recursion to sort the algorithm
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
        quickSort(list, 0, list.size() - 1);
    }


    //  countingSort() will determine an integer where it should be in the list, only works with Integers. Not E types.
    public static void countingSort(ArrayList<Integer> list, int k) {
        int[] arr = new int[list.size()];

        //  Populate the array with the list elements below
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        int[] result = new int[list.size()];  //  Create a result array list with the same size as the passed list
        int[] counts = new int[k];   //  Empty array with length of k


        for (int i = 0; i < k - 1; i++) {
            counts[i] = 0;  //  Set each element in the counts list to 0
        }

        for (int i = 0; i < arr.length - 1; i++) {
            counts[arr[i]]++;
        }

        for (int i = 1; i < k - 1; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = arr.length - 1; i >=0; i--) {
            result[counts[arr[i]] - 1] = arr[i];
            counts[arr[i]]--;
        }

        //  Create a temp arraylist to convert the result array to an array list then update the passed list to the result array list
        ArrayList<Integer> tempList = new ArrayList<>(list.size());

        //  Finally, copy the result array to the list
        for (int i = 0; i < list.size() - 1; i++) {
            list.set(i, result[i]);
        }
    }

    //  radixSort()
    public static void radixSort(ArrayList<Integer> list) {
        //  Create new buckets which are in base 10, of course
        ArrayList<Integer>[] buckets = new ArrayList[10];

        //  Populate buckets with an array list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        //  Find the maximum value
        int maximum = findMaximum(list);

        //  Iterate through it to find the key, taken form pseudocode
        for (int i = 1; i <= maximum; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                int key = list.get(j) / (int) Math.pow(10, i - 1) % 10;
                buckets[key].add(list.get(j));
            }

            //  Init the k to be zero, be incremented inside the for loop at the current bucket and get the integer
            int k = 0;

            for (int j = 0; j < buckets.length - 1; j++) {
                for(int x = 0; x < buckets[j].size(); x++) {
                    list.set(k++, buckets[j].get(x));
                }
                buckets[j].clear();
            }
        }
    }

    /*  TODO: PRIVATE METHODS BELOW   */
    //  Private method to find the maximum integer in a list
    private static Integer findMaximum(ArrayList<Integer> list) {
        Integer max = list.get(0);

        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }

        return max;
    }

    //  private method to merge for two lists and combine them together
    private static <E extends Comparable<E>> void merge(ArrayList<E> leftList, ArrayList<E> rightList, ArrayList<E> result) {
        //  Declare i, j, k and get the left and right size of both left, right lists
        int i, j, k;
        i = j = k = 0;
        int leftSize = leftList.size();
        int rightSize = rightList.size();

        while (i < leftSize && j < rightSize) {
            //  Get the left and right elements at the start
            E leftElem = leftList.get(i);
            E rightElem = rightList.get(j);

            //  If left element is less than the right element, set at k index to left element otherwise it's the opposite
            if(leftElem.compareTo(rightElem) < 0) {
                result.set(k, leftElem);
                i++;
            } else {
                result.set(k, rightElem);
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            //  Get the left element
            E leftElem = leftList.get(i);
            result.set(k, leftElem);
            i++;
            k++;
        }

        while (j < rightSize) {
            //  Get the right element
            E rightElem = rightList.get(j);
            result.set(k, rightElem);
            j++;
            k++;
        }
    }

    //  private method for quick sort which will call the partition function
    private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int low, int high) {
        if(low < high) {
            int p = partition(list, low, high);

            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    //  private method for quick sort which is partition which will be used in the private quick sort method
    private static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high) {
        //  Get the maximum value and assign it to a pivot of E type
        E pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if(list.get(j).compareTo(pivot) <= 0) {
                i += 1;
                //  Get the current at index i then swap with the j index
                E currElem = list.get(i);
                list.set(i, list.get(j));
                list.set(j, currElem);
            }
        }

        //  Swap once more after for loop
        E currElem = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, currElem);

        //  Return current i plus the next
        return i + 1;
    }

    //  TODO: DELETE ONCE FINISHED TESTING Print all items in the passed array list below, DELETE AFTER TESTING
    public static <E extends Comparable<E>> void printAllItems(ArrayList<E> list) {
        for(E item: list) {
            System.out.print(item + ", ");
        }
    }
}
