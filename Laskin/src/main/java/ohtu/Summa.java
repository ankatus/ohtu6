package ohtu;

import javax.swing.*;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int luku;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        try {
            luku = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            return;
        }
        sovellus.plus(luku);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(luku);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
}
