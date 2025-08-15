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


  
