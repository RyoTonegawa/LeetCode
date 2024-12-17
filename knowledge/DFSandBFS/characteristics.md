# The Diffelence Of The DFS And BFS

## Check If You're unsure whether it's BFS or DFS

BFS is

1. Queue based traversal
2. Level-by-Level Exploration
3. No Recursion

## DFS

DFS offers an advantage when aiming to simplify
implementation due to its straightforward and recursive nature.

### Implementation

generally easier to implement recursively.
However, for very large binaryTree or a very large grids,
rucursive DFS can lead to stackoverflow errors.

### Rentime Performance

This might have slightly better cache locality in some
implementations,
potentially offering marginal speed benefits.

## BFS

BFS demonstrates superiority when handling large binary tree or
graphs by effectively preventing stack overflow issues.

### Implementation

typically implemented using a queue,
which is straightforward and avoids recursion depth issues

### Rentime Performance

BFS can be more efficient in scenarios where islands are shallow,
as it explores level by level.
