package com.wasp.scs.enums;

public enum ActionStatus  {
    SUCCESS("Operation completed successfully"),
    FAILED("An error occurred during the operation"),
    INVALID_INPUT("Invalid input data");

    private final String massage;

    ActionStatus (String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
