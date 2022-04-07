package com.zy.datastructure;

/**
 * @author zy
 * @version 1.0.0
 * @ClassName SparseArray.java
 * @Description 稀疏数组的代码实现
 * @createTime 2022年04月07日 22:46:00
 */
public class SparseArray {
    /**
     * 数组转化为稀疏数组
     * a. 获取数组中有效值的个数,所谓有效值,就是与大多数值不相同的值(比如上文中例子里的2,3),将有效值的个数记为sum
     * b. 创建稀疏数组,数组的大小为 array[sum+1][3]   sum+1是因为要加上总行数,总列数  3列就是行/列/值
     * c. 将总行数/总列数,有效值的信息写入稀疏数组
     * @return
     */
    public static int[][] arrayToSparseArray() {
        // 初始化原数组
        //        0,0,0,0,0
        //        0,0,2,0,0
        //        0,0,0,3,0
        int sourceArray[][] = new int[3][5];
        sourceArray[1][2] = 2;
        sourceArray[2][3] = 3;

        // 输出原数组
        System.out.println("=====原数组=====");
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("=====原数组=====");

        // 转换稀疏数组
        // 1.获取有效数个数
        int sum = 0;
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }
        System.out.printf("====有效数的个数为%d",sum);
        // 2. 创建稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        // 3. 稀疏数组辅助
        // 总行数/总列数/有效值个数
        sparseArray[0][0] = sourceArray.length;
        sparseArray[0][1] = sourceArray[0].length;
        sparseArray[0][2] = sum;

        // 有效值信息赋值
        int count = 0;
        for (int i = 0, sourceArrayLength = sourceArray.length; i < sourceArrayLength; i++) {
            int[] ints = sourceArray[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = anInt;
                }
            }
        }

        System.out.println();
        // 输出稀疏数组
        System.out.println("=====稀疏数组=====");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("=====稀疏数组=====");

        return sparseArray;
    }

    /**
     * 2.稀疏数组转数组
     *   a. 根据总行数/总列数创建数组
     *   b. 根据有效值的行/列/值信息给数组赋值即可
     */
    public static void sparseArrayToArray(int[][] sparseArray){
        // 输出稀疏数组
        System.out.println("=====稀疏数组=====");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("=====稀疏数组=====");

        // 1.根据稀疏数组创建数组
        int sourceArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 2.将有效值赋值给原数组
        for (int i = 1; i < sparseArray.length; i++) {
                sourceArray[sparseArray[i][0]][sparseArray[i][1]] =
                        sparseArray[i][2];
        }

        System.out.println("=====原数组=====");
        for (int[] ints : sourceArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("=====原数组=====");
    }

    public static void main(String[] args) {
        // 数组转稀疏数组
        int[][] sparseArray = arrayToSparseArray();

        // 稀疏数组转数组
        sparseArrayToArray(sparseArray);
    }
}
