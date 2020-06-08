package com.dummy.myerp.testbusiness.business;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bootstrapContext.xml"})
public class ComptabiliteManagerImplintegrationTest extends BusinessTestCase{


    private ComptabiliteManagerImpl manager;


   @Test
    public void testgetLigneEcritureComptable(){
        manager = new ComptabiliteManagerImpl();
        assertThat(manager.getListEcritureComptable().size()).isEqualTo(5);
    }

}