package mp3manager;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class TrackTest {

    private File fireSign;
    private File fullFocus;
    private File deepDown;

    @Before
    public void setUp() throws Exception {
        fireSign = new File("testFiles/01. Agulo feat. David Berkeley - Fire Sign (Suncatcher Remix).mp3");
        fullFocus = new File("testFiles/06. Armin van Buuren - Full Focus.mp3");
        deepDown = new File("testFiles/12. Josh Gabriel pres. Winter Kills - Deep Down (Alex M.O.R.P.H. Remix).mp3");
    }


    @Test
    public void testNoFeatFixNeeded() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");

        // Make sure the changes were applied.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }


    @Test
    public void testFixFeat() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign feat. David Berkeley");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign feat. David Berkeley", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeaturing() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign featuring David Berkeley");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign featuring David Berkeley", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeaturingInArtist() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo featuring David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");

        // Make sure the changes were applied.
        assertEquals("Agulo featuring David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeaturingInArtistWithCapital() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo Featuring David Berkeley");

        // Make sure the changes were applied.
        assertEquals("Agulo Featuring David Berkeley", TagManager.getArtist(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeaturingWithCapital() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign Featuring David Berkeley");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign Featuring David Berkeley", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeatUpperCase() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign Feat. David Berkeley");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign Feat. David Berkeley", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign", TagManager.getTitle(fireSign));

        // Fix it in case it didn't
        TagManager.setArtist(fireSign, "Agulo feat. David Berkeley");
        TagManager.setTitle(fireSign, "Fire Sign (Suncatcher Remix)");
    }

    @Test
    public void testFixFeatWithRemix() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign feat. David Berkeley (Suncatcher Remix)");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign feat. David Berkeley (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));
    }

    @Test
    public void testFixFeatWithParenthesisWithRemix() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign (feat. David Berkeley) (Suncatcher Remix)");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (feat. David Berkeley) (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));
    }

    @Test
    public void testFixFeatWithParenthesisNoPeriodWithRemix() throws Exception {
        // Set the title and artist to incorrect formats.
        TagManager.setArtist(fireSign, "Agulo");
        TagManager.setTitle(fireSign, "Fire Sign (feat David Berkeley) (Suncatcher Remix)");

        // Make sure the changes were applied.
        assertEquals("Agulo", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (feat David Berkeley) (Suncatcher Remix)", TagManager.getTitle(fireSign));

        // Ask the Track class to fix this formatting error.
        Track fireTrack = new Track(fireSign);
        fireTrack.fixFeat();

        // See if it did.
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));
    }
}