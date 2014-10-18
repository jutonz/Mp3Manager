package mp3manager;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Encapsulation of several API's for managing an MP3 file's tags.
 * <p/>
 * Created by Justin on 16 Oct 2014.
 */
public class TagManager {

    public static String getArtist(File file) {
        return getTagFromFile(file, "TPE1");
    }

    public static void setArtist(File file, String artist) {
        setField(file, FieldKey.ARTIST, artist);
    }

    public static String getComment(File file) {
        return getTagFromFile(file, "COMM");
    }

    public static void setComment(File file, String comment) {
        setField(file, FieldKey.COMMENT, comment);
    }

    public static String getTitle(File file) {
        return getTagFromFile(file, "TIT2");
    }

    public static void setTitle(File file, String title) {
        setField(file, FieldKey.TITLE, title);
    }

    public static String getAlbumTitle(File file) {
        return getTagFromFile(file, "TALB");
    }

    public static int getTrackNumber(File file) {
        return Integer.parseInt(getTagFromFile(file, "TRCK"));
    }

    public static int getDiscNumber(File file) {
        return Integer.parseInt(getTagFromFile(file, "TPOS"));
    }

    public static String getAlbumArtist(File file) {
        return getTagFromFile(file, "TPE2");
    }

    public static void setAlbumArtist(File file, String albumArtist) {
        setField(file, FieldKey.ALBUM_ARTIST, albumArtist);
    }

    /**
     * Converts the specified file into an MP3File.
     * Returns null if the conversion fails.
     *
     * @param file to convert
     * @return the file as an MP3File, or null if failure
     */
    public static MP3File toMp3File(File file) {
        MP3File mp3file = null;
        try {
            mp3file = new MP3File(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TagException e) {
            e.printStackTrace();
        } catch (ReadOnlyFileException e) {
            e.printStackTrace();
        } catch (InvalidAudioFrameException e) {
            e.printStackTrace();
        }
        return mp3file;
    }

    public static String getTagFromFile(File file, String tag) {
        String result = null;
        try {
            File f = new File("err.txt");
            FileOutputStream fos = new FileOutputStream(f);
            PrintStream ps = new PrintStream(fos);
            System.setErr(ps);
            result = toMp3File(file).getID3v2Tag().getFirst(tag);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setErr(new PrintStream(System.err));
        }
        return result;
    }

    /**
     * Sets the value of the specified field. If an error
     * occurs, nothing happens.
     *
     * @param file to update
     * @param key to change
     * @param value to use
     */
    public static void setField(File file, FieldKey key, String value) {
        try {
            File f = new File("err.txt");
            FileOutputStream fos = new FileOutputStream(f);
            PrintStream ps = new PrintStream(fos);
            System.setErr(ps);

            AudioFile af = AudioFileIO.read(file);
            Tag tag = af.getTag();
            tag.setField(key, value);
            af.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setErr(new PrintStream(System.err));
        }
    }
}
