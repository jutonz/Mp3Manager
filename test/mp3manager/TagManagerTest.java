package mp3manager;

import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagField;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class TagManagerTest extends TestCase {

    @Test
    public void testGetArtist() throws Exception {
        assertEquals("Agulo feat. David Berkeley", TagManager.getArtist(fireSign));
        assertEquals("Armin van Buuren", TagManager.getArtist(fullFocus));
        assertEquals("Josh Gabriel pres. Winter Kills", TagManager.getArtist(deepDown));

        MP3File mp3file = new MP3File(fullFocus);
        Iterator<TagField> it = mp3file.getID3v2Tag().getFields();
        while (it.hasNext())
            System.out.println(it.next().getId());
    }

    @Test
    public void testSetArtist() throws Exception {
        TagManager.setArtist(fullFocus, "Ferry Corsten");
        assertEquals("Ferry Corsten", TagManager.getArtist(fullFocus));
        TagManager.setArtist(fullFocus, "Armin van Buuren");
        assertEquals("Armin van Buuren", TagManager.getArtist(fullFocus));
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("Fire Sign (Suncatcher Remix)", TagManager.getTitle(fireSign));
        assertEquals("Full Focus", TagManager.getTitle(fullFocus));
        assertEquals("Deep Down (Alex M.O.R.P.H. Remix)", TagManager.getTitle(deepDown));
    }

    @Test
    public void testSetTitle() throws Exception {
        TagManager.setTitle(fullFocus, "Brute");
        assertEquals("Brute", TagManager.getTitle(fullFocus));
        TagManager.setTitle(fullFocus, "Full Focus");
        assertEquals("Full Focus", TagManager.getTitle(fullFocus));
    }

    @Test
    public void testGetComment() throws Exception {
        assertEquals("", TagManager.getComment(fireSign));
        assertEquals("", TagManager.getComment(fullFocus));
        assertEquals("", TagManager.getComment(deepDown));
    }

    @Test
    public void testSetComment() throws Exception {
        assertEquals("", TagManager.getComment(fireSign));
        TagManager.setComment(fireSign, "Hi!");
        assertEquals("Hi!", TagManager.getComment(fireSign));
        TagManager.setComment(fireSign, "");
        assertEquals("", TagManager.getComment(fireSign));
    }

    @Test
    public void testGetAlbumTitle() throws Exception {
        assertEquals("Fire Sign", TagManager.getAlbumTitle(fireSign));
        assertEquals("Mirage", TagManager.getAlbumTitle(fullFocus));
        assertEquals("Hands on Armada", TagManager.getAlbumTitle(deepDown));
    }

    @Test
    public void testGetTrackNumber() throws Exception {
        assertEquals(1, TagManager.getTrackNumber(fireSign));
        assertEquals(6, TagManager.getTrackNumber(fullFocus));
        assertEquals(12, TagManager.getTrackNumber(deepDown));
    }

    @Test
    public void testGetDiscNumber() throws Exception {
        assertEquals(1, TagManager.getDiscNumber(fireSign));
        assertEquals(1, TagManager.getDiscNumber(fullFocus));
        assertEquals(1, TagManager.getDiscNumber(deepDown));
    }

    @Test
    public void testGetSetAlbumArtist() throws Exception {
        assertEquals("Agulo", TagManager.getAlbumArtist(fireSign));
        TagManager.setAlbumArtist(fireSign, "Armin van Buuren");
        assertEquals("Armin van Buuren", TagManager.getAlbumArtist(fireSign));
        TagManager.setAlbumArtist(fireSign, "Agulo");
        assertEquals("Agulo", TagManager.getAlbumArtist(fireSign));
    }
}