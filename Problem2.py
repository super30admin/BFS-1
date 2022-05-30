#Time Complexity: O(V + E) 
#Space Complexity: O(N)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indegree = [0] * numCourses
        dic = {}
        values = []
        queue = []
        count = 0
        if not prerequisites:
            return True
        
        for i in prerequisites:
            indegree[i[0]] += 1  
            if i[1] not in dic:
                dic[i[1]] = [i[0]]
            else:
                dic[i[1]].append(i[0])

        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
                count +=1
        if not queue:
            return False
        while queue:
            val = queue.pop(0)
            if val not in dic:
                continue
            values = dic[val]
            if not values:
                continue
            for i in values:
                indegree[i] -= 1
                if indegree[i] == 0:
                    queue.append(i)
                    count +=1
                if count == numCourses:
                    return True
  
        if count < numCourses:
            return False
        return True
                
            
     