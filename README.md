# Divide and Conquer Algorithms Assignment


## Description

This project was created for the Design and Analysis of Algorithms course.

The main goal of this assignment is to implement and analyze divide-and-conquer
algorithms in Java.

The implemented algorithms are:

- MergeSort
- QuickSort
- QuickSelect


The project also includes performance measurements, JUnit tests, and benchmark
results.


---

## Project Structure

src

├── main

│ └── java

│ ├── algorithms

│ │ ├── MergeSort.java

│ │ ├── QuickSort.java

│ │ └── QuickSelect.java
│ │

│ └── utils

│ ├── Metrics.java

│ └── Benchmark.java
│

└── test

└── java

└── tests

└── AlgorithmTest.java

results.csv

REPORT.md
README.md
pom.xml


---

## Implemented Algorithms


### MergeSort

Features:

- divide-and-conquer approach
- reusable buffer array
- insertion sort optimization for small arrays


### QuickSort

Features:

- random pivot selection
- three-way partitioning
- recursion depth optimization


### QuickSelect

Features:

- finds k-th smallest element
- uses partitioning method
- processes only the required side


---

## Requirements

To run this project, you need:

- Java JDK
- Maven


---

## Build the Project


Compile the project using:

mvn clean compile


---

## Run Tests


JUnit tests can be executed using:

mvn test


The tests check:

- sorting correctness
- comparison with Arrays.sort()
- edge cases
- QuickSelect results


---

## Run Benchmark


Run the Benchmark class:

Run Benchmark.java


The program will test algorithms on:

- random arrays
- sorted arrays
- duplicate arrays


with different sizes:
1000
10000
100000
1000000


The results will be saved into:

results.csv


---

## Results


The benchmark file contains:

- algorithm name
- input type
- array size
- execution time
- number of comparisons
- maximum recursion depth


The detailed analysis of complexity and benchmark results is available in:

REPORT.md
---

## Sirnebayev Zhursin

DAA Assignment 1