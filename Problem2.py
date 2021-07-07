# Time Complexity : O(V + E) where V = vertices and E = edges 
# Space Complexity : O(V + E) where V = vertices and E = edges 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
from collections import defaultdict
class Solution:
    def canFinish(self,numCourses,prereq):
        if not numCourses:
            return False 
        d = defaultdict(list)
        indegree = [0 for _ in range(numCourses)]
        for edge in prereq:
            indegree[edge[0]] += 1 
            d[edge[1]].append(edge[0])
        
        q = []
        for i in range(len(indegree)):
            if indegree[i] == 0 :
                q.append(i)
        
        while q:
            key = q.pop(0)
            curr = d[key]
            for i in range(len(curr)):
                indegree[curr[i]] -= 1 
                if indegree[curr[i]] == 0:
                    q.append(curr[i])
        
        
        for i in range(len(indegree)):
            if indegree[i] > 0:
                return False 
        return True 
        

        
            

if __name__ == "__main__":
    s = Solution()
    num = 2
    courses = [[1,0],[0,1]]
    res = s.canFinish(num,courses)
    print(res)