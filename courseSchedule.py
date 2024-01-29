# time: O(n+P)
# n - number of elements , p is prerequisites
#space: O(n) 

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        #we have to create mapping between courses and prerreq to udnerstand 
        #the interdependency
        hashMap ={}
        for c in range(numCourses):
            hashMap[c] =[]
        for cr, pre in prerequisites:
            if cr not in hashMap:
                hashMap[cr] = pre
            else:
                hashMap[cr].append(pre)
        
        visited = set()
        def dfs(cr):
            #it means we have a loop considering we are visiting it again 
            if cr in visited:
                return False 
            
            #if no value means no dependency
            if hashMap[cr] == []:
                return True 

            visited.add(cr)
            for pre in hashMap[cr]:
                if not dfs(pre): 
                    return False
            visited.remove(cr)
            hashMap[cr] =[]
            return True 

        #we need to run the search for every course
        for cr in range(numCourses):
            if not dfs(cr):
                return False
            # val = dfs(cr)
            # if val:
            #     return True
            # else:
            #     return False
        
        return True