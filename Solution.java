
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int left_index = 0;
      int right_index = k - 1;
      double max_avg = Double.MIN_VALUE;
      int cur_sum = 0;
      double cur_avg = 0;
      
      // calculate average
      for(int i = left_index; i <= right_index; i++) {
        cur_sum += nums[i];
      }
      cur_avg = (double)cur_sum / k;
      max_avg = cur_avg;
      left_index++;
      right_index++;

      while(right_index < nums.length) {
        if(nums[right_index] > nums[left_index-1]) {
          // calculate new average
          cur_sum = 0;
          for(int i = left_index; i <= right_index; i++) {
            cur_sum += nums[i];
          }
          cur_avg = (double)cur_sum / k;
          if(cur_avg > max_avg) {
            max_avg = cur_avg;
          }
        }
        left_index++;
        right_index++;
      }
      return max_avg;
    }
    
    public static void main(String[] args) {
      Solution s = new Solution();
      int[] input1 = {1,12,-5,-6,50,3};
      int k = 4;
      
      System.out.println("MaxAverage:" + s.findMaxAverage(input1, k));
    }
}
