package com.dummy.myerp.testbusiness.business;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


class ComptabiliteManagerImplintegrationTest extends BusinessTestCase {

    private ComptabiliteManager manager;


    @Test
    public void testgetLigneEcritureComptable(){
        manager = getBusinessProxy().getComptabiliteManager();
        List<EcritureComptable> ligneEcritureComptables = manager.getListEcritureComptable();
        int nbLigneEcritureComptables = ligneEcritureComptables.size();
        Assert.assertEquals(5, nbLigneEcritureComptables);
    }



}