/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Sorting Algorithms: Average Runtime:
 * Merge Sort           θ(n log(n))
 * Selection Sort       θ(n^2)
 * Bubble Sort          θ(n^2)
 * Insertion Sort       θ(n^2)
 * 
 * 
 * @author sulaimanhamouda
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] arr = new int[10];
        for(int i = 0; i < 10; i++)
            arr[i] = (int) (Math.random()*100);
        
        System.out.println("Unsorted Array:");
        printArray(arr);
        
        // - We will call the sorting algorithms.
        // - These are all different types of sorting algorithms
        System.out.println("Merge Sort:");
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
        
        System.out.println("Selection Sort:");
        selectionSort(arr, arr.length, 0);
        printArray(arr);
        
        System.out.println("Bubble Sort:");
        bubbleSort(arr);
        printArray(arr);
        
        System.out.println("Insertion Sort:");
        insertionSort(arr);
        printArray(arr);
    }

    // - This is a helper function for MergeSort
    public static void sort(int [] arr, int l, int mid, int r){
        // - Here, we find the sizes for the two subarrays
        int sub1 = mid - l + 1; 
        int sub2 = r - mid; 
  
        // - Here, we create the two subarrays: right and left
        int left[] = new int [sub1]; 
        int right[] = new int [sub2]; 
  
        // - We will copy the data into the two seperate arrays
        for(int i=0; i<sub1; ++i)
            left[i] = arr[l + i]; 
        for(int j=0; j<sub2; ++j) 
            right[j] = arr[mid + 1+ j]; 
        
        // - Here, we will compare the left subarray to the right subarray and switch where appropriate
        int i = 0, j = 0 , x = l; 
        while(i < sub1 && j < sub2){ 
            // - If the left array is less than the right array, then we will swap the values
            if(left[i] <= right[j]){ 
                arr[x] = left[i]; 
                i++; 
            } else{ 
                arr[x] = right[j]; 
                j++; 
            } 
            // - Here, we increment k to move onto the next index
            x++; 
        } 
        
        while(i < sub1){
            arr[x] = left[i]; 
            i++; 
            x++; 
        } 
  
        while(j < sub2){ 
            arr[x] = right[j]; 
            j++; 
            x++; 
        }
    }
    
    // - Above this method is the helper function
    public static void mergeSort(int [] arr, int l, int r){
        if(l < r){
            // - We keep dividing the array by 2
            int middle = (l+r)/2;
            
            // - We go from the beginning(l) of the left array to the middle
            mergeSort(arr, l, middle);
            // - We go from the middle + 1 of the right array to the end(r)
            mergeSort(arr, middle+1, r);
            
            
            // - We then sort
            sort(arr, l, middle, r);
        }
    }
    
    public static void selectionSort(int [] arr, int length, int index){
        // - Iterative solution
        int minIndex;
        // - Outer for loop will move the boundary up one by one
        for(int i = 0; i < length - 1; i++){
            // - This will hold the index with the minimum value
            minIndex = i;
            // - We will determine which index has the minimum value
            for(int j = i+1; j < length; j++)
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            
            // - Here, we swap the values
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
    }
    
    // - Bubble Sort works by repeatedly swapping the adjacent elements if they are not in the proper order.
    public static void bubbleSort(int [] arr){
        int size = arr.length;
        for (int i = 0; i < size-1; i++)
            for (int j = 0; j < size-i-1; j++)
                if (arr[j] > arr[j+1]){ 
                    // swap temp and arr[i] 
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                } 
    }
    
    public static void insertionSort(int [] arr){
        int size = arr.length;
        int key;
        for(int i = 1; i < size; i++){ 
            key = arr[i]; 
            int j = i - 1;

            while(j >= 0 && arr[j] > key){ 
                arr[j+1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j+1] = key; 
        }
    }
    
    // - Let us just print the array now
    public static void printArray(int [] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.print("|"+arr[i]+"|");
        System.out.println();
    }
}
