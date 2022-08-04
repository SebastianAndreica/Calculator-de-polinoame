import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Operations{
    public int indexMonom( List<Model.Monom> pol, int exponent ) {
        for (Model.Monom m :
                pol) {
            if (m.getExponent() == exponent)
                return pol.indexOf(m);
        }
        return - 1;
    }

    public List<Model.Monom> adunare1scadere2( List<Model.Monom> pol1, List<Model.Monom> pol2, int op ) { //operatie12 -> 1 adunare : 2 scadere
        List<Model.Monom> rez = new ArrayList<>(pol1);
        for (Model.Monom m :
                pol2) {
            int p;
            if ((p = indexMonom(rez, m.getExponent())) == - 1) {
                Model.Monom a = m;
                if(op == 2) {
                    a.setCoeficient(-a.getCoeficient());
                }
                rez.add(a);
            } else {
                Model.Monom a = rez.get(p);
                a.setCoeficient( op == 1 ? a.getCoeficient() + m.getCoeficient()
                        : a.getCoeficient() - m.getCoeficient());
                if (a.getCoeficient() == 0) {
                    rez.remove(p);
                } else {
                    rez.remove(p);
                    rez.add(p, a);
                }
            }
        }
        Collections.sort(rez);
        return rez;
    }

    public List<Model.Monom> derivare(List<Model.Monom> pol) {
        List<Model.Monom> rez = new ArrayList<>();
        for (Model.Monom m : pol) {
            if( m.getExponent() != 0 ) {
                int p = pol.indexOf(m);
                double coef = m.getCoeficient();
                int exp = m.getExponent();
                m.setCoeficient(coef*exp);
                m.setExponent(--exp);
                rez.add(m);
            }
        }
        return rez;
    }

    public List<Model.Monom> integrare(List<Model.Monom> pol) {
        List<Model.Monom> rez = new ArrayList<>();
        for (Model.Monom m : pol) {
            int p = pol.indexOf(m);
            double coef = m.getCoeficient();
            int exp = m.getExponent();
            m.setExponent(++exp);
            m.setCoeficient(coef/exp);
            rez.add(m);
        }
        return rez;
    }

    public List<Model.Monom> inmultireCuMonom( List<Model.Monom> p, Model.Monom m ) {
        List<Model.Monom> rez = new ArrayList<>();
        for (Model.Monom a:
                p) {
            double coefA = a.getCoeficient();
            int expA = a.getExponent();
            Model.Monom aux = new Model.Monom(a);
            aux.setExponent(expA+m.getExponent());
            aux.setCoeficient(coefA*m.getCoeficient());
            rez.add(aux);
        }
        return rez;
    }

    public List<Model.Monom> inmultire(List<Model.Monom> pol1, List<Model.Monom> pol2) {
        List<Model.Monom> rez = null;
        for (Model.Monom m :
                pol2) {
            if (rez != null) {
                List<Model.Monom> auxiliar = inmultireCuMonom(pol1, m);
                rez = adunare1scadere2(rez, auxiliar, 1);
            } else {
                rez = inmultireCuMonom(pol1, m);
            }
        }
        return rez;
    }

    public List<Model.Monom> inmultireCuMinus(List<Model.Monom> p) {
        List<Model.Monom> rez = new ArrayList<>();
        for (Model.Monom a:
                p) {
            double coefA = a.getCoeficient();
            Model.Monom aux = new Model.Monom(a);
            aux.setCoeficient(-coefA);
            rez.add(aux);
        }
        return rez;
    }
}
