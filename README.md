# NQueens Puzzle

Place n non-attacking queens on an nxn chessboard

Overview (Local Search)
---
Local search demonstrates that modifying states can be more practical than using an initial state to search for solutions. Local search is used when the path to the solution isn't important. Local search can find solutions in large or infinite state spaces that are continuous. A local search algorithm is complete if it always finds a goal if one exists.

Implementation
---
- [Shotgun Hill Climbing](https://en.wikipedia.org/wiki/Hill_climbing#Variants "Random-Restart Hill Climbing")
- [Genetic Algorithm](https://en.wikipedia.org/wiki/Genetic_algorithm "Genetic Algorithm")

Usage
---
Place all packages in a directory then ```cd``` into the directory and run:<br> 
```javac main/*.java localsearch/*.java nqueen/*.java``` then ```java main.Main```<br>
The size for each algorithm can be found in its respective file (```NQueenGenetic.java``` & ```NQueenShotgun.java```) under ```SIZE```.

Shotgun Hill Climbing
---
Also known as Random-Restart Hill Climbing, Shotgun Hill Climbing is complete. Given a random instance it will explore the state space around the instance in search for the best state based on the heuristic value. The heuristic is the number of attacking queens with a goal score of 0.<br> 

For example, for the state ```57401163``` the follwing state space will be searched:
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
This will result in the best state of ```[5,7,4,0,3,1,6,3]Score:3``` which will then have its state space searched. This process will continue until a solution is found. If at any point the state space does not return a better instance than the current best, a restart will occur swapping out the current instance for a new instance. The restart is the key to preventing the instance from hanging on local minima/maxima.

### State Space
For an nxn instance there are ```(n*n)^n``` total possible states when using a brute force algorithm. Restricting the state space by limiting one queen per column will result in a new size of ```n^n``` total states for the same nxn instance. 

Genetic Algorithm
---

Genetic Algorithm searches the state space in a more abstract way. The algorithm is based on evolutionary biology. Given a population of randomly generated states of a certain size, two parents from that population will be selected by their fitness and produce a child by crossing over. The child's fitness value determines the likelihood of the child being useful for generating more fit offspring for the population. There is a certain chance the child will mutate which selects an element and swaps it to a random value in hopes of adding genetic diversity. Then the child is added into the population. If at any point the child has the desired fitness score, the solution will then be returned.

The algorithm generates a population of random states which are sorted according to fitness. Fitness is a score assigned to each state that helps guide the algorithm to a goal state. In this case ```fitness = non-attacking queens```. Those with higher fitness are towards the start of the list. Using ```min(RANDOM.nextInt(POPULATION_SIZE), RANDOM.nextInt(POPULATION_SIZE))``` guarantees that there is a negative sloping distribution meaning those elements at the start of the list, who have better fitness, have a better chance of being chosen as a parent.<br>
```
Crossover position: 6
           0  1  2  3  4  5  6  7
Parent 1: [2, 3, 0, 4, 1, 1, 0, 0] Score: 20
Parent 2: [6, 4, 3, 4, 0, 5, 0, 2] Score: 23
Child:    [2, 3, 0, 4, 1, 1, 0, 2] Score: 22
```
Crossing over incorporates two separate parents, who have independently reached their state, in hopes of generating an offspring that will have a better fitness value. Single-point crossover picks a position to crossover then gives that data to the child. There is a certain ```1/MUTATION_CHANCE``` of mutation. The child is then added to the population, if the child matches the goal score, the solution is returned.

### State Space
For an nxn instance there are ```(n*n)^n``` total possible states. Genetic Algorithm doesn't have any sort of state space restriction.

8 Queens State Space Example
---
An 8x8 instance has 64^8 = 281,474,976,710,656 total states but this can be reduced to C(64,8) or 4,426,165,368 states. If a queen per column restriction is implmented it now has a total of 8^8 = 16,777,216 states. That's an elimination of 4,409,388,152 states. For any nxn instance there is no formula to preemptively calculate how many solutions there will be without searching the entire state space. For an 8x8 instance there are 92 total (not unique) solutions. Restricting the state space guarantees that the solution will be found quickly.
