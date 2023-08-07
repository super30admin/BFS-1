# Time Complexity :O(V+E)
# Space Complexity :O(V+E)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree=[-1 for i in range(numCourses)]
        # indegree={}
        # for i in range(numCourses):
        #     indegree[i]=indegree.get(i, [])
        
        hash={}
        if(len(prerequisites)==0):
            return True
        z=0
        for i in prerequisites:
            if(indegree[i[0]]==-1):
                indegree[i[0]]=0
                if(indegree[i[1]]==-1):
                    indegree[i[1]]=0
            else:
                if(indegree[i[1]]==-1):
                    indegree[i[1]]=0
            indegree[i[0]]+=1
            hash[i[1]]=hash.get(i[1],[])+[i[0]]
        # print(indegree, hash)
        for i in indegree:
            if(i!=-1):
                z+=1
        print("z= ",z)
        q=deque([])
        
        c=0
        for i in range(numCourses):
            if(indegree[i]==0):
                q.append(i)
                c+=1

        print(indegree, hash, q)
        if(len(q)==0):
            return False
        while(len(q) and c<numCourses):
            curr=q.popleft()
            print(curr, q)
            inde=hash.get(curr, [])
            for i in inde:
                indegree[i]-=1
                if(indegree[i]==0):
                    q.append(i)
                    c+=1
        if(c==z):
            return True
        return False