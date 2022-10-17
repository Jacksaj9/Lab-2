/**
 * 
 * Lab 5
 * 
 * Base exception class for representing exceptions that can
 * occur within a calculator.  
 * 
 * This class extends Exception, requiring only that message be given
 * to determine the issue.
 */
public class CalculatorException extends Exception
{
   public CalculatorException(String errorMessage) 
    {
        super(errorMessage);
    }    
}

final class QuitException extends CalculatorException
{
    //thrown when the user inputs quit to end the program
    public QuitException( String errorMessage)
    {
        super(errorMessage);
    }
}

final class DivideByZeroException extends CalculatorException
{
    //thrown when the program attempts to divide by 0
    public DivideByZeroException(String errorMessage)
    {
        super(errorMessage);
    }
}

final class IllegalInputException extends CalculatorException
{
  /*thrown when the input does not match with a format that we expect.
    This exception also has a private String variable illegalType and a getter method (getIllegal-
    Type()) for the variable. illegalType is set through IllegalInputException constructor and gives
    some more detail about what kind of input error occurred. Various values that illegalType
    can take are:
    – “Illegal Token Length”: when the number of tokens is neither 1, 2, or 3
    – “Illegal Token Length”: when a token does not match the type of token expected in it’s
    position. For example: in the input “3 * foo”, “foo” is an illegal argument, as it is not
    an int
    – “Illegal Operator”: when a token in an operator position is not supported by the program.
    The program only accepted “*” and “/” operators for binary operations. So, “ 2 - 1”
    would give error */
    public IllegalInputException(String errorMessage)
    {
        super(errorMessage);
        this.getIllegalType();
    }

    public String getIllegalType(){
       
        return this.getIllegalType();
    }
}
