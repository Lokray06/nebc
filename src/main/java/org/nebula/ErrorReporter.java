package org.nebula;

import java.util.HashMap;

public class ErrorReporter
{
    public enum Kind
    {
        COMPILER,
        ARGS,
        SYNTAX,
        CVT,
        SEMANTIC,
        OTHER
    }

    static HashMap<Kind, String> errorTypeString = new HashMap<>();

    static
    {
        errorTypeString.put(Kind.COMPILER, "nebc");
        errorTypeString.put(Kind.ARGS, "nebc");
        errorTypeString.put(Kind.SYNTAX, "Syntax error");
        errorTypeString.put(Kind.CVT, "CVT error");
        errorTypeString.put(Kind.SEMANTIC, "Semantic error");
        errorTypeString.put(Kind.OTHER, "Other error");
    }

    boolean hasErrors = false;
    private Kind variant;

    public ErrorReporter(Kind variant)
    {
        this.variant = variant;
    }

    public void log(String msg)
    {
        this.hasErrors = true;
        System.err.println(errorTypeString.get(variant) + ": " + msg);
    }

    public Kind getVariant()
    {
        return this.variant;
    }

    public boolean hasErrors() { return this.hasErrors; }
}
