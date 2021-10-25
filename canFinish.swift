

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


    func canFinish(_ numCourses: Int, _ prerequisites: [[Int]]) -> Bool {
        if numCourses == 0 || prerequisites.count == 0 || prerequisites == nil {
            return true
        }
        var inDegree = Array(repeating: 0, count: numCourses)
        var adjacencyList = [Int:[Int]]()
        var queue = [Int]()
        for course in prerequisites {
            var courseFrom = course[1]
            var courseTo = course[0]
            inDegree[courseTo] += 1
            adjacencyList[courseFrom,default: []].append(courseTo)
        }
        for i in 0..<inDegree.count {
            if inDegree[i] == 0 {
                queue.append(i)
            }
        }
        while !queue.isEmpty {
            var courseFrom = queue.removeFirst()
            if let list = adjacencyList[courseFrom] {
                for courseno in list {
                    inDegree[courseno] -= 1
                    if inDegree[courseno] == 0 {
                        queue.append(courseno)
                    }
                }
            }
        }
        for value in inDegree {
            print(value)
            if value != 0 {
                return false
            }
        }
        return true
    }
