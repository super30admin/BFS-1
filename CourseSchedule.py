#Time complexity : O(V+E) 
#Space complexity : O(V+E) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0 or len(prerequisites) ==0:
            return True
        
        hashmap = {}
        
        indegree= [0]*numCourses
        
        for edge1, edge2 in prerequisites:
            indegree[edge1] +=1
           
            if edge2 in hashmap:
                hashmap[edge2].append(edge1)
            else:
                hashmap[edge2] = [edge1]


        queue = deque()
        count = 0
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
                count +=1
        while queue:
            course = queue.popleft()
            if course in hashmap:
                for edge1 in hashmap[course]:
                    indegree[edge1] -= 1
                    if indegree[edge1] == 0:
                        queue.append(edge1)
                        count+=1
        return count == numCourses