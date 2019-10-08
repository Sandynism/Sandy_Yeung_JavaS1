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
public class InvoiceItemRepositoryTest {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    private Invoice invoice;
    private InvoiceItem invoiceItem;
    private InvoiceItem invoiceItem1;

    @Before
    public void setUp() throws Exception {
        invoiceItemRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    @Test
    @Transactional
    public void shouldAddAndGetInvoiceItemFromDatabase() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoiceRepository.save(invoice);

        invoiceItem = new InvoiceItem();

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemName("Tshirt");
        invoiceItem.setItemDescription("Soft");
        invoiceItem.setWeight(1);
        invoiceItem.setShipCost(new BigDecimal("3.99"));

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        InvoiceItem fromRepo = invoiceItemRepository.findById(invoiceItem.getInvoiceItemId()).get();

        assertEquals(invoiceItem, fromRepo);
    }

    @Test
    @Transactional
    public void shouldUpdateInvoiceItemFromDatabase() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoiceRepository.save(invoice);

        invoiceItem = new InvoiceItem();

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemName("Tshirt");
        invoiceItem.setItemDescription("Soft");
        invoiceItem.setWeight(1);
        invoiceItem.setShipCost(new BigDecimal("3.99"));
        invoiceItem.setInvoice(invoice);

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        invoiceItem.setItemDescription("Soft and white");

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        InvoiceItem fromRepo = invoiceItemRepository.findById(invoiceItem.getInvoiceItemId()).get();

        assertEquals(invoiceItem, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteInvoiceItemFromDatabase() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoiceRepository.save(invoice);

        invoiceItem = new InvoiceItem();

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemName("Tshirt");
        invoiceItem.setItemDescription("Soft");
        invoiceItem.setWeight(1);
        invoiceItem.setShipCost(new BigDecimal("3.99"));
        invoiceItem.setInvoice(invoice);

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        invoiceItemRepository.deleteById(invoiceItem.getInvoiceItemId());

        Optional<InvoiceItem> fromRepo = invoiceItemRepository.findById(invoiceItem.getInvoiceItemId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void getAllInvoiceItems() {
        invoice = new Invoice();

        invoice.setCustomerId(1);
        invoice.setShipToZip("11001");
        invoice.setPurchaseDate(LocalDate.of(2012, 12, 12));
        invoice.setTotalCost(new BigDecimal("100.00"));
        invoice.setSalesTax(new BigDecimal("0.08"));
        invoice.setSurcharge(new BigDecimal("101.00"));

        invoiceRepository.save(invoice);

        invoiceItem = new InvoiceItem();

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemName("Tshirt");
        invoiceItem.setItemDescription("Soft");
        invoiceItem.setWeight(1);
        invoiceItem.setShipCost(new BigDecimal("3.99"));
        invoiceItem.setInvoice(invoice);

        invoiceItem = invoiceItemRepository.save(invoiceItem);

        invoiceItem1 = new InvoiceItem();

        invoiceItem1.setInvoiceId(invoice.getInvoiceId());
        invoiceItem1.setItemName("Tshirt");
        invoiceItem1.setItemDescription("Soft");
        invoiceItem1.setWeight(1);
        invoiceItem1.setShipCost(new BigDecimal("3.99"));
        invoiceItem.setInvoice(invoice);

        invoiceItem1 = invoiceItemRepository.save(invoiceItem1);

        List<InvoiceItem> invoiceItemList = invoiceItemRepository.findAll();

        assertEquals(2, invoiceItemList.size());
    }
}