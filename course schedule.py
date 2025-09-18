def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
    degreesarray=[0]*numCourses
    graph={}

    for pr in prerequisites:
        degreesarray[pr[0]]+=1
        if pr[1] not in graph:
            graph[pr[1]]=[]
        graph[pr[1]].append(pr[0])

    count=0
    q=deque()
    for i in range(numCourses):
        if degreesarray[i]==0:
            q.append(i)
            count+=1
    
    if not q:
        return False
    if count==numCourses:
        return True
    
    while q:
        curr=q.pop()
        dependencies=graph.get(curr)
        if dependencies:
            for dep in dependencies:
                degreesarray[dep]-=1
                if degreesarray[dep]==0:
                    q.append(dep)
                    count+=1
                    if count==numCourses:
                        return True
    return False