package chong.u;

import static java.lang.Math.pow;

// runtime complexity - O(2^n)
public class StringCombinations
{
    private static void combine(String str)
    {
        int number = (int) pow(2, str.length());
        for (int i = 1; i < number; i++) {
            System.out.print(i + " : {");

            // generate binary representation
            for (int j = 0; j < str.length(); j++) {
                // print element if bit is 1
                if (((i >> j) & 1) == 1) {
                    System.out.print(str.charAt(j) + "");
                }
            }

            System.out.println("}");
        }
    }

    private static void recCombine(String str)
    {
        doCombine(str.toCharArray(), new StringBuilder(), str.length(), 0, 0);
    }

    private static void doCombine(
        char[] instr,
        StringBuilder outstr,
        int length,
        int level,
        int start)
    {
        for (int i = start; i < length; i++) {
            outstr.append(instr[i]);
            System.out.println(outstr);
            if (i < length - 1) {
                doCombine(instr, outstr, length, level + 1, i + 1);
            }
            outstr.setLength(outstr.length() - 1);
        }
    }

    private static void printPowerSet(int[] a)
    {
        int number = (int) pow(2, a.length);
        System.out.println("1: {}");
        for (int i = 1; i < number; i++) {
            System.out.print((i + 1) + " : { ");
            for (int j = 0; j < a.length; j++) {
                if (((i >> j) & 1) == 1) {
                    System.out.print(a[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3 };
        printPowerSet(a);

        combine("wxyz");
        recCombine("wxyz");
    }
}
