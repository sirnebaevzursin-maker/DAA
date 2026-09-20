# Divide and Conquer Algorithms Report


## 1. Introduction

In this assignment, I implemented three divide-and-conquer algorithms:
MergeSort, QuickSort, and QuickSelect.

The goal of this project was to understand how these algorithms work, analyze
their complexity, and compare theoretical results with real benchmark results.

The algorithms were tested on different types of input:

- random arrays
- sorted arrays
- arrays with duplicate values

The following input sizes were used:

- 1000
- 10000
- 100000
- 1000000

The program measures execution time, number of comparisons, and maximum
recursion depth.


---

# 2. Algorithm Description


## 2.1 MergeSort

MergeSort divides the array into two smaller parts recursively. After sorting
both parts, it combines them using a merge operation.

In this implementation, one helper buffer is created once and reused during
the recursive process. For small subarrays, insertion sort is used as an
optimization.


### Complexity

| Case | Complexity | Reason |
|---|---|---|
| Best | Θ(n log n) | Array is always divided into equal parts |
| Average | Θ(n log n) | Merge process always takes linear time |
| Worst | Θ(n log n) | Input order does not affect splitting |


Recurrence:
T(n) = 2T(n/2) + O(n)

Parameters:
a = 2
b = 2
f(n) = n

Using Master Theorem:
T(n) = Θ(n log n)


---

## 2.2 QuickSort

QuickSort selects a pivot and divides the array into smaller and larger
elements.

In my implementation, random pivot selection is used to reduce the chance of
bad partitions. Three-way partitioning is used to handle arrays with many
duplicate values.


### Complexity

| Case | Complexity | Reason |
|---|---|---|
| Best | Θ(n log n) | Pivot creates balanced partitions |
| Average | Θ(n log n) | Random pivot usually creates balanced splits |
| Worst | O(n²) | Very unbalanced partitions can happen |


Recurrence for balanced case:
T(n) = 2T(n/2) + O(n)

Parameters:
a = 2
b = 2
f(n) = n

Master Theorem result:
T(n) = Θ(n log n)


Random pivot selection makes balanced partitions more likely, therefore the
average performance is close to O(n log n). However, a sequence of bad pivots
can still lead to O(n²).


---

## 2.3 QuickSelect

QuickSelect finds the k-th smallest element without sorting the whole array.

After partitioning, the algorithm continues only in the part that contains the
required element.


### Complexity

| Case | Complexity | Reason |
|---|---|---|
| Best | Θ(n) | Good pivot immediately reduces the search area |
| Average | Θ(n) | Only one side of partition is processed |
| Worst | O(n²) | Repeated bad pivot selections |


Recurrence:
T(n) = T(n/2) + O(n)
Parameters:
a = 1
b = 2
f(n) = n

Using Master Theorem:
T(n) = Θ(n)


---

# 3. Metrics and Benchmark


A benchmark program was created to compare algorithm performance.

For each algorithm the following values were measured:

- execution time using System.nanoTime()
- number of comparisons
- maximum recursion depth


Each test case was executed 5 times and the median value was saved.


The results were exported to:
results.csv


The CSV file contains:
algorithm,input,n,time_ms,comparisons,max_depth


---

# 4. Experimental Results Discussion


## MergeSort Results

MergeSort showed stable performance for different input types.

Because the algorithm always divides the array into two equal parts, the
running time remained close to Θ(n log n).


## QuickSort Results

QuickSort showed good performance on random inputs.

The random pivot strategy helped avoid extremely unbalanced partitions.

The three-way partition method improved the performance for duplicate values.


## QuickSelect Results

QuickSelect was faster than sorting the whole array when only one element was
required.

Because it processes only one part after partitioning, it has linear average
complexity.


---

# 5. Θ Bound Check


To check the theoretical complexity, the measured comparisons were compared
with the expected growth function.

For sorting algorithms:
comparisons / (n * log2(n))

was used.

For QuickSelect:
comparisons / n

was used.


If the ratio becomes almost constant for large n, it confirms the expected Θ
complexity.


The benchmark results generally followed the theoretical expectations.
Small differences appeared because of JVM warm-up, CPU cache effects, and
runtime optimization.


---

# 6. Discussion


The experimental results mostly matched the theoretical analysis.

MergeSort had stable performance because its splitting process is independent
from the input order.

QuickSort was usually faster in practice because it uses less additional
memory, but its performance depends on pivot selection.

The random pivot and three-way partitioning helped improve QuickSort behavior
on difficult inputs.

Some differences between runs appeared because of JVM warm-up, garbage
collection, and hardware effects.

The cutoff optimization in MergeSort also improved performance for small
subarrays.


---

# 7. Conclusion


In this assignment, three divide-and-conquer algorithms were implemented and
tested.

The benchmark results showed the difference between theoretical complexity and
real execution time.

MergeSort provided stable Θ(n log n) performance.

QuickSort achieved good practical performance with random pivot selection.

QuickSelect efficiently found the k-th smallest element without sorting the
whole array.

Overall, the experiment confirmed the expected behavior of divide-and-conquer
algorithms.


---

# 8. Running the Project


Compile:
mvn clean compile


Run tests:
mvn test


Run benchmark:

Run Benchmark.java


The benchmark results are saved into:
results.csv