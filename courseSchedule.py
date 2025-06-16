# TC: O(V+E)
# SC: O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        hmap={}
        ins=[0]*(numCourses)
        for i,j in prerequisites:
            if j not in hmap:
                hmap[j]=[]
            hmap[j].append(i)
            ins[i]+=1
        
        
        q=deque([])
        for i,j in enumerate(ins):
            if j==0:
                q.append(i)
        
        n=numCourses
        
        while q:
            curr=q.popleft()
            n-=1
            if curr in hmap:
                deps=hmap[curr]
                for i in deps:
                    ins[i]-=1
                    if ins[i]==0:
                        q.append(i)
               

        return n==0


        
