final class Validate {

    private Validate() { }

    static String text(String value, String field) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(field + " is required");
        }
        String trimmed = value.trim();
        if (trimmed.contains(",")) {
            throw new IllegalArgumentException(field + " cannot contain commas");
        }
        return trimmed;
    }
}
