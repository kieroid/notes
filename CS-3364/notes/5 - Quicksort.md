# Hoare Partition Algorithm (`quicksort`)
Does not always follow **divide and conquer.** We are not always guaranteed to have equal parts.

Driven by two pointers ($i$ and $j$.)
We can have at most $1$ swap per each iteration.

Look at [this](<https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Quicksort-diagram.svg/320px-Quicksort-diagram.svg.png>) and [this](<https://en.wikipedia.org/wiki/Quicksort>).

## Example 1
In the array $\{ 5,7,1,6,2,4,3 \}$

- PIVOT $i$: Position $1$ which has a value of $5$.
- PIVOT $j$: Position $7$ which has a value of $3$.

Since $P(i) < P(j)$, the pivots switch places.
Therefore, the array would be: $\{ 3,7,1,6,2,4,5 \}$

... Therefore, the array would be: $\{2,3,1,4,5,6,7\}$. 

- PIVOT $i$: Position $3$ which has a value of $1$.
- PIVOT $j$: Position $2$ which has a value of $3$.

Since $P(i) < P(j),$ the positions switch places.
Therefore, the array would be: $\{2,1,3,4,5,6,7\}$.

- PIVOT $i$: Position $2$ which has a value of $1$.
- PIVOT $j$: Position $1$ which has a value of $2$.

Since $P(i) < P(j)$, the positions switch places.
Therefore, the array would be: $\{1,2,3,4,5,6,7\}$.

## Example 2
In the array $\{54,26,93,17,77,31,44,55,20\}$.

- PIVOT $i$: Position $1$ which has a value of $54$.
- PIVOT $j$: Position $9$ which has a value of $20$.

Since $P(i) > P(j)$, the positions would switch places.
Therefore, the array would be: $\{20,26,93,17,77,31,44,55,54\}$.

- PIVOT $i$: Position $2$ which has a value of $26$.
- PIVOT $j$: Position $9$ which has a value of $54$.

Since $P(i) \not> P(j)$, the positions would stay the same. Therefore, the array will remain the same.

- PIVOT $i$: Position $2$ which has a value of 26.
- PIVOT $j$: Position $8$ which has a value of 55.

Since $P(i) \not> P(j)$, the positions would stay the same.
Therefore, the array will remain the same.

- PIVOT $i$: Position $2$ which has a value of 26.
- PIVOT $j$: Position $7$ which has a value of 44.

Since $P(i) \not> P(j)$, the positions would stay the same.
Therefore, the array will remain the same.

- PIVOT $i$: Position $2$ which has a value of 26.
- PIVOT $j$: Position $6$ which has a value of 31.

Since $P(i) \not> P(j)$, the positions would stay the same.
Therefore, the array will remain the same.

- PIVOT $i$: Position $2$ which has a value of 26.
- PIVOT $j$: Position $5$ which has a value of 77.

Since $P(i) \not> P(j)$, the positions would stay the same.
Therefore, the array will remain the same.

- PIVOT $i$: Position $2$ which has a value of 26.
- PIVOT $j$: Position $4$ which has a value of 17.

Since $P(i) > P(j)$, the positions would switch places.
Therefore, the array would be: $\{20,17,93,26,77,31,44,55,54\}$.

- PIVOT $i$: Position $3$ which has a value of 93.
- PIVOT $j$: Position $9$ which has a value of 54.

Since $P(i) > P(j)$, the positions would switch places.
Therefore, the array would be: $\{20,17,54,26,77,31,44,55,93\}$.

...

## Basic Operation: Swap
Question: Ho large can the counters get?

- $i$ can never get larger than the largest array index.
- $j$ can never get larger than the largest array index.
- Therefore, the total number of ticks for $i$ counter vs $j$ counter can never be more than $n+1$.

### Course Upper board
- $i$ can tick $n$ times.
- $j$ ticks $n$ times.
- $i \leq n$ times. $j \leq n$ times.
- Therefore, $2n$ ticks ($n+n$ ticks.) This is a linear time.

## Partitions
Is your partition always split in half?
$T(n)=2T(\frac{n}{2})+\theta(n)$

You have 8 elements. The first element ($\circ$) is the trivial array.

The last 7 elements are known as $Q_5$.

$\circ\cdot\cdot\cdot\cdot\cdots$

After that, there will be another element which turns into an array.

$\circ\circ\cdot\cdot\cdot\cdots$

$\text{levels of recursion} = \text{number of elements } - 1$
In this case, there would be 7 levels of recursion.

Deep recursion? $\theta(n^2)$

### Pivoting
Lets assume the following: $\{8,7,6,5,4,3,2,1\}$ where $i$ exists between $8$ and $7$, and $j$ exists after $1$.

$8$ (a.k.a the pivot point $j$) will go down to the end ($\{1,7,6,5,4,3,2,8\}$) such that $1$ and $8$ will switch places. Now we need to do quicksort on the first $7$ elements ($\{1,7,6,5,4,3,2\}$, excluding $8$.)

After that, the pivot switches from $1\to 7$ to $7\to 6$. As a result, the array ($\{7,6,5,4,3,2\}$) will be quicksorted.

Overall, this process takes around $\theta(n^2)$ complexity.