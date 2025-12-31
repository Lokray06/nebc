package org.nebula;

import org.nebula.nebc.FileType;
import org.nebula.nebc.InputFile;
import org.nebula.nebc.Utils;

public class ArgParser
{
    public void parseArgs(String[] args)
    {
        ErrorReporter er = new ErrorReporter(ErrorReporter.Kind.ARGS);

        if (args.length == 0)
        {
            er.log("No input files.");
            System.out.println(Utils.getHelpMsg());
            System.exit(1);
        }

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
                continue;
            }

            // Valid file — process it
            System.out.println("Valid file: " + file.getFileName() + " (type: " + file.getType() + ")");
        }

        // Optionally exit if any errors occurred
        if (er.hasErrors())
        {
            System.exit(1);
        }
    }
}
