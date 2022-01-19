# // Time Complexity : O(V+E) where V is the number of vertices and E is the number of edges in the graph.
# // Space Complexity : O(V+E) where V is the number of vertices and E is the number of edges in the graph.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        print(numCourses)
        print(prerequisites)
        indegree = [0] * numCourses
        map1 = {}
        for x,y in prerequisites:
            
            indegree[x] += 1
            if y not in map1:
                map1[y] = []
            map1[y].append(x)

        queue = []
        count = 0
        for i,val in enumerate(indegree):
            if val == 0:
                queue.append(i)
                count += 1
        if len(queue) == 0:
            return False
        
        while(len(queue) != 0 and count < numCourses):
            val = queue.pop(0)
            if val in map1:
                children = map1[val]
                for i in children:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        queue.append(i)
                        count += 1
        if count == numCourses:
            return True
        return False
