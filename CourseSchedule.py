class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegree = defaultdict(int)
        depend = defaultdict(list)
        for i in prerequisites:
            a,b = i
            depend[b].append(a)
            inDegree[a]+=1
        print(inDegree)
        stack = deque([i for i in range(numCourses) if inDegree[i]==0])
        if not stack:
            return False
        popped = 0
        while stack:
            curr = stack.popleft()
            popped+=1
            for i in depend[curr]:
                inDegree[i]-=1
                if inDegree[i] == 0:
                    stack.append(i)
            
        return popped == numCourses
Time: O(2*Edges + Vertices)
Space: O(2*V + E)
        

Using DFS:
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        depend = defaultdict(list)
        for i in prerequisites:
            a,b = i
            depend[b].append(a)
        
        path = [False]*numCourses
        
        for i in range(numCourses):
            if self.isCyclic(i, path, depend):
                return False
        
        return True
    def isCyclic(self, i, path, arr):
        if path[i]:
            return True
        path[i] = True
        ret = False
        for num in arr[i]:
            ret = self.isCyclic(num, path, arr)
            if ret:
                break

        path[i] = False
        return ret
    
        
Time: O(E+V)
Space = O(E+V)

            
            
            
