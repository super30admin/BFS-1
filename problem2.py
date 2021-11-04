#Time ,space complexity O(n)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #creating dependency arr and counting the dependencies and adding it
        dependency = [0]*numCourses
    
        for i in range(len(prerequisites)):
            dependency[prerequisites[i][0]]+=1
 
#Creating adjancency matrix with keys as courses and values as dependencies
        arr=[]
        for i in range(numCourses):
            arr.append([])
        
        
        for i in range(len(prerequisites)):
            arr[prerequisites[i][1]].append(prerequisites[i][0])
        
#Creating queue and adding the values with zero dependencies and then again decrementing the dependencies and following the pattern until all nodes become independent        
        q=[]
        for i in range(len(dependency)):
            if dependency[i]==0:
                q.append(i)
                
        while q:
            cur=q.pop()
            ds=arr[cur]
            print(ds)
            for i in range(len(ds)):
                dependency[ds[i]]-=1
                
                if dependency[ds[i]] == 0:
                    q.append(ds[i])      
        for i in range(numCourses):
            if dependency[i] != 0:
                return False
        
        return True
