class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        courseMapping = {}
        courseArr = [0]*(numCourses)
        queue = []
        
        for val in prerequisites:
            
            courseArr[val[0]] += 1
            
            if not courseMapping.get(val[1]):
                
                courseMapping[val[1]] = [val[0]]
            
            else:
                courseMapping[val[1]].append(val[0])
                
        for i in range(len(courseArr)):
            if courseArr[i] == 0:
                queue.append(i)


        count = 0 
        
        while queue:
            
            count = count + 1
            curr = queue.pop(0)
 
            if courseMapping.get(curr):
                
                for val in courseMapping.get(curr):
                    
                    courseArr[val] -= 1
                    
                    if courseArr[val] == 0:
                        
                        queue.append(val)
                        
        if count != numCourses:
            return False
        
        return True
                    
