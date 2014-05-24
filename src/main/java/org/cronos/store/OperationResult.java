package org.cronos.store;

public class OperationResult {
    private final String name;
    private final int status;
    private final String message;

    public OperationResult(String name, int status, String message) {
        this.name = name;
        this.status = status;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isOK() { return status >0; }
}
