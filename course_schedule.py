class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0 for _ in range(numCourses)]
        hashmap = {}
        queue = []
        for n in prerequisites:
            indegree[n[0]]+=1
            if n[1] not in hashmap:
                hashmap[n[1]] = []
            hashmap[n[1]].append(n[0])
        for i in range(len(indegree)):
            if indegree[i]==0:
                queue.append(i)
        if not queue:
            return False
        while queue:
            temp = queue.pop(0)
            if temp in hashmap:
                dependents = hashmap[temp]
                for i in dependents:
                    indegree[i]-=1
                    if indegree[i]==0:
                        queue.append(i)
        for i in indegree:
            if i!=0:
                return False
        return True
    
#time complexity - O(V+E)
#space complexity - O(V+E)
#all test cases passed