package com.zeetcode.array.range;

import java.util.ArrayList;
import java.util.List;


/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive,
 * return its missing ranges. For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * return ["2", "4->49", "51->74", "76->99"].
 */
public class FindMissingRange {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();

        if (nums == null || nums.length == 0) {
            outputToResult(lower, upper, result);
            return result;
        }
        
        if (lower < nums[0]) {
            outputToResult(lower, nums[0]-1, result);
        }
        
        int i = 1;
        while (i <= nums.length-1) {
            if (nums[i-1] + 1 < nums[i]) {
                outputToResult(nums[i-1]+1, nums[i]-1, result);
            }
            i++;
        }
        
        if (nums[nums.length-1] < upper) {
           outputToResult(nums[nums.length-1]+1, upper, result);
        }
        
        return result;
    }
    
    private void outputToResult(int start, int end, List<String> result) {
        StringBuffer sb = new StringBuffer();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start + "->" + end);
        }
         
        result.add(sb.toString());
    }
    
}
