package com.dummy.myerp.model.bean.comptabilite;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EcritureComptableTest {

    private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
        BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
        BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
        String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
                                     .subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
        LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
                                                                    vLibelle,
                                                                    vDebit, vCredit);
        return vRetour;
    }

    private EcritureComptable vEcriture;

    @Before
    public void initEcritureComptable(){
        vEcriture = new EcritureComptable();

        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "40", "7"));

    }

    @Test
    public void isEquilibree() {

        assertThat(vEcriture.isEquilibree()).isEqualTo(true);
    }

    @Test
    public void isNotEquilibree() {

        vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, null, "30"));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "1", "2"));

        assertThat(vEcriture.isEquilibree()).isEqualTo(false);
        }

        @Test
        public void getTotalDebit_test(){
        BigDecimal totalDebit = vEcriture.getTotalDebit();
            Assert.assertEquals(new BigDecimal("341.00"),vEcriture.getTotalDebit());
            Assert.assertNotEquals(new BigDecimal("341.0"),vEcriture.getTotalDebit());
            Assert.assertNotEquals(new BigDecimal("341"),vEcriture.getTotalDebit());

        }

        @Test
        public void getTotalCredit_test(){
        BigDecimal totalCredit = vEcriture.getTotalCredit();
        assertThat(totalCredit.doubleValue()).isEqualTo(341.00);
        }

}
