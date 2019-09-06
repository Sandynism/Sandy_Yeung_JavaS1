package com.company.SandyYeungU1Capstone.service;

import com.company.SandyYeungU1Capstone.dao.*;
import com.company.SandyYeungU1Capstone.model.*;
import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
import com.company.SandyYeungU1Capstone.viewModel.InvoiceViewModel;
import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class InvoiceServiceLayerTest {

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceDao invoiceDao;
    InvoiceServiceLayer invoiceService;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMocks();
        setUpGameDaoMocks();
        setUpTshirtDaoMocks();
        setUpInvoiceDaoMocks();
        setUpProcessingFeeDaoMocks();
        setUpSalesTaxRateDaoMocks();
        invoiceService = new InvoiceServiceLayer(consoleDao, gameDao, tshirtDao, processingFeeDao, salesTaxRateDao, invoiceDao);
    }

    private void setUpConsoleDaoMocks() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);

        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        Console console1 = new Console();
        console1.setModel("PS4");
        console1.setManufacturer("Sony");
        console1.setMemoryAmount("512 MB");
        console1.setProcessor("APU");
        console1.setPrice(new BigDecimal("299.99"));
        console1.setQuantity(8);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleList).when(consoleDao).getConsolesByManufacturer("Sony");
    }

    private void setUpGameDaoMocks() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);

        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        Game game1 = new Game();
        game1.setTitle("Rayman Raving Rabbids");
        game1.setEsrbRating("E");
        game1.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game1.setPrice(new BigDecimal("39.99"));
        game1.setStudio("Ubisoft Motion Pictures");
        game1.setQuantity(25);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(gameList).when(gameDao).getGamesByStudio("Ubisoft Motion Pictures");
        doReturn(gameList).when(gameDao).getGamesByEsrbRating("E");
        doReturn(gameList).when(gameDao).getGamesByTitle("Rayman Raving Rabbids");
    }

    private void setUpTshirtDaoMocks() {
        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);

        Tshirt tshirt = new Tshirt();
        tshirt.setTshirtId(1);
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        Tshirt tshirt1 = new Tshirt();
        tshirt1.setSize("Medium");
        tshirt1.setColor("White");
        tshirt1.setDescription("Premium Cotton");
        tshirt1.setPrice(new BigDecimal("9.99"));
        tshirt1.setQuantity(10);

        List<Tshirt> tshirtList = new ArrayList<>();
        tshirtList.add(tshirt);

//        Tshirt tshirt2 = new Tshirt();
//        tshirt2.setQuantity(15);

        doReturn(tshirt).when(tshirtDao).addTshirt(tshirt1);
        doReturn(tshirt).when(tshirtDao).getTshirt(1);
        doReturn(tshirtList).when(tshirtDao).getAllTshirts();
//        doNothing().when(tshirtDao).updateTshirt(tshirt2);
//        doReturn(tshirt2).when(tshirtDao).getTshirt(1);
//        doNothing().when(tshirtDao).deleteTshirt(3);
//        doReturn(null).when(tshirtDao).getTshirt(3);
        doReturn(tshirtList).when(tshirtDao).getTshirtsBySize("Medium");
        doReturn(tshirtList).when(tshirtDao).getTshirtsByColor("White");
    }

    private void setUpInvoiceDaoMocks() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("199.95"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("213.4370"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Sandy Yeung");
        invoice1.setStreet("189th St");
        invoice1.setCity("Fresh Meadows");
        invoice1.setState("NY");
        invoice1.setZipcode("11365");
        invoice1.setItemType("game");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("39.99"));
        invoice1.setQuantity(5);
        invoice1.setSubtotal(new BigDecimal("199.95"));
        invoice1.setTax(new BigDecimal("0.06"));
        invoice1.setProcessingFee(new BigDecimal("1.49"));
        invoice1.setTotal(new BigDecimal("213.4370"));

        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);

//        Invoice invoice2 = new Invoice();
//        invoice2.setQuantity(10);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
//        doNothing().when(invoiceDao).updateInvoice(invoice2);
//        doReturn(invoice2).when(invoiceDao).getInvoice(1);
//        doNothing().when(invoiceDao).deleteInvoice(3);
//        doReturn(null).when(invoiceDao).getInvoice(3);
    }

    private void setUpProcessingFeeDaoMocks() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("games");
        processingFee.setFee(new BigDecimal("1.49"));

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee.setProductType("games");
        processingFee.setFee(new BigDecimal("1.49"));

        List<ProcessingFee> pfList = new ArrayList<>();
        pfList.add(processingFee);

        doReturn(processingFee).when(processingFeeDao).addProcessingFee(processingFee1);
        doReturn(processingFee).when(processingFeeDao).getProcessingFee("games");
    }

    private void setUpSalesTaxRateDaoMocks() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate1.setState("NY");
        salesTaxRate1.setRate(new BigDecimal("0.06"));

        List<SalesTaxRate> salesTaxList = new ArrayList<>();
        salesTaxList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateDao).addSalesTaxRate(salesTaxRate1);
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NY");
    }

    @Test
    public void saveFindDeleteUpdateInvoice() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("199.95"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("213.4370"));

        invoice = invoiceService.saveInvoice(invoice);
        InvoiceViewModel fromService = invoiceService.findInvoice(invoice.getInvoiceId());
        assertEquals(invoice, fromService);
//        List<InvoiceViewModel> fromServiceList = invoiceService.findAllInvoices();
//        assertEquals(fromServiceList.size(), 1);
//        invoiceService.deleteInvoice(2);
//        assertNull(invoiceService.findInvoice(2));
    }


    @Test
    public void saveFindDeleteUpdateConsole() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        console = invoiceService.saveConsole(console);
        ConsoleViewModel fromService = invoiceService.findConsole(console.getConsoleId());
        assertEquals(console, fromService);
    }


    @Test
    public void getConsolesByManufacturer() {
    }

    @Test
    public void saveFindDeleteUpdateGame() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        game = invoiceService.saveGame(game);
        GameViewModel fromService = invoiceService.findGame(game.getGameId());
        assertEquals(game, fromService);
    }


    @Test
    public void getGamesByEsrbRating() {
    }

    @Test
    public void getGamesByTitle() {
    }

    @Test
    public void getGamesByStudio() {
    }

    @Test
    public void saveFindDeleteUpdateTshirt() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirt = invoiceService.saveTshirt(tshirt);
        TshirtViewModel fromService = invoiceService.findTshirt(tshirt.getTshirtId());
        assertEquals(tshirt, fromService);
    }


    @Test
    public void getTshirtsByColor() {
    }

    @Test
    public void getTshirtsBySize() {
    }

    @Test
    public void validateState() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("199.95"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("213.4370"));

        invoice = invoiceService.saveInvoice(invoice);
        assertEquals("NY", invoiceService.validateState(invoice));
    }

    @Test
    public void validateProductType() {
    }

    @Test
    public void validateItem() {
    }

    @Test
    public void validateAndUpdateInventory() {
    }

    @Test
    public void getItemPrice() {
    }

    @Test
    public void calculateSubtotal() {
    }

    @Test
    public void calculateSalesTax() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));

        invoice = invoiceService.saveInvoice(invoice);
        BigDecimal tax = invoiceService.calculateSalesTax(invoice);
        assertEquals(tax, new BigDecimal("0.06"));
    }

    @Test
    public void calculateProcessingFees() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);

        invoice = invoiceService.saveInvoice(invoice);
        BigDecimal processingFee = invoiceService.calculateProcessingFees(invoice);
        assertEquals(processingFee, new BigDecimal("1.49"));
    }

    @Test
    public void calculateTotal() {
        InvoiceViewModel invoice = new InvoiceViewModel();
        invoice.setName("Sandy Yeung");
        invoice.setStreet("189th St");
        invoice.setCity("Fresh Meadows");
        invoice.setState("NY");
        invoice.setZipcode("11365");
        invoice.setItemType("game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("39.99"));
        invoice.setQuantity(5);

        invoice = invoiceService.saveInvoice(invoice);
        BigDecimal total = invoiceService.calculateTotal();
        assertEquals(total, new BigDecimal("213.4370"));
    }
}