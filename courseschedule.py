#Time Complexity: O(v+e)
#Space Complexity: O(v+e)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        q = deque()
        lst = [0]*numCourses
        dic = {}
        count = 0
        dependentNodes = []
        if len(prerequisites) == 0:
            return True
        
        for edge in prerequisites:
            lst[edge[0]] += 1
            
            if edge[1] not in dic:
                dic[edge[1]] = []
                
            dic[edge[1]].append(edge[0])
            
        for i in range(len(lst)):
            if lst[i] == 0:
                q.append(i)
                count += 1
                
        if len(q) == 0:
            return False
                
        while q:
            node = q.popleft()
            if node in dic:
                for course in dic[node]:
                    lst[course] -= 1    
                    if lst[course] == 0:
                        q.append(course)
                        count += 1
                        if count == numCourses:
                            return True
                        
        return False
            
        
        