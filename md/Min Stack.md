## [Min Stack](https://leetcode.com/problems/min-stack/)

### Problem

 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

- push(x) -- Push element x onto stack.
- pop() -- Removes the element on top of the stack.
- top() -- Get the top element.
- getMin() -- Retrieve the minimum element in the stack.


### Solution


### Code

``` Python
class MinStack:
    def __init__(self):
        self.elements = []
        self.mins = []
    # @param x, an integer
    # @return an integer
    def push(self, x):
        self.elements.append(x)
        if len(self.mins) == 0 or x < self.mins[-1]:
            self.mins.append(x)
        else:
            self.mins.append(self.mins[-1])

    # @return nothing
    def pop(self):
        self.elements.pop()
        self.mins.pop()

    # @return an integer
    def top(self):
        return self.elements[-1]
        
    # @return an integer
    def getMin(self):
        return self.mins[-1]
```

### Refinement
