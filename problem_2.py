from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites: return True

        hmap, indegrees, q, cnt= {}, [0]*numCourses, deque(), 0
        for i in prerequisites:
            course, prereq= i[0], i[1]
            indegrees[prereq]+=1
            if course not in hmap.keys(): hmap[course]= []
            hmap[course].append(prereq)
        for i in range(numCourses):
            if indegrees[i]==0: 
                cnt+=1
                q.append(i)
        if cnt==0: return False
        while q:
            curr= q.pop()
            if curr not in hmap.keys(): continue
            edges= hmap[curr]
            for i in range(len(edges)):
                edge= edges[i]
                indegrees[edge]-=1
                if indegrees[edge]==0: 
                    cnt+=1
                    q.append(edge)
        return cnt==numCourses
        