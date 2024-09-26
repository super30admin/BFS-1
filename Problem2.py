# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        arr = [0] * numCourses
        for i in range(len(prerequisites)):
            arr[prerequisites[i][0]] += 1
        print(arr)

        count = 0
        queue = []
        for num in range(numCourses):
            if arr[num] == 0:
                count += 1
                queue.append(num)
        if len(queue) == 0:
            return False

        while queue and count < numCourses:
            num = queue.pop(0)
            for i in prerequisites:
                if i[1] == num:
                    arr[i[0]] -= 1
                    if arr[i[0]] == 0:
                        queue.append(i[0])
                        count += 1
        for i in arr:
            if i != 0:
                return False
        return True





