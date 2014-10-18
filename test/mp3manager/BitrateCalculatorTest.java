package mp3manager;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BitrateCalculatorTest extends TestCase {

    @Test
    public void testGetBitrateOf() throws Exception {
        System.out.println(BitrateCalculator.getBitrateOf(fireSign));
        System.out.println(BitrateCalculator.getBitrateOf(fullFocus));
        System.out.println(BitrateCalculator.getBitrateOf(deepDown));
    }

    @Test
    public void testIsVBR() throws Exception {
        assertFalse(BitrateCalculator.isVBR(fireSign));
        assertFalse(BitrateCalculator.isVBR(fullFocus));
        assertTrue(BitrateCalculator.isVBR(deepDown));
    }
}