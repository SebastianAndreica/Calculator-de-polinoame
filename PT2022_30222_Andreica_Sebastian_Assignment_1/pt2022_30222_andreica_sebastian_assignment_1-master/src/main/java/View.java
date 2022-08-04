import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JPanel Interfata;
    private JTextField polinom1;
    private JTextField polinom2;
    private JTextField rezultat;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton coefficientButton;
    private JButton a0Button;
    private JButton pointButton;
    private JButton inmultireButton;
    private JButton delButton;
    private JButton backButton;
    private JButton prodButton;
    private JButton divButton;
    private JButton sumButton;
    private JButton subButton;
    private JButton impartireButton;
    private JButton adunareButton;
    private JButton scadereButton;
    private JButton derivareButton;
    private JButton integrareButton;
    private Model model;
    private String userFocus;
    private int polinomCurent = 1;

    public View( Model model) {
        this.model = model;
        this.setContentPane(Interfata);
        this.pack();;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getPolinom1() {
        return polinom1.getText();
    }

    public String getPolinom2() {
        return polinom2.getText();
    }

    public void setRezultat( String rezultat ) {
        if(model.isValid()) {
            this.rezultat.setText(rezultat);
        }
        model.setValid(true);
    }

    public int getPolinomCurent( ) {
        return polinomCurent;
    }

    public void setPolinomCurent( int polinomCurent ) {
        this.polinomCurent = polinomCurent;
    }

    public String getUserFocus( ) {
        userFocus = polinomCurent == 1 ? polinom1.getText() : polinom2.getText();
        return userFocus;
    }

    public void setUserFocus( String userFocus ) {
        this.userFocus = userFocus;
        if( polinomCurent == 1 ) {
            polinom1.setText(userFocus);
        }
        else {
            polinom2.setText(userFocus);
        }
    }

    public void addButtonInmultireListener( ActionListener actionListener ) {
        inmultireButton.addActionListener(actionListener);
    }

    public void addButtonImpartireListener( ActionListener actionListener ) {
        impartireButton.addActionListener(actionListener);
    }

    public void addButtonAdunareListener( ActionListener actionListener ) {
        adunareButton.addActionListener(actionListener);
    }

    public void addButtonScadereListener( ActionListener actionListener ) {
        scadereButton.addActionListener(actionListener);
    }

    public void addButtonDerivareListener( ActionListener actionListener ) {
        derivareButton.addActionListener(actionListener);
    }

    public void addButtonIntegrareListener( ActionListener actionListener ) {
        integrareButton.addActionListener(actionListener);
    }

    public void addButton1Listener( ActionListener actionListener ) {
        a1Button.addActionListener(actionListener);
    }

    public void addButton2Listener( ActionListener actionListener ) {
        a2Button.addActionListener(actionListener);
    }

    public void addButton3Listener( ActionListener actionListener ) {
        a3Button.addActionListener(actionListener);
    }

    public void addButton4Listener( ActionListener actionListener ) {
        a4Button.addActionListener(actionListener);
    }

    public void addButton5Listener( ActionListener actionListener ) {
        a5Button.addActionListener(actionListener);
    }

    public void addButton6Listener( ActionListener actionListener ) {
        a6Button.addActionListener(actionListener);
    }

    public void addButton7Listener( ActionListener actionListener ) {
        a7Button.addActionListener(actionListener);
    }

    public void addButton8Listener( ActionListener actionListener ) {
        a8Button.addActionListener(actionListener);
    }

    public void addButton9Listener( ActionListener actionListener ) {
        a9Button.addActionListener(actionListener);
    }

    public void addButton0Listener( ActionListener actionListener ) {
        a0Button.addActionListener(actionListener);
    }

    public void addButttonNextListener( ActionListener actionListener ) {
        divButton.addActionListener(actionListener);
    }

    public void addButttonXListener( ActionListener actionListener ) {
        pointButton.addActionListener(actionListener);
    }

    public void addButttonCoeffDivListener( ActionListener actionListener ) {
        coefficientButton.addActionListener(actionListener);
    }

    public void addButttonDelListener( ActionListener actionListener ) {
        delButton.addActionListener(actionListener);
    }

    public void addButttonSumListener( ActionListener actionListener ) {
        sumButton.addActionListener(actionListener);
    }

    public void addButttonSubListener( ActionListener actionListener ) {
        subButton.addActionListener(actionListener);
    }

    public void addButttonBackListener( ActionListener actionListener ) {
        backButton.addActionListener(actionListener);
    }

    public void addButttonProdListener( ActionListener actionListener ) {
        prodButton.addActionListener(actionListener);
    }
}
