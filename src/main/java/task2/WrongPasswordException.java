package task2;

public class WrongPasswordException extends Exception {
    private String detail;

    public WrongPasswordException(String incorrect_password) {
        detail = "Incorrect password";
    }

    }


