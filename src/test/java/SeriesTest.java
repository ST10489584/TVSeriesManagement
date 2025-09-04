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

/**
 * SeriesTest.java
 *  Unit tests for the Series management application.
 * 
 * References:
 * 1. JUnit 4 Documentation. (2021). *JUnit 4*. Available at: https://junit.org/junit4/javadoc/4.13.2/ [Accessed 4 Sep. 2025].
 * 2. JUnit 5 Documentation. (2021). *JUnit 5*. Available at: https://junit.org/junit5/docs/current/user-guide/ [Accessed 4 Sep. 2025].
 * 3. Bloch, J. (2018). *Effective Java*. 3rd ed. Boston: Addison-Wesley.
 * 4. Schildt, H. (2018). *Java: The Complete Reference*. 11th ed. New York: McGraw-Hill Education.
 * 5. Osherove, R. (2013). *The Art of Unit Testing*. 3rd ed. Redmond: Microsoft Press.
 * 6. Beck, K. (2002). *Test-Driven Development: By Example*. Boston: Addison-Wesley.
 * 7. Baeldung. (2021). *JUnit 5 Tutorial*. Available at: https://www.baeldung.com/junit-5 [Accessed 4 Sep. 2025].
 * 8. Javatpoint. (2021). *JUnit Tutorial*. Available at: https://www.javatpoint.com/junit-tutorial [Accessed 4 Sep. 2025].
 * 9. Chacon, S. and Straub, B. (2014). *Pro Git*. 2nd ed. Berkeley: Apress.
 * 10. GitHub. (2021). *GitHub Guides*. Available at: https://guides.github.com/ [Accessed 4 Sep. 2025].
 * 11. Oracle. (2021). *Java Collections Framework*. Available at: https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html [Accessed 4 Sep. 2025].
 */


