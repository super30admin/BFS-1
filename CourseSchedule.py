#207. Course Schedule
"""
Time Complexity : O(v + E)
Space Complexity : O(V)
"""
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #null
        if len(prerequisites) == 0 or numCourses == 1:
            return True
        
        # create array of no. of incomming nodes
        arr = [0] * numCourses
        for i in prerequisites:
            arr[i[0]] += 1
            
        #print("arr = ", arr)
        
        #create a dictionary independent : dependent
        d = dict()
        d = {i:[] for i in range(numCourses)}
        for i in prerequisites:
            d[i[1]].append(i[0])
        
        #print(d)
        
        #insert all the nodes with zero incomming
        q = deque()
        count = 0
        for i in range(0, len(arr)):
            if arr[i] == 0:
                q.append(i)
                count += 1
                
        #print(q)
        
        #logic
        while q:
            #print(q, arr)
            n = q.popleft()
            li = d.get(n)
            for ele in li:
                arr[ele] -= 1
                
                if arr[ele] == 0:
                    q.append(ele)
                    count += 1
                    if count == numCourses:
                        return True
                    
                    
        return False
