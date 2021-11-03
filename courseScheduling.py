# Time Complexity : O(V+E) 
# Space Complexity : O(V+E) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        indegrees = []
        for i in range(0,numCourses):
            indegrees.append(0)
        prereq = {}
        for i in prerequisites:
            indegrees[i[0]] +=1
            if i[1] in prereq:
                prereq[i[1]].append(i[0]) 
            else:
                prereq[i[1]] = []
                prereq[i[1]].append(i[0])
                
        edgeDet = deque()
        count = 0
        for i in range(0,len(indegrees)):
            if indegrees[i] == 0:
                count+=1
                edgeDet.append(i)
        while edgeDet:
            ele = edgeDet.pop()
            children = prereq.get(ele)
            if children:
                for c in children : 
                    indegrees[c]-=1
                    if indegrees[c] == 0:
                        count+=1
                        edgeDet.append(c)
        return count == numCourses
                    
            
            
        
