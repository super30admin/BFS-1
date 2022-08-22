
# Time Complexity :O(n)
# Space Complexity : O(n^2)
# Any problem you faced while coding this :
# Did this code successfully run on Leetcode : Yes



class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj = [0]*numCourses
        dict1 = {}
        for i in range(len(prerequisites)):
            adj[prerequisites[i][0]] += 1
            if prerequisites[i][1] not in dict1:
                dict1[prerequisites[i][1]] = []
            dict1[prerequisites[i][1]].append(prerequisites[i][0])
        q = []
        count = 0
        for i in range(len(adj)):
            if adj[i] == 0:
                q.append(i)
                count += 1
        if count == numCourses:
            return True
        while len(q) != 0:
            idx = q.pop(0)
            if idx not in dict1:
                dict1[idx] = []
            temp = (dict1[idx])
            for num in temp:
                adj[num] -= 1
                if adj[num] == 0:
                    q.append(num)
                    count += 1
                if count == numCourses:
                    return True
                
        
        return False
                
        