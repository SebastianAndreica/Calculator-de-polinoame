import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {
    private static View view;

    public Buttons( View view ) {
        Buttons.view = view;
    }

    static class Button1 implements ActionListener {
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "1");
        }
    }

    static class NextButton implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setPolinomCurent(view.getPolinomCurent() == 1 ? 2 : 1);
        }
    }

    static class Button2 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "2");
        }
    }

    static class Button3 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "3");
        }
    }

    static class Button4 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "4");
        }
    }

    static class Button5 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "5");
        }
    }

    static class Button6 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "6");
        }
    }

    static class Button7 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "7");
        }
    }

    static class Button8 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "8");
        }
    }

    static class Button9 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "9");
        }
    }

    static class Button0 implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "0");
        }
    }

    static class ButtonPlus implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "+");
        }
    }

    static class ButtonPower implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) { view.setUserFocus(view.getUserFocus() + "^"); }
    }

    static class ButtonMinus implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "-");
        }
    }

    static class ButtonStea implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "*");
        }
    }

    static class ButtonDel implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus("");
        }
    }

    static class ButtonBack implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            String sir = view.getUserFocus();
            if(! sir.equals("")) {
                sir = sir.substring(0, sir.length() - 1);
            }
            view.setUserFocus(sir);
        }
    }

    static class ButtonX implements ActionListener{
        @Override
        public void actionPerformed( ActionEvent e ) {
            view.setUserFocus(view.getUserFocus() + "X");
        }
    }
}
