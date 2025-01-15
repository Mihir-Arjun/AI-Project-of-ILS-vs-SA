# Travelling Salesman Problem Solver

This project implements a solution for the Travelling Salesman Problem (TSP) using Iterated Local Search (ILS) and Simulated Annealing.

## Description

The TSP is a classic algorithmic problem in the field of computer science and operations research. It focuses on optimization. In this problem, a salesman is given a list of cities, and must determine the shortest route that allows him to visit each city once and return to his original location.

This project uses two metaheuristic algorithms to solve the TSP:

1. Iterated Local Search (ILS): This is a simple and effective metaheuristic used in optimization. It builds upon the concept of local search and takes it to the next level by using perturbations to escape local optima.

2. Simulated Annealing: This is a probabilistic technique used for finding an approximate solution to an optimization problem. It allows the algorithm to escape local optima by accepting worse solutions with a certain probability.

## Getting Started

### Dependencies

* Java 8 or higher

### Installing

* Clone the files to your local machine
* Compile the Java files in your IDE or from the command line with `javac *.java`
* You will also see in both programs a findsolution method in which the number of iterations can be changed in order to test different results

### Executing program

* Run the main method in the `SimulatedAnnealing` or `IteratedLocalSearch` class
