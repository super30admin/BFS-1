#Time Complexity : O(V+E), V being the nodes and E being the edges of the graph created by the courses
#Space Complexity : O(V+E), V being the nodes and E being the edges of the graph created by the courses
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Forgot the part where only nodes/courses becoming 
#"independent" are added to the queue. Had to really debug with solution to figure out. 

#Your code here along with comments explaining your approach in three sentences only
'''Create an array where the dependent courses are kept track of and a dict where the edges of the 
graph are kept track of. Using a queue, bfs, add nodes that are independent or become independent
and reduce the corresponding value dependent array. If at end there is a value greater than 0, then
the results is false. 
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #populate the dependent representing courses and the dictionary representing edges. 
        dependents = [0 for i in range(numCourses)]
        dict_prereq = {}
        for p in prerequisites:
            dependent = p[0]
            independent = p[1]
            dependents[p[0]] = dependents[p[0]]+1
            if independent not in dict_prereq.keys():
                dict_prereq[independent] = [dependent]
            else:
                dict_prereq[independent].append(dependent)
        #create a queue and add initial independent nodes
        queue = []
        for i in range(numCourses):
            if dependents[i]==0:
                queue.append(i)
        #reduce by 1 the dependent nodes, and increase the queue if node becomes independent. 
        while(len(queue)>0):
            length = len(queue)
            for i in range(length):
                course = queue[i]
                if course in dict_prereq.keys():
                    d = dict_prereq[course] 
                    dict_prereq.pop(course)
                    for i in d:
                        dependents[i]=dependents[i]-1
                        if dependents[i]==0:
                            queue.append(i)
            for i in range(length):
                queue.pop(0)
        # results is False if any value in dependents are still greater than 0. 
        if max(dependents)>0:
            return False
        return True