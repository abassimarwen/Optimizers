package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ProduitServiceImplTest {
    @Autowired
    IProduitService produitService;
    @Test
    public void testAddProduit() throws ParseException {
        Produit p = new Produit(1L,"test");

    }

}