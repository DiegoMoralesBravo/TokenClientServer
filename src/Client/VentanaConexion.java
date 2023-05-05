package Client;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConexion extends JFrame {

  public static String mensaje = "";

  private JLabel token;
  private JLabel label;
  private JLabel info;
  private JTextArea log;
  private JTextField texto;
  private JButton boton;

  public VentanaConexion(String cliente) {
    // Configuración de la ventana
    setSize(500, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setTitle("Cliente " + cliente);

    // Creación de los componentes
    this.token = new JLabel();
    this.label = new JLabel();
    this.info = new JLabel();
    this.log = new JTextArea(20, 20);
    this.texto = new JTextField();
    this.boton = new JButton("Enviar");

    log.setLineWrap(true);
    log.setWrapStyleWord(true);

    this.label.setText("Mensaje: ");
    this.token.setText("TOKEN");
    this.info.setText("Log: ");

    // Establecer las posiciones y tamaños de los componentes
    this.label.setBounds(70, 50, 100, 30); // posición x=50, y=50, ancho=100, alto=30
    this.texto.setBounds(140, 55, 75, 20); // posición x=150, y=50, ancho=100, alto=30
    this.boton.setBounds(100, 100, 100, 30); // posición x=100, y=100, ancho=100, alto=30

    this.token.setBounds(400, 5, 50, 50); // posición x=50, y=50, ancho=100, alto=30
    this.info.setBounds(250, 40, 200, 30); // posición x=50, y=50, ancho=100, alto=30
    this.log.setBounds(250, 80, 200, 50); // posición x=50, y=50, ancho=100, alto=30

    // Desactivar el layout manager y añadir los componentes directamente al content
    getContentPane().setLayout(null);
    getContentPane().add(label);
    getContentPane().add(token);
    getContentPane().add(info);
    getContentPane().add(log);
    getContentPane().add(texto);
    getContentPane().add(boton);

    // Agregar un evento al botón
    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Leer el valor del input texto
        mensaje = texto.getText();
        texto.setText("");
      }
    });

    // Mostrar la ventana
    setVisible(true);
  }

  public String getMensaje() {
    return mensaje;
  }

  public void clearMensaje() {
    mensaje = "";
  }

  public void setColorToken(boolean flag) {
    if (flag) {
      this.token.setForeground(Color.GREEN);
      ;
    } else {
      this.token.setForeground(Color.RED);
      ;
    }
  }

  public void setLog(String info) {
    this.log.setText("");
    this.log.setText(info);
  }
}
