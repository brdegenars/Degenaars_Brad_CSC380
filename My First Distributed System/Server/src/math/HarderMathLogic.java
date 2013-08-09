package math;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/8/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class HarderMathLogic implements IMath{

    public static int multiply(Object... a) throws NumberFormatException{
        int total = 1;
        for (Object o : a) {
            int temp = Integer.parseInt(o.toString());
            total *= temp;
        }
        return total;
    }

    public static int divide(Object... a) throws NumberFormatException{
        int total = Integer.parseInt(a[0].toString());
        for (int i = 1; i < a.length; i++) {
            int temp = Integer.parseInt(a[i].toString());
            total /= temp;
        }
        return total;
    }
}
