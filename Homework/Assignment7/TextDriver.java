import java.util.*;

public class TextDriver {
    public static void main(String[] args) {
        testIndividualMethods();
    }

    /**
     * Tests individual methods.
     */
    private static void testIndividualMethods() {
        String[] methods = { "setupStreetMap", "setupParkingLots", "insertPanels", "updateActualEfficiency",
                "updateElectricityGenerated", "countWorkingPanels", "updateWorkingPanels", "calculateSavings" };
        String[] options = { "Test a new input file", "Test another method on the same input file", "Quit" };
        int controlChoice = 1;

        SolarPanels solarPanels = new SolarPanels();

        do {
            solarPanels = new SolarPanels();
            StdOut.print("Enter a street input file name => ");
            String filename = StdIn.readLine();
            do {
                int method = getMethodChoice(methods);
                testMethod(method, solarPanels, filename);
                StdIn.resync();
                controlChoice = getControlChoice(options);
            } while (controlChoice == 2);
        } while (controlChoice == 1);
    }

    /**
     * Provides options for testing a new method or quitting.
     * 
     * @param options the possible options for testing
     * @return the result of this action
     */
    private static int getControlChoice(String[] options) {
        StdOut.println("What would you like to do?");
        for (int i = 0; i < options.length; i++) {
            StdOut.println(i + 1 + ". " + options[i]);
        }
        StdOut.print("Enter a number => ");
        int number = Integer.parseInt(StdIn.readLine());
        return number;
    }

    /**
     * Provides options for testing methods or actions
     * 
     * @param methods the possible options for methods or actions
     * @return the result of this action
     */
    private static int getMethodChoice(String[] methods) {
        StdOut.println("What method would you like to test?");
        for (int i = 0; i < methods.length; i++) {
            StdOut.println(i + 1 + ". " + methods[i]);
        }
        StdOut.print("Enter a number => ");
        int number = Integer.parseInt(StdIn.readLine());
        return number;
    }

    /**
     * Tests a method given by the user.
     * 
     * @param methodNumber the method number identified through the method list
     * @param solarPanels  the SolarPanels object
     * @param filename     the input file name
     */
    private static void testMethod(int methodNumber, SolarPanels solarPanels, String filename) {
        switch (methodNumber) {
            case 1:
                solarPanels.setupStreetMap(filename);
                StdOut.println("Street Map Set Up:");
                printStreetMap(solarPanels.getStreetMap());
                break;

            case 2:
                StdOut.print("Enter a lot input file name => ");
                String fn = StdIn.readLine();
                solarPanels.setupParkingLots(fn);
                StdOut.println("Parking Lots Set Up:");
                printParkingLots(solarPanels.getLots());
                break;

            case 3:
                StdOut.print("Enter the cost per panel => ");
                double costPerPanel = Double.parseDouble(StdIn.readLine());
                solarPanels.insertPanels(costPerPanel);
                StdOut.println("Panels Inserted:");
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
                StdOut.println(txt);
                break;

            case 4:
                StdOut.print("Enter the temperature => ");
                int temperature = Integer.parseInt(StdIn.readLine());
                StdOut.print("Enter the efficiency coefficient => ");
                double coefficient = Double.parseDouble(StdIn.readLine());
                solarPanels.updateActualEfficiency(temperature, coefficient);
                StdOut.println("Actual Efficiency Updated:");
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
                StdOut.println(txt2);
                break;
            case 5:
                solarPanels.updateElectricityGenerated();
                StdOut.println("Electricity Updated:");
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
                StdOut.println(txt3);
                break;
            case 6:
                StdOut.print("Enter the parking lot name (ex: P1) => ");
                String pname = StdIn.readLine();
                int count = solarPanels.countWorkingPanels(pname);
                StdOut.println("Working panels: " + count);
                break;
            case 7:
                solarPanels.updateWorkingPanels();
                StdOut.println("Panels Updated:");
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
                StdOut.println(txt4);
                break;
            case 8:
                double savings = solarPanels.calculateSavings();
                StdOut.println("Savings: $" + savings);
                break;
        }
    }

    static void printStreetMap(String[][] streetMap) {
        if (streetMap == null) {
            StdOut.println("Street map is not set up.");
            return;
        }
        for (String[] row : streetMap) {
            for (String cell : row) {
                StdOut.print(cell + " ");
            }
            StdOut.println();
        }
    }

    static void printParkingLots(ParkingLot[] lots) {
        if (lots == null) {
            StdOut.println("Parking lots are not set up.");
            return;
        }
        StdOut.println("Lots:");
        int index = 0;
        for (ParkingLot lot : lots) {
            StdOut.println(index + ": " + lot.toString());
            index++;
        }
    }

    static void printPanels(Panel[][] panels) {
        if (panels == null) {
            StdOut.println("Panels are not set up.");
            return;
        }
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[0].length; j++) {
                StdOut.print(String.format("[%d][%d] ", i, j));
                if (panels[i][j] != null) {
                    StdOut.println(panels[i][j].toString());
                } else {
                    StdOut.println("No panel here!");
                }
            }
        }
    }
}
