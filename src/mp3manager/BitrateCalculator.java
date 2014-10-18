package mp3manager;

import org.farng.mp3.TagException;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Calculates the bitrate of mp3 files.
 *
 * Created by Justin on 16 Oct 2014.
 */
public class BitrateCalculator {

    /**
     * Returns the bitrate of the specified audio file.
     *
     * @param file to calculate bitrate of
     * @return
     * @throws IOException
     * @throws TagException
     * @throws UnsupportedAudioFileException
     * @throws org.jaudiotagger.tag.TagException
     * @throws ReadOnlyFileException
     * @throws CannotReadException
     * @throws InvalidAudioFrameException
     */
    public static int getBitrateOf(File file) throws IOException, TagException, UnsupportedAudioFileException, org.jaudiotagger.tag.TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        long lengthInBytes = file.length();
        long lengthInBits = lengthInBytes * 8;
        int duration = getDurationInSeconds(file);
        long calculatedBitrate = lengthInBits / duration / 1000;
        return (int) calculatedBitrate;
    }

    /**
     * Determines the length (in seconds) of the specified audio file.
     *
     * @param file length in seconds of the file
     * @return
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public static int getDurationInSeconds(File file) throws UnsupportedAudioFileException, IOException {
        int duration;
        AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
        if (fileFormat instanceof TAudioFileFormat) {
            Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
            String key = "duration";
            Long microseconds = (Long) properties.get(key);
            int mili = (int) (microseconds / 1000);
            int sec = (mili / 1000) % 60;
            int min = (mili / 1000) / 60;
            duration = min * 60 + sec;
        } else {
            throw new UnsupportedAudioFileException();
        }
        return duration;
    }

    /**
     * Determines if the specified audio file has a variable bit rate.
     * The alternative is a constant bit rate.
     *
     * @param file
     * @return
     * @throws org.jaudiotagger.tag.TagException
     * @throws ReadOnlyFileException
     * @throws CannotReadException
     * @throws InvalidAudioFrameException
     * @throws IOException
     */
    public static boolean isVBR(File file) throws org.jaudiotagger.tag.TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        return AudioFileIO.read(file).getAudioHeader().isVariableBitRate();
    }
}
