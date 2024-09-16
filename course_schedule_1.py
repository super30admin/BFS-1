class Solution(object):
    from collections import deque
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        map ={}
        indegree = [0]*numCourses
        q = deque()
        for i in prerequisites:
            indegree[i[1]]+=1
            if i[0] not in map: 
                map[i[0]] = []
            map[i[0]].append(i[1])
        for i in range(len(indegree)):
            if indegree[i]==0:
                q.appendleft(i)
        print(indegree)
        print(map)
        print(q)
        while(len(q)!=0):
            node = q.pop()
            print(node)
            if node in map:
                rem = map[node]
                for r in rem:
                    indegree[r]-=1
                    if indegree[r]==0:
                        q.appendleft(r)
            
        for i in range(len(indegree)):
            if indegree[i]!=0:
                return False
        return True
