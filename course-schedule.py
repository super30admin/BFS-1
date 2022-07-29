"""
Time Complexity:
O(V + E) - because we traverse all the edges corresponding to particular vertex with respect to adjacency list.
Space Complexity;
O(V+E)- we initiate a hashmap with vertex as the key and edges as the value. Indegrees array hold O(V) space.
Yes, the code worked on leetcode.
The idea behind the algorithm is to maintain a adjacency list as the value and the courses/int as the key in hashmap. We also
declare indegrees array which is used to keep count of all the courses with prerequisites. For example, if 1 has 2 incoming edges then the value at particular couse 1 will be 2.
We then declare a queue and add the element which has no incoming edge. We then pop the element and look for its adjacency list in hashmap and we iterate over the list,
we decrement the elements count in indegrees array by 1 over each iteration and when the value becomes 0, we add that element to the queue. This means you have completed the course and now the prerequisite
criteria for other courses are met. The loop goes on until all the courses have been traversed. At the end we check the indegrees list and if any one of the course has value greater than 0, then it means the course cannot be completed so we return False
else True. 
"""


from queue import Queue
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses == 0:
            return True
        adj_list = {}
    
        indegrees = [0 for i in range(numCourses)]
        
        for req in prerequisites:
            in_ = req[0]
            out = req[1]
            indegrees[in_]+=1
            
            if out not in adj_list:
                adj_list[out] = []
            
            adj_list[out].append(in_)
        
        q = []
        
        for i in range(numCourses):
            if indegrees[i]==0:
                q.append(i)
        
        while q:
            curr = q.pop(0)
            edges = adj_list.get(curr)
            if not edges:
                continue
            for edge in edges:
                indegrees[edge]-=1
                
                if (indegrees[edge] ==0):
                    q.append(edge)
                    
        for i in range(numCourses):
            if indegrees[i]!=0:
                return False
        return True
        
        
        