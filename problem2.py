# problem 2 

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        course_count = [0]*numCourses
        my_graph = {}

        for prerequisite in prerequisites:
            course_count[prerequisite[0]] +=1
            if prerequisite[1] not in my_graph:
                my_graph[prerequisite[1]]= []
            my_graph[prerequisite[1]].append(prerequisite[0])
        
        check_queue = deque()
        count = 0
        for i in range(numCourses):
            if course_count[i] == 0:
                check_queue.append(i)
                count+=1
        
        
        if not check_queue:
            return False 
        if count == numCourses:
            return True 

        while(check_queue):
            curr_class = check_queue.popleft()
            graph_vals = my_graph.get(curr_class)
            if graph_vals:
                for graph_val in graph_vals:
                    course_count[graph_val] -=1
                    if course_count[graph_val] == 0:
                        count+=1
                        check_queue.append(graph_val)
                        if count == numCourses:
                            return True
        return False