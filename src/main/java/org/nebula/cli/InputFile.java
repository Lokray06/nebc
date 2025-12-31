package org.nebula.cli;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;

public class InputFile
{
    private static final Map<String, FileType> EXTENSIONS = Map.of(
            "neb", FileType.SOURCE,
            "neblib", FileType.LIB
    );

    private final FileType type;
    private final Path path;
    private final boolean exists;
    private final boolean regularFile;

    public InputFile(String pathStr)
    {
        Path path = Path.of(pathStr);
        this.path = path;

        this.exists = Files.exists(path);
        this.regularFile = Files.isRegularFile(path);

        if (!exists || !regularFile)
        {
            this.type = FileType.UNKNOWN;
        }
        else
        {
            this.type = getTypeFromName(path.getFileName().toString());
        }
    }

    public static FileType getTypeFromName(String fileName)
    {
        int dot = fileName.lastIndexOf('.');
        if (dot == -1 || dot == fileName.length() - 1)
            return FileType.UNKNOWN;

        String extension = fileName.substring(dot + 1).toLowerCase(Locale.ROOT);
        return EXTENSIONS.getOrDefault(extension, FileType.UNKNOWN);
    }

    public String getFileName() { return path.getFileName().toString(); }

    public Path getPath() { return path; }

    public FileType getType() { return type; }

    public boolean exists() { return exists; }

    public boolean isRegularFile() { return regularFile; }

    public boolean isValid() { return exists && regularFile && type != FileType.UNKNOWN; }
}