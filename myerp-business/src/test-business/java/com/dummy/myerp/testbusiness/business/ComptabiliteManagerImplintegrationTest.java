package com.dummy.myerp.testbusiness.business;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;

import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bootstrapContext.xml"})
public class ComptabiliteManagerImplintegrationTest extends BusinessTestCase{


    private ComptabiliteManagerImpl manager;
    private EcritureComptable vEcritureComptable;
    private LigneEcritureComptable ligneEcritureComptableDebit;
    private LigneEcritureComptable ligneEcritureComptableCredit;
    private JournalComptable journalComptable;

    @Before
    public void initComptabliteMangerImpl(){

        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setId(1);
        journalComptable = new JournalComptable("AC", "Achat");
        vEcritureComptable.setJournal(journalComptable);
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setReference("AC-2020/00001");
        vEcritureComptable.setLibelle("Libelle");

        ligneEcritureComptableCredit = new LigneEcritureComptable(new CompteComptable(411),null, new BigDecimal(123),null);
        ligneEcritureComptableDebit = new LigneEcritureComptable(new CompteComptable(411), null, null, new BigDecimal(123));

    }


   @Test
    public void test_GetLigneEcritureComptable(){
        manager = new ComptabiliteManagerImpl();
        assertThat(manager.getListEcritureComptable().size()).isEqualTo(5);
    }

    @Test
    public void test_InsertEcrtirueComptable() throws FunctionalException {
       manager = new ComptabiliteManagerImpl();
       vEcritureComptable.getListLigneEcriture().add(ligneEcritureComptableDebit);
       vEcritureComptable.getListLigneEcriture().add(ligneEcritureComptableCredit);
       manager.insertEcritureComptable(vEcritureComptable);

    }

}