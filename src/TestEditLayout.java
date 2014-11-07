
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gonxi's
 */
public class TestEditLayout {

    /**
     * @param args the command line arguments
     */
    static JTextArea textArea = null;

    public static void main(String[] args) {

        createAndShowGUI();
    }

    private static void addComponentsToPane(Container pane) {

        //set Layout to pane
        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(500, 300));

        //1.- Component
        Insets insets = pane.getInsets();
        textArea = new JTextArea("Escriba aqui!");
        textArea.setBounds(0 + insets.left, 0 + insets.top, 400, 300);
        pane.add(textArea);

        JButton buttonSubrayar = new JButton("SUBRAYAR");
        buttonSubrayar.setBounds(textArea.getWidth() + 5, 35 + insets.top, 90, 30);
        pane.add(buttonSubrayar);

        JButton buttonNegrita = new JButton("NEGRITA");
        buttonNegrita.setBounds(textArea.getWidth() + 5, 95 + insets.top + buttonSubrayar.getHeight(), 90, 30);
        pane.add(buttonNegrita);

        JButton buttonItalic = new JButton("CURSIVA");
        buttonItalic.setBounds(textArea.getWidth() + 5, 155 + insets.top + buttonNegrita.getHeight() + buttonSubrayar.getHeight(), 90, 30);
        pane.add(buttonItalic);

        //listeners
        buttonNegrita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Map attrs = textArea.getFont().getAttributes();
                attrs.put(TextAttribute.UNDERLINE, null);
                textArea.setFont(textArea.getFont().deriveFont(attrs));
                textArea.setFont(textArea.getFont().deriveFont(Font.BOLD));                
            }
        });

        buttonSubrayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                    Map attrs = textArea.getFont().getAttributes();
                    attrs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    textArea.setFont(textArea.getFont().deriveFont(attrs));
                    textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN));
                
            }
        });
        
        buttonItalic.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Map attrs = textArea.getFont().getAttributes();
                attrs.put(TextAttribute.UNDERLINE, null);
                textArea.setFont(textArea.getFont().deriveFont(attrs));
                textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC));
            }
            
        
        });







        /*
        
         JPanel panel1 = new JPanel ();
         JTextArea texto = new JTextArea ("Escriba aqui!");
         texto.setOpaque(true);
         panel1.setBackground(Color.WHITE);
         texto.setBounds(600, 600, 400, 600);
         panel1.add(texto);
         pane.add(panel1, FlowLayout.LEFT);
        
         //2.- Component
         JPanel panel2 = new JPanel ();
         panel2.setLayout(new BoxLayout (panel2, BoxLayout.Y_AXIS));
         panel2.setPreferredSize(new Dimension(100, 300));
         addButtonsToPanel (panel2);
         pane.add(panel2);
         * */
    }

    private static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Otro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        //Fix the size
        frame.setResizable(false);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
