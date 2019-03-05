package com.abb.bit;

import java.util.ArrayList;
import java.util.List;

public class IPtoCICR {
	public List<String> ipToCIDR(String ip, int n) {
		long x = 0;
		
		String[] ipsegment = ip.split("\\.");
		for(int i=0;i<ipsegment .length;i++){
			x = Integer.parseInt(ipsegment[i]) + x * 256;
		}
		
		List<String> result = new ArrayList<String>();
		
		while (n > 0) { 
			long step = x & -x; 
			
			while (step > n) {
				step /= 2;
			}
			
			result.add(longToIP(x, (int) step));
			
			x += step;
			n -= step;
		}
		
		return result;
	}
	
	private String longToIP(long x, int step) {  
        int[] ans = new int[4];  
        ans[0] = (int) (x & 255);  
        x >>= 8;  
        ans[1] = (int) (x & 255);  
        x >>= 8;  
        ans[2] = (int) (x & 255);  
        x >>= 8;  
        ans[3] = (int) x;  
        int len = 33;  
        while (step > 0) {  
            len --;  
            step /= 2;  
        }  
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;  
    }  
}
