package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class JournalComptableTest {

    private List<JournalComptable> journalComptables;

    @Before
    public void initJournalComptable(){
        journalComptables = new ArrayList<JournalComptable>();
        journalComptables.add(new JournalComptable("ACH","Achat"));

    }
}
