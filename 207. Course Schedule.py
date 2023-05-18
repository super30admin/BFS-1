#Time Complexity:O(V+E)
#Space Complexity:O(V+E)

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        vert={}
        dq=collections.deque()
        count=0
        indegree=[0]*numCourses
        for i in range(len(prerequisites)):
            prerequisite=prerequisites[i]
            to=prerequisite[0]
            frum=prerequisite[1]
            indegree[to]+=1
            if frum not in vert:
                vert[frum]=[]
            vert.get(frum).append(to)
        for i in range(len(indegree)):
            if indegree[i]==0:
                dq.append(i)
                count+=1
        while dq:
            curr=dq.popleft()
            edges=vert.get(curr)
            if not edges:
                continue
            for i in range(len(edges)):
                edge=edges[i]
                indegree[edge]-=1
                if indegree[edge]==0:
                    dq.append(edge)
                    count+=1
        return count==numCourses