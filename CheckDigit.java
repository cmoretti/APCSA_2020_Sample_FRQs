public class CheckDigit
{
    // adapted from: https://www.cs.princeton.edu/courses/archive/spr20/cos217/asgts/03symtable/index.html
    public static int getCheck(int num) {
        int HASH_MULTIPLIER = 65599;
        long hash = 0;
        long l;
        
        while(num > 0) {
            hash = hash * HASH_MULTIPLIER + (num % 10);
            num /= 10;
        }
        
        return (int) ((hash+7) % 10);
    }
    
    // part (a)
    public static boolean isValid(int numWithCheckDigit) {
        int prefix = numWithCheckDigit / 10;
        int check = numWithCheckDigit % 10;
        return getCheck(prefix) == check;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.printf("%d -> %d|%d\ngetCheck(%d) = %d\n%b\n",
                          num,
                          num/10,
                          num%10,
                          num/10,
                          getCheck(num/10),
                          isValid(num)
                          );
        
    }

    // part (b)
    /* 
       Introduce a new private static int variable numIncorect to the
       class, with initial value 0.

       Within the code to isValid, instead of returning the result of
       the comparison immediately, store it into a new local boolean
       variable, valid. If valid is false, then increment
       numIncorrect. Then unconditionally return valid.
     
       Potentially add a static getter method for numIncorrect, either
       public or private depending on indented use.
    */
}
