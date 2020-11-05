public class Main {
    public static void main(String[] args) {
        int arr[] = {1, 11, 13, 5, 6, 7, 9, 21};

        System.out.println("Given Array");
        printArray(arr);

        Main ob = new Main();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int left, int mid, int right) {

        // Find sizes of two subarrays to be merged
        int n1sizeOfSubArrayToBeMerged = mid - left + 1;
        int n2sizeOfSubArrayToBeMerged = right - mid;

        /* Create temp arrays */
        int L[] = new int [n1sizeOfSubArrayToBeMerged];
        int R[] = new int [n2sizeOfSubArrayToBeMerged];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1sizeOfSubArrayToBeMerged; i++)
            L[i] = arr[left + i];
        for (int j=0; j<n2sizeOfSubArrayToBeMerged; j++)
            R[j] = arr[mid + 1+ j];

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array

        int k = left;
        while (i < n1sizeOfSubArrayToBeMerged && j < n2sizeOfSubArrayToBeMerged) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1sizeOfSubArrayToBeMerged) {
            arr[k] = L[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2sizeOfSubArrayToBeMerged) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left..right] using
    // merge()
    void sort(int arr[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left+right)/2;

            // Sort first and second halves
            sort(arr, left, mid);
            sort(arr , mid +1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
