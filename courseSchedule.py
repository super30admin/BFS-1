from typing import List
from collections import defaultdict
import queue
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree=[0  for _  in range(numCourses)]
        graph= defaultdict(list)
        # build the Graph
        for edges in prerequisites:
            ind=edges[0]
            out=edges[1]
            graph[out]=graph[out].append(ind)
            # initiated the dependancy matrix
            indegree[ind]+=1
        # added the independent edge into the queue
        qumanuplation= queue.Queue()
        for vertex in indegree:
            if vertex ==0:
                qumanuplation.put(vertex)

        if qumanuplation.empty(): return False

        while not qumanuplation.empty():
            current=qumanuplation.get()
            if graph[current] is None: continue
            for vertes in graph[current]:
                indegree[vertes]-=1
                if indegree[vertes]==0:
                    qumanuplation.put(indegree[vertes])

        # check the zeros in indegree
        for element in indegree:
            if element>0: return False
        return True


















# time=O(N)
# Space= O(E+v)




if __name__ == '__main__':
    # root=TreeNode(4)
    # root.right=TreeNode(12)
    # root.right.left=TreeNode(11)
    # root.right.right=TreeNode(13)
    # root.left=TreeNode(2)
    # root.left.left=TreeNode(1)
    # root.left.right=TreeNode(3)

    print(Solution().canFinish(numCourses=2,prerequisites=[[1,0],[0,1]]))
