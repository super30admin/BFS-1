# Time Complexity : O(Vertices + edges) where vertices is numCourses
# Space Complexity : O(vertices + edges) where vertices is numCourses
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
            IS:
                - directed graph ...'
                things to ask: build a graph based on given input? visited set necessary?
                DID DFS WAY.. will put BFS approach later
        """
        if len(prerequisites)  == 0:
            return True
        
        #build graph..want to know how many nodes point to this node know no.of prereq at I
        holder = [0] * (numCourses)
        for i in range(len(prerequisites)):
            holder[prerequisites[i][0]] += 1

        stack = [] 
        for i in range(0,len(holder)):
            if holder[i] == 0:
                stack.append(i)
        count = 0 
        while stack:
            curr = stack.pop()
            count += 1
            for i in range(len(prerequisites)):  #process graph node and DFS iteratively
                if prerequisites[i][1] == curr:
                    holder[prerequisites[i][0]] -= 1
                    if (holder[prerequisites[i][0]] == 0):
                        stack.append(prerequisites[i][0])
                    
        return count == numCourses