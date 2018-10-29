# NQueens Puzzle

Place n non-attacking queens on an nxn chessboard

Overview
---
Uses local search algorithms to search for solutions in the state space. Local search demonstrates that modifying states can be more practical than using an initial state to search for solutions. Local search is used when the path to the solution isn't important. Local search can find solutions in large or infinite state spaces that are continuous. A local search algorithm is complete if it always finds a goal if one exists.

Implementation
---
- [Shotgun Hill Climbing](https://en.wikipedia.org/wiki/Hill_climbing#Variants "Random-Restart Hill Climbing")
- [Genetic Algorithm](https://en.wikipedia.org/wiki/Genetic_algorithm "Genetic Algorithm")

Shotgun Hill Climbing
---
Also known as Random-Restart Hill Climbing, Shotgun Hill Climbing is complete. Given a random instance it will explore the state space around the instance in search for the best instance based on the heuristic value. The heuristic is the number of attacking queens with a goal score of 0.<br> 

For example, for the state 57401163 the follwing state space will be searched:
```
[0,7,4,0,1,1,6,3]Score:6 [5,0,4,0,1,1,6,3]Score:6 [5,7,0,0,1,1,6,3]Score:5 [5,7,4,1,1,1,6,3]Score:6
[1,7,4,0,1,1,6,3]Score:6 [5,1,4,0,1,1,6,3]Score:8 [5,7,1,0,1,1,6,3]Score:7 [5,7,4,2,1,1,6,3]Score:6
[2,7,4,0,1,1,6,3]Score:5 [5,2,4,0,1,1,6,3]Score:6 [5,7,2,0,1,1,6,3]Score:5 [5,7,4,3,1,1,6,3]Score:8
[3,7,4,0,1,1,6,3]Score:6 [5,3,4,0,1,1,6,3]Score:7 [5,7,3,0,1,1,6,3]Score:7 [5,7,4,4,1,1,6,3]Score:5
[4,7,4,0,1,1,6,3]Score:5 [5,4,4,0,1,1,6,3]Score:8 [5,7,5,0,1,1,6,3]Score:5 [5,7,4,5,1,1,6,3]Score:7
[6,7,4,0,1,1,6,3]Score:8 [5,5,4,0,1,1,6,3]Score:8 [5,7,6,0,1,1,6,3]Score:6 [5,7,4,6,1,1,6,3]Score:5
[7,7,4,0,1,1,6,3]Score:5 [5,6,4,0,1,1,6,3]Score:7 [5,7,7,0,1,1,6,3]Score:6 [5,7,4,7,1,1,6,3]Score:6

[5,7,4,0,0,1,6,3]Score:5 [5,7,4,0,1,0,6,3]Score:5 [5,7,4,0,1,1,0,3]Score:8 [5,7,4,0,1,1,6,0]Score:5
[5,7,4,0,2,1,6,3]Score:4 [5,7,4,0,1,2,6,3]Score:4 [5,7,4,0,1,1,1,3]Score:7 [5,7,4,0,1,1,6,1]Score:7
[5,7,4,0,3,1,6,3]Score:3 [5,7,4,0,1,3,6,3]Score:4 [5,7,4,0,1,1,2,3]Score:8 [5,7,4,0,1,1,6,2]Score:4
[5,7,4,0,4,1,6,3]Score:5 [5,7,4,0,1,4,6,3]Score:3 [5,7,4,0,1,1,3,3]Score:8 [5,7,4,0,1,1,6,4]Score:7
[5,7,4,0,5,1,6,3]Score:3 [5,7,4,0,1,5,6,3]Score:5 [5,7,4,0,1,1,4,3]Score:7 [5,7,4,0,1,1,6,5]Score:6
[5,7,4,0,6,1,6,3]Score:5 [5,7,4,0,1,6,6,3]Score:3 [5,7,4,0,1,1,5,3]Score:6 [5,7,4,0,1,1,6,6]Score:5
[5,7,4,0,7,1,6,3]Score:3 [5,7,4,0,1,7,6,3]Score:5 [5,7,4,0,1,1,7,3]Score:6 [5,7,4,0,1,1,6,7]Score:6
```
This will result in the best state of ```[5,7,4,0,3,1,6,3]Score:3```. This process will continue until a solution is found. If at any point the state space does not return a better value than the current best, a restart will occur swapping out the current instance for a new instance. The restart is the key to preventing the solution from hanging on local minima/maxima.

### State Space
For an nxn instance there is ```(n*n)^n``` total possible states when using a brute force algorithm.<br>
Restricting the state space by limiting one queen per column will result in a new size of n^n total states for the same nxn instance. For example, an 8x8 instance has 64^8 = 281,474,976,710,656 total states. If a queen per column restriction is implmented it now has a total of 8^8 = 16,777,216 states. That's an elimination of 281,474,959,933,440 states. For any nxn instance there is no formula to calculate how many solutions there will be without searching the entire state space and determining how many solutions there was. For an 8x8 instance there are 92 total (not unique) solutions. Restricting the state space guarantees that the solution will be found more quickly.

Genetic Algorithm
---

