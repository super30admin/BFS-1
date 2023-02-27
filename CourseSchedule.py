"""
Rasika Sasturkar
Time Complexity: O(V+E)
Space Complexity: O(V+E)
"""

from collections import deque


def canFinish(numCourses, prerequisites) -> bool:
    """
    Solved like graph of the courses where the vertices are courses
    and edges directed from pre-req courses with the help of
    adjacency lists and a queue.
    """
    adj_list = {i: [] for i in range(numCourses)}
    in_degrees = [0 for _ in range(numCourses)]
    for pre_req in prerequisites:
        in_degrees[pre_req[0]] += 1

        # from independent to dependent
        # if pre_req[1] not in adj_list:
        #     adj_list[pre_req[1]] = []
        adj_list[pre_req[1]].append(pre_req[0])

    # initial queue
    queue = deque()
    count = 0
    for i in range(numCourses):
        if in_degrees[i] == 0:
            queue.append(i)
            count += 1

    if len(queue) == 0:
        return False

    while queue:
        curr = queue.popleft()
        children = adj_list[curr]  # list
        for child in children:
            in_degrees[child] -= 1
            if in_degrees[child] == 0:
                queue.append(child)
                count += 1
    return count == numCourses


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(canFinish(numCourses=2, prerequisites=[[1, 0]]))  # returns True
    print(canFinish(numCourses=2, prerequisites=[[1, 0], [0, 1]]))  # returns False


if __name__ == "__main__":
    main()
