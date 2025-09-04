 import java.util.Scanner;

public class SeriesApp {
    private static Series seriesManager = new Series();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("LATEST SERIES - 2025");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        
        String userInput = scanner.nextLine(); // Capture user input

        // Check if the user wants to launch the menu
        if (!userInput.equals("1")) {
            System.out.println("Exiting application...");
            return; // Exit if the input is not '1'
        }

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    seriesManager.captureSeries();
                    break;
                case 2:
                    seriesManager.searchSeries();
                    break;
                case 3:
                    seriesManager.updateSeries();
                    break;
                case 4:
                    seriesManager.deleteSeries();
                    break;
                case 5:
                    seriesManager.printSeriesReport();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nPlease select one of the following menu items:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update a series.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report.");
        System.out.println("(6) Exit Application.");
    }

    private static int getMenuChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
}
