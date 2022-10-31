package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class ProduitServiceImplTest {
    @Autowired
    IProduitService produitService;
    @Test
    @Order(1)
    public void testAddProduit()  {
        Produit produitToAddTest = new Produit("addtest","libelleTest", (float) 2.2);
        log.debug("test add produit: "+produitToAddTest);
        produitService.addProduit(produitToAddTest);
        assertNotNull(produitService.retrieveProduit(produitToAddTest.getIdProduit()));
        assertEquals(produitToAddTest.getCodeProduit(),produitService.retrieveProduit(produitToAddTest.getIdProduit()).getCodeProduit());
        assertEquals(produitToAddTest.getLibelleProduit(),produitService.retrieveProduit(produitToAddTest.getIdProduit()).getLibelleProduit());
        assertEquals(produitToAddTest.getPrix(),produitService.retrieveProduit(produitToAddTest.getIdProduit()).getPrix());
        produitService.deleteProduit(produitToAddTest.getIdProduit());
    }
    @Test
    @Order(2)
    public void retreiveAllProduitTest(){
        Produit p1 = new Produit("retrieveAlltest1","libelleTest", (float) 2.2);
        Produit p2 = new Produit("retrieveAlltest2","libelleTest", (float) 2.2);
        Produit p3 = new Produit("retrieveAlltest3","libelleTest", (float) 2.2);
        produitService.addProduit(p1);
        produitService.addProduit(p2);
        produitService.addProduit(p3);
        assertTrue(produitService.retrieveAllProduits().size()>1);
        assertEquals(3,produitService.retrieveAllProduits().size());
        produitService.deleteProduit(p1.getIdProduit());
        produitService.deleteProduit(p2.getIdProduit());
        produitService.deleteProduit(p3.getIdProduit());

    }
    @Test
    @Order(3)
    public void testDeleteProduit(){
        Produit produitToDeleteTest = new Produit("deleteTest","liblee",(float) 1.1);
        produitService.addProduit(produitToDeleteTest);
        produitService.deleteProduit(produitToDeleteTest.getIdProduit());
        assertNull(produitService.retrieveProduit(produitToDeleteTest.getIdProduit()));
    }
    @Test
    @Order(4)
    public void testUpdateProduit(){
        Produit produitToUpdateTest = new Produit("beforeUpdateTest","liblee",(float) 1.1);
        produitService.addProduit(produitToUpdateTest);
        assertEquals(produitToUpdateTest.getCodeProduit(),produitService.retrieveProduit(produitToUpdateTest.getIdProduit()).getCodeProduit());
        produitToUpdateTest.setCodeProduit("updateTest");
        produitService.updateProduit(produitToUpdateTest);
        assertEquals(produitToUpdateTest.getCodeProduit(),produitService.retrieveProduit(produitToUpdateTest.getIdProduit()).getCodeProduit());
        produitService.deleteProduit(produitToUpdateTest.getIdProduit());
    }
    @Test
    @Order(5)
    public void assignProduitToStock(){

    }

}