#Time complexity for put and get: O(V+E)
#Space complexity: O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        adj_list = defaultdict(list)
        indegree = {}
        
        for src,dest in prerequisites:
            adj_list[dest].append(src)
            indegree[src] = indegree.get(src,0)+1
        
        indegreezeroq = deque()
        for course in xrange(numCourses):
            if course not in indegree:
                indegreezeroq.append(course)
        final_order = []
        while indegreezeroq:
            node = indegreezeroq.popleft()
            final_order.append(node)
            if node in adj_list:
                li = adj_list[node]
                for el in li:
                    indegree[el] -= 1
                    if indegree[el] == 0:
                        indegreezeroq.append(el)
        
        return len(final_order) == numCourses