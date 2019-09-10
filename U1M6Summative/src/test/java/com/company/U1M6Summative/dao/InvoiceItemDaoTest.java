package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {
    @Autowired
    protected InvoiceItemDao invoiceItemDao;
    @Autowired
    protected ItemDao itemDao;
    @Autowired
    protected InvoiceDao invoiceDao;
    @Autowired
    protected CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        invoiceItemList.stream().forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        List<Item> itemList = itemDao.getAllItems();
        itemList.stream().forEach(item -> itemDao.deleteItem(item.getItemId()));

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream().forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream().forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));
    }


    @Test
    public void addGetDeleteInvoiceItem() {
        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Plumber");
        customer.setEmail("Mario@nintendo.com");
        customer.setCompany("Super Mario Bros");
        customer.setPhone("212-567-1234");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 11, 22));
        invoice.setPickupDate(LocalDate.of(2019, 11, 23));
        invoice.setReturnDate(LocalDate.of(2019, 11, 26));
        invoice.setLateFee(new BigDecimal("1.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.");
        item.setDailyRate(new BigDecimal("2.99"));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("10.01"));
        invoiceItem.setDiscount(new BigDecimal("0.25"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem2 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());
        assertEquals(invoiceItem, invoiceItem2);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());
        invoiceItem2 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem2);
    }


    @Test
    public void getAllInvoiceItems() {
        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Plumber");
        customer.setEmail("Mario@nintendo.com");
        customer.setCompany("Super Mario Bros");
        customer.setPhone("212-567-1234");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 11, 22));
        invoice.setPickupDate(LocalDate.of(2019, 11, 23));
        invoice.setReturnDate(LocalDate.of(2019, 11, 26));
        invoice.setLateFee(new BigDecimal("1.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.");
        item.setDailyRate(new BigDecimal("2.99"));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("10.01"));
        invoiceItem.setDiscount(new BigDecimal("0.25"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(12);
        invoiceItem.setUnitRate(new BigDecimal("11.03"));
        invoiceItem.setDiscount(new BigDecimal("0.35"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        assertEquals(invoiceItemList.size(), 2);
    }


    @Test
    public void updateInvoiceItem() {
        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Plumber");
        customer.setEmail("Mario@nintendo.com");
        customer.setCompany("Super Mario Bros");
        customer.setPhone("212-567-1234");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 11, 22));
        invoice.setPickupDate(LocalDate.of(2019, 11, 23));
        invoice.setReturnDate(LocalDate.of(2019, 11, 26));
        invoice.setLateFee(new BigDecimal("1.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.");
        item.setDailyRate(new BigDecimal("2.99"));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("10.01"));
        invoiceItem.setDiscount(new BigDecimal("0.25"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setQuantity(12);
        invoiceItem.setUnitRate(new BigDecimal("11.03"));
        invoiceItem.setDiscount(new BigDecimal("0.35"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        InvoiceItem invoiceItem2 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());
        assertEquals(invoiceItem, invoiceItem2);
    }

    @Test
    public void getInvoiceItemByInvoiceId() {

        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Plumber");
        customer.setEmail("Mario@nintendo.com");
        customer.setCompany("Super Mario Bros");
        customer.setPhone("212-567-1234");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 11, 22));
        invoice.setPickupDate(LocalDate.of(2019, 11, 23));
        invoice.setReturnDate(LocalDate.of(2019, 11, 26));
        invoice.setLateFee(new BigDecimal("1.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.");
        item.setDailyRate(new BigDecimal("2.99"));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("10.01"));
        invoiceItem.setDiscount(new BigDecimal("0.25"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(12);
        invoiceItem.setUnitRate(new BigDecimal("11.03"));
        invoiceItem.setDiscount(new BigDecimal("0.35"));
        invoiceItemDao.addInvoiceItem(invoiceItem);



        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(customer.getCustomerId());
        invoice2.setOrderDate(LocalDate.of(2019, 03, 31));
        invoice2.setPickupDate(LocalDate.of(2019, 04, 01));
        invoice2.setReturnDate(LocalDate.of(2019, 04, 03));
        invoice2.setLateFee(new BigDecimal("1.99"));
        invoice2 = invoiceDao.addInvoice(invoice);

        Item item2 = new Item();
        item2.setName("The Proposal");
        item2.setDescription("Faced with deportation to her native Canada, high-powered book editor Margaret Tate says she's engaged to marry Andrew Paxton, her hapless assistant.");
        item2.setDailyRate(new BigDecimal("2.99"));
        item2 = itemDao.addItem(item);

        InvoiceItem invoiceItem2 = new InvoiceItem();
        invoiceItem2.setInvoiceId(invoice2.getInvoiceId());
        invoiceItem2.setItemId(item2.getItemId());
        invoiceItem2.setQuantity(2);
        invoiceItem2.setUnitRate(new BigDecimal("10.01"));
        invoiceItem2.setDiscount(new BigDecimal("0.25"));
        invoiceItemDao.addInvoiceItem(invoiceItem2);

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemByInvoiceId(invoiceItem.getInvoiceId());
        assertEquals(invoiceItemList.size(), 2);

        invoiceItemList= invoiceItemDao.getInvoiceItemByInvoiceId(invoiceItem2.getInvoiceId());
        assertEquals(invoiceItemList.size(),1);
    }

    @Test
    public void getInvoiceItembyItemId(){
        Customer customer = new Customer();
        customer.setFirstName("Mario");
        customer.setLastName("Plumber");
        customer.setEmail("Mario@nintendo.com");
        customer.setCompany("Super Mario Bros");
        customer.setPhone("212-567-1234");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019, 11, 22));
        invoice.setPickupDate(LocalDate.of(2019, 11, 23));
        invoice.setReturnDate(LocalDate.of(2019, 11, 26));
        invoice.setLateFee(new BigDecimal("1.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.");
        item.setDailyRate(new BigDecimal("2.99"));
        item = itemDao.addItem(item);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(2);
        invoiceItem.setUnitRate(new BigDecimal("10.01"));
        invoiceItem.setDiscount(new BigDecimal("0.25"));
        invoiceItemDao.addInvoiceItem(invoiceItem);

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getInvoiceItemByItemId(item.getItemId());
        assertEquals(invoiceItemList.size(), 1);

    }
}



//Customer
//
//firstName - “Mario”
//lastName - “Plumber”
//Email - “Mario@nintendo.com”
//Company - “Super Mario Bros”
//Phone - “212-567-1234”
//
//firstName - “Princess”
//lastName - “Peach”
//Email - “princessp@MushroomCastle.com”
//Company - “Toadsworth”
//Phone - “212-567-1234”
//
//Item
//name - “Titanic”
//Description - “An epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic.”
//DailyRate - “2.99”
//
//name - “The Proposal”
//Description - “Faced with deportation to her native Canada, high-powered book editor Margaret Tate says she's engaged to marry Andrew Paxton, her hapless assistant.”
//DailyRate - “2.99”
//
//Invoice (date, yyy.MM.dd)
//orderDate - 2019, 11, 22
//pickupDate- 2019, 11, 23
//returnDate - 2019, 11, 26
//lateFee - 1.99
//
//Invoice (date, yyy.MM.dd)
//orderDate - 2019, 03, 31
//pickupDate- 2019, 04, 01
//returnDate - 2019, 04, 03
//lateFee - 1.99
//
//
//Inovice_item
//Quantity - 2
//unitRate - 10.01
//Discount -.25
//
//Quantity - 12
//unitRate - 11.03
//Discount -.35