'''
TC: O(V+E) - vertices + edges
SC: O(V+E)
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = collections.defaultdict(list)
        count = {}
        for i in range(numCourses):
            count[i] = 0
        for x,y in prerequisites:
            graph[y].append(x)
            count[x]+=1

        total = 0
        q = deque()
        for k,v in count.items():
            if v == 0:
                total += 1
                q.append(k)
        while q:
            k = q.popleft()
            for node in graph[k]:
                count[node]-=1
                if count[node] == 0:
                    total += 1
                    q.append(node)

        return total==numCourses