package com.dummy.myerp.model.bean.comptabilite;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompteComptableTest {

    private List<CompteComptable> compteComptableList;

    @Before
    public void initCompteComptable(){
        compteComptableList = new ArrayList<CompteComptable>();
        compteComptableList.add(new CompteComptable(1234,"Compte courant 1"));
        compteComptableList.add(new CompteComptable(123456, "Compte courant 2"));

    }

    @Test
    public void getByNumero_whenCompteComptableExist(){
        assertThat(CompteComptable.getByNumero(compteComptableList, 1234).getLibelle()).isEqualTo("Compte courant 1");
    }

    @Test
    public void getByNumero_whenCompteComptableNotExist(){
        assertThat(CompteComptable.getByNumero(compteComptableList, 12)).isEqualTo(null);

    }
}
