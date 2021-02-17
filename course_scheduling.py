'''
Time complexity: O(V + E) => V = numCourses, E = prerequisites
Space complexity: O(V + E) => V = numCourses, E = prerequisites
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = [0] * numCourses
        hashMap = {}
        
        for i in prerequisites:
            to = i[1]
            fromm = i[0]
            inDegree[to] = inDegree[to] + 1
            
            if hashMap.get(fromm) is None:
                hashMap[fromm] = []
            
            hashMap[fromm].append(to)
        queue = deque()
        for x in range(0, numCourses):
            if inDegree[x] == 0:
                queue.append(x)
        
        while queue:
            front = queue.pop()
            if hashMap.get(front):
                for x in hashMap.get(front):
                    inDegree[x] = inDegree[x] - 1
                    if inDegree[x] == 0:
                        queue.append(x)
        
        for x in inDegree:
            if x!=0:
                return False
        return True