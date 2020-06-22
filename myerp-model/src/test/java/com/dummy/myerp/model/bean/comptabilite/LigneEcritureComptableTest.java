package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class LigneEcritureComptableTest {

    @Test
    public void testSetGetLigneEcritureComptable(){
        LigneEcritureComptable vLigneEcritureComptable = new LigneEcritureComptable();
        CompteComptable vCompteComptable = new CompteComptable();

        vLigneEcritureComptable.setLibelle("test_Libelle");
        assertThat(vLigneEcritureComptable.getLibelle()).isNotEqualTo("other");
        assertThat(vLigneEcritureComptable.getLibelle()).isEqualTo("test_Libelle");

        vLigneEcritureComptable.setDebit(new BigDecimal("124"));
        assertThat(vLigneEcritureComptable.getDebit()).isEqualTo("124");
        assertThat(vLigneEcritureComptable.getDebit()).isNotEqualTo("125");

        vLigneEcritureComptable.setCredit(new BigDecimal("124"));
        assertThat(vLigneEcritureComptable.getCredit()).isEqualTo("124");
        assertThat(vLigneEcritureComptable.getCredit()).isNotEqualTo("126");

        vLigneEcritureComptable.setCompteComptable(vCompteComptable);
        assertThat(vLigneEcritureComptable.getCompteComptable()).isEqualTo(vCompteComptable);
    }

    @Test
    public void test_toString_line(){
        LigneEcritureComptable vLigneEcritureComptable = new LigneEcritureComptable(new CompteComptable(2,"test compte"),"test ligne",new BigDecimal("123"), new BigDecimal("123"));

        String testToString = "LigneEcritureComptable{compteComptable="+vLigneEcritureComptable.getCompteComptable()+", libelle='"+vLigneEcritureComptable.getLibelle()+"', "+"debit="+vLigneEcritureComptable.getDebit()+", "+"credit="+vLigneEcritureComptable.getCredit()+"}";
        String resultatTestToString = vLigneEcritureComptable.toString();
        assertThat(testToString).isEqualTo(resultatTestToString);
    }
}
