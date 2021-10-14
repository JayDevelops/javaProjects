/*
* Created by Jesus Perez Arias, CS 2013-01
*
* The SortedSet keeps track of the number of elements and adds those elements to E[] set.
*
* Each method and constructor has a description detailing what each method does.
*
* */
import java.util.Arrays;

public class SortedSet<E extends Comparable<E>> {
    private int size;   //  This is the size of the set, not the capacity of the set
    private E[] set;    //  This is the set where I will store the data into


    //  Create a default empty E[] set with capacity 10 but empty
    public SortedSet() {
        this.size = 10;
        this.set = (E[])(new Comparable[size]);
    }

    //  This constructor will initialize the capacity for the E[] set array but it's empty
    public SortedSet(int capacity) {
        this.set = (E[])(new Comparable[capacity]);
    }

    //  This constructor will take separated comma values and deep copy it to the E[] set array
    public SortedSet(E ... values) {
        this.size = values.length;  //  Keep the size the amount of passed values
        this.set = (E[])(new Comparable[size * 2]); //  Multiply by 2 to ensure capacity and keep O(1)

        //  Come back to this once you create the add(value) and addAll(E ... values) methods
        System.arraycopy(values, 0, this.set, 0, values.length);
    }

    //  This copy constructor will deep copy one array to another
    public SortedSet(SortedSet sortedSet) {
        //  Create a temp array to temporarily store the passed array
        E[] tempArr = (E[])(new Comparable[sortedSet.size]);

        //  Iterate through the size of the sortedSet.size() and add it to the tempArr
        for (int i = 0; i < sortedSet.size(); i++) {
            tempArr[i] = (E) sortedSet.get(i);
        }

        size = sortedSet.size;  //  Copy the size
        System.arraycopy(tempArr, 0, set, 0, size); //  Deep copy the temp array to set array

    }


    /*  TODO: Public Methods Below  */

    //  This method will return true or false if the value is found in the E[] set
    public boolean exists(E value) {
        //  Change the boolean if the value is
        boolean result = false;

        for (int i = 0; i < this.size; i++) {
            //  If the iterated item finds a duplicate, then change result to true
            if(get(i).compareTo(value) == 0) {
                result = true;
                break;
            }
        }

        //  Return the result
        return result;
    }

    //  This method will try to add a value to a set, if the capacity isn't enough then it will add more capacity
    public void add(E value) {
        //  First, check if the size is equal to the capacity, if true then resize to make space
        if(size == set.length) {
            resize(this.set);
        }

        //  Next, if the value exists then print to the user this value can't be added. Else, add to the array at the end
        if(exists(value)) {
            System.out.println("The passed value of " + value + " can't be added because this value already exists in this SortedSet.");
        } else {
            this.set[this.size] = value;  //  Get the last size and assign it to the value
            this.size++;    //  Increment the size by one to this.size
            Arrays.sort(this.set, 0, this.size);  //  Finally, sort the array. It will take the most amount of time
        }
    }

    //  Add all the values by calling add(value) until it has gone through all values
    public void addAll(E ... values) {
        //  Iterate in for loop until index reaches the last list item
        for (E value : values) {
            add(value);
        }
    }

    //  This will take the value and remove it at the current index
    public void remove(E value) {
        //  First find the index of the value, if it returns 0 then print an index out of bounds exception
        int foundIndexAt = findValueIndex(value);

        //  Create a tempArray with a capacity of minus one of the original array
        E[] tempArray = (E[])(new Comparable[this.set.length - 1]);

        //  Copy elements from the foundIndexAt from this.set to the temp array
        System.arraycopy(this.set, 0, tempArray, 0, foundIndexAt);

        //  Copy the elements backwards from the foundIndexAt from the original array to the temp array
        System.arraycopy(this.set, foundIndexAt + 1, tempArray, foundIndexAt, this.size - foundIndexAt - 1);

        //  Decrement the size by one
        this.size--;

        //  Set the this.set to tempArray
        this.set = tempArray;
    }

    //  Tries to return the element at the current index, will throw an exception if it's out of bounds
    public E get(int index) throws IndexOutOfBoundsException {
        return this.set[index];
    }

    //  Returns the total size, the number of elements, in this.set[] array
    public int size() {
        return this.size;
    }

    //  TODO: Override equals() method
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SortedSet)) return false;

        SortedSet<?> sortedSet = (SortedSet<?>) o;

        if (!(size == sortedSet.size)) return false;

        boolean lastBool = true;    //  This will check if each element is of the same type
        //  Iterate through both arrays to check if they're of the same type
        for (int i = 0; i < sortedSet.size; i++) {
            if(!(get(i) == sortedSet.get(i))){
                lastBool = false;
            }
        }
        return lastBool;
    }

    //  TODO: Override the toString() method
    @Override
    public String toString() {
        //  First create a string builder to achieve a faster O(n) algorithm
        StringBuilder sb = new StringBuilder();
        int index = 0;  //  Tracks the index to keep track of the comma placement

        //  Append each value to the string builder
        for(E value: this.set) {
            if(value != null) {
                if(index != this.size) {
                    sb.append(value + ", ");
                } else {
                    sb.append(value);
                }
            }
            index++;
        }

        //  Then, convert the string builder to a String
        String finalStringValue = sb.toString();


        //  Finally, return it here
        return "set = { " + finalStringValue + " }";
    }

    /*  TODO: Private Methods Below */
    //  Resize method will copy old values, double the new capacity of the array
    public void resize(E[] set) {
        //  Create a temp newCapacity with a new doubled capacity for the new array
        int newCapacity = this.set.length * 2;
        E[] tempArr = (E[])(new Comparable[newCapacity]);

        //  Next, copy the old values of the passed E[] set into the tempArr
        System.arraycopy(set, 0, tempArr, 0, set.length);

        //  Finally, instantiate the this.set once again to the tempArr
        this.set = tempArr;
    }

    //  This will return the index at the given value, will be used in remove() method
    private int findValueIndex(E value) {
        int indexAt = 0;  //  Will know where the value is and return the index
        for (int i = 0; i < this.size; i++) {
            //  If the current index equals the value, then return the index where it's located at
            if(get(i).compareTo(value) == 0) {
                indexAt = i;
                break;
            }
        }
        return indexAt;
    }
}
