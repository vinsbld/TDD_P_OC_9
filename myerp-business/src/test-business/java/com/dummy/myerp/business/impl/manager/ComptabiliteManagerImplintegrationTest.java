package com.dummy.myerp.business.impl.manager;

import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.consumer.dao.impl.DaoProxyImpl;
import com.dummy.myerp.consumer.dao.impl.db.dao.ComptabiliteDaoImpl;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;


class ComptabiliteManagerImplintegrationTest {

    private EcritureComptable vEcritureComptable;

    private JournalComptable journalComptable;

    private LigneEcritureComptable ligneEcritureComptableDebit;

    private LigneEcritureComptable ligneEcritureComptableCredit;

    private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();

    @Before
    public void initComptabliteMangerImpl(){

        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setId(1);
        journalComptable = new JournalComptable("AC", "Achat");
        vEcritureComptable.setJournal(journalComptable);
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setReference("AC-2020/00001");
        vEcritureComptable.setLibelle("Libelle");

        ligneEcritureComptableCredit = new LigneEcritureComptable(new CompteComptable(1),null, new BigDecimal(123),null);
        ligneEcritureComptableDebit = new LigneEcritureComptable(new CompteComptable(2), null, null, new BigDecimal(123));

    }



}