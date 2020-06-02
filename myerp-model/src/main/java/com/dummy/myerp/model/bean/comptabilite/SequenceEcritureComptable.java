package com.dummy.myerp.model.bean.comptabilite;


/**
 * Bean représentant une séquence pour les références d'écriture comptable
 */
public class SequenceEcritureComptable {

    // ==================== Attributs ====================
    /** L'année */
    private Integer annee;
    /** La dernière valeur utilisée */
    private Integer derniereValeur;
    /** Le code du journal **/
    private JournalComptable journalComptable;

    // ==================== Constructeurs ====================
    /**
     * Constructeur
     */
    public SequenceEcritureComptable() {
    }

    public SequenceEcritureComptable(Integer annee, Integer derniereValeur, JournalComptable journalComptable) {
        this.annee = annee;
        this.derniereValeur = derniereValeur;
        this.journalComptable = journalComptable;
    }

    // ==================== Getters/Setters ====================
    public Integer getAnnee() {
        return annee;
    }
    public void setAnnee(Integer pAnnee) {
        annee = pAnnee;
    }
    public Integer getDerniereValeur() {
        return derniereValeur;
    }
    public void setDerniereValeur(Integer pDerniereValeur) {
        derniereValeur = pDerniereValeur;
    }

    public JournalComptable getJournalComptable() {
        return journalComptable;
    }

    public void setJournalComptable(String journalComptable) {
        this.journalComptable = journalComptable;
    }

    // ==================== Méthodes ====================
    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append("{")
            .append("annee=").append(annee)
            .append(vSEP).append("derniereValeur=").append(derniereValeur)
            .append("}");
        return vStB.toString();
    }
}
