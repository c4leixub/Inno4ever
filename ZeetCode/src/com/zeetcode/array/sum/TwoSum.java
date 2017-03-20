package com.zeetcode.array.sum;

public interface TwoSum {
    /*
     * Stores input in an internal data structure.
     */
    public void Store(int input);
 
    /*
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    public boolean Test(int val);
}
