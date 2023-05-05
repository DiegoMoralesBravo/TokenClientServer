package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

  public static String name = "";

  public Ventana() {
    // Configuración de la ventana
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("Cliente");

    // Creación de los componentes
    JLabel label = new JLabel();
    JTextField texto = new JTextField();
    JButton boton = new JButton("Conectar");

    label.setText("Cliente:");

    // Establecer las posiciones y tamaños de los componentes
    label.setBounds(80, 50, 200, 30); // posición x=50, y=50, ancho=100, alto=30
    texto.setBounds(140, 55, 75, 20); // posición x=150, y=50, ancho=100, alto=30
    boton.setBounds(100, 100, 100, 30); // posición x=100, y=100, ancho=100, alto=30

    // Desactivar el layout manager y añadir los componentes directamente al content
    getContentPane().setLayout(null);
    getContentPane().add(label);
    getContentPane().add(texto);
    getContentPane().add(boton);

    // Agregar un evento al botón
    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Leer el valor del input texto
        String cliente = texto.getText();
        System.out.println("Conectando con el cliente: " + cliente);
        name = cliente;
        setVisible(false);
      }
    });

    // Mostrar la ventana
    setVisible(true);
  }

  public String getName() {
    return name;
  }
}
