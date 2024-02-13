package utils;

/**
 * A dynamic array class for storing strings. This class automatically adjusts its capacity
 * as elements are added or removed, providing dynamic resizing capabilities.
 */
public class DynamicArrayList {

    private String[] array;
    private int size;
    private int capacity;
    private final int domainExpansion; // Default expansion factor can be set if not specified

    // Default constructor
    /**
     * Constructs a new DynamicArrayList with a default capacity and expansion factor.
     */
    public DynamicArrayList() {
        this.capacity = 10; // Default capacity
        this.array = new String[this.capacity];
        this.size = 0;
        this.domainExpansion = 10; // Default expansion factor
    }

    // Constructor with expansion factor
    /**
     * Constructs a new DynamicArrayList with a specified expansion factor.
     * @param domainExpansion The expansion factor to use when growing the array.
     * @throws IllegalArgumentException if the expansion factor is less than or equal to 0.
     */
    public DynamicArrayList(int domainExpansion) {
        if (domainExpansion <= 0) {
            throw new IllegalArgumentException("Expansion factor must be greater than 0");
        }
        this.capacity = 10; // Default capacity
        this.array = new String[this.capacity];
        this.size = 0;
        this.domainExpansion = domainExpansion;
    }
    /**
     * Returns the number of elements currently stored in the list.
     * @return The current size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the element at the specified position in the list.
     * @param position The index of the element to retrieve.
     * @return The string at the specified position.
     * @throws IndexOutOfBoundsException if the position is out of the list's bounds.
     */
    public String get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position at position " + position);
        }
        return array[position];
    }

    /**
     * Finds the index of the first occurrence of the specified string in the list.
     * @param toBeFound The string to search for.
     * @return The index of the first occurrence of the string, or -1 if not found.
     */

    public int indexOf(String toBeFound) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(toBeFound)) {
                return i;
            }
        }
        System.out.println("String not found in array");
        return -1;
    }

    /**
     * Adds a new string to the end of the list.
     * @param toBeAdded The string to be added.
     * @return true after adding the string.
     */

    public boolean add(String toBeAdded) {
        if (size == capacity) {
            growArray();
        }
        array[size] = toBeAdded;
        size++;
        return true;
    }

    /**
     * Private method to grow the internal array when the current capacity is reached.
     */

    private void growArray() {
        int newCapacity = capacity + domainExpansion;
        String[] newArray = new String[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }

    /**
     * Inserts a string at the specified position in the list.
     * @param toBeAdded The string to insert.
     * @param position The position at which to insert the string.
     * @throws IndexOutOfBoundsException if the position is out of the list's bounds.
     */

    public void add(String toBeAdded, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position at position " + position);
        }
        if (size == capacity) {
            growArray();
        }
        // Shift elements to make room for the new one
        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = toBeAdded;
        size++;
    }

    /**
     * Removes the first occurrence of the specified string from the list, starting at the specified position.
     * @param toBeRemoved The string to be removed.
     * @param startPosition The starting position to search from.
     * @return true if the string was removed; false otherwise.
     * @throws IllegalArgumentException if the string to be removed is null.
     * @throws IndexOutOfBoundsException if the starting position is out of bounds.
     */
    public boolean remove(String toBeRemoved, int startPosition) {
        if (toBeRemoved == null) {
            throw new IllegalArgumentException("Cannot remove null");
        }
        if (startPosition < 0 || startPosition >= size) {
            throw new IndexOutOfBoundsException("Invalid position at position " + startPosition);
        }
        for (int i = startPosition; i < size; i++) {
            if (array[i].equals(toBeRemoved)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;


     }
/*
First clone method didn't work when I ran the test.
because this was a shallow copy of the array.
I changed it to a deep copy of the array.
public String[] clone(){
        String[] newArray = new String[size];
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        return newArray;

 */

    /**
     * Clones this DynamicArrayList, creating an independent copy.
     * @return A new DynamicArrayList instance that is a copy of this list.
     */

public DynamicArrayList clone() {
    DynamicArrayList newList = new DynamicArrayList(this.domainExpansion);
    newList.array = new String[this.capacity]; // Ensure capacity matches
    for (int i = 0; i < this.size; i++) {
        newList.array[i] = this.array[i];
    }
    newList.size = this.size;
    newList.capacity = this.capacity;
    return newList;
}


}





















