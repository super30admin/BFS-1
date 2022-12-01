
# # Problem 2
# Course Schedule (https://leetcode.com/problems/course-schedule/)
# TC : O(n)
# SC : O(n)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        dependency = [0] * numCourses
        track = []
        d = defaultdict(list)
        for i in prerequisites:
            dependency[i[0]] += 1
            d[i[1]].append(i[0])
        # print(d, dependency)
        for j in range(len(dependency)):
            if dependency[j]==0:
                track.append(j)
        while track:
            curr = track.pop(0)
            res =  d[curr]
            if res:
                for i in res:
                    dependency[i] -= 1
                    if dependency[i]==0:
                        track.append(i)
        # print(dependency)
        for k in dependency:
            if k!=0:
                return False
        return True