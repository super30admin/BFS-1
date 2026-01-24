/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}

Intuition:
I model courses as a directed graph where edges represent prerequisites.
I track how many prerequisites each course has using an in-degree array and store dependencies in an adjacency map.
Courses with in-degree `0` are added to a queue since they can be taken first. Using BFS, I process courses, reduce the in-degree of their dependents, and add new `0` in-degree courses to the queue.
If all courses are processed, there’s no cycle and we can finish; otherwise, a cycle exists.
T.C: O(V+E)
S.C: O(V+E)
 */
var canFinish = function (numCourses, prerequisites) {
    // create in degree array
    const inDegree = Array.from({
        length: numCourses
    }).fill(0);
    // adj map to store parent and child relationship
    let adjacencyMap = new Map();
    for (let i = 0; i < prerequisites.length; i++) {
        const [child, parent] = prerequisites[i];
        inDegree[child]++;
        if (adjacencyMap.has(parent)) {
            const currList = adjacencyMap.get(parent);
            currList.push(child);
        } else {
            adjacencyMap.set(parent, [child]);
        }
    };

    const queue = [];
    for (let i = 0; i < inDegree.length; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
        }
    }
    // bfs
    let idx = 0;
    while (idx < queue.length) {
        const currLength = queue.length - idx;
        const course = queue[idx++];
        const childs = adjacencyMap.get(course);
        if (childs?.length) {
            for (let j = 0; j < childs.length; j++) {
                const child = childs[j];
                // decrease the indegree as the parent is processed
                inDegree[child]--;
                // if the inDegree of a child is 0, add it to the queue.
                if (inDegree[child] === 0) queue.push(child);
            }

        }
    }
    // if queue got all the courses that are given as input return true, oterwise false
    return queue.length === numCourses;
};