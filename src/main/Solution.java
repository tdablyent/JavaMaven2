import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[][] grid1 =
                {
                        {'.', '#'},
                        {'.', '.'},
                        {'#', '.'}
                };
        System.out.println(isWithinKSec(grid1, 4));

        char[][] grid2 =
                {
                        {'.', '#'},
                        {'.', '#'},
                        {'#', '.'}
                };
        System.out.println(isWithinKSec(grid2, 10));

        char[][] grid3 =
                {
                        {'.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.'}
                };
        System.out.println(isWithinKSec(grid3, 1000));

        char[][] grid4 =
                {
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
                };

        System.out.println("Test case 4:");

        System.out.println(isWithinKSec(grid4, 26));
        System.out.println(isWithinKSec(grid4, 27));

        char[][] grid5 =
                {
                        {'.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#'},
                        {'.', '#', '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'.', '#', '#', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'.', '#', '#', '#', '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '#', '#', '#'},
                        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.'}
                };
        System.out.println("Test case 5:");
        //In this case, length of the path is 39.
        System.out.println(isWithinKSec2(grid5, 38));
        System.out.println(isWithinKSec2(grid5, 39));
    }

    public static boolean isWithinKSec2(char[][] grid, int k){
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 9999999);
        }

        result[0][0] = 1;
        boolean changed = true;
        int iteration = 0;

        while(changed){
            changed = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // check the up cell

                    if (i > 0 && grid[i - 1][j] == '.') {
                        if (result[i - 1][j] > result[i][j] + 1) {
                            result[i - 1][j] = result[i][j] + 1;
                            //very important! If there is an around cell updated, then we need to check that updated cell recursively! Please refer my test case #5.
                            changed = true;
                        }
                    }
                    // check the down cell
                    if (i + 1 < grid.length && grid[i + 1][j] == '.') {
                        if (result[i + 1][j] > result[i][j] + 1) {
                            result[i + 1][j] = result[i][j] + 1;
                            //If there is an around cell updated, then we need to check that updated cell recursively!
                            changed = true;
                        }
                    }
                    // check the left cell
                    if (j > 0 && grid[i][j - 1] == '.') {
                        if (result[i][j - 1] > result[i][j] + 1) {
                            result[i][j - 1] = result[i][j] + 1;
                            //If there is an around cell updated, then we need to check that updated cell recursively!
                            changed = true;
                        }
                    }
                    // check the right cell
                    if (j + 1 < grid[0].length && grid[i][j + 1] == '.') {
                        if (result[i][j + 1] > result[i][j] + 1) {
                            result[i][j + 1] = result[i][j] + 1;
                            //If there is an around cell updated, then we need to check that updated cell recursively!
                            changed = true;
                        }
                    }
                }
            }
            iteration++;
        }

        System.out.println("Iteration: " + iteration);
        return result[grid.length - 1][grid[0].length - 1] <= k ? true : false;
    }


    public static boolean isWithinKSec(char[][] grid, int k) {
        //Dynamic Programming. result[][] to store the min steps (in seconds) from left-top to the corresponding element in each iteration.
        int[][] result = new int[grid.length][grid[0].length];
        //Initial the DP matrix.
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 9999999);
        }
        //Initial Top-left cell.
        result[0][0] = 1;
        //Fill the value to build the DP matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dpHelper(i, j, grid, result);
            }
        }
        // return true if within k seconds. (include k)
        return result[grid.length - 1][grid[0].length - 1] <= k ? true : false;
    }

    public static void dpHelper(int i, int j, char[][] grid, int[][] result) {
        int tmp = 0;
        // check the up cell
        if (i > 0 && grid[i - 1][j] == '.') {
            if (result[i - 1][j] > result[i][j] + 1) {
                result[i - 1][j] = result[i][j] + 1;
                //very important! If there is an around cell updated, then we need to check that updated cell recursively! Please refer my test case #5.
                dpHelper(i - 1, j, grid, result);
            }
        }
        // check the down cell
        if (i + 1 < grid.length && grid[i + 1][j] == '.') {
            if (result[i + 1][j] > result[i][j] + 1) {
                result[i + 1][j] = result[i][j] + 1;
                //If there is an around cell updated, then we need to check that updated cell recursively!
                dpHelper(i + 1, j, grid, result);
            }
        }
        // check the left cell
        if (j > 0 && grid[i][j - 1] == '.') {
            if (result[i][j - 1] > result[i][j] + 1) {
                result[i][j - 1] = result[i][j] + 1;
                //If there is an around cell updated, then we need to check that updated cell recursively!
                dpHelper(i, j - 1, grid, result);
            }
        }
        // check the right cell
        if (j + 1 < grid[0].length && grid[i][j + 1] == '.') {
            if (result[i][j + 1] > result[i][j] + 1) {
                result[i][j + 1] = result[i][j] + 1;
                //If there is an around cell updated, then we need to check that updated cell recursively!
                dpHelper(i, j + 1, grid, result);
            }
        }

        return;
    }
}
