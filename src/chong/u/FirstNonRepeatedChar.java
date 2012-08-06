package chong.u;

// runtime complexity O(n)
public class FirstNonRepeatedChar
{
    private static char firstNonRepeated(String str)
    {
        int[] bitset = new int[128]; // ASCII are 7-bit

        // initialize array
        for (int i = 0; i < bitset.length; ++i)
            bitset[i] = 0;

        // count occurrences of each character
        // copes with extremely long strings where a particular character
        // occurs too many times for an int to store its no. of occurrences
        for (int i = 0; i < str.length(); ++i) {
            if (bitset[str.charAt(i)] == 0) {
                bitset[str.charAt(i)] = 1;
            } else {
                // more than once
                bitset[str.charAt(i)] = 2;
            }
        }

        for (int i = 0; i < str.length(); ++i) {
            if (bitset[str.charAt(i)] == 1) return str.charAt(i);
        }

        return (char) 0;
    }

    public static void main(String[] args)
    {
        System.out.println("total: " + firstNonRepeated("total"));
        System.out.println("teeter: " + firstNonRepeated("teeter"));
    }
}
