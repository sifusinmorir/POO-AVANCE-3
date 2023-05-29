/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Uptow
 */

// Interfaz para las medidas
interface Medida {
    double convertir(String unidadDestino);
}

// Clase que representa una medida de longitud
class Longitud implements Medida {
    private double valor;

    public Longitud(double valor) {
        this.valor = valor;
    }

    @Override
    public double convertir(String unidadDestino) {
        switch (unidadDestino) {
            case "m":
                return valor / 1000;
            case "km":
                return valor;
            case "cm":
                return valor * 100;
            case "ft":
                return valor / 3280.84;
            default:
                throw new IllegalArgumentException("Unidad de longitud no válida: " + unidadDestino);
        }
    }
}

// Clase que representa una medida de peso
class Peso implements Medida {
    private double valor;

    public Peso(double valor) {
        this.valor = valor;
    }

    @Override
    public double convertir(String unidadDestino) {
        switch (unidadDestino) {
            case "kg":
                return valor;
            case "g":
                return valor * 1000;
            case "lb":
                return valor / 2.20462;
            case "N":
                return valor / 9.80665;
            case "t":
                return valor * 1000;
            case "mg":
                return valor / 1000000;
            case "oz":
                return valor / 35.27396;
            default:
                throw new IllegalArgumentException("Unidad de peso no válida: " + unidadDestino);
        }
    }
}

// Clase que representa una medida de temperatura
class Temperatura implements Medida {
    private double valor;

    public Temperatura(double valor) {
        this.valor = valor;
    }

    @Override
    public double convertir(String unidadDestino) {
        switch (unidadDestino) {
            case "C":
                return valor;
            case "F":
                return (valor - 32) * 5 / 9;
            case "K":
                return valor - 273.15;
            default:
                throw new IllegalArgumentException("Unidad de temperatura no válida: " + unidadDestino);
        }
    }
}

public class ConversorMedidasGUI {
    private JFrame frame;
    private JComboBox<String> medidaComboBox;
    private JTextField valorTextField;
    private JComboBox<String> unidadOrigenComboBox;
    private JComboBox<String> unidadDestinoComboBox;
    private JTextArea resultadoTextArea;

    // Mapa que contiene las opciones de conversión para cada tipo de medida
    private Map<String, String[]> opcionesConversor;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConversorMedidasGUI window = new ConversorMedidasGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ConversorMedidasGUI() {
        initialize();
        inicializarOpcionesConversor();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblMedida = new JLabel("Medida:");
        lblMedida.setBounds(20, 20, 60, 25);
        frame.getContentPane().add(lblMedida);

        medidaComboBox = new JComboBox<String>();
        medidaComboBox.setBounds(90, 20, 100, 25);
        frame.getContentPane().add(medidaComboBox);

        medidaComboBox.addItem("Longitud");
        medidaComboBox.addItem("Peso");
        medidaComboBox.addItem("Temperatura");

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20, 60, 60, 25);
        frame.getContentPane().add(lblValor);

        valorTextField = new JTextField();
        valorTextField.setBounds(90, 60, 100, 25);
        frame.getContentPane().add(valorTextField);
        valorTextField.setColumns(10);

        JLabel lblUnidadOrigen = new JLabel("Unidad Origen:");
        lblUnidadOrigen.setBounds(20, 100, 100, 25);
        frame.getContentPane().add(lblUnidadOrigen);

        unidadOrigenComboBox = new JComboBox<String>();
        unidadOrigenComboBox.setBounds(130, 100, 100, 25);
        frame.getContentPane().add(unidadOrigenComboBox);

        JLabel lblUnidadDestino = new JLabel("Unidad Destino:");
        lblUnidadDestino.setBounds(20, 140, 100, 25);
        frame.getContentPane().add(lblUnidadDestino);

        unidadDestinoComboBox = new JComboBox<String>();
        unidadDestinoComboBox.setBounds(130, 140, 100, 25);
        frame.getContentPane().add(unidadDestinoComboBox);

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(20, 180, 100, 25);
        frame.getContentPane().add(btnConvertir);

        resultadoTextArea = new JTextArea();
        resultadoTextArea.setBounds(20, 220, 340, 30);
        frame.getContentPane().add(resultadoTextArea);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(260, 180, 100, 25);
        frame.getContentPane().add(btnSalir);

        // Acción del botón "Convertir"
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertirMedida();
            }
        });

        // Acción del botón "Salir"
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Acción de cambio de medida seleccionada
        medidaComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarOpcionesConversor();
            }
        });
    }

    private void inicializarOpcionesConversor() {
        opcionesConversor = new HashMap<String, String[]>();
        opcionesConversor.put("Longitud", new String[]{"m", "km", "cm", "ft"});
        opcionesConversor.put("Peso", new String[]{"kg", "g", "lb", "N", "t", "mg", "oz"});
        opcionesConversor.put("Temperatura", new String[]{"C", "F", "K"});

        actualizarOpcionesConversor();
    }

    private void actualizarOpcionesConversor() {
        String medidaSeleccionada = (String) medidaComboBox.getSelectedItem();
        String[] opciones = opcionesConversor.get(medidaSeleccionada);
        unidadOrigenComboBox.setModel(new DefaultComboBoxModel<String>(opciones));
        unidadDestinoComboBox.setModel(new DefaultComboBoxModel<String>(opciones));
    }

    private void convertirMedida() {
        String medidaSeleccionada = (String) medidaComboBox.getSelectedItem();
        String valorStr = valorTextField.getText();
        String unidadOrigen = (String) unidadOrigenComboBox.getSelectedItem();
        String unidadDestino = (String) unidadDestinoComboBox.getSelectedItem();

        if (valorStr.isEmpty()) {
            resultadoTextArea.setText("Por favor, introduce un valor válido.");
            return;
        }

        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            resultadoTextArea.setText("Valor no válido. Por favor, introduce un número válido.");
            return;
        }

        Medida medida;
        switch (medidaSeleccionada) {
            case "Longitud":
                medida = new Longitud(valor);
                break;
            case "Peso":
                medida = new Peso(valor);
                break;
            case "Temperatura":
                medida = new Temperatura(valor);
                break;
            default:
                resultadoTextArea.setText("Medida no válida. Por favor, selecciona una medida válida.");
                return;
        }

        double resultado;
        try {
            resultado = medida.convertir(unidadDestino);
        } catch (IllegalArgumentException e) {
            resultadoTextArea.setText("Opción no válida. " + e.getMessage());
            return;
        }

        resultadoTextArea.setText("Resultado: " + resultado + " " + unidadDestino);
    }
}