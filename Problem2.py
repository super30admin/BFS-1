class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        
        indegree = [0] * numCourses
        map = defaultdict(list)
        q = deque()
        count = 0 
        n = len(prerequisites)
        for i in range(n):
            ind = prerequisites[i][1]
            dep = prerequisites[i][0]

            indegree[dep] += 1
            map[ind].append(dep)

        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)
                count += 1
            
        if count == numCourses:
            return True
        if len(q) == 0:
           return False

        while q:
            curr = q.popleft()

            children = map[curr]
            if children == None:
                continue
            for child in children:
                indegree[child] -= 1
                if indegree[child] == 0:
                    q.append(child)
                    count += 1
                if count == numCourses:
                       return True
            
        return False


                