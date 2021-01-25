class Solution {
  public boolean kLengthApart(int[] nums, int k) {
        int prevIdx = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                if(prevIdx != -1){
                    int distance = i - prevIdx - 1;
                    if(distance < k){
                        return false;
                    }
                }
                prevIdx = i;
            }
        }
        return true;
    }
}