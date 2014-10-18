package mp3manager;

import org.junit.Before;
import org.junit.Test;

public class Mp3ManagerTest {

    private Mp3Manager manager;
    private String directory, fireSign;

    @Before
    public void setUp() throws Exception {
        directory = "testFiles";
        fireSign = "testFiles/01. Agulo feat. David Berkeley - Fire Sign (Suncatcher Remix).mp3";
    }

    @Test
    public void test() throws Exception {
        manager = new Mp3Manager(directory);
    }
}