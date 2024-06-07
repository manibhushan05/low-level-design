package interviews.observeai;

public enum SplitType {
    EXACT,
    PERCENT,
    EQUAL;

    public static SplitType fromString(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }
        switch (type.toUpperCase()) {
            case "EXACT":
                return EXACT;
            case "PERCENT":
                return PERCENT;
            case "EQUAL":
                return EQUAL;
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
