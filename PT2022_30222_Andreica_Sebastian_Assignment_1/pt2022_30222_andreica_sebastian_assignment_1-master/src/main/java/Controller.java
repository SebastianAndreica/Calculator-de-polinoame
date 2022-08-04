import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;
    private Buttons buttons;

    public Controller( Model model, View view) {
        this.model = model;
        this.view = view;
        buttons = new Buttons(view);

        //operatii
        view.addButtonInmultireListener(new InmultireButton());
        view.addButtonImpartireListener(new ImpartireButton());
        view.addButtonAdunareListener(new AdunareButton());
        view.addButtonScadereListener(new ScadereButton());
        view.addButtonDerivareListener(new DerivareButton());
        view.addButtonIntegrareListener(new IntegrareButton());

        //tastatura din UI
        view.addButton1Listener(new Buttons.Button0());
        view.addButton1Listener(new Buttons.Button1());
        view.addButton2Listener(new Buttons.Button2());
        view.addButton3Listener(new Buttons.Button3());
        view.addButton4Listener(new Buttons.Button4());
        view.addButton5Listener(new Buttons.Button5());
        view.addButton6Listener(new Buttons.Button6());
        view.addButton7Listener(new Buttons.Button7());
        view.addButton8Listener(new Buttons.Button8());
        view.addButton9Listener(new Buttons.Button9());
        view.addButton0Listener(new Buttons.Button0());
        view.addButttonSumListener(new Buttons.ButtonPlus());
        view.addButttonSubListener(new Buttons.ButtonMinus());
        view.addButttonDelListener(new Buttons.ButtonDel());
        view.addButttonProdListener(new Buttons.ButtonStea());
        view.addButttonXListener(new Buttons.ButtonX());
        view.addButttonBackListener(new Buttons.ButtonBack());
        view.addButttonCoeffDivListener(new Buttons.ButtonPower());
        view.addButttonNextListener(new Buttons.NextButton());
    }

    private void setarePolinoameIntrare() {
        if(view.getPolinom1().equals("") && view.getPolinom2().equals("")) {
            model.setValid(false);
        }
        else
            if (view.getPolinom2().equals("")) {
                model.setPolinom1(view.getPolinom1());
            } else {
                model.setPolinom1(view.getPolinom1());
                if(model.isValid()) {
                    model.setPolinom2(view.getPolinom2());
                }
            }
        //model.test();
    }

    class InmultireButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(model.isValid()) {
                model.inmultire();
                view.setRezultat(model.getRezultat());
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    class ImpartireButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(model.isValid()) {
                model.impartire();
                view.setRezultat("Cat: " + model.getRezultat() + "  Rest: " + model.getPolinom1());
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    class AdunareButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(model.isValid()) {
                model.adunare();
                view.setRezultat(model.getRezultat());
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    class ScadereButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(model.isValid()) {
                model.scadere();
                view.setRezultat(model.getRezultat());
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    class DerivareButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(!view.getPolinom1().equals("")&& model.isValid()) {
                model.derivare();
                view.setRezultat(model.getRezultat());
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    class IntegrareButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setarePolinoameIntrare();
            if(!view.getPolinom1().equals("")&& model.isValid()) {
                model.integrare();
                view.setRezultat(model.getRezultat()+"+C");
            }
            else {
                model.setValid(true);
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }
}
