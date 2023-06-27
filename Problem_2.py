# Time Complexity: O(A + B)
# Space Complexity: O(A + B)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        course = collections.defaultdict(set)
        curr = collections.defaultdict(set)
        for x, y in prerequisites:
            course[x].add(y)
            curr[y].add(x)
        currcourse = [n for n in range(numCourses) if not course[n]]
        count = 0
        while currcourse:
            num = currcourse.pop()
            count+=1
            for x in curr[num]:
                course[x].remove(num)
                if not course[x]:
                    currcourse.append(x)
        return count == numCourses