# As taught in class, used topological sort to solve the problem
# Time Complexity: O(E+V)
# Space Complexity: O(n)
from collections import defaultdict 
def canFinish(courses,prereq):
    indegrees = [0] * courses
    maps = dict()#defaultdict(list) 
    for i in range(len(prereq)):
        indegrees[prereq[i][0]] = indegrees[prereq[i][0]] + 1
        if (prereq[i][1] not in maps):
            maps[prereq[i][1]] = list()
        maps[prereq[i][1]].append(prereq[i][0])
    q = list()
    for i in range(len(courses)):
        if indegrees[i] == 0:
            q.append(i)
    while(len(q)!=0):
        current = q.pop(0)
        child = maps[current]
        for c in child:
            indegrees[c] = indegrees[c] - 1
            if(indegrees[c]==0):
                q.append(c)
    for i in range(courses):
        if (indegrees[i]>0):
            return False
    return True


courses = 2
pre = [[1,0],[0,1]]
res = canFinish(courses,pre)
print(res)