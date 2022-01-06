# Time: O(n)
# Space: O(n)
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        dic = {}
        dependency = []
        for i in range(numCourses):
            dic[i] = []
            dependency.append(0)
        
        for prerequisite in prerequisites:
            dependency[prerequisite[0]] += 1
            if prerequisite[1] not in dic:
                dic[prerequisite[1]] = [prerequisite[0]]
            else:
                dic[prerequisite[1]].append(prerequisite[0])
        q = []
        #print(dependency)
        for ind in range(len(dependency)):
            if dependency[ind] == 0:
                q.append(ind)
        while len(q) != 0:
            #print(q)
            curr = q.pop(0)
            #print(curr)
            for ind in dic[curr]:
                if dependency[ind] == 1:
                    dependency[ind] -= 1
                    q.append(ind)
                else:
                    dependency[ind] -= 1
        #is_true = True
        for val in dependency:
            if val > 0:
                return False
        return True
                    
            
                
                
            
        
        
        
                
            
        
