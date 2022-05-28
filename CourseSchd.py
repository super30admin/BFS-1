'''
time complexity: O(V+E)
space complexity: O(V+E)
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if(len(prerequisites)==0): return True
        inbond = [0 for _ in range(numCourses)]
        
        courseDict = defaultdict(list)
        
        for course in prerequisites:
            inbond[course[0]]+=1
            courseDict[course[1]].append(course[0])
        
        queue = []
        count=0
        print(inbond)
        for i in range(len(inbond)):
            if(inbond[i]==0):
                queue.append(i)
                count+=1
        
        print(courseDict)
        if(len(queue)==0): return False
        while(len(queue)!=0):
            curr = queue.pop(0)
            for child in courseDict[curr]:
                inbond[child]-=1
                
                if(inbond[child]==0):
                    queue.append(child)
                    count+=1
                    if(count==numCourses):
                        return True
        return False
                
        