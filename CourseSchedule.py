#Time Complexity: O(V+E)
#Space Complexity : O(V+E)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        coursesTaken = 0
        queue = []
        Dependencies = [0]*numCourses
        adjacencyList = {}
        
        for pre in prerequisites:
            Dependencies[pre[0]] += 1
            if(pre[1] not in adjacencyList):
                adjacencyList[pre[1]] = []
                adjacencyList[pre[1]].append(pre[0])
            else:
                adjacencyList[pre[1]].append(pre[0])
        
        for i in range(len(Dependencies)):
            if(Dependencies[i] == 0):
                queue.append(i)
                coursesTaken += 1
        print(Dependencies)
        
        while(queue):
            currCourse = queue.pop()
            if(currCourse in adjacencyList):
                dependents = adjacencyList[currCourse]
                for i in dependents:
                    Dependencies[i] -= 1
                    if(Dependencies[i] == 0):
                        queue.append(i)
                        coursesTaken += 1
                print(Dependencies)
        return coursesTaken == numCourses
