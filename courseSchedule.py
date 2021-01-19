# Approach:
# First define a hashmap with the courses and prerequisites and simultaneously increment the degrees list with the courses
# The indegree count should represent the number of prerequistes the course needs in order to be completed
# Initialize the queue and add the independant courses ie those that dont need any prerequisites
# For the corresponding course, in the indegree decrement the list count
# When the count becomes zero,it is now independant and can be added to the queue
# Finally compare if the numOfCourses matches the result count we have, if it does, return True

# Time : O(E + V)
# Space: O(V + E)


def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

    course_count = 0
    queue = []
    degrees = [0] * numCourses
    hashmap = collections.defaultdict(list)

    for course, req in prerequisites:
        hashmap[req].append(course)
        degrees[course] += 1

    for idx in range(len(degrees)):
        if degrees[idx] == 0:
            queue.append(idx)

    while queue:

        current_course = queue.pop(0)
        course_count += 1

        edges = hashmap[current_course]

        for edge in edges:
            degrees[edge] -= 1

            if degrees[edge] == 0:
                queue.append(edge)

    return course_count == numCourses