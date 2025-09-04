import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {
    private Series seriesManager;

    @Before
    public void setUp() {
        seriesManager = new Series();
        // Adding sample data for testing
        seriesManager.captureSeries("1", "Sample Series", "13", "10");
        seriesManager.captureSeries("2", "Another Series", "16", "8");
    }

    @Test
    public void TestSearchSeries() {
        SeriesModel series = seriesManager.searchSeries("1");
        assertNotNull(series);
        assertEquals("Sample Series", series.getSeriesName());
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesModel series = seriesManager.searchSeries("999");
        assertNull(series);
    }

    @Test
    public void TestUpdateSeries() {
        seriesManager.updateSeries("1", "Updated Series", "14", "12");
        SeriesModel series = seriesManager.searchSeries("1");
        assertEquals("Updated Series", series.getSeriesName());
    }

    @Test
    public void TestDeleteSeries() {
        seriesManager.deleteSeries("1");
        SeriesModel series = seriesManager.searchSeries("1");
        assertNull(series);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        seriesManager.deleteSeries("999");
        // Check that size remains the same
        assertEquals(2, seriesManager.getSeriesCount());
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        boolean isValid = seriesManager.isAgeValid("13");
        assertTrue(isValid);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInvalid() {
        boolean isValid = seriesManager.isAgeValid("20");
        assertFalse(isValid);
    }


}

