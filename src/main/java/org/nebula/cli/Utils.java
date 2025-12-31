package org.nebula.cli;

public class Utils
{
    public static String getHelpMsg()
    {
        return """
                OVERVIEW: Compiler for the Nebula language.
                USAGE: nebc [options] file...
                OPTIONS:
                  -h, --help                Show this help message and exit.
                  -v, --version                 Show compiler version and exit.
                  --verbose             Enable verbose debug logging. // Added
                  -o, --output <file>       Specify the output file name.
                  -L <path>                 Add a directory to the library search path.
                  -l <file>                 Link a specific .neblib library file.
                  -B, --library             Compile as a library (.neblib + .a/.so).
                  -t, --target <platform>   Specify the target platform (e.g., 'linux-x64').
                  -k, --check               Run semantic analysis only; do not generate output.
                  -n, --native <files...>   Explicitly include native source files (.cpp, .h) in the build.
                """;
    }
}
