package org.nebula.cli;

import org.nebula.ErrorReporter;

import java.util.ArrayList;
import java.util.List;

public class ArgParser
{
    public NebCState parseArgs(String[] args)
    {
        ErrorReporter er = new ErrorReporter(ErrorReporter.Kind.ARGS);

        if (args.length == 0)
        {
            er.log("No input files.");
            System.out.println(Utils.getHelpMsg());
            System.exit(1);
        }

        List<InputFile> files = new ArrayList<>();

        for (String arg : args)
        {
            InputFile file = new InputFile(arg);

            if (!file.exists())
            {
                er.log("File does not exist: " + arg);
                continue;
            }

            if (!file.isRegularFile())
            {
                er.log("Not a regular file: " + arg);
                continue;
            }

            if (file.getType() == FileType.UNKNOWN)
            {
                er.log("Unsupported file type: " + file.getFileName());
            }

            files.add(file);
        }

        // Optionally exit if any errors occurred
        if (er.hasErrors())
        {
            System.exit(1);
        }

        return new NebCState(files);
    }
}
