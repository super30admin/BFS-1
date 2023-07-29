#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_arr=[0 for i in range(numCourses)]
        course_map={}
        count=0
        queue=collections.deque()
        for course in prerequisites:
            course_arr[course[0]]+=1
            if not course_map.get(course[1]):
                course_map[course[1]]=[]
            course_map[course[1]].append(course[0])
        
        for j in range(0,len(course_arr)):
            if course_arr[j]==0:
                queue.append(j)
                count=count+1
        
        if count==numCourses:
            return True

        while queue:
            c=queue.popleft()
            if course_map.get(c):
                values=course_map[c]
                for v in values:
                    course_arr[v]=course_arr[v]-1
                    if course_arr[v]==0:
                        queue.append(v)
                        count=count+1
                        if count==numCourses:
                            return True

        return False
        
            

        


        
            
            
