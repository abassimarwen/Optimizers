package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

    @Mock
    ProduitRepository produitRepository;
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl stockService;


    @Test
   public void getAllStock() {

        Stock s1 = new Stock("retrivestocktest1",10,100);
        Stock s2 = new Stock("retrivestocktest2",10,100);
        Stock s3 = new Stock("retrivestocktest3",10,100);

        List<Stock> stockList = new ArrayList<>();
        stockList.add(s1);
        stockList.add(s2);
        stockList.add(s3);
        when(stockRepository.findAll()).thenReturn(stockList);
        List<Stock> listToCheck = stockService.retrieveAllStocks();
        verify(stockRepository).findAll();
        assertNotNull(listToCheck);
        assertTrue(listToCheck.size() > 1);
        assertEquals(3, listToCheck.size());
        assertSame(stockList, listToCheck);
    }

    @Test
    public void testAddStock() {
        Stock stock = new Stock("addstocktest",10,100);
        when(stockRepository.save(ArgumentMatchers.any(Stock.class))).thenReturn(stock);
        Stock savedStock= stockService.addStock(stock);
        verify(stockRepository).save(stock);
        assertNotNull(savedStock.getLibelleStock());
        assertEquals(savedStock,stock);
        assertSame(savedStock,stock);

    }



    @Test
    public void testDeleteStock() {
        Stock stockToDeleteTest = new Stock("deletestocktest",30,60);
        doAnswer(s-> {
                    verify(stockRepository).deleteById(stockToDeleteTest.getIdStock());
                    assertSame(s, stockToDeleteTest);
                    return null;
        }).when(stockRepository).deleteById(ArgumentMatchers.anyLong());
        stockService.deleteStock(stockToDeleteTest.getIdStock());
    }

    @Test
    public void testgetStock() {
        Stock stockToRetriveTest = new Stock("gettocktest",30,60);
        Operateur operateurToRetreiveTest = new Operateur("nomOp", "prenomOp", "xxxx");
        when(stockRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(stockToRetriveTest));
        Stock retrieved =  stockService.retrieveStock(stockToRetriveTest.getIdStock());
        verify(stockRepository).findById(operateurToRetreiveTest.getIdOperateur());
    }
    @Test
    public void testUpdateStock() {
        Stock stock = new Stock("updatestocktest",30,60);
        when(stockRepository.save(ArgumentMatchers.any(Stock.class))).thenReturn(stock);
        Stock stocktToUpdate = stockService.updateStock(stock);
        verify(stockRepository).save(stock);
        assertNotNull(stocktToUpdate);
        assertEquals(stocktToUpdate, stock);
        assertSame(stocktToUpdate, stock);
    }

}
