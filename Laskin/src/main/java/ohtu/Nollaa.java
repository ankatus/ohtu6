package ohtu;

import javax.swing.*;

public class Nollaa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int tulos;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        tulos = sovellus.tulos();
        sovellus.plus(-1*tulos);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.plus(tulos);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
}
