package mp3manager;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TrackTest extends TestCase {

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