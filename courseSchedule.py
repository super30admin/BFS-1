'''
Time Complexity -->
O(n)

Space Complexity -->
O(n)
'''

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dit = defaultdict(list)
        ls = [0 for x in range(numCourses)]
        for i in range(len(prerequisites)):
            ls[prerequisites[i][0]]+=1
        #print(ls)    #this is to calculate all the inbounds
        q = []       #This queue data structure is used monitor the dependency
        for i in range(len(ls)):
            if ls[i]==0:
                q.append(i)
        if len(q)==0:    #If all the courses have inbounds then return false
            return False
        else:
            
            #Create adjacency list here
            for i in range(len(prerequisites)):
                dit[prerequisites[i][1]].append(prerequisites[i][0])
            
            #print(dit)
            
            
            while q:
                l = len(q)
                for i in range(l):
                    s = q.pop(0)
                    lis = []
                    if s in dit:
                        lis = dit[s]
                    for i in lis:
                        ls[i]-=1
                        if ls[i]==0:
                            q.append(i)
            
            for i in range(len(ls)):
                if ls[i]!=0:
                    return False
            return True
            
                        
                    
                        
                    
        
        