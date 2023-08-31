# # Problem 2
# Course Schedule (https://leetcode.com/problems/course-schedule/)
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
from collections import deque


def canFinish(numCourses, prerequisites):
    # if no prerequisites
    if not prerequisites:
        # can finish
        return True
    # taking a hashmap of {independent course : dependent courses}
    hashmap = {}
    # indegrees list
    indegrees = [0] * numCourses
    # creating a hashmap of dependent to independent variables
    for pr in prerequisites:
        # pr[0] --> dependent pr[1] --> independent
        indegrees[pr[0]] += 1
        # if independent node not already present
        if pr[1] not in hashmap:
            # add it
            hashmap[pr[1]] = []
        # if present, add the dependent node
        hashmap[pr[1]].append(pr[0])
    # counting number of courses
    count = 0
    # Making a queue
    q = deque()
    # iterating over the indegrees
    for i in range(len(indegrees)):
        # adding all independent nodes
        if indegrees[i] == 0:
            # getting count of independent ones
            count += 1
            # adding it to q
            q.append(i)

    if not q:
        return False

    # bfs
    while q:
        # popping out value from q
        curr = q.popleft()
        # getting hashmap value of dependent subjects
        dependent_nodes = hashmap.get(curr)
        if dependent_nodes:
            for dependent_node in dependent_nodes:
                indegrees[dependent_node] -= 1
                # if node has become independent
                if indegrees[dependent_node] == 0:
                    # increasing count of independent nodes
                    count += 1
                    q.append(dependent_node)
                    if count == numCourses:
                        return True
    return False


numCourses = 2
prerequisites = [[1, 0]]
print(canFinish(numCourses, prerequisites))
