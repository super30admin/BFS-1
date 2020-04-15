"""
// Time Complexity : O(V + E) 
// Space Complexity : O(V + E)  //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Given below
"""

from collections import defaultdict
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        
        """
        1. Create the indegree array
        2. Create the adjacency list based on the prereqs matrix
        3. Get the nodes for whom indegree is 0( zero dependency, so can be added
        to the queue)
        4. While queue is not empty
            - poll the course
            - Iterate over dependent courses
                - Decrement the indegree of course by 1
                - if indegreee - 0, add to queue
        5. If even single indegree element is non 0,return False
        """
        indegree = [0]*numCourses
        prereq_map = defaultdict(list)
        
        #build the prereqmap and updating the indegree array
        for p in prerequisites:
            prereq_map[p[1]].append(p[0])
            indegree[p[0]]+=1

        course_queue = []
        #adding the seed nodes to run BFS on
        for i,v in enumerate(indegree):
            if v == 0:
                course_queue.append(i)
        
        #run BFS
        while course_queue:
            course = course_queue.pop(0)
            for i in prereq_map[course]:
                indegree[i]-=1

                #no dependency so add to queue
                if indegree[i] == 0:
                    course_queue.append(i)
        
        for i in indegree:
            if i!=0:
                return False
        return True