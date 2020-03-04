BFS traversal
Time complexity:O(n)
space complexity:O(n)
Ran on leetcode:Yes
problems faced: took some time to figure the edge cases.
Code Description:
This problem is a graph related question.we stored in map as a adjacency list where the parent node as a key and children as its values.
we tried to eliminate the nodes which are having no dependencies so that we can test the dependencies of its dependent nodes.In this way we stoed these results in a list to know whether all the subjects are completed or not.



from collections import deque,defaultdict
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        if numCourses==0 or len(prerequisites)==0:
            return True
        d=defaultdict(list)
        temp=[0 for i in range(numCourses)]
        for k,v in prerequisites:
            d[v].append(k)
        for n in prerequisites:
            temp[n[0]]=temp[n[0]]+1
        queue=deque([])
        for i in range(len(temp)):
            if temp[i]==0:
                queue.append(i)
        if len(queue)==0:
            return False
        # print(queue)
        while(len(queue)!=0):
            e=queue.popleft()
            # print(e,d[e])
            # print(e)
            u=d[e]
            # print(e,d[e])
            if len(u)!=0:
                for j in d[e]:
                    temp[j]=temp[j]-1
                    if temp[j]==0:
                        queue.append(j)
            # print("temp is ",temp)
        for k in temp:
            if k>0:
                return False
        return True
        
        
        
        