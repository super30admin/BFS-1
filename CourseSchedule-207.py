# Time Complexity : O(n)
# Space Complexity : O(n) n no of course
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

def canFinish(self, numCourses, prerequisites):
    #1. create array for incoming edges to every node
    incomingEdges = [0] * numCourses
    #2. adjacency list to keep track of edges going out from every node
    res = {}


    for pre in prerequisites:
        indegree = pre[0]
        outdegree = pre[1]
        
        #3. for every incoming edge increment count
        incomingEdges[indegree] += 1

        #4. for every outgoing edge add the nodes
        if outdegree not in res:
            res[outdegree] = []
        res[outdegree].append(indegree)
    
    #5. check for the starting point having no indegree
    queue = []
    for i in range(0, len(incomingEdges)):
        if incomingEdges[i] == 0:
            queue.append(i)
    
    #6. Go step wise and decrement counter for every node if visisted from incoming edges
    while queue:
        course = queue.pop(0)
        #get children from the map
        if course in res:
            children = res[course]
            for child in children:
                incomingEdges[child] -= 1
                if incomingEdges[child] == 0:
                    queue.append(child)
    

    #7. Check if all the nodes has 0 incoming edges value
    for i in incomingEdges:
        if i != 0:
            return False
    return True
        