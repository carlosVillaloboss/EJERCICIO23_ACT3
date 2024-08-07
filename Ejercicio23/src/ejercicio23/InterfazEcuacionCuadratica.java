package ejercicio23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEcuacionCuadratica {

    private JFrame frame;
    private JTextField txtA;
    private JTextField txtB;
    private JTextField txtC;
    private JTextArea txtOutput;

    public InterfazEcuacionCuadratica() {
        // Crear la ventana principal
        frame = new JFrame("Resolver Ecuación Cuadrática");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        // Crear componentes
        JLabel lblA = new JLabel("Coeficiente a:");
        JLabel lblB = new JLabel("Coeficiente b:");
        JLabel lblC = new JLabel("Coeficiente c:");

        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();

        JButton btnCalcular = new JButton("Calcular Raíces");
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);

        // Agregar componentes al panel
        frame.add(lblA);
        frame.add(txtA);
        frame.add(lblB);
        frame.add(txtB);
        frame.add(lblC);
        frame.add(txtC);
        frame.add(new JLabel()); // Espacio vacío
        frame.add(btnCalcular);
        frame.add(new JLabel()); // Espacio vacío
        frame.add(new JScrollPane(txtOutput));

        // Configurar acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularYMostrar();
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }

    private void calcularYMostrar() {
        try {
            // Leer datos de los campos de texto
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            // Crear un objeto EcuacionCuadratica
            EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);

            // Mostrar resultados
            txtOutput.setText(ecuacion.calcularRaices());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, ingrese datos válidos.",
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazEcuacionCuadratica());
    }
}
