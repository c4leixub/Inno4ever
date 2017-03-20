package com.zeetcode.array.range;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		
		int s = 0;
		int e = 1;
		while (e < nums.length) {
			if (nums[e-1]+1 == nums[e]) {
				e++;
			} else {
				outputToResult(nums[s], nums[e-1], result);
				s = e;
				e++;
			}
		}
		outputToResult(nums[s], nums[e-1], result);
		
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
	
	public static void main(String[] args) {
		SummaryRange r = new SummaryRange();
		System.out.println(r.summaryRanges(new int[] {0,1,2,4,5,7}));
		System.out.println(r.summaryRanges(new int[] {0}));
	}
}
