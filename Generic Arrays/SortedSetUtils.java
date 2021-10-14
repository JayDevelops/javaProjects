/*
* Created by Jesus Perez Arias, CS 2013-01
*
*
* */
public class SortedSetUtils {
    private SortedSetUtils() {
        //  Empty constructor, don't do anything here
    }

    /* This method shall take two SortedSet class instances, containing elements of any data type, as parameters,
       and return a SortedSet object (not an array) which is the union of the two sets. */
    public static <E extends Comparable<E>> SortedSet<E> union(SortedSet<E> ssOne, SortedSet<E> ssTwo) throws IndexOutOfBoundsException {
        //  Let's create a capacity of adding ssOne.size() and ssTwo.size() array, the solution can't be more than that
        int capacity = ssOne.size() + ssTwo.size();

        //  Create a temp array of SortedSet<E> type to store the intersection solution
        SortedSet<E> unionSolution = new SortedSet<E>(capacity);

        //  Add to set one first to the union solution
        for (int i = 0; i < ssOne.size(); i++) {
            unionSolution.add(ssOne.get(i));
        }

        //  Add to set one lastly to the union solution
        for (int i = 0; i < ssTwo.size(); i++) {
            unionSolution.add(ssTwo.get(i));
        }

        return unionSolution;
    }

    /* This method shall take two SortedSet class instances, containing elements of any data type, as parameters,
     and return a SortedSet object (not an array) which is the union of the two sets.*/
    public static <E extends Comparable<E>> SortedSet<E> intersection(SortedSet<E> ssOne, SortedSet<E> ssTwo) throws IndexOutOfBoundsException {
        //  Let's create a capacity of adding ssOne.size() and ssTwo.size() array, the solution can't be more than that
        int capacity = ssOne.size() + ssTwo.size();

        //  Create a temp array of SortedSet<E> type to store the intersection solution
        SortedSet<E> intersectionSol = new SortedSet<E>(capacity);

        //  Iterate through the second set
        for (int i = 0; i < ssTwo.size(); i++) {
            //  If the set one exists the second set element, then add it to the intersection set
            if(ssOne.exists(ssTwo.get(i))) {
                intersectionSol.add(ssTwo.get(i));
            }
        }

        return intersectionSol;
    }
}
