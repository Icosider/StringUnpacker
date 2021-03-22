package ru.icosider.stringunpacker.service;

import ru.icosider.stringunpacker.exception.ValidateException;
import ru.icosider.stringunpacker.utils.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnpackService {
    private String text;
    private final Pattern PATTERN_REPEAT = Pattern.compile("(\\d+)\\[([^\\d\\[\\]]*)\\]");

    public UnpackService(String text) {
        this.text = text;
    }

    public UnpackService validate() {
        if (Validator.INSTANCE.isEmpty(text))
            throw new ValidateException("The text cannot be empty!");
        if (Validator.INSTANCE.patternNotMatch(text))
            throw new ValidateException("The text not match a pattern \"" + Validator.PATTERN + "\"!");
        return this;
    }

    public String parse() {
        String output = replace(this.text);
        while (!output.equals(this.text)) {
            this.text = output;
            output = replace(this.text);
        }
        return output;
    }

    private String replace(String text) {
        final Matcher matcher = PATTERN_REPEAT.matcher(text);
        final StringBuilder builder = new StringBuilder();
        while (matcher.find())
            matcher.appendReplacement(builder, matcher.group(2).repeat(Integer.parseInt(matcher.group(1))));
        matcher.appendTail(builder);
        return builder.toString();
    }
}