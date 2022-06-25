class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #inDegree list and urgency list(hashmap)
        inDegree=[0 for i in range(numCourses)]
        to=-1
        fro=-1
        dic={}
        q=deque()
        for item in prerequisites:
            to,fro=item[0],item[1]
            inDegree[to]+=1
            
            if fro not in dic.keys():
                dic[fro]=[]
            dic.get(fro).append(to)
                
        #Seach for starting point and BFS
        for i in range(numCourses):
            if inDegree[i]==0:
                q.append(i)
            
        while q:
            temp=q.popleft()
            
            if temp in dic.keys():
                for x in dic[temp]:
                    inDegree[x]-=1
                    if inDegree[x]==0:
                        q.append(x)
                        
        for x in inDegree:
            if x!=0:
                return False
                
        return True