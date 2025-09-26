# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        adj = collections.defaultdict(list)
        ind = [0] * numCourses

        for u,v in prerequisites: 
            adj[u].append(v)
            ind[v]+=1

        q = collections.deque()

        for i in range(numCourses): 
            if ind[i] == 0: 
                q.append(i)


        while q: 
            node = q.popleft()
            for neigh in adj[node]: 
                ind[neigh]-=1
                if ind[neigh] == 0: 
                    q.append(neigh)

        return sum(ind) == 0
                


