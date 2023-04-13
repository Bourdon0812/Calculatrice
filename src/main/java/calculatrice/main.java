package calculatrice;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener {
    private static final String IMAGE_ICON_PATH = "/src/main/java/calculatrice/img/CalculatriceIcon.png";
    private static final String TITLE = "Calculatrice";
    private static final short WIDTH = 550;
    private static final short HEIGHT = 700;
    private static long calcul = 0;
    private static boolean addition = false;
    private static boolean isExecutable = false;
    public static JTextArea calc = new JTextArea(4, 4);

    public main() {

        this.setJMenuBar(menuBar());
        JPanel content = (JPanel) this.getContentPane();
        content.setBackground(Color.black);

        content.setLayout(new BorderLayout());

        JPanel res = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));
        res.setBackground(Color.black);
        res.setPreferredSize(new Dimension(300, 250));
        content.add(res, BorderLayout.NORTH);
        JButton exe = new JButton("exe");
        exe.setPreferredSize(new Dimension(150, 200));
        exe.addActionListener(this);
        calc.setPreferredSize(new Dimension(300, 30));
        calc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        calc.setBackground(Color.LIGHT_GRAY);
        res.add(calc);
        res.add(exe);

        //content.add(new Button("="));
        //content.add(new Button("+"));
        JPanel Calculatrice = new JPanel(new GridLayout(3, 4));
        Calculatrice.setBackground(Color.black);
        content.add(Calculatrice);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonCalc = new JButton("<--");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonAdd = new JButton("+");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonSus = new JButton("-");
        button1.setBackground(Color.gray);
        button2.setBackground(Color.gray);
        button3.setBackground(Color.gray);
        button4.setBackground(Color.gray);
        button5.setBackground(Color.gray);
        button6.setBackground(Color.gray);
        button7.setBackground(Color.gray);
        button8.setBackground(Color.gray);
        button9.setBackground(Color.gray);
        buttonCalc.setBackground(Color.gray);
        buttonAdd.setBackground(Color.gray);
        buttonSus.setBackground(Color.gray);
        exe.setBackground(Color.gray);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSus.addActionListener(this);
        buttonCalc.addActionListener(this);
        Calculatrice.add(button1);
        Calculatrice.add(button2);
        Calculatrice.add(button3);
        Calculatrice.add(buttonCalc);
        Calculatrice.add(button4);
        Calculatrice.add(button5);
        Calculatrice.add(button6);
        Calculatrice.add(buttonAdd);
        Calculatrice.add(button7);
        Calculatrice.add(button8);
        Calculatrice.add(button9);
        Calculatrice.add(buttonSus);
    }

    private JMenuBar menuBar() {
        JMenuBar menu = new JMenuBar();

        JMenu police = new JMenu("Police");
        JMenuItem size = new JMenuItem("Size");
        JMenuItem italic = new JMenuItem("Italic");
        JMenuItem gras = new JMenuItem("Gras");
        JMenuItem couleur = new JMenuItem("Couleur");
        police.add(size);
        police.add(italic);
        police.add(gras);
        police.add(couleur);

        JMenu theme = new JMenu("Theme");
        JMenuItem black_theme = new JMenuItem("Black Theme");
        JMenuItem white_theme = new JMenuItem("White Theme");
        JMenuItem blue_theme = new JMenuItem("Blue Theme");
        JMenuItem pink_theme = new JMenuItem("Pink Theme");
        JMenuItem green_theme = new JMenuItem("Green Theme");
        JMenuItem yellow_theme = new JMenuItem("Yellow Theme");
        JMenuItem red_theme = new JMenuItem("Red Theme");
        JMenuItem perso_theme = new JMenuItem("Perso Theme      ...");
        theme.add(black_theme);
        theme.add(white_theme);
        theme.add(blue_theme);
        theme.add(pink_theme);
        theme.add(green_theme);
        theme.add(yellow_theme);
        theme.add(red_theme);
        theme.add(perso_theme);

        menu.add(police);
        menu.add(theme);
        return menu;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        ImageIcon icon = new ImageIcon(IMAGE_ICON_PATH);

        main window = new main();
        window.setTitle(TITLE);
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setIconImage(icon.getImage());
        //window.setLocationRelativeTo(null);
        window.setBackground(Color.black);
        window.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            if (((JButton) source).getText() == "<--") {
                calcul = 0;
                calc.setText("");
                addition = false;
                isExecutable = false;
            } else if (((JButton) source).getText() == "+") {
                if (calc.getText() == "") {
                    return;
                } else {
                    if (addition) {
                        calcul += Integer.parseInt(calc.getText());
                        calc.setText(String.valueOf(calcul));
                        addition = false;
                        isExecutable = false;
                    }
                }
            } else if (((JButton) source).getText() == "exe") {
                /*try {
                    this.executeCalcul();
                } catch (ScriptException ex) {
                    throw new RuntimeException(ex);
                }*/
                if (isExecutable) {
                    calcul += Integer.parseInt(calc.getText());
                    calc.setText(String.valueOf(calcul));
                    addition = false;
                    isExecutable = false;
                }
            } else {
                if (!addition) {
                    calc.setText("");
                    addition = true;
                }

                String text = calc.getText() + ((JButton) source).getText();
                calc.setText(text);
                isExecutable = true;

            }
        }
    }

    public void executeCalcul() /*throws ScriptException*/ {
        /*ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        System.out.println(engine);
        String calcul = calc.getText();
        System.out.println(engine.eval(calcul));*/
    }
}
