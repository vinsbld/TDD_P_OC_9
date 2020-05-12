package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JournalComptableTest {

    private List<JournalComptable> journalComptables;

    @Before
    public void initJournalComptable(){
        journalComptables = new ArrayList<JournalComptable>();
        journalComptables.add(new JournalComptable("ACH","Achat"));

    }

    @Test
    public void getByCode_whenJournalComptableExist(){
        assertThat(JournalComptable.getByCode(journalComptables,"ACH").getLibelle()).isEqualTo("Achat");
    }

    @Test
    public void getByCode_whenJournalComptableNotExist(){
        assertThat(JournalComptable.getByCode(journalComptables, "AC")).isEqualTo(null);
    }
}
