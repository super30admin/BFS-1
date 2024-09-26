# Leetcode 207. Course Schedule

# Time Complexity :  O(V + E) where V is the no. of the nodes, E is the no. of edges i.e len(prerequisites)

# Space Complexity : O(V + E) where V is the no. of the nodes, E is the no. of edges i.e len(prerequisites)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: For every edge in the prerequesites, increment the indegree value for every incoming node
# and check in the hashmap for the outgoing node, if its present append the incoming node in the current
# edge to value array for the outgoing node in the hashmap. Append the nodes that are independent, i.e.
# have a 0 in the indegree to the Q. While processing the Q, pop the leftmost node and fetch the child nodes
# of the node from hashmap. For every child node, decrement the indegree value and if the indegree value 
# reaches 0, add it to the Q as it is an independent node that can be processed. Once the Q is empty,
# if the indegree values for all the nodes is 0, then return true else false.

# Your code here along with comments explaining your approach

from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not prerequisites or len(prerequisites)==0:
            return True

        count = 0
        # Array to store the indegrees for each node
        inDegree = [0]*numCourses
        hashMap = dict()
        q = deque()

        for edge in prerequisites:
            inDegree[edge[0]]+=1
            # check if the indegree nodes for every node in the edge are in hashmap, if not add them
            if edge[1] not in hashMap:
                hashMap[edge[1]]=[]
            hashMap[edge[1]].append(edge[0])

        # If the initial indegree of any node is zero, add it to Q for processinf
        for i in range(len(inDegree)):
            if inDegree[i]==0:
                q.append(i)

        if len(q)==0:
            return False

        while(q):
            # Pop the left most entry from Q and get its children from hashMap
            node = q.popleft()
            childrenOfNode = hashMap.get(node)
            if childrenOfNode!=None:
                # for every child of the node reduce their indegree
                for child in childrenOfNode:
                    inDegree[child]-=1
                    # If the indegree reaches 0, the child is independent & can be processed, 
                    # so add to Q
                    if(inDegree[child]==0):
                        q.append(child)

        # check if indegree of all nodes is all 0 and return true else return False
        for i in range(len(inDegree)):
            if inDegree[i]>0:
                return False

        return True