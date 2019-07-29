import java.util.*;

public class Model {
	
    public static double calculateExpression(String expression) {

        Stack<Double> operandStack = new Stack<Double>();
        Stack<Character> operatorStack = new Stack<Character>();

        if (!isValidExpression(expression)) {
            System.out.println("Not a valid expression to evaluate");
            return 0;
        }

        int i = 0;
        String currentInteger = null;
        while (i < expression.length()) {

            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {

                currentInteger = expression.charAt(i) + "";
                i++;
                while (i != expression.length() && ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9') || expression.charAt(i) == '.')) {
                    currentInteger = currentInteger + expression.charAt(i);
                    i++;
                }

                operandStack.push(Double.parseDouble(currentInteger));
            } else {

                if (expression.charAt(i) == ')') {

                    while (operatorStack.peek() != '(') {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.pop();
                } else {

                    Character currentOperator = expression.charAt(i);
                    Character lastOperator = (operatorStack.isEmpty() ? null : operatorStack.peek());


                    if (lastOperator != null && checkPrecedence(currentOperator, lastOperator)) {
                        performArithmeticOperation(operandStack, operatorStack);
                    }
                    operatorStack.push(expression.charAt(i));

                }
                i++;
            }

        }


        while (!operatorStack.isEmpty()) {
            performArithmeticOperation(operandStack, operatorStack);
        }


        return operandStack.pop();

    }

    public static void performArithmeticOperation(Stack<Double> operandStack, Stack<Character> operatorStack) {
        try {
            double value1 = operandStack.pop();
            double value2 = operandStack.pop();
            char operator = operatorStack.pop();

            double intermediateResult = arithmeticOperation(value1, value2, operator);
            operandStack.push(intermediateResult);
        } catch (EmptyStackException e) {
            System.out.println("Not a valid expression to evaluate");
            throw e;
        }
    }


    public static boolean checkPrecedence(Character operator1, Character operator2) {

        List<Character> precedenceList = new ArrayList<Character>();
        precedenceList.add('(');
        precedenceList.add(')');
        precedenceList.add('^');
        precedenceList.add('/');
        precedenceList.add('*');
        precedenceList.add('%');
        precedenceList.add('+');
        precedenceList.add('-');


        if(operator2 == '(' ){
            return false;
        }

        if (precedenceList.indexOf(operator1) > precedenceList.indexOf(operator2)) {
            return true;
        } else {
            return false;
        }

    }

    public static double arithmeticOperation(double value2, double value1, Character operator) {

        double result;

        switch (operator) {

            case '+':
                result = value1 + value2;
                break;

            case '-':
                result = value1 - value2;
                break;

            case '*':
                result = value1 * value2;
                break;

            case '/':
                result = value1 / value2;
                break;

            case '%':
                result = value1 % value2;
                break;
            case '^':
                result = calculateExponent(value1, value2);
                break;

            default:
                result = value1 + value2;


        }
        return result;
    }

    /**
     * 
     * @param expression
     * @return
     */
    public static boolean isValidExpression(String expression) {

        if ((!Character.isDigit(expression.charAt(0)) && !(expression.charAt(0) == '(') && !(expression.charAt(0) == '.'))
                || (!Character.isDigit(expression.charAt(expression.length() - 1)) && !(expression.charAt(expression.length() - 1) == ')') && !(expression.charAt(0) == '.'))) {
            return false;
        }

        HashSet<Character> validCharactersSet = new HashSet<Character>();
        validCharactersSet.add('*');
        validCharactersSet.add('+');
        validCharactersSet.add('-');
        validCharactersSet.add('/');
        validCharactersSet.add('%');
        validCharactersSet.add('^');
        validCharactersSet.add('(');
        validCharactersSet.add(')');

        Stack<Character> validParenthesisCheck = new Stack<Character>();

        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i)) && !(expression.charAt(i) == '.') && !validCharactersSet.contains(expression.charAt(i))) {
                return false;
            }

            if (expression.charAt(i) == '(') {
                validParenthesisCheck.push(expression.charAt(i));
            }

            if (expression.charAt(i) == ')') {

                if (validParenthesisCheck.isEmpty()) {
                    return false;
                }
                validParenthesisCheck.pop();
            }
        }

        if (validParenthesisCheck.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static double calculateExponent(double value1, double value2) {
    	String valueString = Double.toString(value2);
    	String [] numberAsArray = valueString.split("\\.");

    	if (Integer.parseInt(numberAsArray[1]) > 0) {
    		return calculatePowerForReal(value1, value2);
    	}
    	if (value2 < 0.0) {
    		value1 = 1.0 / value1;
    		value2 = value2 * -1;
    		return calculateExponent(value1, value2);
    	} else if (value2 == 0.0) {
    		return 1.0;
    	} else if ((value2 % 2) == 0.0) {
    		value1 = value1 * value1;
    		value2 = value2 / 2;
    		return calculateExponent(value1, value2);
    	} else {
    		value2 = (value2 - 1) / 2;
    		return value1 * calculateExponent(value1 * value1, value2);
    	}
    }
    
    
    
    
    /**
     * Calculates the factorial for the given number.
     * @param number This is a given number.
     * @return factorial This is the factorial of the given number.
     */
    
    public static double calculateFactorial(double number)  {
      if (number <= 1) {
        return 1;
      }  else {
        return (number * calculateFactorial(number - 1));     
      }
    }

    
    
    /**
     * Calculates the Natural log for the given number.
     * @param number This is a given number.
     * @return ans This is the natural log of given number.
     */

    public static double calculateNaturalLog(double number) {
      double ans = 0;
      double base = (number - 1) / (number + 1);
      for (int i = 1; i <= 125; i++) {
        double exponent = 2 * i - 1;
        ans += (1 / exponent) * (calculateExponent(base,exponent));
      }
      return 2 * ans;           
    }

    
    /**
     * Calculates the power for any user given numbers.
     * @param x This is a base.
     * @param y This is a exponent.
     * @return answer This is the power x raised to the power of y.
     */

    public static double calculatePowerForReal(double x,double y) {
      double answer = 0;
      double logValue;
    
      if (y == 0) {
        answer = 1;
        return answer;
      }
      if (x < 0) {
        logValue = calculateNaturalLog(x * (-1));
      } else {
        logValue = calculateNaturalLog(x);
      }
      if (x == 0 && y > 0) {
        return answer;
      }
      
      for (int i = 0; i <= 125; i++) {
        double numerator = calculateExponent((y * logValue),i);
        double denominator = calculateFactorial(i);
        answer = answer + (numerator / denominator);
      } 
      
      if (x < 0 && y % 2 != 0) {
        return answer * (-1);
      } else {
        return answer;
      }
    }
}
