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
        public void getTotalDebit_test_Is_Equals_To_The_Sum_Of_TotalDebit(){
            vEcriture.getListLigneEcriture().clear();
            vEcriture.getListLigneEcriture().add(createLigne(1,"100.00",null));
            vEcriture.getListLigneEcriture().add(createLigne(1,"50","30"));
            vEcriture.getListLigneEcriture().add(createLigne(1,"25.5","29.00"));
            vEcriture.getListLigneEcriture().add(createLigne(1,"-40","89.8"));

            Assert.assertEquals(vEcriture.getTotalDebit(), BigDecimal.valueOf(100+50+25.5+(-40)).setScale(2, BigDecimal.ROUND_HALF_UP));

        }

        @Test
        public void getTotalCredit_test_Is_Equals_To_The_Sum_Of_TotalCredit(){
            vEcriture.getListLigneEcriture().clear();
            vEcriture.getListLigneEcriture().add(createLigne(1,"100.00",null));
            vEcriture.getListLigneEcriture().add(createLigne(1,"50","30"));
            vEcriture.getListLigneEcriture().add(createLigne(1,"25","-29.00"));
            vEcriture.getListLigneEcriture().add(createLigne(1,"40","89.8"));

            Assert.assertEquals(vEcriture.getTotalCredit(), BigDecimal.valueOf(30+(-29.00)+89.8).setScale(2, BigDecimal.ROUND_HALF_UP));
        }



}
