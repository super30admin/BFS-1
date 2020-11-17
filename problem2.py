
#bfs
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if prerequisites==[]: return 1
        _indegree=[0 for _ in range(numCourses)]
        _coursemap={}
        # indegree count of cousres that has number of prerequisities
        for i in range(len(prerequisites)):
            _indegree[prerequisites[i][0]]+=1
            if prerequisites[i][1] in _coursemap:
                _coursemap[prerequisites[i][1]].append(prerequisites[i][0])
            else:
                _coursemap[prerequisites[i][1]]=[prerequisites[i][0]]
                
                
        #print(_indegree)
        #print(_coursemap)
        queue=[]
        for i in range(len(_indegree)):
            if _indegree[i]==0:
                queue.append(i)
        while queue!=[]:
            temp=queue.pop(0)
            print(temp)
            if temp in _coursemap.keys():
                for j in _coursemap[temp]:
                    if _indegree[j]!=0:
                        _indegree[j]-=1
                        if _indegree[j]==0:
                            queue.append(j)
                            #print(queue)
           
        #print(_indegree) 
        for i in range(len(_indegree)):
            if _indegree[i]!=0:
                return False
        return True
            
        