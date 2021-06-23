from collections import deque
class Solution:
    """Time complexity-O(V+E) as we will be going through these many nodes based on given list
    Space Complexity-O(V+E) as hashmap contains V keys and total E values"""
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dependency=[0]*numCourses
        mapfunc={}
        q=deque()
        for i in prerequisites:
            incoming = i[0]
            dependency[incoming]+=1
            outgoing=i[1]
            if outgoing not in mapfunc:
                mapfunc[outgoing]=[]
            mapfunc[outgoing].append(incoming)
        for i in range(len(dependency)):
            if dependency[i]==0:
                q.append(i)
        if not q:
            return False
        count=0
        while q:
            count+=1
            curr=q.popleft()
            if curr in mapfunc:
                children=mapfunc[curr]
                if children:
                    for i in children:
                        dependency[i]-=1
                        if dependency[i]==0:
                            q.append(i)
        if count==numCourses:
            return True
        else:
            return False
            
            
                
                
            
        