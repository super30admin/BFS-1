
# TOPOLOGICAL SORTING OF NODES IN GRAPH, as processing of one node is dependent on processing nodes before it
# BFS of all the nodes connected to it 
# DataStructures used: HashMap (representing the Graph in HashMap, with dependents of each course --> O(1) retrieval); 
#                      Array (maintains no.of.prereqs to be completed for each course)
#                      Queue (BFS on the graph node)

# time : O(V+E)
# space : O(V+E)

class Solution:
    def canFinish(self, numCourses, prerequisites):

        # the dependent is at the index 1 in each prerequisites array
        # [[1,0]], we need to increase the count at prerequisites[i][1] of our indegrees array

        indegrees = [0 for i in range(numCourses)]
        graph = {}     # { course: [dependents] }
        q = []

        for i in range(len(prerequisites)):
            indegrees[prerequisites[i][0]] += 1
            if prerequisites[i][1] not in graph:
                graph[prerequisites[i][1]] = [prerequisites[i][0]]    
            else:
                graph[prerequisites[i][1]].append(prerequisites[i][0]) 
        
        # start BFS on the node that has no prereqs
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                q.append(i)
        while q != []:
            course = q.pop(0)
            if course in graph:
                children = graph[course] 
                for child in children:
                    indegrees[child] -= 1             # decrease the dependents of the course by 1
                    if indegrees[child] == 0:
                        q.append(child)

        for i in range(len(indegrees)):
            if indegrees[i] != 0:
                return False
        return True


obj = Solution()
print(obj.canFinish(numCourses=2, prerequisites=[[1,0]]))
