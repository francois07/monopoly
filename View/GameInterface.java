package View;

import javax.swing.*;

import Controller.Plateau;

import java.awt.*;
import java.awt.event.*;

public class GameInterface implements ActionListener {
  private Plateau plateau;
  private JFrame frame;
  private JTextField entryField;
  private JTextArea log;
  private JLabel image;

  public GameInterface(final Plateau plateau) {
    this.plateau = plateau;
    this.createInterface();
  }

  public void print(final String pText) {
    this.log.append(pText);
    this.log.setCaretPosition(this.log.getDocument().getLength());
  }

  public void println(final String pText) {
    this.print(pText + "\n");
  }

  private void createInterface() {
    this.frame = new JFrame("Monopoly");
    this.entryField = new JTextField(34);
    this.log = new JTextArea();

    this.log.setEditable(false);
    this.log.setLineWrap(true);
    this.log.setWrapStyleWord(true);

    JPanel panel = new JPanel();
    JPanel buttonPanel = new JPanel();
    buttonPanel.setPreferredSize(new Dimension(100, 20));

    JScrollPane listScroller = new JScrollPane(this.log);
    listScroller.setPreferredSize(new Dimension(640, 480));
    listScroller.setMinimumSize(new Dimension(200, 200));

    this.image = new JLabel();

    JButton quitButton = new JButton("Quitter");
    JButton helpButton = new JButton("Aide");

    panel.setLayout(new BorderLayout());
    buttonPanel.setLayout(new GridLayout(2, 1));

    panel.add(this.image, BorderLayout.NORTH);
    panel.add(listScroller, BorderLayout.CENTER);
    panel.add(entryField, BorderLayout.SOUTH);
    panel.add(buttonPanel, BorderLayout.EAST);

    buttonPanel.add(quitButton);
    buttonPanel.add(helpButton);

    this.frame.getContentPane().add(panel, BorderLayout.CENTER);

    this.frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    quitButton.addActionListener(e -> this.frame.dispose());
    helpButton.addActionListener(e -> this.plateau.parseCommand("help"));

    this.entryField.addActionListener(this);

    this.frame.pack();
    this.frame.setVisible(true);
    this.frame.requestFocus();

  }

  public void actionPerformed(final ActionEvent event) {
    // no need to check the type of action at the moment
    // because there is only one possible action (text input) :
    this.processCommand(); // never suppress this line
  } // actionPerformed(.)

  /**
   * A command has been entered. Read the command and do whatever is
   * necessary to process it.
   */
  private void processCommand() {
    String input = this.entryField.getText();
    this.entryField.setText("");

    this.plateau.parseCommand(input);
  } // processCommand()
}
