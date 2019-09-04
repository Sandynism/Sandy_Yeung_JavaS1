package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoicesList = invoiceDao.getAllInvoices();
        for(Invoice i : invoicesList) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("149.95"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("158.94"));

        invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Kenny Hom");
        invoice.setStreet("97th Pl");
        invoice.setCity("Corona");
        invoice.setState("NY");
        invoice.setZipcode("11368");
        invoice.setItemType("Consoles");
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(1);
        invoice.setSubtotal(new BigDecimal("299.99"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("329.98"));

        invoiceDao.addInvoice(invoice);

        List<Invoice> invoicesList = invoiceDao.getAllInvoices();
        assertEquals(invoicesList.size(), 2);
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("149.95"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("158.94"));

        invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice, invoice1);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice1);
    }


    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("149.95"));
        invoice.setTax(new BigDecimal("0.05"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("158.94"));

        invoiceDao.addInvoice(invoice);

        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("59.98"));
        invoice.setTotal(new BigDecimal("64.47"));

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice, invoice1);
    }
}

//    invoice_id int(11) not null auto_increment primary key,
//    name varchar(80) not null,
//    street varchar(30) not null,
//    city varchar(30) not null,
//    state varchar(30) not null,
//    zipcode varchar(5) not null,
//    item_type varchar(20) not null,
//    item_id int(11) not null,
//    unit_price decimal(5,2) not null,
//    quantity int(11) not null,
//    subtotal decimal(5,2) not null,
//    tax decimal(5,2) not null,
//    processing_fee decimal (5,2) not null,
//    total decimal(5,2) not null