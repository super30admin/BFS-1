# time: O(v+e)
# space: O(ve)

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        depCnt = [0]*(numCourses)
        hmap = {}
        q = []
        for pre in prerequisites:
            inde = pre[1]
            dep = pre[0]
            depCnt[dep] += 1
            if inde not in hmap:
                hmap[inde] = []
            hmap[inde].append(dep)
        # print(depCnt)
        # print(hmap)
        count = 0
        # now create the queue
        for i in range(len(depCnt)):
            if depCnt[i] == 0:
                q.append(depCnt[i])
                count += 1
        if count == numCourses:
            return True
        if count == 0:
            return False
        # now initialy q has all the independent elements
        while q:
            ele = q.pop(0)
            if ele not in hmap:
                continue
            children = hmap[ele]
            if children == None:
                continue
            # make cnt --
            # make cnt of the elements dependent on ele reduce by 1: ge tform map
            for c in children:
                depCnt[c] -= 1
                if depCnt[c] == 0:
                    q.append(depCnt[c])
                    count += 1
                if count == numCourses:
                    return True
        return False