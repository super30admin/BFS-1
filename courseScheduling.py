#TimeComplexity:O(V+E) where V are keys and E are values in dictionary 
#SpaceComplexity: O(V+E)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dict1={}
        header=[0]*numCourses
        for i in prerequisites:
            header[i[0]]+=1
            if i[1] not in dict1:
                dict1[i[1]]=[i[0]]
            else:
                dict1[i[1]].append(i[0])
        queue=[]
        for i in range(numCourses):
            if header[i]==0:
                queue.append(i)
        print(queue,dict1,header)
        while(queue):
            front=queue.pop(0)
            l=dict1.get(front)
            if l==None:
                continue
            for x in l:
                header[x]-=1
                if header[x]==0:
                    queue.append(x)
        for i in header:
            if i!=0:
                return False
        return True
                
        
                
            
            
        