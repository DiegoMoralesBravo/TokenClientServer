package App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VentanaServidor extends JFrame {
  private JLabel labelTitulo;
  private JLabel labelLog;
  private JTextArea textAreaLog;
  private JPanel panelLista;
  private JScrollPane scrollPaneLista;
  private ArrayList<JLabel> listaEtiquetas;

  public VentanaServidor() {
    // Configuración de la ventana
    super("Servidor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(800, 600));

    // Creación de los componentes
    labelTitulo = new JLabel("Servidor");
    labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
    labelLog = new JLabel("Log");
    textAreaLog = new JTextArea();
    textAreaLog.setEditable(false);
    JScrollPane scrollPaneLog = new JScrollPane(textAreaLog); // JScrollPane agregado
    scrollPaneLog.setPreferredSize(new Dimension(250, 100)); // Tamaño reducido
    panelLista = new JPanel(new GridLayout(0, 1));
    panelLista.setBorder(BorderFactory.createTitledBorder("Lista Clientes"));
    listaEtiquetas = new ArrayList<>();
    scrollPaneLista = new JScrollPane(panelLista);
    scrollPaneLista.setPreferredSize(new Dimension(200, 50)); // Tamaño reducido

    // Añadir los componentes a la ventana
    JPanel panelIzquierdo = new JPanel(new BorderLayout());
    panelIzquierdo.add(scrollPaneLista, BorderLayout.CENTER);
    panelIzquierdo.setBorder(new EmptyBorder(0, 0, 300, 20)); // Separación de 20 píxeles a la derecha
    JPanel panelDerecho = new JPanel(new BorderLayout());
    panelDerecho.add(labelLog, BorderLayout.NORTH);
    panelDerecho.add(new JScrollPane(textAreaLog), BorderLayout.CENTER);
    JPanel panelPrincipal = new JPanel(new BorderLayout());
    panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);
    panelPrincipal.add(panelDerecho, BorderLayout.CENTER);
    panelPrincipal.setBorder(new EmptyBorder(20, 40, 40, 40)); // Separación de 40 píxeles a la izquierda
    getContentPane().add(panelPrincipal);
    getContentPane().add(labelTitulo, BorderLayout.NORTH);

    // Mostrar la ventana
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  // Método para añadir una línea al log
  public void agregarLineaLog(String linea) {
    textAreaLog.append(linea + "\n");
  }

  // Método para añadir un elemento a la lista
  public void agregarElementoLista(String elemento) {
    JLabel label = new JLabel(elemento);
    listaEtiquetas.add(label);
    panelLista.add(label);
    scrollPaneLista.revalidate();
    scrollPaneLista.repaint();
  }

  public void eliminarElementoLista(int posicion) {
    panelLista.remove(posicion);
    listaEtiquetas.remove(posicion);
    scrollPaneLista.revalidate();
    scrollPaneLista.repaint();
  }

  public void seleccionarElementoLista(int posicion, Color color) {
    if (posicion >= 0 && posicion < listaEtiquetas.size()) {
      JLabel label = listaEtiquetas.get(posicion);
      label.setForeground(color);
    }
  }

  public int posicionLista() {
    return listaEtiquetas.size();
  }
}
