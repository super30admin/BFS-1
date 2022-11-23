#Time Complexity :- O(V+E)
#Space Complexity :- O(V+E) because V is the number of nodes that we add in hashMap along with it's edges that we add 
#Approach :- We have used the approach of topological sort in which we add the indepedent elements in the queue at start and then we keep on adding it's edges along with pop


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegrees = []
        hashMap = {}
        queue = []
        for i in range(numCourses):
            indegrees.append(0)

        for preArray in prerequisites:
            input = preArray[0]
            output = preArray[1]
            indegrees[input] +=1
            if output not in hashMap:
                hashMap[output] = []
            hashMap[output].append(input)
        
        courseCompleted  = 0
        for j in range(numCourses):
            if indegrees[j] == 0:
                courseCompleted +=1
                queue.append(j)
        
        while len(queue)>0:
            current = queue.pop(0)
            currentList = hashMap.get(current)
            if currentList is not None:
                for curr in currentList:
                    indegrees[curr] -=1
                    if indegrees[curr] == 0:
                        courseCompleted+=1
                        queue.append(curr)
            
        return courseCompleted == numCourses


      


