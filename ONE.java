// What is Time Complexity? 🧠 What is Space Complexity?
//✅ Rule of Thumb:Time complexity = How fast? Space complexity = How heavy?

<!-- 📌 80/20 Time Complexity Mastery Table

If you know these 8 complexity classes (and when they’re good or bad), you can ace most interview + CP problems.

Big-O	Name	When to Use	Max N Possible (CP)	Example Problems

O(1)	Constant	Direct formula, hash lookups	10^18+	Check if a number is even, access array element

O(log N)	Logarithmic	Divide & conquer	10^18	Binary search

O(√N)	Root-time	Number theory	10^10	Check prime by trial division

O(N)	Linear	Single loop, basic traversal	10^7	Find max in array

O(N log N)	Log-linear	Sorting, efficient searches	10^6	Merge sort, sorting array

O(N²)	Quadratic	Nested loops, brute force on small N	10^3	All pairs, Floyd-Warshall on small N

O(2^N)	Exponential	Subset generation, brute-force recursion	N ≤ 20	Traveling salesman brute force

O(N!)	Factorial	All permutations	N ≤ 10	Generate all permutations

O(1) → Constant time (super fast)

O(log N) → Logarithmic (fast for big inputs)

O(N) → Linear (slower than log, but still manageable)

O(N²) → Quadratic (can be deadly for large inputs)

O(2ⁿ) → Exponential (avoid unless you like pain) -->

lets start the game bro--
  
1]Time Complexity of a Single for Loop
  
  public class SingleLoopComplexity {
    public static void main(String[] args) {
        int n = 10; // You can change this to test with bigger N

        // Single loop - runs N times
        System.out.println("Printing numbers from 1 to " + n);

        for (int i = 1; i <= n; i++) {
            System.out.println(i); // This executes exactly N times
        }

        /*
         * Time Complexity Analysis:
         * -------------------------
         * The loop runs from 1 to n (inclusive), so total iterations = n.
         * Each iteration does a constant amount of work (printing).
         *
         * Therefore:
         * Time Complexity = O(n)  → Linear Time
         *
         * Space Complexity Analysis:
         * --------------------------
         * We are only using a few variables (n, i) → constant space usage.
         * Space Complexity = O(1) → Constant Space
         */
    }
}

2]🔁 Time Complexity of Nested for Loops

public class NestedLoopComplexity {
    public static void main(String[] args) {
        int n = 5; // You can change this to see how execution grows

        // Nested loops example
        System.out.println("Printing all pairs (i, j):");

        for (int i = 1; i <= n; i++) {        // Outer loop → runs n times
            for (int j = 1; j <= n; j++) {    // Inner loop → runs n times for each i
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }

        /*
         * Time Complexity Analysis:
         * -------------------------
         * Outer loop runs n times.
         * Inner loop runs n times for EACH iteration of outer loop.
         *
         * Total operations = n * n = n²
         *
         * Therefore:
         * Time Complexity = O(n²) → Quadratic Time
         *
         * Space Complexity Analysis:
         * --------------------------
         * Only variables i, j, n are stored → constant space usage.
         * Space Complexity = O(1) → Constant Space
         */
    }
}

3] Time Complexity of Loop with i *= 2 (Logarithmic)
public class LogarithmicLoopComplexity {
    public static void main(String[] args) {
        int n = 100; // Change to test bigger numbers

        System.out.println("Loop with i *= 2:");

        for (int i = 1; i <= n; i *= 2) { // i doubles each time
            System.out.println("i = " + i);
        }

        /*
         * Time Complexity Analysis:
         * -------------------------
         * i starts at 1 and is multiplied by 2 each time.
         * Number of times loop runs:
         * 1 → 2 → 4 → 8 → ... → n
         *
         * After k iterations: i = 2^k
         * Stop when 2^k > n → k ≈ log₂(n)
         *
         * Therefore:
         * Time Complexity = O(log n) → Logarithmic Time
         *
         * Space Complexity Analysis:
         * --------------------------
         * Only i and n are stored → constant space usage.
         * Space Complexity = O(1)
         */
    }
}

4] Time vs Input Size: Understanding Growth of Functions

  public class TimeVsInputSize {
    public static void main(String[] args) {
        int[] testsizes = {10, 100, 500, 1000, 5000};

        for(int n : testsizes) {
            System.out.println("\n === N ="+n+"===");

            //0(1) - constant
            measureTime("O(1) constant", () -> constantTime(n));
            measureTime("O(log N) logarithmic", () -> LogTime(n));
            measureTime("O(N) Linear", () -> LinearTime(n));
            measureTime("O(N log N)", () -> nLogNTime(n));

            if (n <= 2000)
               measureTime("O(N^2) Quadratic", () -> quadraticTime(n));
        }
    }

    //  complexity examaples -

    static void constantTime(int n) {
        int x = n * n;
    }

    static void LogTime(int n){
        for(int i = 1; i < n; i *= 2){
            int x = i;
        }
    }

    static void LinearTime(int n){
        for(int i = 0; i < n; i++){
            int x = i;
        }
    }

    static void nLogNTime(int n ){
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j *= 2){
                int x = i + j;
            }
        }
    }

    static void quadraticTime(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                int x = i + j;
            }
        }
    }

    //utility for timing
    static void measureTime(String label, Runnable function ) {
        long start = System.nanoTime();
        function.run();
        long end = System.nanoTime();
        System.out.printf("%-25s: %d ns%n", label , (end - start));
    }
}

 === N =10===
O(1) constant            : 3800 ns
O(log N) logarithmic     : 2500 ns
O(N) Linear              : 4300 ns
O(N log N)               : 3900 ns
O(N^2) Quadratic         : 4300 ns

 === N =100===
O(1) constant            : 900 ns
O(log N) logarithmic     : 1400 ns
O(N) Linear              : 2400 ns
O(N log N)               : 14100 ns
O(N^2) Quadratic         : 63400 ns

 === N =500===
O(1) constant            : 1200 ns
O(log N) logarithmic     : 1500 ns
O(N) Linear              : 6300 ns
O(N log N)               : 214000 ns
O(N^2) Quadratic         : 1217800 ns

 === N =1000===
O(1) constant            : 800 ns
O(log N) logarithmic     : 1100 ns
O(N) Linear              : 14000 ns
O(N log N)               : 326000 ns
O(N^2) Quadratic         : 175600 ns


 === N =5000===
O(1) constant            : 1100 ns

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(N) Linear              : 57400 ns

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns

 === N =5000===
O(1) constant            : 1100 ns

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(N) Linear              : 57400 ns
O(N log N)               : 699900 ns
PS C:\Users\Abhishek\DataStructure&Algorithm>

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(N) Linear              : 57400 ns

 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(N) Linear              : 57400 ns
O(N log N)               : 699900 ns

 === N =5000===
O(1) constant            : 1100 ns
 === N =5000===
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(1) constant            : 1100 ns
O(log N) logarithmic     : 1300 ns
O(log N) logarithmic     : 1300 ns
O(N) Linear              : 57400 ns
O(N log N)               : 699900 ns


  5] Time Complexity of Array Access
  📌 Key Idea
Accessing an element by index (arr[i]) is O(1) → Constant Time.
reason: Arrays are stored in contiguous memory. The address of any element can be directly calculated as:
Address of arr[i] = BaseAddress + (i * size_of_element)
No loops, no searching → just one calculation.

  public class ArrayAccessComplexity {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        // Accessing array elements by index
        System.out.println("First element: " + arr[0]); // O(1)
        System.out.println("Third element: " + arr[2]); // O(1)
        System.out.println("Last element: " + arr[arr.length - 1]); // O(1)

        /*
         * Time Complexity Analysis:
         * -------------------------
         * Accessing arr[i] is direct (via memory address calculation).
         * → Time Complexity = O(1) → Constant Time
         *
         * Space Complexity Analysis:
         * --------------------------
         * The array itself takes O(n) space (n elements).
         * Accessing an element uses no extra space → O(1).
         */
    }
}


6] Space Complexity of Arrays (with variations)
  📦 Summary Table
Type of Array	Space Complexity
1D Array (size n)	O(n)
2D Array (n × m)	O(n × m)
Jagged Array	O(total elements)
Dynamic Array (ArrayList)	O(n) amortized

  public class ArraySpaceComplexity {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n]; // 1D array of size n

        /*
         * Space Complexity:
         * -----------------
         * Each int = 4 bytes
         * Total space = O(n)
         *
         * Example: n = 5 → 5 * 4 = 20 bytes (ignoring overhead)
         */
    }
}


int n = 3, m = 4;
int[][] matrix = new int[n][m]; // n x m matrix

/*
 * Space Complexity:
 * -----------------
 * Each element = 4 bytes
 * Total = n * m
 *
 * Example: 3x4 → 12 * 4 = 48 bytes
 */


int[][] jagged = new int[3][];
jagged[0] = new int[2]; // Row 1 → length 2
jagged[1] = new int[4]; // Row 2 → length 4
jagged[2] = new int[3]; // Row 3 → length 3

/*
 * Space Complexity:
 * -----------------
 * Total space = sum of all row sizes
 * = 2 + 4 + 3 = 9 integers
 * = O(total elements)
 */


import java.util.*;

ArrayList<Integer> list = new ArrayList<>();

/*
 * Space Complexity:
 * -----------------
 * Internally uses a dynamic array.
 * Initial capacity = 10
 * When full → capacity doubles.
 *
 * Total space = O(n) (amortized)
 */

11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
  Auxiliary Space vs Total Space
  📦 1. Total Space Complexity
➡️ The total memory used by the algorithm/program.
It includes:
Input size (array, matrix, etc.)
Auxiliary space (extra temporary storage)
📦 2. Auxiliary Space Complexity
➡️ The extra space used by the algorithm apart from the input itself.
Includes temporary variables, recursion stack, extra arrays/lists.
Does NOT count the input storage.

  ✅ Example 1 — Sum of Array
public class SpaceExample1 {
    static int sumArray(int[] arr) {
        int sum = 0; // auxiliary variable
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[100]; // Input array → takes O(n) space
        int result = sumArray(arr);
        System.out.println("Sum = " + result);

        /*
         * Space Analysis:
         * ---------------
         * Input array size = O(n)
         * Auxiliary space = O(1) (just variable 'sum')
         * Total space = O(n) + O(1) = O(n)
         */
    }
}

✅ Example 2 — Recursive Factorial
public class SpaceExample2 {
    static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial = " + factorial(n));

        /*
         * Space Analysis:
         * ---------------
         * Input = integer 'n' → O(1)
         * Auxiliary space = O(n) (recursion stack of depth n)
         * Total space = O(1) + O(n) = O(n)
         */
    }
}

✅ Example 3 — Extra Array Used
public class SpaceExample3 {
    static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length]; // extra space O(n)
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] doubled = doubleArray(arr);

        /*
         * Space Analysis:
         * ---------------
         * Input array = O(n)
         * Auxiliary space = O(n) (new array 'result')
         * Total space = O(n) + O(n) = O(n)
         */
    }
}

📌 Quick Summary
Case	Input Space	Auxiliary Space	Total Space
Sum of array	O(n)	O(1)	O(n)
Factorial (recursion)	O(1)	O(n)	O(n)
Doubling array	O(n)	O(n)	O(n)

  next topic ] Time Complexity of Searching in Unsorted Array (Linear)
  key idea =  🔍 Linear Search
  Works on unsorted arrays.
We check each element one by one until:
We find the target, OR
We reach the end of the array.
⏳ Time Complexity
Best Case (target at first index) → O(1)
Worst Case (target at last index or not present) → O(n)
Average Case → O(n/2) ≈ O(n)
📦 Space Complexity
No extra data structures → O(1) (only a few variables).
  
code - 
public class LinearSearch {
    // Function to perform linear search
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {23, 45, 12, 67, 34, 89, 10};
        int target = 67;

        int index = linearSearch(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found.");
        }

        /*
         * Time Complexity:
         * ----------------
         * Best Case   = O(1)   (element at first index)
         * Worst Case  = O(n)   (element at last or not present)
         * Average Case= O(n)
         *
         * Space Complexity:
         * -----------------
         * O(1) → only 'i' and 'target'
         */
    }
}


next topic - ]

  Space Used by Variables, Inputs, and Function Calls
📊 Essential Time & Space Complexity (Pareto Version)
Case	Time Complexity	Space Complexity	Why Important?
Array Access	O(1)	O(n)	Basis of arrays, indexing
Linear Search	O(n)	O(1)	Unsorted search → default
Binary Search	O(log n)	O(1)	Sorted search → interview favorite
Single Loop	O(n)	O(1)	Core of all problems
Nested Loops	O(n²)	O(1)	Matrix, brute-force, comparisons
Logarithmic Loop	O(log n)	O(1)	Divide & conquer, binary ops
Recursion (Factorial / DFS depth)	O(n)	O(n)	Foundation of recursion, stack space

  next topic - ]
  Steps to Follow (Dry Run Method)
Assign cost = 1 step to each basic operation (assignment, comparison, arithmetic, return).
Count steps inside loops carefully.
Sum them up → you get exact steps.
Then generalize → convert to Big-O form.
⚡ Example 1: Constant Time
int a = 5;       // 1 step
int b = 10;      // 1 step
int sum = a+b;   // 1 step
System.out.println(sum); // 1 step
👉 Total = 4 steps (constant) → O(1)
⚡ Example 2: Single Loop
int n = 5;
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
Dry Run Count:
Initialization: int i = 0 → 1 step
Comparisons: i < n runs n+1 times → 6 steps (for n=5)
Increments: i++ runs n times → 5 steps
Print statement runs n times → 5 steps
👉 Total = 1 + 6 + 5 + 5 = 17 steps (for n=5)
👉 In general → ≈ 3n + 2 steps → O(n)
⚡ Example 3: Nested Loop
int n = 3;
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + "," + j);
    }
}
Dry Run Count (n=3):
Outer loop comparisons & increments → ~ (n+1) + n = 7
Inner loop runs n times for each outer → n × ( (n+1) + n + print )
= 3 × (4 + 3 + 3) = 30 steps
👉 General → ≈ n² steps → O(n²)

  next topic - Best Case, Worst Case, Average Case Analysis
  
  🎯 Best, Worst, and Average Case Analysis
1️⃣ Best Case

The minimum number of steps the algorithm takes.

Happens when the input is the most favorable.
👉 Example: Searching x=10 in array [10,20,30,...].

Found at first index → only 1 comparison.

Time Complexity: O(1)

2️⃣ Worst Case

The maximum number of steps the algorithm may take.

Happens when the input is the least favorable.
👉 Example: Searching x=100 in [10,20,30,...,90].

Element not found, loop runs full length.

Time Complexity: O(n)

3️⃣ Average Case

Expected number of steps for a random input.

Typically:

If element exists → on average, found in middle.

If element doesn’t exist → checked full array.
👉 Formula for linear search (probability uniform):

Average = (1 + 2 + 3 + ... + n)/n = (n+1)/2 ≈ n/2

Time Complexity: O(n)

  
  
