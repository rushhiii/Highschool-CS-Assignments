public class Project2Runner {
    
    /*
     * Name: Rushi Patel
     * Student ID: xxxxxxxxxxx
     * 
     ******** Project Description ********
     * 
     * This Java project is a quadratic equation solver application with a graphical user interface (GUI) built using Swing. 
     * The application allows users to input quadratic equations in the form ax² + bx + c = 0, and then displays the solutions (roots), 
     * discriminant, vertex, and a graphical representation of the equation. The program provides interactive elements including 
     * buttons for refreshing the interface and downloading solution steps.
     * 
     ******** Swing Requirement ********
     * 
     * The program utilizes three unique Swing components:
     * 1. JFrame: Serves as the main window container for the application
     * 2. JTextField: Custom rounded text field for equation input
     * 3. JButton: Refresh button and download button for interactive functionality
     * 4. JLabel: Multiple labels for displaying equation information, solutions, and graphical elements
     * 5. JTextArea: Scrollable area for displaying step-by-step solutions
     * These components are defined throughout the GUI.java file.
     * 
     ******** 2D Graphics Requirement ********
     *
     * The program includes a custom Graph panel that extends JPanel. This panel draws:
     * - A coordinate system with x and y axes
     * - The quadratic curve based on the input equation
     * - Specific points along the curve with coordinates
     * - A title displaying the current equation
     * - Visual elements using gradients and custom fonts
     * The Graph class is defined in Graph.java.
     * 
     ******** Event Listener Requirement ********
     *
     * 1. KeyListener: Attached to the input text field to detect when the user presses Enter (GUI.java line 237)
     * 2. ActionListener: Attached to the refresh button to reset the interface (GUI.java line 367)
     * 3. ActionListener: Attached to the download button to save solution steps to a file (GUI.java line 407)
     */

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.display();
    }

    // Test Cases:
    // 12x^2+4x+2=0
    // 2x^2+4x+2=0
    // 12x^2+22x+4=0
    // 1x^2-5x+6=0
    // 3x^2-5x+6=0 
}