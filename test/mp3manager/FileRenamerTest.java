package mp3manager;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileRenamerTest extends TestCase {

    @Test
    public void testRename() throws Exception {
        File tempFile = File.createTempFile("temporary_file_for_testing_", null);
        tempFile.deleteOnExit();
        String oldName = tempFile.getName();

        String newName = "the_rename_was_a_success.tmp";
        tempFile = FileRenamer.rename(tempFile, newName);
        assertNotNull(tempFile);
        assertEquals(newName, tempFile.getName());

        tempFile = FileRenamer.rename(tempFile, oldName);
        assertNotNull(tempFile);
        assertEquals(oldName, tempFile.getName());
    }
}