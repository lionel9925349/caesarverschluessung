

package pis.hue1;
        import java.util.*;

/**
 * @author Noui lionel
 * @version 14.0.1
 */
public class Caesar implements Codec{

    private int verschiebung;
    private String losung;

    public Caesar(String losung) {
        this.losung = losung;
    }
    public Caesar() {
        this.losung ="THM";
    }

    /**
     * diese Methode erlaubt uns ein character zu kodieren
     * @param c ist der character der kodiert werden soll
     * @param x ist der Abstand .zb wenn man A kodiert moechte mit dem Abstand 5 dann A--F  usw
     * @return ist was man am Ende bekommt wenn man die kodiere diese Zeichen macht zb in og beispiel ist F
     */
    public static char KodiereEincharacter ( char c , int x) {
        if ( c >= (char) 65 && c <=(char) 90) {
            c  += x;

            while(c> (char) 90) {
                c-=26;
            }
        }
        else if ( c >= (char) 97 && c <=(char) 122) {

            c  += x;
        }
        while(c> (char) 122) {
            c-=26;
        }
        return c;
    }

    /**
     * diese Methode erlaubt uns ein String also ein klartext zu kodieren oder verschuesseln
     * @param klartext ist was man verschuelsseln moechte
     * @return ist das Ergebnis,das man erwartet wenn man der klartext kodiere
     */
    public String kodiere(String klartext) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i< klartext.length();i++) {

            sb.append(KodiereEincharacter(klartext.charAt(i),verschiebung));
        }


        return sb.toString();
    }

    public static char  DekodiereEinKarakter(char c , int x) {


        if ( c >= (char) 65 && c <=(char) 90) {
            c  -= x;

            while(c<(char) 65) {
                c+=26;
            }
        }
        else if ( c >= (char) 97 && c <=(char) 122) {
            c  -= x;

            while(c<(char) 97) {
                c+=26;
            }
        }
        return c;
    }

    /**
     * diese Methode erlaubt uns ein geheimtext zu dekodieren oder entschuesseln
     * @param geheimtext ist was man entschuesseln moechte
     * @return ist das Ergebnis dieser Methode und diese Ergebniss ist der klartext
     */
    public String dekodiere(String geheimtext) {


        StringBuilder sb = new StringBuilder();
        for (int i = 0;i< geheimtext.length();i++) {

            sb.append(DekodiereEinKarakter(geheimtext.charAt(i),verschiebung));
        }


        return sb.toString();
    }

    /**
     * giblosung gibt die losung aus
     * @return gibt das losung wort zuruck
     */
    @Override

    public String gibLosung() {

        return losung;
    }

    /**
     * setzeLosung
     * @param schluessel die losung wird gesetzt
     * @throws IllegalArgumentException bei ungeeignette schluessel die meldung wird geworfen
     */
    @Override

    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        verschiebung =schluessel.length();
        losung = schluessel;
        if(schluessel.contains("ä")||schluessel.contains("ö")||schluessel.contains("ß")||schluessel.contains("ü") )
            throw new IllegalArgumentException ("es darf kein sondern zeichen eingetragen werden bitte noch mal versuchen ");

        if(schluessel.isEmpty())
            throw new IllegalArgumentException ("der schluessel muss nicht leer sein.bitte gut eintragen");


    }
}
