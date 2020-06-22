package com.dummy.myerp.model.bean.comptabilite;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class SequenceEcritureComptableTest {

    private int annee = 2020;
    private int dernereValeur = 20;
    private JournalComptable vJournalComptable;

    @Test
    public void test_ConstructorSequenceEcritureComptable(){
        vJournalComptable = new JournalComptable();
        SequenceEcritureComptable vSequenceEcritureComptable = new SequenceEcritureComptable(annee, dernereValeur, vJournalComptable);
        assertThat(vSequenceEcritureComptable.getAnnee()).isEqualTo(annee);
        assertThat(vSequenceEcritureComptable.getDerniereValeur()).isEqualTo(dernereValeur);
        assertThat(vSequenceEcritureComptable.getJournalComptable()).isEqualTo(vJournalComptable);
    }

    @Test
    public void test_GetSet_SequenceEcritureComptable(){
        vJournalComptable = new JournalComptable();
        SequenceEcritureComptable pSequenceEcritureComptable = new SequenceEcritureComptable();

        pSequenceEcritureComptable.setJournalComptable(vJournalComptable);
        assertThat(pSequenceEcritureComptable.getJournalComptable()).isEqualTo(vJournalComptable);

        pSequenceEcritureComptable.setAnnee(2020);
        assertThat(pSequenceEcritureComptable.getAnnee()).isNotEqualTo(2016);
        assertThat(pSequenceEcritureComptable.getAnnee()).isEqualTo(2020);

        pSequenceEcritureComptable.setDerniereValeur(24);
        assertThat(pSequenceEcritureComptable.getDerniereValeur()).isNotEqualTo(90);
        assertThat(pSequenceEcritureComptable.getDerniereValeur()).isEqualTo(24);
    }

    @Test
    public void test_toString_Sequence(){
        SequenceEcritureComptable vSequenceEcritureComptable = new SequenceEcritureComptable(2020, 24, vJournalComptable);
        String testToString = "SequenceEcritureComptable{annee="+vSequenceEcritureComptable.getAnnee()
                +", "+"derniereValeur="+vSequenceEcritureComptable.getDerniereValeur()
                +", "+"journal comptable="+vSequenceEcritureComptable.getJournalComptable()+"}";
        String resultatTestToString = vSequenceEcritureComptable.toString();
        assertThat(testToString).isEqualTo(resultatTestToString);
    }
}
