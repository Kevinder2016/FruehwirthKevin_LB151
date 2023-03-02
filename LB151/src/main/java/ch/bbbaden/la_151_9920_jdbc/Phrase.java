package ch.bbbaden.la_151_9920_jdbc;

import java.math.BigDecimal;
import java.util.Date;

public class Phrase {
    private long id;
    private String spielername;
    private BigDecimal betrag;
    private int spielrunden;
    private Date datum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpielername() {
        return spielername;
    }

    public void setSpielername(String spielername) {
        this.spielername = spielername;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public int getSpielrunden() {
        return spielrunden;
    }

    public void setSpielrunden(int spielrunden) {
        this.spielrunden = spielrunden;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
