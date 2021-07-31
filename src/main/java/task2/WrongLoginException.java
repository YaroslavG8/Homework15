package task2;

public class WrongLoginException extends Exception {
    private String detail;

    public WrongLoginException(String incorrect_login) {
        detail = "Incorrect login";
    }



}
