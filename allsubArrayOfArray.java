// Find the Subarray of Given array
// Input: [1,2,3,4,5]
// // Output: [1] 
// 1,2 
// 1,2,3
//  1,2,3,4
// 1,2,3,4,5
//  2 
//  2,3 
// 2,3,4
// 2,3,4,5
// 3
// 3,4
// 3,4,5 
// 4
//  4,5
//   5

import java.util.*;

public class allsubArrayOfArray {

    // create a function to find the subarray of given array
    public static void subArray(int[] k) {
        // create a loop which will run from 0 to length of array
        for(int i =0; i<k.length; i++) {
            // create a loop which will run from i to length of array
            for(int j = i; j<k.length; j++) {
                // finding the subarray
                for(int p =i; p<=j; p++) {
                    System.out.print(k[p] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String args[]) {
        int[] k = {1,2,3,4,5};
         subArray(k);
    }
}