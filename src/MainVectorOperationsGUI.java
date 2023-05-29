import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainVectorOperationsGUI extends JFrame {
    private JButton sumButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton magnitudButton;
    private JButton magnitud1Button;
    private JButton magnitudR3Button;

    public MainVectorOperationsGUI() {
        setTitle("VECTOR CALCULATOR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        // Create buttons for each operation
        sumButton = new JButton("A + B");
        subtractButton = new JButton("A - B");
        multiplyButton = new JButton("scalar * (A + C)");
        magnitud1Button = new JButton("[scalar * (A + B)] - C");
        magnitudButton = new JButton("|| scalar1(A) + scalar2(B) - C||");
        magnitudR3Button = new JButton("R = ||[(scalar1(U) * scalar2(V)) S] x W||");


        // Add buttons to the frame
        add(sumButton);
        add(subtractButton);
        add(multiplyButton);
        add(magnitud1Button);
        add(magnitudButton);
        add(magnitudR3Button);

        setLocationRelativeTo(null);

        // Add action listeners to the buttons
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSumOperationWindow();
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSubtractOperationWindow();
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMultiplyOperationWindow();
            }
        });

        magnitud1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOperationWindow();
            }
        });

        magnitudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMagnitudOperationWindow();
            }
        });

        magnitudR3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMagnitudR3OperationWindow();
            }
        });
    }

    private void openSumOperationWindow() {
        JFrame sumWindow = new JFrame("A + B");
        sumWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sumWindow.setSize(400, 200);
        sumWindow.setLayout(new BoxLayout(sumWindow.getContentPane(), BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField vectorATextField = new JTextField(15);
        JTextField vectorBTextField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Vector A:"));
        panel1.add(vectorATextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector B:"));
        panel2.add(vectorBTextField);

        // Add components to the sumWindow
        sumWindow.add(panel1);
        sumWindow.add(panel2);
        sumWindow.add(calculateButton);
        sumWindow.add(resultArea);

        sumWindow.setLocationRelativeTo(null);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vectorAInput = vectorATextField.getText();
                String vectorBInput = vectorBTextField.getText();

                // Parse vector input values
                double[] vectorA = parseVectorInput(vectorAInput);
                double[] vectorB = parseVectorInput(vectorBInput);

                // Perform the sum operation
                Vector result = VectorOperations.sum(new Vector2D(vectorA), new Vector2D(vectorB));
                resultArea.setText(Arrays.toString(result.getArray()));
            }
        });

        // Make the sumWindow visible
        sumWindow.setVisible(true);
    }

    private void openSubtractOperationWindow() {
        JFrame subtractWindow = new JFrame("A - B");
        subtractWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        subtractWindow.setSize(400, 200);
        subtractWindow.setLayout(new BoxLayout(subtractWindow.getContentPane(), BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField vectorATextField = new JTextField(15);
        JTextField vectorBTextField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Vector A:"));
        panel1.add(vectorATextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector B:"));
        panel2.add(vectorBTextField);

        // Add components to the subtractWindow
        subtractWindow.add(panel1);
        subtractWindow.add(panel2);
        subtractWindow.add(calculateButton);
        subtractWindow.add(resultArea);

        // Center the subtractWindow on the screen
        subtractWindow.setLocationRelativeTo(null);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vectorAInput = vectorATextField.getText();
                String vectorBInput = vectorBTextField.getText();

                // Parse vector input values
                double[] vectorA = parseVectorInput(vectorAInput);
                double[] vectorB = parseVectorInput(vectorBInput);

                // Perform the subtract operation
                Vector result = VectorOperations.subtract(new Vector2D(vectorA), new Vector2D(vectorB));
                resultArea.setText(Arrays.toString(result.getArray()));
            }
        });

        // Make the subtractWindow visible
        subtractWindow.setVisible(true);
    }


    private void openMultiplyOperationWindow() {
        JFrame multiplyWindow = new JFrame("scalar * (A + C)");
        multiplyWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        multiplyWindow.setSize(400, 200);
        multiplyWindow.setLayout(new BoxLayout(multiplyWindow.getContentPane(), BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField scalar1TextField = new JTextField(15);
        JTextField vectorATextField = new JTextField(15);
        JTextField vectorCTextField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Scalar 1:"));
        panel1.add(scalar1TextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector A:"));
        panel2.add(vectorATextField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(new JLabel("Vector C:"));
        panel3.add(vectorCTextField);

        // Add components to the multiplyWindow
        multiplyWindow.add(panel1);
        multiplyWindow.add(panel2);
        multiplyWindow.add(panel3);
        multiplyWindow.add(calculateButton);
        multiplyWindow.add(resultArea);

        // Center the multiplyWindow on the screen
        multiplyWindow.setLocationRelativeTo(null);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String scalar1Input = scalar1TextField.getText();
                String vectorAInput = vectorATextField.getText();
                String vectorCInput = vectorCTextField.getText();

                int scalar1 = Integer.parseInt(scalar1Input);

                // Parse vector input values
                double[] vectorA = parseVectorInput(vectorAInput);
                double[] vectorC = parseVectorInput(vectorCInput);

                // Perform the multiply operation
                Vector result = VectorOperations.multiply(scalar1, VectorOperations.sum(new Vector2D(vectorA), new Vector2D(vectorC)));
                resultArea.setText(Arrays.toString(result.getArray()));
            }
        });

        // Make the multiplyWindow visible
        multiplyWindow.setVisible(true);
    }


    private void openOperationWindow() {
        JFrame magnitud1Window = new JFrame("[scalar * (A + B)] - C");
        magnitud1Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        magnitud1Window.setSize(400, 300);
        magnitud1Window.setLayout(new BoxLayout(magnitud1Window.getContentPane(), BoxLayout.Y_AXIS));

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField scalar1TextField = new JTextField(15);
        JTextField vectorATextField = new JTextField(15);
        JTextField vectorBTextField = new JTextField(15);
        JTextField vectorCTextField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Scalar 1:"));
        panel1.add(scalar1TextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector A:"));
        panel2.add(vectorATextField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(new JLabel("Vector B:"));
        panel3.add(vectorBTextField);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(new JLabel("Vector C:"));
        panel4.add(vectorCTextField);

        // Add components to the main panel
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        mainPanel.add(calculateButton);
        mainPanel.add(resultArea);

        magnitud1Window.setLocationRelativeTo(null);

        // Center align the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the main panel to the magnitudWindow
        magnitud1Window.add(mainPanel, BorderLayout.CENTER);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vectorAInput = vectorATextField.getText();
                String vectorBInput = vectorBTextField.getText();
                String vectorCInput = vectorCTextField.getText();

                int scalar1 = Integer.parseInt(scalar1TextField.getText());

                // Parse vector input values
                double[] vectorA = parseVectorInput(vectorAInput);
                double[] vectorB = parseVectorInput(vectorBInput);
                double[] vectorC = parseVectorInput(vectorCInput);

                // Perform the vector operations
                Vector2D A = new Vector2D(vectorA);
                Vector2D B = new Vector2D(vectorB);
                Vector2D C = new Vector2D(vectorC);

                Vector result = VectorProduct.multiplyScalarByVector(scalar1, VectorOperations.sum(A, B), C);
                resultArea.setText(Arrays.toString(result.getArray()));
            }
        });

        // Make the magnitudWindow visible
        magnitud1Window.setVisible(true);
    }


    private void openMagnitudOperationWindow() {
        JFrame magnitudWindow = new JFrame("|| scalar1(A) + scalar2(B) - C||");
        magnitudWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        magnitudWindow.setSize(400, 300);
        magnitudWindow.setLayout(new BoxLayout(magnitudWindow.getContentPane(), BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField scalar1TextField = new JTextField(15);
        JTextField vectorATextField = new JTextField(15);
        JTextField scalar2TextField = new JTextField(15);
        JTextField vectorBTextField = new JTextField(15);
        JTextField vectorCTextField = new JTextField(15);
        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Scalar 1:"));
        panel1.add(scalar1TextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector A:"));
        panel2.add(vectorATextField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(new JLabel("Scalar 2:"));
        panel3.add(scalar2TextField);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(new JLabel("Vector B:"));
        panel4.add(vectorBTextField);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        panel5.add(new JLabel("Vector C:"));
        panel5.add(vectorCTextField);

        // Add components to the magnitudWindow
        magnitudWindow.add(panel1);
        magnitudWindow.add(panel2);
        magnitudWindow.add(panel3);
        magnitudWindow.add(panel4);
        magnitudWindow.add(panel5);
        magnitudWindow.add(calculateButton);
        magnitudWindow.add(resultArea);

        // Center the magnitudWindow on the screen
        magnitudWindow.setLocationRelativeTo(null);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String scalar1Input = scalar1TextField.getText();
                String vectorAInput = vectorATextField.getText();
                String scalar2Input = scalar2TextField.getText();
                String vectorBInput = vectorBTextField.getText();
                String vectorCInput = vectorCTextField.getText();

                int scalar1 = Integer.parseInt(scalar1Input);
                int scalar2 = Integer.parseInt(scalar2Input);

                // Parse vector input values
                double[] vectorA = parseVectorInput(vectorAInput);
                double[] vectorB = parseVectorInput(vectorBInput);
                double[] vectorC = parseVectorInput(vectorCInput);

                // Perform the magnitude operation
                double result = VectorOperations.magnitud(scalar1, new Vector2D(vectorA), scalar2, new Vector2D(vectorB), new Vector2D(vectorC));
                resultArea.setText(Double.toString(result));
            }
        });

        // Make the magnitudWindow visible
        magnitudWindow.setVisible(true);
    }

    private void openMagnitudR3OperationWindow() {
        JFrame magnitudR3Window = new JFrame("R = ||[(scalar1(U) * scalar2(V)) S] x W||");
        magnitudR3Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        magnitudR3Window.setSize(400, 400);
        magnitudR3Window.setLayout(new BoxLayout(magnitudR3Window.getContentPane(), BoxLayout.Y_AXIS));

        // Create UI components for input
        JTextField vectorUTextField = new JTextField(15);
        JTextField vectorVTextField = new JTextField(15);
        JTextField vectorSTextField = new JTextField(15);
        JTextField vectorWTextField = new JTextField(15);

        JTextField scalar1TextField = new JTextField(15);
        JTextField scalar2TextField = new JTextField(15);


        // Create panels for each label and text input pair
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel("Scalar 1:"));
        panel1.add(scalar1TextField);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(new JLabel("Vector U:"));
        panel2.add(vectorUTextField);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(new JLabel("Scalar 2:"));
        panel3.add(scalar2TextField);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel4.add(new JLabel("Vector V:"));
        panel4.add(vectorVTextField);

        JPanel panel5 = new JPanel();
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        panel5.add(new JLabel("Vector S:"));
        panel5.add(vectorSTextField);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
        panel6.add(new JLabel("Vector W:"));
        panel6.add(vectorWTextField);


        JButton calculateButton = new JButton("Calculate");
        JTextArea resultArea = new JTextArea();

        // Add components to the magnitudWindow
        magnitudR3Window.add(panel1);
        magnitudR3Window.add(panel2);
        magnitudR3Window.add(panel3);
        magnitudR3Window.add(panel4);
        magnitudR3Window.add(panel5);
        magnitudR3Window.add(panel6);

        magnitudR3Window.add(calculateButton);
        magnitudR3Window.add(resultArea);

        magnitudR3Window.setLocationRelativeTo(null);

        // Add action listener to the calculateButton
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vectorUInput = vectorUTextField.getText();
                String vectorVInput = vectorVTextField.getText();
                String vectorSInput = vectorSTextField.getText();
                String vectorWInput = vectorWTextField.getText();

                int scalar1 = Integer.parseInt(scalar1TextField.getText());
                int scalar2 = Integer.parseInt(scalar2TextField.getText());

                // Parse vector input values
                Vector3D U = new Vector3D(parseVectorInput(vectorUInput));
                Vector3D V = new Vector3D(parseVectorInput(vectorVInput));
                Vector3D S = new Vector3D(parseVectorInput(vectorSInput));
                Vector3D W = new Vector3D(parseVectorInput(vectorWInput));

                // Perform the magnitude operation
                double result = VectorOperations.magnitudR3(scalar1,scalar2,U, V, S, W);
                resultArea.setText(Double.toString(result));
            }
        });

        // Make the magnitudWindow visible
        magnitudR3Window.setVisible(true);
    }

    private double[] parseVectorInput(String input) {
        String[] values = input.split(",");
        double[] vector = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            vector[i] = Double.parseDouble(values[i].trim());
        }

        return vector;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainVectorOperationsGUI ui = new MainVectorOperationsGUI();
                ui.setVisible(true);
            }
        });
    }
}
