# tc O(V+E), sc O(V+E).
adj_list = [[] for _ in range(numCourses)]
indegrees = [0] * numCourses
for u, v in prerequisites:
    adj_list[v].append(u)
    indegrees[u] += 1

from collections import deque
queue = deque([])
for node, degree in enumerate(indegrees):
    if degree == 0:
        queue.append(node)
if len(queue) == 0:
    return False
res = []
while queue:
    node = queue.popleft()
    res.append(node)

    for neigh in adj_list[node]:
        indegrees[neigh] -= 1
        if indegrees[neigh] == 0:
            queue.append(neigh)

return len(res) == numCourses