package Q_207_Course_Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//There are a total of n courses you have to take, labeled from 0 to n-1.
//
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
//Example 1:
//
//Input: 2, [[1,0]] 
//Output: true
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: 2, [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take. 
//             To take course 1 you should have finished course 0, and to take course 0 you should
//             also have finished course 1. So it is impossible.
//Note:
//
//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//You may assume that there are no duplicate edges in the input prerequisites.


//Time Complexity  : O(V*E)
//Space Complexity : O(V+E)



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites = {{1,0}};
//		int[][] prerequisites = {{1,0},{0,1}};

		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int [] inDegree = new int[numCourses];
		Queue<Integer> q = new LinkedList<>();

		for(int i=0; i < prerequisites.length;i++)
		{
			inDegree[prerequisites[i][0]]++;
			if(!map.containsKey(prerequisites[i][1])) {
				map.put(prerequisites[i][1], new ArrayList<>());
			}
			map.get(prerequisites[i][1]).add(prerequisites[i][0]);


		}

		for(int i=0; i < inDegree.length;i++)
		{
			if(inDegree[i] ==0)
			{
				q.add(i);
			}
		}

		while(!q.isEmpty())
		{
			int course = q.poll();
			List<Integer> adjList = map.get(course);
			if(adjList != null)
			{
				for(int adj : adjList) {
					inDegree[adj]--;
					if(inDegree[adj] == 0 ) {
						q.add(adj);
					}
				}
			}
		}

		for(int i =0 ; i< inDegree.length;i++)
		{
			if(inDegree[i] > 0)
			{
				return false;
			}
		}

		return true;
	}

}
