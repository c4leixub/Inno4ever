package com.zeetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceRecontruction {
	
	public boolean sequenceReconstructionTopologicalSort(int[] org, int[][] seqs) {
        if (seqs == null || seqs.length == 0) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        
        // init
        for (int j = 0; j < org.length; j++) {
            graph.put(org[j], new HashSet<Integer>());
            indegree.put(org[j], 0);
        }
        
        // build graph and indegree
        for (int[] seq : seqs) {
            if (seq.length == 1) {
                
            	// found character not in "org"
            	if (!graph.containsKey(seq[0])) {
                    return false;
                }
                continue;
            }
            
            for (int i = 0; i < seq.length - 1; i++) {
            	// found character not in "org"
            	if (!graph.containsKey(seq[i]) || !graph.containsKey(seq[i+1])) {
                    return false;
                }
                
                if (!graph.get(seq[i]).contains(seq[i+1])) {    
                    graph.get(seq[i]).add(seq[i+1]);
                    indegree.put(seq[i+1], indegree.get(seq[i+1])+1);
                }
            }
        }
        
        // topological sort
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Integer k : indegree.keySet()) {
            if (indegree.get(k) == 0) {
                queue.add(k);
            }
        }
        
        int index = 0;
        while (!queue.isEmpty()) {
            
        	// if org is unique sequence, then queue will only contains one element
            if (queue.size() > 1) {
                return false;
            }
            
            Integer cur = queue.poll();
            
            // check whether the character correctness
            if (index >= org.length || org[index] != cur){
                return false;
            }
            index++;
            
            for (Integer n : graph.get(cur)) {
                indegree.put(n, indegree.get(n)-1);
                
                if (indegree.get(n) == 0) {
                    queue.add(n);
                }
            }
        }
        
        return index == org.length;
    }
}
