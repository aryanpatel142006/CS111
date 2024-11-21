import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class AnimatedDriver {

    private static SolarPanels solarPanels;
    private static String[] actions;
    private static String[] options;
    private static int n = 4;

    public static void main(String[] args) {
        String[] tempacts = { "setupStreetMap", "setupParkingLots", "insertPanels", "updateActualEfficiency",
                "updateElectricityGenerated", "countWorkingPanels", "updateWorkingPanels", "calculateSavings" };
        String[] opts = { "Test a new input file", "Test a method using this input file", "Quit" };
        actions = tempacts;
        options = opts;
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(0, 4);
        StdDraw.enableDoubleBuffering();
        Font font = new Font("Arial", Font.PLAIN, 24);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font);

        int controlChoice = 1;
        do {
            String filename = null;
            do {
                int method = getActionChoice(actions);
                switch (method) {
                    case 1:
                        filename = getFileChoice();
                        displayStreetMap(filename);
                        break;
                    case 2:
                        filename = getFileChoice();
                        StdDraw.setCanvasSize(600, 900);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        solarPanels.setupParkingLots(filename);
                        int index = 0;
                        String text = "";
                        for (ParkingLot lot : solarPanels.getLots()) {
                            text += (index + ": " + lot.toString() + "\n");
                            index++;
                        }
                        drawOfficialDocument(text);
                        break;
                    case 3:
                        double panelCost = Double
                                .parseDouble(getChoice("Enter the cost per panel (only the number, no $)."));
                        solarPanels.insertPanels(panelCost);
                        displayStreetMapWithPanels();
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        String txt = "";
                        Panel[][] panels = solarPanels.getPanels();
                        for (int i = 0; i < panels.length; i++) {
                            for (int j = 0; j < panels[0].length; j++) {
                                if (panels[i][j] != null)
                                    txt += "Index [" + i + "][" + j + "]: " + panels[i][j].toString() + "\n";
                                else
                                    txt += "Index [" + i + "][" + j + "]: " + "No panel here!" + "\n";

                            }
                        }
                        drawOfficialDocument(txt);
                        break;
                    case 4:
                        int temp = Integer
                                .parseInt(getChoice("Enter the temperature (only the integer, nothing else)."));
                        double coe = Double
                                .parseDouble(getChoice("Enter the coefficient (only the number, nothing else)."));
                        solarPanels.updateActualEfficiency(temp, coe);
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        String txt2 = "";
                        Panel[][] pnls = solarPanels.getPanels();
                        for (int i = 0; i < pnls.length; i++) {
                            for (int j = 0; j < pnls[0].length; j++) {
                                if (pnls[i][j] != null)
                                    txt2 += "Index [" + i + "][" + j + "]: " + pnls[i][j].toString() + "\n";
                                else
                                    txt2 += "Index [" + i + "][" + j + "]: " + "No panel here!" + "\n";

                            }
                        }
                        drawOfficialDocument(txt2);
                        break;
                    case 5:
                        solarPanels.updateElectricityGenerated();
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        String txt3 = "";
                        Panel[][] pnls3 = solarPanels.getPanels();
                        for (int i = 0; i < pnls3.length; i++) {
                            for (int j = 0; j < pnls3[0].length; j++) {
                                if (pnls3[i][j] != null)
                                    txt3 += "Index [" + i + "][" + j + "]: " + pnls3[i][j].toString() + "\n";
                                else
                                    txt3 += "Index [" + i + "][" + j + "]: " + "No panel here!" + "\n";
                            }
                        }
                        drawOfficialDocument(txt3);
                        break;
                    case 6:
                        String pname = getChoice("Enter a parking lot name.");
                        int count = solarPanels.countWorkingPanels(pname);
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        drawOfficialDocument("There are " + count + " working panels in " + pname + "\n");
                        break;
                    case 7:
                        solarPanels.updateWorkingPanels();
                        displayStreetMapWithPanels();
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        String txt4 = "";
                        Panel[][] pnls4 = solarPanels.getPanels();
                        for (int i = 0; i < pnls4.length; i++) {
                            for (int j = 0; j < pnls4[0].length; j++) {
                                if (pnls4[i][j] != null)
                                    txt4 += "Index [" + i + "][" + j + "]: " + pnls4[i][j].toString() + "\n";
                                else
                                    txt4 += "Index [" + i + "][" + j + "]: " + "No panel here!" + "\n";
                            }
                        }
                        drawOfficialDocument(txt4);
                        break;
                    case 8:
                        double savings = solarPanels.calculateSavings();
                        StdDraw.setCanvasSize(600, 850);
                        StdDraw.setXscale(0, 4);
                        StdDraw.setYscale(0, 4);
                        drawOfficialDocument("You save $ " + savings + " in energy costs with this project.");
                        break;

                }
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.setFont(font);
                controlChoice = getControlChoice(options);
            } while (controlChoice == 2);
        } while (controlChoice == 1);
        System.exit(0);

    }

    private static void displayStreetMap(String filename) {
        solarPanels = new SolarPanels();
        solarPanels.setupStreetMap(filename);

        String[][] streetMap = solarPanels.getStreetMap();
        if (streetMap == null) {
            System.out.println("Street map is not set up.");
            return;
        }

        int rows = streetMap.length;
        int cols = streetMap[0].length;

        StdDraw.setCanvasSize(100 * cols, 100 * rows);
        StdDraw.setXscale(0, cols);
        StdDraw.setYscale(0, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String value = streetMap[i][j];
                double centerX = j + 0.5;
                double centerY = (rows - 1 - i) + 0.5;

                if (value.contains("P")) {
                    // Draw parking lot
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawParkingLines(centerX, centerY);
                    StdDraw.setPenColor(new Color(255, 255, 255, 255));
                    StdDraw.setFont(new Font("Arial", Font.BOLD, 30));
                    StdDraw.text(centerX, centerY, value);
                } else if (value.equals("RD")) {
                    // Draw road with horizontal lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadLines(centerX, centerY, false);

                } else if (value.equals("VR")) {
                    // Draw road with vertical lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadLines(centerX, centerY, true);
                } else if (value.equals("JN")) {
                    // Draw road with a white outline and no yellow lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadOutline(centerX, centerY);
                } else if (value.contains("CR")) {
                    // Draw building with bricks
                    StdDraw.setPenColor(new Color(139, 69, 19)); // Brown for bricks
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawBricks(centerX, centerY);
                } else {
                    // Default color for unspecified tiles
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                }

            }
        }
        StdDraw.show();
        while (StdDraw.hasNextKeyTyped())
            StdDraw.nextKeyTyped();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                break;
            }
            StdDraw.pause(20);
        }
        StdDraw.setPenColor(Color.BLACK);
    }

    private static void displayStreetMapWithPanels() {

        String[][] streetMap = solarPanels.getStreetMap();
        Panel[][] panels = solarPanels.getPanels();

        if (streetMap == null) {
            System.out.println("Street map is not set up.");
            return;
        }

        int streetRows = streetMap.length;
        int streetCols = streetMap[0].length;
        int panelRows = panels != null ? panels.length : 0;
        int panelCols = panels != null && panelRows > 0 ? panels[0].length : 0;

        int rows = Math.max(streetRows, panelRows);
        int cols = Math.max(streetCols, panelCols);

        StdDraw.setCanvasSize(100 * cols, 100 * rows);
        StdDraw.setXscale(0, cols);
        StdDraw.setYscale(0, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double centerX = j + 0.5;
                double centerY = (rows - 1 - i) + 0.5;

                if (i >= streetRows || j >= streetCols) {
                    // Draw mismatched rows or columns in red
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    continue;
                }

                String value = streetMap[i][j];

                if (value.contains("P")) {
                    // Draw parking lot
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawParkingLines(centerX, centerY);
                    StdDraw.setPenColor(new Color(255, 255, 255, 255));
                    StdDraw.setFont(new Font("Arial", Font.BOLD, 30));
                    StdDraw.text(centerX, centerY, value);
                } else if (value.equals("RD")) {
                    // Draw road with horizontal lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadLines(centerX, centerY, false);
                } else if (value.equals("VR")) {
                    // Draw road with vertical lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadLines(centerX, centerY, true);
                } else if (value.equals("JN")) {
                    // Draw road with a white outline and no yellow lines
                    StdDraw.setPenColor(StdDraw.DARK_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawRoadOutline(centerX, centerY);
                } else if (value.contains("CR")) {
                    // Draw building with bricks
                    StdDraw.setPenColor(new Color(139, 69, 19)); // Brown for bricks
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                    drawBricks(centerX, centerY);
                } else {
                    // Default color for unspecified tiles
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(centerX, centerY, 0.5);
                }

                // Draw panels if present
                if (i < panelRows && j < panelCols && panels[i][j] != null) {
                    if (panels[i][j].isWorking())
                        drawPanels(centerX, centerY, Color.BLUE);
                    else
                        drawPanels(centerX, centerY, StdDraw.BOOK_RED);

                    StdDraw.setPenColor(new Color(255, 255, 255, 190));
                    StdDraw.setFont(new Font("Arial", Font.BOLD, 30));
                    StdDraw.text(centerX, centerY, value);
                }
            }
        }

        StdDraw.show();
        while (StdDraw.hasNextKeyTyped())
            StdDraw.nextKeyTyped();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                break;
            }
            StdDraw.pause(20);
        }
        StdDraw.setPenColor(Color.BLACK);
    }

    private static void drawParkingLines(double centerX, double centerY) {
        // Set the color for the parking lot background
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(centerX, centerY, 0.5);

        // Set the color for the parking lines
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.setPenRadius(0.005);

        // Draw horizontal parking lines
        for (double offset = -0.4; offset <= 0.4; offset += 0.4) {
            StdDraw.line(centerX - 0.5, centerY + offset, centerX + 0.5, centerY + offset);
        }

        // Draw vertical parking lines within the parking lot spaces
        double lineWidth = 0.02; // Width of the vertical lines
        for (double offset = -0.3; offset <= 0.3; offset += 0.3) {
            StdDraw.filledRectangle(centerX + offset, centerY, lineWidth / 2, 0.4);
        }

    }

    private static void drawPanels(double centerX, double centerY, Color c) {
        // Set the color for the solar panels
        StdDraw.setPenColor(c);
        StdDraw.setPenRadius(0.002);
        double panelWidth = 0.1;
        double panelHeight = 0.1;

        for (double y = centerY - 0.35; y <= centerY + 0.35; y += panelHeight + 0.02) {
            double startX = centerX - 0.35;
            while (startX < centerX + 0.35) {
                StdDraw.setPenColor(c);
                StdDraw.filledRectangle(startX + panelWidth / 2, y + panelHeight / 2, panelWidth / 2, panelHeight / 2);
                StdDraw.setPenColor(new Color(0, 0, 0, 255)); // Solar panel lines
                StdDraw.rectangle(startX + panelWidth / 2, y + panelHeight / 2, panelWidth / 2, panelHeight / 2);
                startX += panelWidth + 0.02;
            }
        }
    }

    private static void drawRoadLines(double centerX, double centerY, boolean vertical) {
        StdDraw.setPenColor(Color.YELLOW);
        StdDraw.setPenRadius(0.01);
        double dashLength = 0.1;

        if (vertical) {
            for (double y = centerY - 0.8; y < centerY + 0.4; y += 2 * dashLength) {
                StdDraw.line(centerX, y, centerX, y + dashLength);
            }
        } else {
            for (double x = centerX - 0.5; x < centerX + 0.5; x += 2 * dashLength) {
                StdDraw.line(x, centerY, x + dashLength, centerY);
            }
        }
    }

    private static void drawRoadOutline(double centerX, double centerY) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

        // Draw thick rectangle on the left side
        StdDraw.filledRectangle(centerX - 0.475, centerY, 0.1, 0.5);

        // Draw thick rectangle on the bottom side
        StdDraw.filledRectangle(centerX, centerY - 0.475, 0.5, 0.1);
    }

    private static void drawBricks(double centerX, double centerY) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.002);
        for (double y = centerY - 0.5; y <= centerY + 0.5; y += 0.1) {
            for (double x = centerX - 0.5; x <= centerX + 0.5; x += 0.2) {
                StdDraw.rectangle(x, y, 0.1, 0.05);
            }
        }

        StdDraw.setPenColor(new Color(124, 252, 0));
        StdDraw.setPenRadius(0.0125);
        StdDraw.square(centerX, centerY, 0.5);
    }

    private static void drawOfficialDocument(String text) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        Font font = new Font(Font.SERIF, Font.PLAIN, 18);
        StdDraw.setFont(font);

        // Split the text by newlines
        String[] lines = text.split("\n");

        ArrayList<String> prompt = new ArrayList<>();

        prompt.add("RU Solar Panels");
        prompt.add("\n");
        prompt.add("Project Report");
        prompt.add("\n");

        for (int i = 0; i < lines.length; i++) {
            prompt.add(String.format("%s", lines[i]));
        }

        for (int line = 0; line < prompt.size(); line++) {
            if (line == 0) {
                font = new Font(Font.SERIF, Font.BOLD, 26);
                StdDraw.setPenColor(Color.RED);
            } else if (line == 2) {
                font = new Font(Font.SERIF, Font.BOLD, 21);
                StdDraw.setPenColor(Color.BLACK);
            } else {
                font = new Font(Font.SERIF, Font.PLAIN, 16);
                StdDraw.setPenColor(Color.BLACK);
            }
            StdDraw.setFont(font);
            StdDraw.textLeft(0.2, (4 - 0.25) - 0.1 * line, prompt.get(line));

        }
        StdDraw.show();
        while (StdDraw.hasNextKeyTyped())
            StdDraw.nextKeyTyped();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                break;
            }
            StdDraw.pause(20);
        }
        StdDraw.setPenColor(Color.BLACK);
    }

    private static int getActionChoice(String[] actions) {
        StdDraw.clear();
        while (StdDraw.hasNextKeyTyped())
            StdDraw.nextKeyTyped();

        ArrayList<String> prompt = new ArrayList<>();
        prompt.add("What do you want to test?");

        for (int i = 0; i < actions.length; i++) {
            prompt.add(String.format("%d. %s", i + 1, actions[i]));
        }

        for (int line = 0; line < actions.length + 1; line++) {
            StdDraw.textLeft(0.5, (n - 0.4) - 0.3 * line, prompt.get(line));
        }

        StdDraw.show();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if ('1' <= key && key <= '8')
                    return key - '0';
            }

            StdDraw.pause(20);
        }
    }

    /**
     * Obtains and displays the action to take after student tests a method,
     * allowing students to choose the action.
     * 
     * @param options all possible actions to take
     * @return the number of the control action choice to take
     * 
     **/
    private static int getControlChoice(String[] options) {
        StdDraw.clear();
        while (StdDraw.hasNextKeyTyped())
            StdDraw.nextKeyTyped();

        ArrayList<String> prompt = new ArrayList<>();
        prompt.add("What do you want to do now?");

        for (int i = 0; i < 3; i++) {
            prompt.add(String.format("%d. %s", i + 1, options[i]));
        }

        for (int line = 0; line < 4; line++) {
            StdDraw.textLeft(0.5, (n - 0.4) - 0.3 * line, prompt.get(line));
        }

        StdDraw.show();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if ('1' <= key && key <= '3')
                    return key - '0';
            }

            StdDraw.pause(20);
        }
    }

    private static String getFileChoice() {
        StdDraw.clear();

        File[] allFiles = new File(".").listFiles();
        ArrayList<String> choices = new ArrayList<>();
        ArrayList<String> files = new ArrayList<>();
        choices.add("What file do you want to test on?");
        choices.add("Type only characters and backspace.");
        choices.add("Press enter to submit.");
        for (File f : allFiles) {
            if (f.getName().endsWith(".in")) {
                files.add(f.getName());
            }
        }
        Font font = new Font("Arial", Font.PLAIN, 24);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font);
        double x = 0.25;
        for (int line = 0; line < choices.size(); line++) {
            StdDraw.textLeft(x, (n - 0.4) - 0.21 * line, choices.get(line));
        }

        StdDraw.show();

        String selection = "";
        char key;
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                key = StdDraw.nextKeyTyped();
                if (key == '\n') {
                    if (files.contains(selection)) {
                        font = new Font("Arial", Font.PLAIN, 30);
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.setFont(font);
                        return selection;
                    } else {
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.filledRectangle(2, (n - 1.5), 1.9, .4);
                        StdDraw.setPenColor(Color.RED);
                        font = new Font("Arial", Font.PLAIN, 32);
                        StdDraw.setFont(font);
                        StdDraw.text(2, (n - 1.5), "Could not open " + selection);
                        StdDraw.show();
                        selection = "";
                        continue;
                    }
                } else if (key == '\b') {
                    if (selection.length() != 0)
                        selection = selection.substring(0, selection.length() - 1);
                } else if (key >= 32 && key <= 127) {
                    selection += key;
                }
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.filledRectangle(2, (n - 1.5), 1.9, .4);
                StdDraw.setPenColor(Color.WHITE);
                font = new Font("Arial", Font.PLAIN, 32);
                StdDraw.setFont(font);
                StdDraw.text(2, (n - 1.5), selection);
                StdDraw.show();
            }

            StdDraw.pause(20);
        }
    }

    private static String getChoice(String text) {
        StdDraw.clear();

        ArrayList<String> choices = new ArrayList<>();
        choices.add(text);
        choices.add("Type only characters and backspace.");
        choices.add("Press enter to submit.");
        Font font = new Font("Arial", Font.PLAIN, 24);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font);
        double x = 0.25;
        for (int line = 0; line < choices.size(); line++) {
            StdDraw.textLeft(x, (n - 0.4) - 0.21 * line, choices.get(line));
        }

        StdDraw.show();

        String selection = "";
        char key;
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                key = StdDraw.nextKeyTyped();
                if (key == '\n') {
                    return selection;
                } else if (key == '\b') {
                    if (selection.length() != 0)
                        selection = selection.substring(0, selection.length() - 1);
                } else if (key >= 32 && key <= 127) {
                    selection += key;
                }
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.filledRectangle(2, (n - 1.5), 1.9, .4);
                StdDraw.setPenColor(Color.WHITE);
                font = new Font("Arial", Font.PLAIN, 32);
                StdDraw.setFont(font);
                StdDraw.text(2, (n - 1.5), selection);
                StdDraw.show();
            }

            StdDraw.pause(20);
        }
    }
}
