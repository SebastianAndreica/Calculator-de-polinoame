import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model{
    public static class Monom implements Comparable {
        private double coeficient;
        private int exponent;

        public Monom( Double coeficient, int exponent ) {
            this.coeficient = coeficient;
            this.exponent = exponent;
        }

        public Monom( Monom m ) {
            this.coeficient = m.coeficient;
            this.exponent = m.exponent;
        }

        public double getCoeficient( ) {
            return coeficient;
        }

        public void setCoeficient( double coeficient ) {
            this.coeficient = coeficient;
        }

        public int getExponent( ) {
            return exponent;
        }

        public void setExponent( int exponent ) {
            this.exponent = exponent;
        }

        @Override
        public int compareTo( Object o ) {
            if(exponent > ((Monom)o).exponent){ return -1;}
            else
                if(exponent < ((Monom)o).exponent){ return 1;}
                else { return 0;}
        }
    }

    class Polinom {
        private List<Monom> polinom;
        private int grad;

        public Polinom( List<Monom> polinom ) {
            this.polinom = polinom;
            this.grad = 0;
        }

        private Monom convert(String monom) {
            int coeff = 0, exp = 0;
            String patternString = "([+\\-]\\d*)|([1-9]{1}[0-9]*)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(monom);
            while(matcher.find()) {
                if(matcher.group(1) != null) {
                    String sir = matcher.group(1);
                    if(sir.length() == 1 && (sir.charAt(0) == '-' || sir.charAt(0) == '+')) {
                        sir += "1";
                    }
                    coeff = Integer.parseInt(sir);
                }
                if(matcher.group(2) != null) {
                    String sir = matcher.group(2);
                    exp = Integer.parseInt(sir);
                    grad = Math.max(grad, exp);
                }
            }
            if(monom.charAt(monom.length()-1) == 'X') {
                exp = 1;
                grad = Math.max(grad, exp);
            }
            return new Monom((double) coeff, exp);
        }

        public Polinom( String p ) {
            valid = true;
            polinom = new ArrayList<>();
            p = p.charAt(0) == '+' || p.charAt(0) == '-' ? p : "+" + p;
            int pDimension = p.length();
            String patternString = "([+\\-\\s][1-9]{0,1}\\d*[X]{1}[\\^]{1}[1-9]{1}\\d*)|([+\\-\\s]\\d*[X])|([+\\-\\s]\\d*)";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(p);
            int nrCaractere = 0;
            while(matcher.find()) {
                String grup = matcher.group();
                Monom m = convert(grup);
                polinom.add(m);
                nrCaractere += grup.length();
            }
            if( nrCaractere != pDimension ) {
                valid = false;
            }
        }

        public Polinom( Polinom p ) {
            polinom = new ArrayList<>();
            polinom.addAll(p.polinom);
            this.grad = p.grad;
        }

        @Override
        public String toString( ) {
            StringBuilder output = new StringBuilder();
            for (Monom m:
                 polinom) {
                if(m.coeficient != 0 ) {
                    if(Math.abs(m.coeficient) == 1){
                        output.append(m.exponent == grad ? (m.coeficient < 0 ? "-" : "") : (m.coeficient < 0 ? "-" : "+")).append(m.exponent == 0 ? "1" : "");
                    }
                    else{
                        output.append(m.exponent == grad ? "" : (m.coeficient < 0 ? "" : "+")).append(m.coeficient == (int) m.coeficient ? Integer.toString((int) m.coeficient) : Double.toString(m.coeficient));
                    }
                    if (m.exponent > 0) {
                        output.append("X").append(m.exponent != 1 ? "^" + m.exponent : "");
                    }
                }
                else
                    if(m.exponent == 0 ) { output.append("0");}
            }
            return output.toString();
        }
    }

    private boolean valid = true;
    private Polinom polinom1;
    private Polinom polinom2;
    private Polinom rezultat;
    private Operations operatii;

    public Model() {
        clean();
    }

    private void clean() {
        polinom1 = new Polinom(new ArrayList<>());
        polinom2 = new Polinom(new ArrayList<>());
        rezultat = new Polinom(new ArrayList<>());
        operatii = new Operations();
    }

    public void setPolinom1( String polinom1 ) { this.polinom1 = new Polinom(polinom1);}

    public boolean isValid( ) { return valid;}

    public void setValid( boolean valid ) { this.valid = valid;}

    public String getPolinom1( ) { return (polinom1.toString().equals("") ? "0" : polinom1.toString());}

    public void setPolinom2( String polinom2 ) {
        this.polinom2 = new Polinom(polinom2);
    }

    public String getRezultat() {
        return (rezultat.toString().equals("") ? "0" : rezultat.toString());
    }

    private void setGradRezultat (){
        assert rezultat != null;
        if(rezultat.polinom.size() == 0 ) {
            rezultat.grad = 0;
        }
        else {
            rezultat.grad = rezultat.polinom.get(0).exponent;
        }
    }

    public void adunare() {
        rezultat.polinom = operatii.adunare1scadere2(polinom1.polinom, polinom2.polinom, 1);
        setGradRezultat();
    }

    public void scadere() {
        rezultat.polinom = operatii.adunare1scadere2(polinom1.polinom, polinom2.polinom, 2);
        setGradRezultat();
    }

    public void derivare() {
        rezultat.polinom = operatii.derivare(polinom1.polinom);
        setGradRezultat();
    }

    public void integrare() {
        rezultat.polinom = operatii.integrare(polinom1.polinom);
        setGradRezultat();
    }

    public void inmultire() {
        rezultat.polinom = operatii.inmultire(polinom1.polinom, polinom2.polinom);
        setGradRezultat();
    }

    public void impartire() {
        if (polinom1.grad < polinom2.grad) {
            valid = false;
            JOptionPane.showMessageDialog(null, "Gradul primului polinom trebuie sa fie mai mare decat al celui de-al doilea!!!");
        } else
        if(polinom2.polinom.get(0).coeficient == 0) {
            valid = false;
            JOptionPane.showMessageDialog(null, "Nu se poate face impartire la 0!!!");
        }
        else {
            Polinom cat = new Polinom(new ArrayList<>());
            Monom monomImpartitor = polinom2.polinom.get(0);

            if(polinom1.grad != 0 && (polinom2.grad != 0 && polinom1.polinom.size() > 1)) {
                while (polinom1.grad >= polinom2.grad) {
                    Monom monomDeimpartit = new Monom(polinom1.polinom.get(0));
                    monomDeimpartit.coeficient /= monomImpartitor.coeficient;
                    monomDeimpartit.exponent -= monomImpartitor.exponent;
                    cat.polinom.add(monomDeimpartit);
                    cat.grad = Math.max(cat.grad, monomDeimpartit.exponent);
                    Polinom auxiliar = new Polinom(operatii.inmultireCuMonom(polinom2.polinom, monomDeimpartit));
                    Polinom aux1 = new Polinom(operatii.inmultireCuMinus(auxiliar.polinom));
                    polinom1.polinom = operatii.adunare1scadere2(polinom1.polinom, aux1.polinom, 1);
                    if(polinom1.polinom.size() == 0 ) {
                        polinom1.grad = 0;
                    }
                    else {
                        polinom1.grad = polinom1.polinom.get(0).exponent;
                    }
                }
                setGradRezultat();
                rezultat = cat;
            }
            else {
                rezultat.polinom.add(new Monom(polinom1.polinom.get(0).coeficient/polinom2.polinom.get(0).coeficient, polinom1.grad- polinom2.grad));
                rezultat.grad = polinom1.grad- polinom2.grad;
                polinom1.polinom.clear();
            }
        }
    }
}
