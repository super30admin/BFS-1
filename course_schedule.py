


from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        queue = deque([])

        hashmap = {}

        if prerequisites == None or len(prerequisites) == 0: return True

        for i in range(numCourses):
            hashmap[i] = []

        temp_list = [0] * numCourses

        for courses in prerequisites:
            hashmap[courses[1]].append(courses[0])
            temp_list[courses[0]] += 1

        print(hashmap)
        print(temp_list)
        # finding the independent course
        root = []
        for i in range(len(temp_list)):
            if temp_list[i] == 0:
                root.append(i)
                queue.append(i)

        print("Root", root)
        if len(root) == None: return False

        while (len(queue) != 0):
            print("Queue", queue)
            current_course = queue.popleft()
            print("Current course", current_course)
            if len(hashmap[current_course]) != 0:
                for i in range(len(hashmap[current_course])):
                    temp_list[hashmap[current_course][i]] -= 1

                    if (temp_list[hashmap[current_course][i]] == 0):
                        queue.append(hashmap[current_course][i])

        # print(temp_list)
        if sum(temp_list) > 0:
            return False
        else:
            return True