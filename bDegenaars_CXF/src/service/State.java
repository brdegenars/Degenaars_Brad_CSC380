package service;

/**
 * Created with IntelliJ IDEA.
 * User: brdegenaars
 * Date: 8/6/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class State {

    String fullName;
    String twoDigitCode;

    public State(String fullName, String twoDigitCode) {
        this.fullName = fullName;
        this.twoDigitCode = twoDigitCode;
    }

    public State(){}

    public String getTwoDigitCode() {
        return twoDigitCode;
    }

    public void setTwoDigitCode(String twoDigitCode) {
        this.twoDigitCode = twoDigitCode;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
