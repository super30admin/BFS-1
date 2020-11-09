class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if numCourses==0:
            return True

        in_degree= {i:0 for i in range(numCourses)}
        graph = {i:[] for i in range(numCourses)}


        for edge in prerequisites:
            parent,child = edge[0],edge[1]
            graph[parent].append(child)
            in_degree[child]+=1

        sources=collections.deque()
        for v in in_degree:
            if in_degree[v]==0:
                sources.append(v)

        order=[]
        while sources:
            vertex = sources.popleft()
            order.append(vertex)
            for child in graph[vertex]:
                in_degree[child]-=1
                if in_degree[child]==0:
                    sources.append(child)

        return len(order)==numCourses
