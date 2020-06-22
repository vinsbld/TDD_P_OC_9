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
        journalComptables.add(new JournalComptable("AC","Achat"));

    }

    @Test
    public void getByCode_whenJournalComptableExist(){
        assertThat(JournalComptable.getByCode(journalComptables,"AC").getLibelle()).isEqualTo("Achat");
    }

    @Test
    public void getByCode_whenJournalComptableNotExist(){
        assertThat(JournalComptable.getByCode(journalComptables, "AS")).isEqualTo(null);
    }

    @Test
    public void testSetJournalComptable(){
        JournalComptable pJournalComptable = new JournalComptable();
        pJournalComptable.setCode("AC");
        pJournalComptable.setLibelle("Achat");
        assertThat(pJournalComptable.getCode()).isEqualTo("AC");
        assertThat(pJournalComptable.getCode()).isNotEqualTo("BC");
        assertThat(pJournalComptable.getLibelle()).isEqualTo("Achat");
        assertThat(pJournalComptable.getLibelle()).isNotEqualTo("Other");
    }
    @Test
    public void test_toString_JournalComptable(){
        JournalComptable vJournalComptable = new JournalComptable("AC","test Compte Comptable");
        String toStringTest = "JournalComptable{code='"+vJournalComptable.getCode()
                +"', "+"libelle='"+vJournalComptable.getLibelle()+"'}";
        String resultatTestToString = vJournalComptable.toString();
        assertThat(toStringTest).isEqualTo(resultatTestToString);
    }
}
