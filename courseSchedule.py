#TC - O(m+n)
#SC - O(m+n)
def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    adj = {i:[] for i in range(numCourses)}
    for n1,n2 in prerequisites:
        adj[n1].append(n2)
    indegree = [0]*numCourses
    for i in adj:
        for j in adj[i]:
            indegree[j]+=1
    q = collections.deque()
    for i in range(len(indegree)):
        if indegree[i] ==0:
            q.append(i)
    topo = []
    while q:
        node = q.popleft()
        topo.append(node)
        for nei in adj[node]:
            indegree[nei]-=1
            if indegree[nei] == 0:
                q.append(nei)
    if len(topo) == numCourses:
        return True
    return False

