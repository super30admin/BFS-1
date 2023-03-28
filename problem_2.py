# Time Complexity - O(V+E)
# Space Complexity - O(V+E)


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dictionary = {}
        indegree = [0] * numCourses
        q = []
        for each in prerequisites:
            inVal = each[0]
            outVal = each[1] 
            indegree[inVal] += 1 

            if outVal in dictionary: 
                dictionary[outVal].append(inVal)
            else:
                dictionary[outVal] = [inVal] 


        count = 0
        for i in range(numCourses):
            if indegree[i] == 0 :
                q.append(i) 
                count += 1 

        while len(q)> 0 : 
            val = q.pop(0)
            if val in dictionary :

                children = dictionary[val]
            
                for i in range(len(children)):
                    indegree[children[i]] -= 1
                    if indegree[children[i]] == 0 :
                        q.append(children[i]) 
                        count += 1 
               
                
            
        if count == numCourses :
            return True 

        return False

        

        

        

