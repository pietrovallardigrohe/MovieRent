package Exceptions;

import javax.swing.*;

public class DateNotRecognizedException extends Exception {

    private String reason;

    public DateNotRecognizedException(String reason) {

        this.reason = reason;

    }

    public void sendMessage() {
        JOptionPane.showMessageDialog(null, String.format("Date not recognized, Reason: %s", reason));
    }

}
