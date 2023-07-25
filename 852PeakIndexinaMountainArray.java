/*
 852. Peak Index in a Mountain Array

An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.

 

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
 

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

///// SOlUTION /////////////

Intuition
An array is said to be a mountain array if it satisfies the following conditions:

The length of the given array is should be greater or equal to 3 i.e. LENGTH >=3.
There must be only one peak in the array or the largest element in the array.
The array must follows the condition: ARRAY[0] < ARRAY[1] < ARRAY[i-1] < ARRAY[ i] > ARRAY[ i+1 ] > ARRAY[..] > ARRAY[length-1]
The task is to find the peak index of the mountain array.

Approach
The problem can be solved using the following two approaches:

Using Binary Search
Using Linear Search
Using Binary Search
The elements in the given array must be in either ascending or descending sorted order. There should not be duplicate elements. Using the binary search algorithm, we can find out the required element. In this approach, at every step reduce the search by half. The problem can be solved by using the following steps:

Find the middle element of the array arr.
If the array is arranged in descending order (arr[mid]>arr[mid+1]), it means the peak element will be on the left side of the middle element. Therefore, reduce the search between the left half and the middle
If the array is arranged in ascending order (arr[mid+1]<arr[mid]), it means the peak element will be on the right side of the middle element. Therefore, reduce the search between the right element and the middle+1
Repeat step 2 and 3, recursively until the condition left<right become false.
When the condition left >= right becomes true, the peak element will be at the left index.
lets us disscuss with an example:

Suppose the input array is {4, 2, 7, 9, 8, 3, 1}.

The length of the array will be array length-1, i.e. 7-1 = 6.

Therefore, High=6 and Low=0

Let's find the mid of the array.

Mid=low+(high-low)/2

Mid=0+(6-0)/2 = 3

Now check if (array[mid]>=array[mid+1]) or not

Therefore, 9 >= 8, the condition is true. Set high=Mid

Now, low=0, Mid=3, High=3

Again, find the mid of the array Mid=low+(high-low)/2

Mid = 0 + (3 - 0) / 2 = 1

Now check if (array[mid]>=array[mid+1])

Therefore, 2 >= 7, the condition is false. Set low=Mid+1

Now, low=1+1=2, Mid=1, High=3
Again, find the mid of the array Mid=low+(high-low)/2

Mid = 2 + (3 - 2) / 2 = 2

Now check if (array[mid]>=array[mid+1])
Therefore, 7 >= 9, the condition is false. Set low=Mid+1

Now, low=2+1=3, Mid=2, High=3

Again, find the mid of the array Mid=low+(high-low)/2

Mid = 3 + (3 - 3) / 2 = 1

Now check if (array[mid]>=array[mid+1])

Therefore, 2 >= 7, the condition is false. Set low=Mid+1

Repeat the above process. At last we get low=3, High=3, Mid=3;

And here when it comes in loop while (low < high), means 3< 3 and the condition becomes false. Exit from the loop and return low i.e. 3. Hence, the peak index become 3.

Algorithm
Set low = 0.
Set high to the length of array -1.
Declare a variable mid.
Set mid = low + (high - low) / 2.
While low < high:
If array[ mid ] > = array [ mid + 1].
then high = mid.
Else
then low = mid + 1.
Return low.
Using Linear Search
In this approach, we iterate through the given input array A. At each iteration, if the current element is greater than the previous element and the current element is smaller than the next element then the current element is the peak element.

Complexity
Time complexity: Using Binary Search O(logn)

Using Linear search O(n)

Space complexity:
O(1)
 */

 // CODE 

 // Approach 1. Using Binary search 

// class Solution {
//     public int peakIndexInMountainArray(int[] arr) {
//         int low = 0;
//         int high = arr.length -1;

//         int mid;

//         while (low < high) {
//             mid = low + (high-low) /2;

//             // compares mid of the array with the next element

//             if(arr[mid] >= arr[mid +1]) {
//                 // if above condition is true, sets high = mid

//                 high = mid;

//             } 
//             // if the condition becomes false arr[mid] >= arr[mid+1] sets low = mid+1

//             else {
//                 low = mid +1;
//             }
//         }

//         return low;
//     }
// }



/* Approach 2. linear search : In this approach, we iterate through the given input array A. At each iteration, if the current element is greater than the previous element and the current element is smaller than the next element then the current element is the peak element.

Complexity
The time complexity of the above solution is O(log n) where n is the length of the array. The space complexity is O(1) because we have not used any extra space for calculation.

*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

       if(arr == null || arr.length < 3) return -1;

       int previous = arr[0];

       for (int i=1; i<arr.length -1; i++) {
           if(previous < arr[i] && arr[i+1] < arr[i]) {
               return i;
           }
       }
       return -1;
    }
}