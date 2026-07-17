package farcic.dev.pdv.java.exeption;

public class CashRegisterAlreadyOpenException extends RuntimeException {

    public CashRegisterAlreadyOpenException(String message) {
        super(message);
    }
}
