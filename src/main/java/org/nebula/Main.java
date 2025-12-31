package org.nebula;

import org.nebula.cli.ArgParser;
import org.nebula.cli.NebCState;
import org.nebula.nebc.Compiler;

public class Main
{
    static void main(String[] args)
    {
        NebCState state = new ArgParser().parseArgs(args);
        Compiler compiler = new Compiler(state);

        compiler.parse();
    }
}