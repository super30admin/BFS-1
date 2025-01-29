############# Course Schedule

# Time Complexity :  O(v+e)
# Space Complexity : O(v+e) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : missed out on some edge cases like if the course does not have a prerequisite or if the prerequisites is empty.


# transform to a graph using adjacency matrix. perform topological sort using kahns algorithm by keepng track of the indegree and repeatedly modifying it. 
# every time we pop an element from the queue increment count and once done with all nodes check if count is equal to the number of courses

from collections import defaultdict

def course_schedule(numCourses, prerequisites):
        if numCourses == 0:
            return True
        
        if not prerequisites:
            return True
        
        graph =  {}
        
        for i in range(numCourses):
            graph[i] = []
            
        
        indegree = defaultdict(int)
        
        for x,y in prerequisites:
            graph[y].append(x)
            indegree[x]+=1
            
            
        queue = [x for x in graph.keys()if indegree[x]==0]
        
        count = 0
        while queue:
            node =  queue.pop(0)
            count +=1
            for child in graph[node]:
                indegree[child]-=1
                if indegree[child] == 0:
                    queue.append(child)
        
        return count == numCourses
