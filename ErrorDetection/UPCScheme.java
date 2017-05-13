/**
 *
 * @author Vodka
 * Inspired by Gallian and his book "Contemporary Abstract Algebra"
 * Additional reading from Error Detection Methods by J. Gallian
 */
public class UPCScheme {
    //additional character to use for modulo system > 10
    //limit of modulo system is 10 + 26 = modulo 36
    final char[] alphabet = {'A','B','C','D','E','F','G','H','I','J',
                             'K','L','M','N','O','P','Q','R','S','T',
                             'U','V','W','X','Y','Z'};
    int modulo;
        //the system to multiply with digits of check number 
    int[] sequence;
        //the check digit
        //can be 2-digit, 3-digit, n-digit alternate (n<modulo system)
    
       
    String checknum;
        //string we want to test
    
    public UPCScheme (int mod, int[] m_system, int length)
    {
        //the modulo system you want to work with
        modulo = mod;
        //the alternating system u want to implement
        sequence = new int[length];
         //the repeating alternative multiplicators
        sequence = generate_system(m_system);
        
    }
    private int[] generate_system(int[] m_seq)
    {
        int[] temp_Seq = new int [sequence.length];
        if (m_seq.length > modulo)    //error checking
        { 
            System.out.println("Can't generate automated sequence, too short");
            return null;
        }
        else 
        {
            int k = 0; //counter for alternate digits
                       //when done one loop (= 0 mod m_seq.length, k return back to 0 
            for (int n = 0 ; n < sequence.length ; n++)
            {
                temp_Seq[n] = m_seq[k];
                k++;
                k = k % m_seq.length;
            }
            return temp_Seq;
        }
    }
    //convert the check string to array of values suitable for calculation
    private int[] conversion (String input)
    {
        int[] c_check = new int[input.length()];
        String letter = new String(alphabet);
        for (int n = 0 ; n < c_check.length ; n ++)
        {
            //basic case, convert char to int
            if(Character.isDigit(input.charAt(n)))
            {
                c_check[n] = Character.getNumericValue(input.charAt(n));
            }
            else
            {
                c_check[n] = letter.indexOf(input.charAt(n)) + 10;
            }
        }
        return c_check;     
    }
            
    public boolean calculation()
    {
        int[] c_check = conversion(checknum);
        int sum = 0;
        for( int n = 0 ; n < sequence.length ; n ++)
        {
            sum += c_check[n] * sequence[n];
            //System.out.println("Value at pos " + n +" : "+c_check[n]*sequence[n]);
        }    
        return sum%modulo == 0;
    }
    
    public void getString(String input)
    {
        checknum = input;
    }
}
