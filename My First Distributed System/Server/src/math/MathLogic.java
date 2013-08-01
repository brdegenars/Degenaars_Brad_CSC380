package math;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 7/9/13
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class MathLogic {

    public static int add(Object... a) throws NumberFormatException{
        int total = 0;
        for (Object o : a) {
            int temp = Integer.parseInt(o.toString());
            total += temp;
        }
        return total;
    }

    public static int subtract(Object... a) throws NumberFormatException{
        int total = Integer.parseInt(a[0].toString());
        for (int i = 1; i < a.length; i++) {
            int temp = Integer.parseInt(a[i].toString());
            total -= temp;
        }
        return total;
    }
}
