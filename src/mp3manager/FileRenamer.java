package mp3manager;

import java.io.File;

/**
 * Safely renames files.
 *
 * Created by Justin on 18 Oct 2014.
 */
public class FileRenamer {

    /**
     * Renames the file. Only handles renaming the file
     * within its current directory. Cannot move files
     * into new directories.
     *
     * @param file to rename
     * @param newName the new name of the file (Do not specify a directory!)
     * @return the new file, or null if the rename failed.
     */
    public static File rename(File file, String newName) {
        String path = file.getParentFile().getPath() + "/";
        File newFile = new File(path + newName);
        boolean success = file.renameTo(newFile);
        return success ? newFile : null;
    }
}
