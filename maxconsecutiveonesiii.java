// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: using sliding window approach, we will keep track of the number of zeros in the current window. If the count of zeros exceeds k, we will move the left pointer to the right until the count of zeros is less than or equal to k. The length of the longest subarray with at most k zeros will be the difference between the right and left pointers.
class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int slow = 0;
        for(int i =0; i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
            if(count>k)
            {
                if(nums[slow]==0)
                {
                    count--;
                }
                slow++;
            }
        } 
        return nums.length-slow;
}
}