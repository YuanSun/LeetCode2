package nineQueenPuzzle;

public class Queen {
	private int count;  // count how many solutions
	
	//constructor
	public Queen()
	{
		count = 0;
	}
	
	public int getCount()
	{
		return count;
	}

   /***************************************************************************
    * Return true if queen placement q[n] does not conflict with
    * other queens q[0] through q[n-1]
    ***************************************************************************/
    public boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
        return true;
    }

   /***************************************************************************
    * Print out N-by-N placement of queens from permutation q in ASCII.
    ***************************************************************************/
    public void printQueens(int[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j) System.out.print("Q ");  // Put Q at corresponding cell
                else           System.out.print("* ");	// Put * for empty cell
            }
            System.out.println();
        }  
        System.out.println();
       count++; 
    }


   /***************************************************************************
    *  Try all permutations using backtracking
    ***************************************************************************/
    public void enumerate(int N) {
        int[] a = new int[N];
        
        //start with row 0
        enumerate(a, 0);
    }

    public void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N) printQueens(q);
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;  	//at nth row, Q is place at ith column
                //if no attacking, move to next column
                // the array will record column number
                if (isConsistent(q, n)) enumerate(q, n+1); 
            }
        }
    }  
}
