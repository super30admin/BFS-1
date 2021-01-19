# Time Complexity : O(V+E)
# Space Complexity : max(O(V+E))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Initialize an indegree list and for each prerequisite as index increment the index by 1 in list
# Also maintain a HashMap for each vertices as key and values as the courses that are dependent on this key(that is course)
# Then iterate over the indegree list and check if the value on any index == 0, then append it to queue and increment count by 1
# Then iterate over the queue until it is empty and pop the vertices from the queue and check if that vertex exists in HashMap
# If it exists, get the values from the dict and decrement its value on that index in the indegree list by 1
# Again check if that indegree value == 0 then add it to the queue and increment the count by 1


class Solution:
    def canFinish(self, numCourses: int,
                  prerequisites: List[List[int]]) -> bool:
        if not prerequisites:
            return True
        dict = defaultdict(list)
        queue = []
        indegree = [0] * numCourses
        for i in range(len(prerequisites)):
            index = prerequisites[i][0]
            indegree[index] += 1
            dict[prerequisites[i][1]].append(prerequisites[i][0])
        count = 0
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
                count += 1
        while queue:
            node = queue.pop()
            if node in dict:
                for i in dict[node]:
                    indegree[i] -= 1
                    if indegree[i] == 0:
                        queue.append(i)
                        count += 1
        if count != numCourses:
            return False
        return True
