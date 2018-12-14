package com.linjie.algo;

/**
 * Created by zhuxiaolong on 2018/12/11.
 */
public class LArray {

    public int removeElement(int[] array, int element) {

        if (array == null || array.length == 0)
            return 0;

        int pos = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == element) {
                array[pos] = element;
                pos++;
            }
        }

        return pos;
    }

    public int removeDuplicatesFromSortedArray(int[] sortedArray) {

        if (sortedArray == null)
            return 0;

        int pos = 0;

        for (int i = 1; i < sortedArray.length; i++) {

            if (sortedArray[i] == sortedArray[pos]) {

                continue;
            }

            sortedArray[++pos] = sortedArray[i];

        }

        return pos + 1;
    }

    public int removeTimesOfDuplicatesFromSortedArray(int[] sortedArray) {

        if (sortedArray == null)
            return 0;

        int pos = 0, timesOfDuplicate = 1;

        for (int i = 1; i < sortedArray.length; i++) {

            if (sortedArray[i] == sortedArray[pos]) {

                if (timesOfDuplicate < 2) {

                    sortedArray[++pos] = sortedArray[i];
                }
                timesOfDuplicate++;

            } else {

                sortedArray[++pos] = sortedArray[i];
                timesOfDuplicate = 1;


            }
        }

        return pos + 1;
    }

    public void mergeSortedArrays(int[] arrayA, int[] arrayB, int m, int n) {

        int posA = m - 1, posB = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {

            if (posA < 0) {

                arrayA[i] = arrayB[posB--];

            } else if (posB < 0) {

                break;

            } else {

                if (arrayA[posA] > arrayB[posB]) {

                    int tmpPos = findFirstGreater(arrayA, 0, posA, arrayB[posB]);

                    while (posA >= tmpPos) {

                        arrayA[i--] = arrayA[posA--];
                    }
                    arrayA[i] = arrayB[posB--];

                } else {

                    int tmpPos = findFirstGreater(arrayB, 0, posB, arrayA[posA]);

                    while (posB >= tmpPos) {

                        arrayA[i--] = arrayB[posB--];
                    }
                    arrayA[i] = arrayA[posA--];

                }
            }
        }
    }

    private int findFirstGreater(int[] arrayA, int start, int end, int target) {

        if (start == end)
            return end;

        if (arrayA[start] < target)
            return end;


        while (start < end) {

            int mid = (start + end) / 2;

            if (arrayA[mid] > target)
                end = mid;
            else
                start = mid;
        }

        return end;
    }


}
