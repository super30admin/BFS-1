//Time Complexity : O(V+E)
//Space Complexity : O(V+E)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++)
        {
        	indegrees[prerequisites[i][0]]++;
        	if(!map.containsKey(prerequisites[i][1]))
        	{
        		map.put(prerequisites[i][1], new ArrayList<>());
        	}
        	map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
        {
        	if(indegrees[i] == 0)
        		q.add(i);
        }
        
        while(!q.isEmpty())
        {
        	int curr = q.poll();
        	List<Integer> babies = map.get(curr);
        	if(babies != null)
        	{
        		for(int baby : babies)
            	{
            		indegrees[baby]--;
            		if(indegrees[baby] == 0)
            			q.add(baby);
            	}
        	}
        	
        }
        for(int i = 0; i < numCourses; i++)
        {
        	if(indegrees[i] > 0)
        		return false;
        }
        return true;
    }
}
