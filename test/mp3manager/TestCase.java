package mp3manager;

import java.io.File;

/**
 * Handles setup required by all tests.
 *
 * Created by Justin Toniazzo on 18 Oct 2014.
 */
public class TestCase {

    public String testFileDir = "testFiles/";
    public File fireSign;
    public File fullFocus;
    public File deepDown;

    @org.junit.Before
    public void setUp() throws Exception {
        fireSign = new File(testFileDir + "01. Agulo feat. David Berkeley - Fire Sign (Suncatcher Remix).mp3");
        fullFocus = new File(testFileDir + "06. Armin van Buuren - Full Focus.mp3");
        deepDown = new File(testFileDir + "12. Josh Gabriel pres. Winter Kills - Deep Down (Alex M.O.R.P.H. Remix).mp3");
    }
}
