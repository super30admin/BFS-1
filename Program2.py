class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        if len(prerequisites) == 0:
            return True

        Indegree = collections.defaultdict(int)
        Dict = collections.defaultdict(list)

        for ele in prerequisites:
            Dict[ele[1]].append(ele[0])
            Indegree[ele[0]] += 1


        Q = collections.deque([])

        for i in range(numCourses):
            if Indegree[i] == 0:
                Q.append(i)
                del Indegree[i]


        if len(Q) == 0:
            return False

        while Q:
            parent = Q.popleft()

            for child in Dict[parent]:
                Indegree[child] -= 1
                if Indegree[child] == 0:
                    del Indegree[child]
                    Q.append(child)

        if len(Indegree) > 0:
            return False
        else:
            return True
