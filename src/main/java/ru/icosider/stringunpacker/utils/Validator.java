package ru.icosider.stringunpacker.utils;

public enum Validator {
    INSTANCE;

    public static final String PATTERN = "[A-Za-z0-9\\[\\]]*";

    public boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    public boolean patternMatch(String text) {
        return text.matches(PATTERN);
    }

    public boolean patternNotMatch(String text) {
        return !patternMatch(text);
    }
}