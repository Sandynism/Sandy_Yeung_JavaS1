package com.trilogyed.invoiceservice.repository;

import com.trilogyed.invoiceservice.model.Invoice;
import com.trilogyed.invoiceservice.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    private Invoice invoice;
    private Invoice invoice1;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();
    }

    @Test
    @Transactional
    public void shouldAddAndGetInvoiceFromDatabase() {

        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoice = invoiceRepository.save(invoice);

        Invoice fromRepo = invoiceRepository.findById(invoice.getInvoiceId()).get();

        assertEquals(invoice, fromRepo);
    }

    @Test
    @Transactional
    public void shouldUpdateInvoiceInDatabase() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoiceRepository.save(invoice);

        invoice.setShipToZip("11111");

        invoice = invoiceRepository.save(invoice);

        Invoice fromRepo = invoiceRepository.findById(invoice.getInvoiceId()).get();

        assertEquals(invoice, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteInvoiceFromDatabase() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoice = invoiceRepository.save(invoice);

        invoiceRepository.deleteById(invoice.getInvoiceId());

        Optional<Invoice> fromRepo = invoiceRepository.findById(invoice.getInvoiceId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void getAllInvoices() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoice1 = new Invoice();

        invoice1.setCustomerId(2);
        invoice1.setShipToZip("11002");
        invoice1.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice1.setTotalCost(new BigDecimal("101.00"));
        invoice1.setSalesTax(new BigDecimal("0.08"));
        invoice1.setSurcharge(new BigDecimal("103.00"));

        invoiceRepository.save(invoice);
        invoiceRepository.save(invoice1);

        List<Invoice> invoiceList = invoiceRepository.findAll();

        assertEquals(2, invoiceList.size());
    }
}