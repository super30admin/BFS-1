#space: O( vertex + edges)
#time: O( vertex + edges)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites) <= 1 or numCourses ==1:
            return True
        indegree=  [0]* numCourses
        ctr = numCourses
        hmap=dict()
        for lst in prerequisites:
            frm = lst[1]
            to= lst[0]
            indegree[to] +=1
            temp= hmap.get(frm, [])
            temp.append(to)
            hmap[frm] =  temp
        q= list()
        for i in range(numCourses):
            if(indegree[i] == 0):
                q.append(i)
        while len(q) != 0:
            vertex= q.pop(0)
            ctr -=1
            edges= hmap.get(vertex,[])
            if len(edges) == 0:
                continue
            for e in edges:
                if( indegree[e] >= 1):
                    indegree[e] -=1
                if( indegree[e] == 0):
                    q.append(e)

        if ctr== 0:
            return True
        else: 
            return False


        
