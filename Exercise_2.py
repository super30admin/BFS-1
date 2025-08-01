# Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
# Space Complexity: O(V + E) for the graph representation and indegrees list
# Were you able to solve this problem on Leetcode?: Yes
# Did you face any challenges while solving the problem? No

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        if numCourses == 1 and len(prerequisites)>=1:
            return True

        
        indegrees = [0] * numCourses
        graph = {}

        
        for i in prerequisites:

            # create an incoming edges list for each node 
            indegrees[i[0]]+=1

            # build the graph adjacency list
            if graph.get(i[1], None):
                graph[i[1]].append(i[0])
            else:
                graph[i[1]] = [i[0]]
            
        count = 0 
        # queue for BFS topological sort
        queue = []


        # find the starting courses which have no dependencies, indegree is 0
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)

        # no course exist with zero dependencies, return false
        if len(queue) == 0:
            return False

        # if the number of courses with no dependencies is equal to the total number of courses
        # then we can finish all courses
        if count == numCourses:
            return True

        while queue:
            # pop the first course from the queue
            # and process its dependencies
            # if the course has dependencies, reduce the indegree of its dependencies
            # if the indegree becomes 0, add it to the queue
            # increment the count of courses processed
            curr = graph.get(queue.pop(0), None)
            if curr:

                for i in curr:
                    if indegrees[i] != 0:
                        indegrees[i] -=1

                    if indegrees[i] == 0:
                        queue.append(i)

                        if count == numCourses:
                            return True

            count+=1
        # if the count of courses processed is equal to the total number of courses
        # then we can finish all courses
        return numCourses == count



        







        
        