class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        """
        Time Complexity: O(V + E)
        Space Complexity: O(V + E)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this: No
        Your code here along with comments explaining your approach:
        The approach: 
            - BFS
            - Get the dependency map 
            - create an in_lst where each index represents the corresponding course.
            increase the value by 1 if the course is dependent on another course
            - create a queue list
            - Initially add only the independent course
            - now use the dependency map and see which course are dependent on the 
            first node in the q list. Reduce the counter by 1  for the dependent course
            in the in_lst. 
                - if the count == 0 -> add it to the queue 
            - Add a counter for everytime a course is added in the q lst
            - If counter == numCourse return True
            - else return False
        """      
        map = dict()
        q = list()
        in_lst = [0 for i in range(0, numCourses)]
        for i in prerequisites:
            in_lst[i[0]] += 1
            if i[1] in map:
                map[i[1]].append(i[0])
            else:
                map[i[1]] = [i[0]]

        count = 0
        for i in range(0, len(in_lst)):
            if in_lst[i] == 0:
                q.append(i)
                count += 1

        while (len(q) > 0):
            a = q.pop(0)
            if a in map:
                for dependency in map[a]:
                    in_lst[dependency] -= 1
                    if in_lst[dependency] == 0:
                        q.append(dependency)
                        count += 1
        if count == numCourses:
            return True
        return False
