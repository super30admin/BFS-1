# // Time Complexity : O(V+E)
# // Space Complexity :O(V+E)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

from collections import defaultdict
class Solution:
    def canFinish(self, numCourses: int, prerequisites):
        #adjecency list for storing independent courses and their depedency list
        indegrees = [0]*numCourses
        hMap = defaultdict(list)
        for edge in prerequisites:
            indegrees[edge[0]] += 1
            if(edge[1] not in hMap.keys()):
                hMap[edge[1]] = []
            hMap[edge[1]].append(edge[0])
            
        count = 0
        q = list()
        for i in range(numCourses):
            if indegrees[i]== 0:
                q.append(i)
                count += 1
        if q == []:
            return False
        
        print(q)
        print(indegrees)
        print(hMap)
        
        while(q != []):
            curr = q.pop(0)
            children = []
            children = (hMap[curr])
            # print(children)
            if children != None or children != []:
                for child in children:
                    indegrees[child] -= 1
                    if indegrees[child] == 0:
                        q.append(child)
                        count += 1
                        print(q)
        if count == numCourses:
            return True
        
        return False
        
        
numCourses = 6
prerequisites = [[1,0],[2,0],[3,1],[3,2],[4,1],[5,4],[5,2]]
sol = Solution()
print(sol.canFinish(numCourses,prerequisites))
                
        
            
            
            
        
        