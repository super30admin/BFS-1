class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return []
        dep = [0 for i in range(numCourses)]
        hp = dict()
        for edge in prerequisites:
            dep[edge[0]] += 1
            if edge[1] not in hp:
                hp[edge[1]] = []
            hp[edge[1]].append(edge[0])
        q = []
        for i in range(numCourses):
            if dep[i] == 0:
                q.append(i)
        if len(q) == 0:
            return False
        cnt = 0
        while len(q) != 0:
            cur = q.pop(0)
            cnt += 1
            edges = hp.get(cur)
            if edges != None:
                for edge in edges:
                    dep[edge] -= 1
                    if dep[edge] == 0:
                        q.append(edge)
                        print(q)
        return cnt == numCourses
