import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTest {

    @org.junit.jupiter.api.Test
    void adunareTest1( ) {
        Model m = new Model();
        m.setPolinom1("X^2+2");
        m.setPolinom2("X^2+1");
        m.adunare();
        assertEquals("2X^2+3", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void adunareTest2( ) {
        Model m = new Model();
        m.setPolinom1("X^2-3X-2");
        m.setPolinom2("2X^2+2");
        m.adunare();
        assertEquals("3X^2-3X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void adunareTest3( ) {
        Model m = new Model();
        m.setPolinom1("X^2-3X-2");
        m.setPolinom2("-X^2+3X+2");
        m.adunare();
        assertEquals("0", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void adunareTest4( ) {
        Model m = new Model();
        m.setPolinom1("-2");
        m.setPolinom2("0");
        m.adunare();
        assertEquals("-2", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void adunareTest5( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2-3X-2");
        m.setPolinom2("4X^4-X^2+3X+2");
        m.adunare();
        assertEquals("4X^4+2X^3-2X^2", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void scadereTest1( ) {
        Model m = new Model();
        m.setPolinom1("X^2+2");
        m.setPolinom2("X^2+1");
        m.scadere();
        assertEquals("1", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void scadereTest2( ) {
        Model m = new Model();
        m.setPolinom1("X^2-3X-2");
        m.setPolinom2("2X^2+2");
        m.scadere();
        assertEquals("-X^2-3X-4", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void scadereTest3( ) {
        Model m = new Model();
        m.setPolinom1("X^2-3X-2");
        m.setPolinom2("-X^2+3X+2");
        m.scadere();
        assertEquals("2X^2-6X-4", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void scadereTest4( ) {
        Model m = new Model();
        m.setPolinom1("-2");
        m.setPolinom2("0");
        m.scadere();
        assertEquals("-2", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void scadereTest5( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2-3X-2");
        m.setPolinom2("4X^4-X^2+3X+2");
        m.scadere();
        assertEquals("-4X^4+2X^3-6X-4", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void derivareTest1( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2-3X-2");
        m.derivare();
        assertEquals("6X^2-2X-3", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void derivareTest2( ) {
        Model m = new Model();
        m.setPolinom1("X");
        m.derivare();
        assertEquals("1", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void derivareTest3( ) {
        Model m = new Model();
        m.setPolinom1("-2");
        m.derivare();
        assertEquals("0", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void derivareTest4( ) {
        Model m = new Model();
        m.setPolinom1("3X-1");
        m.derivare();
        assertEquals("3", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void derivareTest5( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2");
        m.derivare();
        assertEquals("6X^2-2X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void integrareTest1( ) {
        Model m = new Model();
        m.setPolinom1("3X-1");
        m.integrare();
        assertEquals("1.5X^2-X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void integrareTest2( ) {
        Model m = new Model();
        m.setPolinom1("-4");
        m.integrare();
        assertEquals("-4X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void integrareTest3( ) {
        Model m = new Model();
        m.setPolinom1("3X^2-2X+1");
        m.integrare();
        assertEquals("X^3-X^2+X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void integrareTest4( ) {
        Model m = new Model();
        m.setPolinom1("X");
        m.integrare();
        assertEquals("0.5X^2", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void integrareTest5( ) {
        Model m = new Model();
        m.setPolinom1("3X");
        m.integrare();
        assertEquals("1.5X^2", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void inmultireTest1( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2-3X-2");
        m.setPolinom2("4X^4-X^2+3X+2");
        m.inmultire();
        assertEquals("8X^7-4X^6-14X^5-X^4+4X^3-9X^2-12X-4", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void inmultireTest2( ) {
        Model m = new Model();
        m.setPolinom1("-2");
        m.setPolinom2("2");
        m.inmultire();
        assertEquals("-4", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void inmultireTest3( ) {
        Model m = new Model();
        m.setPolinom1("2X");
        m.setPolinom2("4X^4");
        m.inmultire();
        assertEquals("8X^5", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void inmultireTest4( ) {
        Model m = new Model();
        m.setPolinom1("X");
        m.setPolinom2("1");
        m.inmultire();
        assertEquals("X", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void inmultireTest5( ) {
        Model m = new Model();
        m.setPolinom1("0");
        m.setPolinom2("4X^4-X^2+3X+2");
        m.inmultire();
        assertEquals("0", m.getRezultat());
    }

    @org.junit.jupiter.api.Test
    void impartireTest1( ) {
        Model m = new Model();
        m.setPolinom1("X");
        m.setPolinom2("1");
        m.impartire();
        assertEquals("X", m.getRezultat());
        assertEquals("0", m.getPolinom1());
    }

    @org.junit.jupiter.api.Test
    void impartireTest2( ) {
        Model m = new Model();
        m.setPolinom1("X^2-2X+1");
        m.setPolinom2("X-1");
        m.impartire();
        assertEquals("X-1", m.getRezultat());
        assertEquals("0", m.getPolinom1());
    }

    @org.junit.jupiter.api.Test
    void impartireTest3( ) {
        Model m = new Model();
        m.setPolinom1("X^2");
        m.setPolinom2("X");
        m.impartire();
        assertEquals("X", m.getRezultat());
        assertEquals("0", m.getPolinom1());
    }

    @org.junit.jupiter.api.Test
    void impartireTest4( ) {
        Model m = new Model();
        m.setPolinom1("X^2+X+2");
        m.setPolinom2("X+1");
        m.impartire();
        assertEquals("X", m.getRezultat());
        assertEquals("2", m.getPolinom1());
    }

    @org.junit.jupiter.api.Test
    void impartireTest5( ) {
        Model m = new Model();
        m.setPolinom1("2X^3-X^2-3X-2");
        m.setPolinom2("4X^2+3X+2");
        m.impartire();
        assertEquals("0.5X-0.625", m.getRezultat());
        assertEquals("-2.125X-0.75", m.getPolinom1());
    }
}