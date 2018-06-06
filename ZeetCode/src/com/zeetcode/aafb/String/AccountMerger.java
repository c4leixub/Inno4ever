package com.zeetcode.aafb.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class AccountMerger {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        List<String> accountList;
        String email;
        Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
        for (int i = 0; i < accounts.size(); i++) {
            accountList = accounts.get(i);
            for (int j = 1; j < accountList.size(); j++) {
                email = accountList.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, new HashSet<Integer>());
                }
                map.get(email).add(i);
            }
        }
        
        Set<String> emails;
        Queue<Integer> queue;
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < accounts.size(); i++) {
            if (visited.contains(i)) continue;
            
            emails = new TreeSet<String>();
            
            queue = new LinkedList<Integer>();
            queue.add(i);
            
            while (!queue.isEmpty()) {
                Integer index = queue.poll();
                visited.add(index);
                
                for (int j = 1; j < accounts.get(index).size(); j++) {
                    email = accounts.get(index).get(j);
                    emails.add(email);
                    
                    for (Integer idx : map.get(email)) {
                        if (visited.contains(idx)) continue;
                        queue.add(idx);
                        visited.add(idx);
                    }
                    
                }
            }
            
            addToResult(result, emails, accounts.get(i).get(0));
        }
        
        return result;
    }
    
    private void addToResult(List<List<String>> result, Set<String> emails, String name) {
        List<String> list = new ArrayList<String>();
        list.add(name);
        list.addAll(emails);
        result.add(list);
    }
}
