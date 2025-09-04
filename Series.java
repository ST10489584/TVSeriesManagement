// Series.java
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Capture a new series
    public void captureSeries() {
        System.out.print("Enter the series ID: ");
        String seriesId = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String seriesName = scanner.nextLine();
        System.out.print("Enter the age restriction (2-18): ");
        String seriesAge = scanner.nextLine();
        System.out.print("Enter the number of episodes: ");
        String seriesNumberOfEpisodes = scanner.nextLine();

        // Create a new SeriesModel object
        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAge, seriesNumberOfEpisodes);
        seriesList.add(newSeries);
        System.out.println("Series processed successfully!");
    }

    // Search for a series
    public void searchSeries() {
        System.out.print("Enter the series ID to search: ");
        String seriesId = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(seriesId)) {
                System.out.println(series); // Using toString method
                return;
            }
        }
        System.out.println("Series with Series ID: " + seriesId + " was not found!");
    }

    // Update a series
    public void updateSeries() {
        System.out.print("Enter the series ID to update: ");
        String seriesId = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(seriesId)) {
                System.out.print("Enter new series name (leave empty to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    series.setSeriesName(newName);
                }
                System.out.print("Enter new age restriction (leave empty to keep current): ");
                String newAge = scanner.nextLine();
                if (!newAge.isEmpty()) {
                    series.setSeriesAge(newAge);
                }
                System.out.print("Enter new number of episodes (leave empty to keep current): ");
                String newEpisodes = scanner.nextLine();
                if (!newEpisodes.isEmpty()) {
                    series.setSeriesNumberOfEpisodes(newEpisodes);
                }
                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series with Series ID: " + seriesId + " was not found!");
    }

    // Delete a series
    public void deleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String seriesId = scanner.nextLine();
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(seriesId)) {
                seriesList.remove(series);
                System.out.println("Series deleted successfully!");
                return;
            }
        }
        System.out.println("Series with Series ID: " + seriesId + " was not found!");
    }

    // Print series report
    public void printSeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            System.out.println("Series Report:");
            for (SeriesModel series : seriesList) {
                System.out.println(series);
                System.out.println("------------------------------------------------");
            }
        }
    }
}
