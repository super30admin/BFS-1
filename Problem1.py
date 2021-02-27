"""
207. Course Schedule
Time Complexity - O(V+E) i.e. Vertex and edges of graph created
Space Complexity - O(V+E)

Making a adjacency list with key as from value and values as to values
Create a indegree list where its index represent values and value at that index gives information about how many pre-reqs we need to complete to complete that course.Hence checking values as 0 in indegree queue and pushing those index.
Now pop those index and check if it is pre req for any other courses if yes then after popping decreasing there count by 1 again appending value = 0 in indegree list 
if indegree has all values 0 return True
else return False"""
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0]*numCourses 
        hashmap = {}
        
        for no in prerequisites:
            to = no[1]
            from_val = no[0]
            
            indegree[to] += 1
            
            if from_val in hashmap:
                hashmap[from_val].append(to)
            else:
                hashmap[from_val] = [to]
        print(hashmap)    
        queue = []
        for i in range(0,numCourses):
            if indegree[i] == 0:
                queue.append(i)
                
        while(queue):
            front = queue.pop(0)
            if front in hashmap:
                for value in hashmap[front]:
                    indegree[value] -= 1
                    if indegree[value] == 0:
                        queue.append(value)
            print(indegree)
                        
        for x in range(len(indegree)):
            if indegree[x] != 0:
                return False
        return True