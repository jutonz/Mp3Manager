package mp3manager;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 16 Oct 2014.
 */
public class Mp3Manager {

    private List<Track> tracklist;

    public Mp3Manager(String fileOrDirectory) {
        tracklist = new ArrayList<Track>();
        loadFileOrDirectory(fileOrDirectory);
    }

    private void loadFileOrDirectory(String fileOrDirectory) {
        File f = new File(fileOrDirectory);
        if (f.isDirectory())
            loadDirectory(f);
        else
            loadFile(f);
    }

    /**
     * Adds the files in the directory to the tracklist. If the directory
     * contains files that are not media files they are not added.
     *
     * @param directory to add
     */
    private void loadDirectory(File directory) {
        for (File file : directory.listFiles()) {
            loadFile(file);
        }
    }

    /**
     * Adds a file to the tracklist. If the file is not a media file,
     * nothing happens.
     *
     * @param file to load.
     */
    private void loadFile(File file) {
        try {
            String mediaType = new Tika().detect(file);
            if (mediaType.equals("audio/mpeg"))
                tracklist.add(new Track(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
