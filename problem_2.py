# TC: O(n) n == number of subjects
# SC: O(n) n == number of subjects

from collections import defaultdict, deque


def canFinish(numCourses, prerequisites):
    # No pre reqs
    if len(prerequisites) == 0: return True

    d = defaultdict(list)
    a = [0 for x in range(numCourses)]
    for x in prerequisites:
        a[x[0]] += 1
        d[x[1]].append(x[0])
    
    q = deque()
    counter = 0
    for idx in range(len(a)):
        if a[idx] == 0:
            q.append(idx)
            
    while(q):
        pop_ele = q.popleft()
        counter += 1
        l = d[pop_ele]
        for j in l:
            a[j] -= 1
            if a[j] == 0: q.append(j)
    
    return counter == numCourses
