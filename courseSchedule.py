"""
TC: O(V+E)
SP : O(V+E) Where V is the number of courses and 
E is the number of prerequisites.

"""

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj_map = defaultdict(list)
        dep_count = [0]*numCourses

        for i, j in prerequisites:
            adj_map[j].append(i)
            dep_count[i]+=1
        q = deque()
        for i in range(len(dep_count)):
            if dep_count[i]==0:
                q.append(i)

        if not q: return False
        complete = 0
        while q:
            for _ in range(len(q)):
                c = q.popleft()
                complete +=1
                for i in adj_map[c]:
                    dep_count[i]-=1
                    if dep_count[i]==0:
                        q.append(i)
        return complete==numCourses

        