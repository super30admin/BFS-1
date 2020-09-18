# Time complexity - O(V + E) V- no.of courses, E -  prerequisites
# space complexity - O(V + E)
# using topological sort, index Array and hashmap







#[[2,0],[4,0],[1,2],[1,4],[3,2],[5,3]]

#indexArr - 0 1 2 3 4 5 
#           0 2 1 1 1 1

# dic 
# 0 - [2,4]
# 2 - [1,3]
# 4 - [1]
# 3 - [5]



class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        indexArr = [0] * numCourses
        dic = {}
        count = 0
        
        for i in prerequisites:
            if i[1] not in dic:
                dic[i[1]] = [i[0]]
                indexArr[i[0]] += 1
            else:
                dic[i[1]].append(i[0])
                indexArr[i[0]] += 1
                
        q = deque()
        for i in range(0,len(indexArr)):
            if indexArr[i] == 0:
                q.append(i)
        
        while q:
            
            temp = q.popleft()
            if temp in dic: 
                for i in dic[temp]:
                    indexArr[i] -= 1
                    if indexArr[i] == 0:
                        q.append(i)
            count += 1
            
        return count == numCourses
            
            
