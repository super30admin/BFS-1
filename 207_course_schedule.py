from collections import defaultdict


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
                https://leetcode.com/problems/course-schedule/
                // Time Complexity : O(V * E)
                // Space Complexity : O(V + E)
                // Did this code successfully run on Leetcode : Yes
                // Any problem you faced while coding this : No
                // Three line explanation of solution in plain english :
                    - make an adjacency list for graph using default dict
                    - make an indegree dict with each node and corresponding
                      nodes pointing to it
                    - start with with any edge with indegree zero
                    - if all indegrees are zero, then courses can be completed
        """

        if not prerequisites:
            return True

        # make adj list
        # make indegree dic
        adj_list = defaultdict(list)
        indegree = defaultdict(int)

        for edge in prerequisites:
            # adj list
            adj_list[edge[1]].append(edge[0])
            # add to indegree
            indegree[edge[0]] += 1
            indegree[edge[1]] += 0

        # find all node with indegree zero
        stack = list(filter(lambda x: indegree[x] == 0, indegree.keys()))

        # no element with indegree zero, so the graph has a cycle
        if not stack:
            return False

        while stack:
            cur_node = stack.pop()
            # get all adjacent edges
            adj_edges = adj_list[cur_node]
            for edge in adj_edges:
                indegree[edge] -= 1
                if indegree[edge] == 0:
                    stack.append(edge)

        # if any of the nodes still have an indegree > 0
        # this means that this course cannot be taken and
        # there is an interdependency on some other course
        for i in indegree.values():
            if i != 0:
                return False
        return True
