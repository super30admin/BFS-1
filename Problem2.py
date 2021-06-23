# S30 FAANG Problem #57 {Medium}
# 207. Course Schedule


# Time Complexity: O(V*E); there's a loop which is moving over vertices and edges(nodes and their children)
# Space Complexity:
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

# Approach: Keep track of independent nodes through the indegrees list. If the nodes are not all traversed or covered,
# then return False

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #adjacency list -> map of the dependencies and nodes
        
        mapPrereqs = {}
        for i in range(0, numCourses):
            mapPrereqs[i] = []

        for l in prerequisites:
                mapPrereqs[l[1]].append(l[0])
        
        indegrees = [0 for x in range(0,numCourses)]
        for key,val in mapPrereqs.items():
            
            for n in val:
                indegrees[n] = indegrees[n]+1

        try:
            while(indegrees.index(0)!= None):

                idx = indegrees.index(0)
                l_children = mapPrereqs[idx]
                for child in l_children:
                    indegrees[child] = indegrees[child]-1
                indegrees[idx] = -1
                if sum(indegrees) == -(numCourses):
                    break
        except:
            return False
        
        return True
