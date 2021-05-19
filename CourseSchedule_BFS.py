# TC: O(N) since we are processing all the nodes. 
# SC: O(N) where N would be the size of the inDegree array and the size of the queue but it will be smaller than or equal to the inDegree array.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * (numCourses)
        hmap = {}
        
        for i in range(numCourses):
            hmap[i] = []
        
        for i in range(len(prerequisites)):
            temp = hmap.get(prerequisites[i][1])
            temp.append(prerequisites[i][0])
            hmap[prerequisites[i][1]] = temp
        
        for k in hmap:
            v = hmap.get(k)
            for j in v:
                inDegree[j] += 1
        
        queue = collections.deque()
        for j in range(len(inDegree)):
            if inDegree[j] == 0:
                queue.append(j)
                
        if not queue:
            return False
        
        while queue:
            curr = queue.popleft()
            temp = hmap.get(curr)
            for i in temp:
                inDegree[i] -= 1
                if inDegree[i] == 0:
                    queue.append(i)
        
        for i in range(len(inDegree)):
            if inDegree[i] > 0:
                return False
        
        return True
