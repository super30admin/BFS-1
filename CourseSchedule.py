#Time Complexity: O(V+E)
#Space: O(V+E)
#Successfully ran on leetcode

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if len(prerequisites)==0 or numCourses==0:
            return True
        dependency = {}
        prereqs = {}
        courses = 0
        for i in range(numCourses):
            prereqs[i] = 0
        for i in range(len(prerequisites)):
            ai = prerequisites[i][0]
            bi = prerequisites[i][1]
            prereqs[ai]+=1
            if bi not in dependency:
                dependency[bi] = [ai]
            else:
                dependency[bi].append(ai)
        queue = []
        for i in range(len(prereqs)):
            if prereqs[i]==0:
                queue.append(i)
                courses+=1
        print(prereqs)
        while queue:
            x = queue.pop(0)
            if x in dependency:
                for i in dependency[x]:
                    prereqs[i]-=1
                    if prereqs[i]==0:
                        queue.append(i)
                        courses+=1
        print(dependency,prereqs)
        return numCourses==courses