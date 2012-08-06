public class StringReverse {    
    public static String stringBufferReverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }
    
    public static String arrayReverse(String s) {
        char[] reverseStringArray = new char[s.length()];
        for (int i = s.length() - 1, j = 0; i != -1; i--, j++) {
            reverseStringArray[j] = s.charAt(i);
        }
        return new String(reverseStringArray);
    }

    public static String stringReverse(String s) {
        String reverseStringVariable = "";
        for (int i = s.length() - 1; i != -1; i--) {
            reverseStringVariable += s.charAt(i);
        }
        return reverseStringVariable;
    }

    public static String recursiveReverse(String s) {
        if (s.length() <= 1) { 
            return s;
        }
        return recursiveReverse(s.substring(1, s.length())) + s.charAt(0);
    }

    public static String inplaceReverse( String s ) {
        byte[] array = s.getBytes();
        byte swap;
        for( int i = 0, j = array.length - 1; i < array.length / 2; i++, j-- ) {
            swap = array[ j ];
            array[ j ] = array[ i ];
            array[ i ] = swap;
        }
        return new String( array );
    }

    public static String xorInplaceReverse( String s ) {
        byte[] array = s.getBytes();
        for( int i = 0, j = array.length - 1; i < array.length / 2; i++, j-- ) {
            array[ i ] ^= array[ j ];
            array[ j ] ^= array[ i ];
            array[ i ] ^= array[ j ];
        }
        return new String( array );
    }


    public static void main( String[] args ) {
        String s = "Hello, World!";
        System.out.println( "s = " + s );
        System.out.println( "stringBufferReverse( s ): " + stringBufferReverse( s ) );
        System.out.println( "arrayReverse( s ): " + arrayReverse( s ) );
        System.out.println( "stringReverse( s ): " + stringReverse( s ) );
        System.out.println( "recursiveReverse( s ): " + recursiveReverse( s ) );
        System.out.println( "inplaceReverse( s ): " + inplaceReverse( s ) );
        System.out.println( "xorInplaceReverse( s ): " + xorInplaceReverse( s ) );
   }
}
