package org.nebula.nebc;

import org.nebula.cli.InputFile;
import org.nebula.cli.NebCState;

import java.util.List;

public class Compiler
{
    private final List<InputFile> files;

    public Compiler(NebCState state)
    {
        this.files = state.files();
    }

    public void parse()
    {
        for (InputFile file : files)
        {
            System.out.println("Parsing " + file.getFileName());
        }
    }
}
