package org.cronos.store;

public class OperationResult {
    private String name;
    private int status;
    private String message;

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
}
