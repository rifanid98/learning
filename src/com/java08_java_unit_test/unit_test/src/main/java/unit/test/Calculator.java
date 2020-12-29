package unit.test;

/**
 * Hello world!
 *
 */
public class Calculator
{
    /**
     * Sum Number
     * @param num1
     * @param num2
     * @return sum of two numbers
     */
    public Integer add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    /**
     * Divide Number
     * @param num1
     * @param num2
     * @return divide of two number
     */
    public Integer divide(Integer num1, Integer num2) {
        if (num1 == 0 || num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        } else {
            return num1 / num2;
        }
    }
}
