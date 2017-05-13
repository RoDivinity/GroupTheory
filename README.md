# GroupTheory
Implementations of group theory 
a)Error Checking Methods
  * Most used in checking digit of serial number
  Common error table:
  Type         |         Form       |        Frequency*
  ___________________________________________________________
  single              a -> b                  79.1%
  tranposition       ab -> ba                 10.2%
  jump transpose    abc -> cba                 0.8%
  double             aa -> bb                  0.5%
  phonetic          1a <-> a0 (a: 2->9)        0.5%
  double jump       aba -> cbc                 0.3%
  
  
   1) UPC scheme
      => Implement the use of weight on position of digit. 
      
      => Create an injective function from serial code to check digit.
      
      => The weight is alternative
       
       |==Can the weight be 3 repeating? i.e (1,2,3,1,2,3,...)?
       
       |==Can the weight is different from sequence (3,1,3,1,3,1 ... )?
      
      E Version: abbreviated serial number (Only 8 digit)
      
      => 4 step functions for distributed weight of digit to make an injective function
   2) 
   
   
  * Test for prime
  * RSA encryption
