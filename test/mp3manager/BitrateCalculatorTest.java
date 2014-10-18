package mp3manager;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BitrateCalculatorTest {

    private BitrateCalculator br;
    private File fireSign;
    private File fullFocus;
    private File deepDown;

    @org.junit.Before
    public void setUp() throws Exception {
        br = new BitrateCalculator();
        fireSign = new File("testFiles/01. Agulo feat. David Berkeley - Fire Sign (Suncatcher Remix).mp3");
        fullFocus = new File("testFiles/06. Armin van Buuren - Full Focus.mp3");
        deepDown = new File("testFiles/12. Josh Gabriel pres. Winter Kills - Deep Down (Alex M.O.R.P.H. Remix).mp3");
    }

    @Test
    public void testGetBitrateOf() throws Exception {
        System.out.println(br.getBitrateOf(fireSign));
        System.out.println(br.getBitrateOf(fullFocus));
        System.out.println(br.getBitrateOf(deepDown));
    }

    @Test
    public void testIsVBR() throws Exception {
        assertFalse(BitrateCalculator.isVBR(fireSign));
        assertFalse(BitrateCalculator.isVBR(fullFocus));
        assertTrue(BitrateCalculator.isVBR(deepDown));
    }
}