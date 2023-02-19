package pl.roclawski.bartek.app.translationjobs.model;

public enum JobStatus {
    NEW(),
    QUOTING("Quote awaited", 2),
    TO_ACCEPT,
    IN_PROGRESS,
    REJECTED,
    SUSPENDED,
    FINISHED,
    SETTLED("To be settled", 8);

    private String message;
    private int code;

    JobStatus() {
    }

    JobStatus(String message) {
        this.message = message;
    }

    JobStatus(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
