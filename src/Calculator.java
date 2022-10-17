/**
 * The Calculator class provides functionality for parsing input strings
 * that contain simple expressions and for computing the result of the expression.
 *
 */

public class Calculator 
{
    public Calculator()
    {
        // Constructor does nothing
    }

    /**
     * Compute the result of the expression encoded in a sequence of tokens.
     * 
     * Here are the different cases:
     * 0 tokens: IllegalInputException: "Illegal Token Length"
     * 1 token: 
     *      "quit" (any casing): QuitException
     *      All other cases: IllegalInputException: "Illegal Argument"
     * 2 tokens:
     *      "-" and any number: return negative of number
     *      "-" and not a number: IllegalInputException: "Illegal Argument"
     *      other string and any string: IllegalInputException: "Illegal Operator"
     * 3 tokens:
     *      number1, "+", number2: return sum of two numbers
     *      number1, "/", zero: DivideByZeroException
     *      number1, "/", not zero: return number1/number2
     *      not a number, anything, anything: IllegalInputException: "Illegal Argument"
     *      number1, anything, not a number: IllegalInputException: "Illegal Argument"
     *      number1, not an operator, number2: IllegalInputException: "Illegal Operator"
     * 4 or more tokens: IllegalInputException: "Illegal Token Length"
     *     
     * Note: all numbers are integers
     * 
     * @param tokens The array of tokens to evaluate
     * @return int result of evaluating the expression
     * @throws CalculatorException If some form of error has been generated or
     * "quit" has been typed. Throws one of the several child classes of CalculatorException
     * in order to give more information on what the error is.
     */
   
    
    public static int compute(String[] tokens) throws CalculatorException, QuitException, DivideByZeroException, IllegalInputException
    {
        // Condition on the number of tokens
        switch(tokens.length)
        {
            case 0:
                if(tokens.length == 0)
                {
                    //TODO: complete the cases
                    throw new IllegalInputException("Illegal Token Length");
                }

            case 1:
                // Only case: quit
                if(tokens.toString().equals("quit")){
                    throw new QuitException("Quitting");
                }
            case 2:
                // Only case: unary operator
                if(tokens[0]== "-")
                {
                    if(tokens[1]=="1"||tokens[1]=="2"||tokens[1]=="3"||tokens[1]=="4"||tokens[1]=="5"||tokens[1]=="6"||tokens[1]=="7"||tokens[1]=="8"||tokens[1]=="9"){
                        return (Integer.parseInt(tokens[1].toString())*-1);
                    }
                    else{
                        throw new IllegalInputException("Illegal Argument");
                    }
                }
                else if(!(tokens[0]=="1"||tokens[0]=="2"||tokens[0]=="3"||tokens[0]=="4"||tokens[0]=="5"||tokens[0]=="6"||tokens[0]=="7"||tokens[0]=="8"||tokens[0]=="9")){
                    throw new IllegalInputException("Illegal Operator");
                }

            case 3:
                // Binary operator
                if(tokens[1]=="+")
                {
                    return (Integer.parseInt(tokens[0].toString())+ Integer.parseInt(tokens[2].toString()));
                }
                else if(tokens[1]=="/"&& tokens[2]=="0")
                {
                    throw new DivideByZeroException("Tried to divide by zero");
                }
                else if(tokens[1]=="/")
                {
                    return (Integer.parseInt(tokens[0].toString())/ Integer.parseInt(tokens[2].toString()));
                }
                else if(!(tokens[0]=="1"||tokens[0]=="2"||tokens[0]=="3"||tokens[0]=="4"||tokens[0]=="5"||tokens[0]=="6"||tokens[0]=="7"||tokens[0]=="8"||tokens[0]=="9"))
                {
                    throw new IllegalInputException("Illegal Argument");
                }
                else
                {
                    if(!(tokens[1]=="-"|| tokens[1]=="+"||tokens[1]=="/"||tokens[1]=="*")){
                        throw new IllegalInputException("Illegal Operator");
                    }
                }
                /*
                *     
                *      not a number, anything, anything: IllegalInputException: "Illegal Argument"
                *      number1, anything, not a number: IllegalInputException: "Illegal Argument"
                *      number1, not an operator, number2: IllegalInputException: "Illegal Operator" */


            default:
                // 4 or more tokens
                if(tokens.length>4){
                    throw new IllegalInputException("Illegal Token Length");
                }
                return 0;// TODO: complete the cases 
        }

    }

    /**
     * Parse the input string as an expression and evaluate it.
     * 
     * If the input is a legal expression, then the result is printed
     * 
     * Otherwise a CalculatorException has occurred.  Print a message based on
     * what exception type it is.
     * 
     * Always print out what the input was. Use a finally block for this.
     * 
     * Always prints out two lines, following the rules:
     * 1st line:
     * -No Exception: "The result is: " + result
     * -QuitException: "Quitting"
     * -DivideByZeroException: "Tried to divide by zero"
     * -IllegalInputException: "Illegal input: " + illegalinputtype(given to constructor)
     * -CalculatorException: <should never happen> e.getMessage()
     * 2nd line:
     * "Input was: " + input
     * 
     * @param input A String possibly containing a mathematical expression
     * @return true if the String is equal to "quit"; false otherwise
     */
    public static boolean parseAndCompute(String input)
    {
        // Pull out the tokens
        String[] tokens = input.split(" ");
        try 
        {
            // TODO: complete implementation.
            
            System.out.println("The result is"+ compute(tokens));// +compute(tokens));
        }
        catch (QuitException e)
        {
               System.out.println("Quitting");// TODO: complete implementation.
            
        }
        catch (IllegalInputException e)
        {
            System.out.println("Illegal input: "+ e.getIllegalType());// TODO: complete implementation.
        }
        catch (CalculatorException e)
        {
            // This catches the remaining CalculatorException case: DivideByZeroException
            System.out.println("Tried to divide by zero");// TODO: complete implementation.
        }

        System.out.println("Input was:"+ input);
        System.out.println();

        // Quit has not been specified
        return false;
    }
}
