package seminars.fourth.database;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataProcessorTest {

    @Test
    public void testProcessData() {
        Database database = mock(Database.class);
        when(database.query(ArgumentMatchers.anyString())).thenReturn(Arrays.asList("First", "Second", "Third"));
        DataProcessor dataProcessor = new DataProcessor(database);
        List<String> resultSize = dataProcessor.processData("SELECT * FROM table");
        assertEquals(3, resultSize.size());
    }
}