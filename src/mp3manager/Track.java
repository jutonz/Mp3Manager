package mp3manager;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representation of a single track, or playable audio file. Contains
 * information about the track's tags, which can also be manipulated
 * based on user preferences. Also maintains an idea of a "proper"
 * format which all tracks are expected to follow. This includes both
 * tag and filename formatting.
 *
 * Created by Justin Toniazzo on 16 Oct 2014.
 */
public class Track {

    private File file;
    private int bitrate;
    private boolean isVBR;
    private String artist;
    private String comment;
    private String title;

    public Track(File inputFile) {
        file = inputFile;
        load(file);
    }

    /**
     * Loads the contents of the track into memory.
     *
     * @param file the track's location on disc
     */
    private void load(File file) {
        try {
            bitrate     = BitrateCalculator.getBitrateOf(file);
            isVBR       = BitrateCalculator.isVBR(file);
            artist      = TagManager.getArtist(file);
            title       = TagManager.getTitle(file);
            comment     = TagManager.getComment(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enforceFormats() {
        fixFeat();
    }

    public void fixFeat() {
        // Fixes Featuring
        // To    feat.
        Pattern pattern = Pattern.compile("[Ff]eaturing");
        Matcher matcher = pattern.matcher(title);
        if (matcher.find()) {
            String badStyle = matcher.group(0);
            title = title.replace(badStyle, "feat.");
        }

        // Fixes Featuring (in Artist Name)
        // To    feat.
        pattern = Pattern.compile("[Ff]eaturing");
        matcher = pattern.matcher(artist);
        if (matcher.find()) {
            String badStyle = matcher.group(0);
            artist = artist.replace(badStyle, "feat.");
            TagManager.setArtist(file, artist);
            TagManager.setTitle(file, title);
            return;
        }

        pattern = Pattern.compile(".*feat.*");
        matcher = pattern.matcher(title.toLowerCase());
        if (matcher.find()) {
            // Fixes Artist Name - Track Title (feat. Vocalist Name) (Artist Remix)
            // to    Artist Name feat. Vocalist Name - Track Title (Artist Remix)
            pattern = Pattern.compile("\\s\\([F|f]eat[\\.]?.*\\).*(?=\\s\\()");
            matcher = pattern.matcher(title);
            if (matcher.find()) {
                String featuringArtist = matcher.group(0);
                title = title.replace(featuringArtist, "");
                artist += featuringArtist;
                artist = artist.replace("(", "");
                artist = artist.replace(")", "");
            }

            // Fixes Artist Name - Track Title feat. Vocalist Name (Artist Remix)
            // to    Artist Name feat. Vocalist Name - Track Title (Artist Remix)
            pattern = Pattern.compile("\\s[F|f]eat[\\.]?.*(?=\\s\\()");
            matcher = pattern.matcher(title);
            if (matcher.find()) {
                String featuringArtist = matcher.group(0);
                title = title.replace(featuringArtist, "");
                artist += featuringArtist;
            }

            // Fixes Artist Name - Track Title feat. Vocalist Name
            // To    Artist Name feat. Vocalist - Track Title
            pattern = Pattern.compile("\\s[F|f]eat[\\.]?.*");
            matcher = pattern.matcher(title);
            if (matcher.find()) {
                String featuringArtist = matcher.group(0);
                title = title.replace(featuringArtist, "");
                artist += featuringArtist;
            }

            // Fixes Feat
            // To    feat
            pattern = Pattern.compile("Feat");
            matcher = pattern.matcher(artist);
            if (matcher.find()) {
                String badCaps = matcher.group(0);
                artist = artist.replace(badCaps, badCaps.toLowerCase());
            }

            // Fixes feat
            // To    feat.
            pattern = Pattern.compile("feat\\s");
            matcher = pattern.matcher(artist);
            if (matcher.find()) {
                String badCaps = matcher.group(0);
                artist = artist.replace(badCaps, "feat. ");
            }

            System.out.println("Fixed title: " + title);
            System.out.println("Fixed artist: " + artist);

            // Apply fixes to the file's tags.
            TagManager.setArtist(file, artist);
            TagManager.setTitle(file, title);
        }
    }

    public boolean isVBR() {
        return isVBR;
    }

    public int getBitrate() {
        return bitrate;
    }

    public File getFile() {
        return file;
    }
}
