import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.*;

public class Graph extends JPanel {
    private List<Double> vertices;
    private String equation;

    public void setVertices(List<Double> vertices) {
        this.vertices = vertices;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Graphics2D g2d = (Graphics2D) g;
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setColor(Color.RED); // Set the color of the line

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setColor(Color.RED); // S

        int width = getWidth();
        int height = getHeight();


        // vertical flip
        g2d.translate(0, height);
        g2d.scale(1, 1);

        if (vertices != null && vertices.size() >= 2) {
            // Calculate the scaling factors to fit the line within the graph bounds
            double minX = vertices.get(0);
            double maxX = vertices.get(vertices.size() - 1);
            double minY = Double.POSITIVE_INFINITY;
            double maxY = Double.NEGATIVE_INFINITY;

            for (double vertex : vertices) {
                minY = Math.min(minY, vertex);
                maxY = Math.max(maxY, vertex);
            }

            double scaleX = getWidth() / (maxX - minX);
            double scaleY = getHeight() / (maxY - minY);


           // Draw the line segment between each pair of consecutive vertices
            for (int i = 0; i < vertices.size() - 1; i++) {
                double x1 = (vertices.get(i) - minX) * scaleX;
                double y1 = height - (vertices.get(i) - minY) * scaleY;
                double x2 = (vertices.get(i + 1) - minX) * scaleX;
                double y2 = height - (vertices.get(i + 1) - minY) * scaleY;

                g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
            }
        }

        super.paintComponent(g);

        // Check if vertices are available
        if (vertices != null && vertices.size() == 3) {
            // Graphics2D g2d = (Graphics2D) g;
            // int width = getWidth();
            // int height = getHeight();

            // Set up the coordinate system
            g2d.translate(width / 2, height / 2);
            g2d.scale(1, -1);

            // Calculate the scale factor for x and y axes
            double xScale = width / (2 * Math.abs(vertices.get(2)));
            double yScale = height / (2 * Math.abs(vertices.get(0)));

            // Draw x and y axes
            g2d.setColor(Color.WHITE);
            g2d.drawLine(-(width / 2), 0, width / 2, 0);
            g2d.drawLine(0, -(height / 2), 0, height / 2);

            // Draw the quadratic curve
            g2d.translate(0, height + 10);

            g2d.setColor(Color.BLACK);
            for (int x = -(width / 2); x < (width / 2); x++) {
                double xValue = x / xScale;
                double yValue = vertices.get(0) * Math.pow(xValue, 2) + vertices.get(1) * xValue + vertices.get(2);
                int y = (int) (yValue * yScale);
                g2d.fillOval(x, y, 1, 1);
            }

            // Draw the line
            g2d.setColor(Color.BLUE);
            double x1 = -(width / 2) / xScale;
            double y1 = vertices.get(0) * Math.pow(x1, 2) + vertices.get(1) * x1 + vertices.get(2);
            int y1Coord = (int) (y1 * yScale);
            double x2 = (width / 2) / xScale;
            double y2 = vertices.get(0) * Math.pow(x2, 2) + vertices.get(1) * x2 + vertices.get(2);
            int y2Coord = (int) (y2 * yScale);
            g2d.drawLine(-(width / 2), -y1Coord, width / 2, -y2Coord);

            // Draw the coordinates
             g2d.scale(1, -1);
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
                Font customFontLarge = customFont.deriveFont(Font.PLAIN, 10);
                g2d.setFont(customFontLarge);
                g2d.setColor(Color.RED);
            } catch (Exception e) {
                g2d.setFont(new Font("Arial", Font.PLAIN, 10));
                g2d.setColor(Color.RED);
            }

            DecimalFormat df = new DecimalFormat("#.##");
            for (int x = -(width / 2); x <= width / 2; x += 50) {
                double xValue = x / xScale;
                double yValue = vertices.get(0) * Math.pow(xValue, 2) + vertices.get(1) *
                        xValue + vertices.get(2);
                int y = (int) (yValue * yScale);
                g2d.drawString("(" + df.format(xValue) + ", " + df.format(yValue) + ")", x -
                        10, -y - 10);
            }
        }

        if (equation != null) {
            try {
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
                Font customFontLarge = customFont.deriveFont(Font.BOLD, 15);
                g.setFont(customFontLarge);
                g.setColor(Color.WHITE);
                g.drawString("Equation: " + equation, 10, 20);
            } catch (Exception e) {
                g.setFont(new Font("Arial", Font.BOLD, 15));
                g.setColor(Color.WHITE);
                g.drawString("Equation: " + equation, 10, 20);
            }
        }
    }

@Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400); // Set the preferred size of the graph panel
    }
    
}
        
    
// import java.awt.*;
// import java.io.File;
// import java.text.DecimalFormat;
// import java.util.List;
// import javax.swing.*;

// public class Graph extends JPanel {
//     private List<Double> vertices;
//     private String equation;

//     private int width = 400;
//     private int height = 200;

//     public void setVertices(List<Double> vertices) {
//         this.vertices = vertices;
//     }

//     public void setEquation(String equation) {
//         this.equation = equation;
//     }

//     @Override
//     protected void paintComponent(Graphics g) {

//         super.paintComponent(g);

//         // Graphics2D g2d = (Graphics2D) g;
//         // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//         // RenderingHints.VALUE_ANTIALIAS_ON);
//         // g2d.setColor(Color.RED); // Set the color of the line

//         Graphics2D g2d = (Graphics2D) g;
//         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//         // g2d.setColor(Color.RED); // Set the color of the line

//         int width = getWidth();
//         int height = getHeight();
//         System.out.printf("Width: %s\nHeight: %s", width, height);

//         // int height = getImageHeight();
//         // int width = getImageWidth();

//         // vertical flip
//         g2d.translate(0, height);
//         g2d.scale(1, 1);

//         if (vertices != null && vertices.size() >= 2) {
//             // Calculate the scaling factors to fit the line within the graph bounds
//             double minX = vertices.get(0);
//             double maxX = vertices.get(vertices.size() - 1);
//             double minY = Double.POSITIVE_INFINITY;
//             double maxY = Double.NEGATIVE_INFINITY;

//             for (double vertex : vertices) {
//                 minY = Math.min(minY, vertex);
//                 maxY = Math.max(maxY, vertex);
//             }

//             double scaleX = getWidth() / (maxX - minX);
//             double scaleY = getHeight() / (maxY - minY);

//             // Draw the line segment between each pair of consecutive vertices
//             for (int i = 0; i < vertices.size() - 1; i++) {
//                 double x1 = (vertices.get(i) - minX) * scaleX;
//                 double y1 = height - (vertices.get(i) - minY) * scaleY;
//                 double x2 = (vertices.get(i + 1) - minX) * scaleX;
//                 double y2 = height - (vertices.get(i + 1) - minY) * scaleY;

//                 g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
//             }
//         }

//         super.paintComponent(g);

//         // Check if vertices are available
//         if (vertices != null && vertices.size() == 3) {
//             // Graphics2D g2d = (Graphics2D) g;
//             // int width = getWidth();
//             // int height = getHeight();

//             // Set up the coordinate system
//             g2d.translate(width / 2, height / 2);
//             g2d.scale(1, -1);

//             // Calculate the scale factor for x and y axes
//             double xScale = width / (2 * Math.abs(vertices.get(2)));
//             double yScale = height / (2 * Math.abs(vertices.get(0)));

//             // Draw x and y axes
//             g2d.setColor(Color.WHITE);
//             g2d.drawLine(-(width / 2), 0, width / 2, 0);
//             g2d.drawLine(0, -(height / 2), 0, height / 2);

//             // Draw the quadratic curve
//             g2d.setColor(Color.BLACK);
//             for (int x = -(width / 2); x < (width / 2); x++) {
//                 double xValue = x / xScale;
//                 double yValue = vertices.get(0) * Math.pow(xValue, 2) + vertices.get(1) * xValue + vertices.get(2);
//                 int y = (int) (yValue * yScale);
//                 g2d.fillOval(x, y, 1, 1);
//             }

//             // Draw the line
//             g2d.setColor(Color.BLUE);
//             double x1 = -(width / 2) / xScale;
//             double y1 = vertices.get(0) * Math.pow(x1, 2) + vertices.get(1) * x1 + vertices.get(2);
//             int y1Coord = (int) (y1 * yScale);
//             double x2 = (width / 2) / xScale;
//             double y2 = vertices.get(0) * Math.pow(x2, 2) + vertices.get(1) * x2 + vertices.get(2);
//             int y2Coord = (int) (y2 * yScale);
//             g2d.drawLine(-(width / 2), -y1Coord, width / 2, -y2Coord);

//             // Draw the coordinates
//             g2d.translate(0, height);
//             g2d.scale(1, -1);
//             try {
//                 Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
//                 Font customFontLarge = customFont.deriveFont(Font.PLAIN, 10);
//                 g2d.setFont(customFontLarge);
//                 g2d.setColor(Color.RED);
//             } catch (Exception e) {
//                 g2d.setFont(new Font("Arial", Font.PLAIN, 10));
//                 g2d.setColor(Color.RED);
//             }

//             DecimalFormat df = new DecimalFormat("#.##");
//             for (int x = -(width / 2); x <= width / 2; x += 50) {
//                 double xValue = x / xScale;
//                 double yValue = vertices.get(0) * Math.pow(xValue, 2) + vertices.get(1) *
//                         xValue + vertices.get(2);
//                 int y = (int) (yValue * yScale);
//                 g2d.drawString("(" + df.format(xValue) + ", " + df.format(yValue) + ")", x -
//                         10, -y - 10);
//             }
//         }

//         if (equation != null) {
//             try {
//                 Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Regular.ttf"));
//                 Font customFontLarge = customFont.deriveFont(Font.BOLD, 15);
//                 g.setFont(customFontLarge);
//                 g.setColor(Color.WHITE);
//                 g.drawString("Equation: " + equation, 10, 20);
//             } catch (Exception e) {
//                 g.setFont(new Font("Arial", Font.BOLD, 15));
//                 g.setColor(Color.WHITE);
//                 g.drawString("Equation: " + equation, 10, 20);
//             }
//         }
//     }


//     public int getImageHeight() { return this.height; }
//     public int getImageWidth() { return this.width; }

//     @Override
//     public Dimension getPreferredSize() {
//         return new Dimension(400, 400); // Set the preferred size of the graph panel
//     }
// }