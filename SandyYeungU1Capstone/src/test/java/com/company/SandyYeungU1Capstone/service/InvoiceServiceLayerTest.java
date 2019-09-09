package com.company.SandyYeungU1Capstone.service;

import com.company.SandyYeungU1Capstone.dao.*;
import com.company.SandyYeungU1Capstone.model.*;
import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
import com.company.SandyYeungU1Capstone.viewModel.InvoiceViewModel;
import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

        Console consoleUpdate = new Console();
        consoleUpdate.setConsoleId(2);
        consoleUpdate.setModel("Updated Model");
        consoleUpdate.setManufacturer("Updated Manufacturer");
        consoleUpdate.setMemoryAmount("512 MB");
        consoleUpdate.setProcessor("APU");
        consoleUpdate.setPrice(new BigDecimal("299.99"));
        consoleUpdate.setQuantity(10);

        Console console3 = new Console();
        console3.setConsoleId(3);
        console3.setModel("XBOX 360");
        console3.setManufacturer("Microsoft");
        console3.setMemoryAmount("512 MB");
        console3.setProcessor("APU");
        console3.setPrice(new BigDecimal("299.99"));
        console3.setQuantity(10);

        consoleList.add(console3);

        List<Console> newConsoleList = new ArrayList<>();
        newConsoleList.add(console);

        doReturn(console).when(consoleDao).addConsole(console1);
        doReturn(console).when(consoleDao).getConsole(1);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doNothing().when(consoleDao).updateConsole(consoleUpdate);
        doReturn(consoleUpdate).when(consoleDao).getConsole(2);
        doNothing().when(consoleDao).deleteConsole(3);
        doReturn(null).when(consoleDao).getConsole(3);
        doReturn(newConsoleList).when(consoleDao).getConsolesByManufacturer("Sony");
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

        Game gameUpdate = new Game();
        gameUpdate.setGameId(2);
        gameUpdate.setTitle("Update Rayman");
        gameUpdate.setEsrbRating("T");
        gameUpdate.setDescription("Updated");
        gameUpdate.setPrice(new BigDecimal("39.99"));
        gameUpdate.setStudio("Updated Studio");
        gameUpdate.setQuantity(25);

        Game game3 = new Game();
        game3.setGameId(3);
        game3.setTitle("Who are the rabbids?");
        game3.setEsrbRating("E");
        game3.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game3.setPrice(new BigDecimal("39.99"));
        game3.setStudio("Ubisoft Motion Pictures");
        game3.setQuantity(25);

        gameList.add(game3);

        List<Game> newGameList = new ArrayList<>();
        newGameList.add(game);

        doReturn(game).when(gameDao).addGame(game1);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(gameList).when(gameDao).getAllGames();
        doNothing().when(gameDao).updateGame(gameUpdate);
        doReturn(gameUpdate).when(gameDao).getGame(2);
        doNothing().when(gameDao).deleteGame(3);
        doReturn(null).when(gameDao).getGame(3);
        doReturn(newGameList).when(gameDao).getGamesByStudio("Ubisoft Motion Pictures");
        doReturn(newGameList).when(gameDao).getGamesByEsrbRating("E");
        doReturn(newGameList).when(gameDao).getGamesByTitle("Rayman Raving Rabbids");
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

        Tshirt tshirtUpdate = new Tshirt();
        tshirtUpdate.setTshirtId(2);
        tshirtUpdate.setSize("Small");
        tshirtUpdate.setColor("Pink");
        tshirtUpdate.setDescription("Premium Cotton");
        tshirtUpdate.setPrice(new BigDecimal("11.99"));
        tshirtUpdate.setQuantity(15);

        Tshirt tshirt3 = new Tshirt();
        tshirt3.setTshirtId(3);
        tshirt3.setSize("Small");
        tshirt3.setColor("Black");
        tshirt3.setDescription("Polyester");
        tshirt3.setPrice(new BigDecimal("9.99"));
        tshirt3.setQuantity(10);

        tshirtList.add(tshirt3);

        List<Tshirt> newTshirtList = new ArrayList<>();
        newTshirtList.add(tshirt);

        doReturn(tshirt).when(tshirtDao).addTshirt(tshirt1);
        doReturn(tshirt).when(tshirtDao).getTshirt(1);
        doReturn(tshirtList).when(tshirtDao).getAllTshirts();
        doNothing().when(tshirtDao).updateTshirt(tshirtUpdate);
        doReturn(tshirtUpdate).when(tshirtDao).getTshirt(2);
        doNothing().when(tshirtDao).deleteTshirt(3);
        doReturn(null).when(tshirtDao).getTshirt(3);
        doReturn(newTshirtList).when(tshirtDao).getTshirtsBySize("Medium");
        doReturn(newTshirtList).when(tshirtDao).getTshirtsByColor("White");
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
    public void saveFindInvoice() {
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

        console = new ConsoleViewModel();
        Console consoleUpdate = new Console();
        consoleUpdate.setConsoleId(2);
        consoleUpdate.setModel("Updated Model");
        consoleUpdate.setManufacturer("Updated Manufacturer");
        consoleUpdate.setMemoryAmount("512 MB");
        consoleUpdate.setProcessor("APU");
        consoleUpdate.setPrice(new BigDecimal("299.99"));
        consoleUpdate.setQuantity(10);

        console.setConsoleId(consoleUpdate.getConsoleId());
        console.setModel(consoleUpdate.getModel());
        console.setManufacturer(consoleUpdate.getManufacturer());
        console.setMemoryAmount(consoleUpdate.getMemoryAmount());
        console.setProcessor(consoleUpdate.getProcessor());
        console.setPrice(consoleUpdate.getPrice());
        console.setQuantity(consoleUpdate.getQuantity());

        invoiceService.updateConsole(console);

        fromService = invoiceService.findConsole(2);

        Console console3 = new Console();
        console3.setConsoleId(fromService.getConsoleId());
        console3.setModel(fromService.getModel());
        console3.setManufacturer(fromService.getManufacturer());
        console3.setMemoryAmount(fromService.getMemoryAmount());
        console3.setProcessor(fromService.getProcessor());
        console3.setPrice(fromService.getPrice());
        console3.setQuantity(fromService.getQuantity());

        assertEquals(consoleUpdate, console3);

        invoiceService.deleteConsole(3);
        fromService = invoiceService.findConsole(3);
        assertNull(fromService);
    }


    @Test
    public void getConsolesByManufacturer() {
        ConsoleViewModel console = new ConsoleViewModel();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("512 MB");
        console.setProcessor("APU");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(8);

        console = invoiceService.saveConsole(console);
        List<ConsoleViewModel> fromService = invoiceService.getConsolesByManufacturer("Sony");
        assertEquals(fromService.size(), 1);
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
        GameViewModel game = new GameViewModel();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        game = invoiceService.saveGame(game);
        List<GameViewModel> fromService = invoiceService.getGamesByEsrbRating("E");
        assertEquals(fromService.size(), 1);
    }

    @Test
    public void getGamesByTitle() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        game = invoiceService.saveGame(game);
        List<GameViewModel> fromService = invoiceService.getGamesByTitle("Rayman Raving Rabbids");
        assertEquals(fromService.size(), 1);
    }

    @Test
    public void getGamesByStudio() {
        GameViewModel game = new GameViewModel();
        game.setTitle("Rayman Raving Rabbids");
        game.setEsrbRating("E");
        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
        game.setPrice(new BigDecimal("39.99"));
        game.setStudio("Ubisoft Motion Pictures");
        game.setQuantity(25);

        game = invoiceService.saveGame(game);
        List<GameViewModel> fromService = invoiceService.getGamesByStudio("Ubisoft Motion Pictures");
        assertEquals(fromService.size(), 1);
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

        tshirt = new TshirtViewModel();
        Tshirt tshirtUpdate = new Tshirt();

        tshirtUpdate.setTshirtId(2);
        tshirtUpdate.setSize("Small");
        tshirtUpdate.setColor("Pink");
        tshirtUpdate.setDescription("Premium Cotton");
        tshirtUpdate.setPrice(new BigDecimal("11.99"));
        tshirtUpdate.setQuantity(15);

        tshirt.setTshirtId(tshirtUpdate.getTshirtId());
        tshirt.setSize(tshirtUpdate.getSize());
        tshirt.setColor(tshirtUpdate.getColor());
        tshirt.setDescription(tshirtUpdate.getDescription());
        tshirt.setPrice(tshirtUpdate.getPrice());
        tshirt.setQuantity(tshirtUpdate.getQuantity());

        invoiceService.updateTshirt(tshirt);

        fromService = invoiceService.findTshirt(2);

        Tshirt tshirt3 = new Tshirt();
        tshirt3.setTshirtId(fromService.getTshirtId());
        tshirt3.setSize(fromService.getSize());
        tshirt3.setColor(fromService.getColor());
        tshirt3.setDescription(fromService.getDescription());
        tshirt3.setPrice(fromService.getPrice());
        tshirt3.setQuantity(fromService.getQuantity());

        assertEquals(tshirtUpdate, tshirt3);

        invoiceService.deleteTshirt(3);
        fromService = invoiceService.findTshirt(3);
        assertNull(fromService);
    }


    @Test
    public void getTshirtsByColor() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirt = invoiceService.saveTshirt(tshirt);
        List<TshirtViewModel> fromService = invoiceService.getTshirtsByColor("White");
        assertEquals(fromService.size(), 1);
    }

    @Test
    public void getTshirtsBySize() {
        TshirtViewModel tshirt = new TshirtViewModel();
        tshirt.setSize("Medium");
        tshirt.setColor("White");
        tshirt.setDescription("Premium Cotton");
        tshirt.setPrice(new BigDecimal("9.99"));
        tshirt.setQuantity(10);

        tshirt = invoiceService.saveTshirt(tshirt);
        List<TshirtViewModel> fromService = invoiceService.getTshirtsBySize("Medium");
        assertEquals(fromService.size(), 1);
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
        assertEquals("game", invoiceService.validateProductType(invoice));
    }

    @Test
    public void validateItem() {
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
        assertEquals(1, invoiceService.validateItem(invoice));
    }

    @Test
    public void validateAndUpdateInventory() {
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
        assertEquals(5, invoiceService.validateAndUpdateInventory(invoice));
    }

    @Test
    public void getItemPrice() {
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
        assertEquals(new BigDecimal("39.99"), invoiceService.getItemPrice(invoice));
    }

    @Test
    public void calculateSubtotal() {
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
        assertEquals(new BigDecimal("199.95"), invoiceService.calculateSubtotal(invoice));
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




//package com.company.SandyYeungU1Capstone.service;
//
//import com.company.SandyYeungU1Capstone.dao.*;
//import com.company.SandyYeungU1Capstone.model.*;
//import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
//import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
//import com.company.SandyYeungU1Capstone.viewModel.InvoiceViewModel;
//import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.*;
//
//public class InvoiceServiceLayerTest {
//
//    ConsoleDao consoleDao;
//    GameDao gameDao;
//    TshirtDao tshirtDao;
//    ProcessingFeeDao processingFeeDao;
//    SalesTaxRateDao salesTaxRateDao;
//    InvoiceDao invoiceDao;
//    InvoiceServiceLayer invoiceService;
//
//    @Before
//    public void setUp() throws Exception {
//        setUpConsoleDaoMocks();
//        setUpGameDaoMocks();
//        setUpTshirtDaoMocks();
//        setUpInvoiceDaoMocks();
//        setUpProcessingFeeDaoMocks();
//        setUpSalesTaxRateDaoMocks();
//        invoiceService = new InvoiceServiceLayer(consoleDao, gameDao, tshirtDao, processingFeeDao, salesTaxRateDao, invoiceDao);
//    }
//
//    private void setUpConsoleDaoMocks() {
//        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
//
//        Console console = new Console();
//        console.setConsoleId(1);
//        console.setModel("PS4");
//        console.setManufacturer("Sony");
//        console.setMemoryAmount("512 MB");
//        console.setProcessor("APU");
//        console.setPrice(new BigDecimal("299.99"));
//        console.setQuantity(8);
//
//        Console console1 = new Console();
//        console1.setModel("PS4");
//        console1.setManufacturer("Sony");
//        console1.setMemoryAmount("512 MB");
//        console1.setProcessor("APU");
//        console1.setPrice(new BigDecimal("299.99"));
//        console1.setQuantity(8);
//
//        List<Console> consoleList = new ArrayList<>();
//        consoleList.add(console);
//
//        doReturn(console).when(consoleDao).addConsole(console1);
//        doReturn(console).when(consoleDao).getConsole(1);
//        doReturn(consoleList).when(consoleDao).getAllConsoles();
//
//        Console consoleUpdate = new Console();
//        consoleUpdate.setConsoleId(2);
//        consoleUpdate.setModel("Updated Model");
//        consoleUpdate.setManufacturer("Updated Manufacturer");
//        consoleUpdate.setMemoryAmount("512 MB");
//        consoleUpdate.setProcessor("APU");
//        consoleUpdate.setPrice(new BigDecimal("299.99"));
//        consoleUpdate.setQuantity(10);
//
//        doNothing().when(consoleDao).updateConsole(consoleUpdate);
//        doReturn(consoleUpdate).when(consoleDao).getConsole(2);
//
//        Console console3 = new Console();
//        console3.setConsoleId(2);
//        console3.setModel("XBOX 360");
//        console3.setManufacturer("Microsoft");
//        console3.setMemoryAmount("512 MB");
//        console3.setProcessor("APU");
//        console3.setPrice(new BigDecimal("299.99"));
//        console3.setQuantity(10);
//
//        consoleList.add(console3);
//
//        List<Console> sonyConsoles = new ArrayList<>();
//        sonyConsoles.add(console);
//
//        doReturn(sonyConsoles).when(consoleDao).getConsolesByManufacturer("Sony");
//    }
//
//    private void setUpGameDaoMocks() {
//        gameDao = mock(GameDaoJdbcTemplateImpl.class);
//
//        Game game = new Game();
//        game.setGameId(1);
//        game.setTitle("Rayman Raving Rabbids");
//        game.setEsrbRating("E");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Ubisoft Motion Pictures");
//        game.setQuantity(25);
//
//        Game game1 = new Game();
//        game1.setTitle("Rayman Raving Rabbids");
//        game1.setEsrbRating("E");
//        game1.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game1.setPrice(new BigDecimal("39.99"));
//        game1.setStudio("Ubisoft Motion Pictures");
//        game1.setQuantity(25);
//
//        List<Game> gameList = new ArrayList<>();
//        gameList.add(game);
//
//        doReturn(game).when(gameDao).addGame(game1);
//        doReturn(game).when(gameDao).getGame(1);
//        doReturn(gameList).when(gameDao).getAllGames();
//
//        Game gameUpdate = new Game();
//        gameUpdate.setGameId(2);
//        gameUpdate.setTitle("Rayman Raving Rabbids");
//        gameUpdate.setEsrbRating("E");
//        gameUpdate.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        gameUpdate.setPrice(new BigDecimal("39.99"));
//        gameUpdate.setStudio("Ubisoft Motion Pictures");
//        gameUpdate.setQuantity(30);
//
//        doNothing().when(gameDao).updateGame(gameUpdate);
//        doReturn(gameUpdate).when(gameDao).getGame(2);
//
//        Game game3 = new Game();
//        game.setGameId(3);
//        game.setTitle("Fake Game");
//        game.setEsrbRating("M");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Motion Pictures");
//        game.setQuantity(20);
//
//        gameList.add(game3);
//
//        List<Game> studioRatingTitleGames = new ArrayList<>();
//        studioRatingTitleGames.add(game);
//
//        doNothing().when(gameDao).deleteGame(3);
//        doReturn(null).when(gameDao).getGame(3);
//        doReturn(studioRatingTitleGames).when(gameDao).getGamesByStudio("Ubisoft Motion Pictures");
//        doReturn(studioRatingTitleGames).when(gameDao).getGamesByEsrbRating("E");
//        doReturn(studioRatingTitleGames).when(gameDao).getGamesByTitle("Rayman Raving Rabbids");
//    }
//
//    private void setUpTshirtDaoMocks() {
//        tshirtDao = mock(TshirtDaoJdbcTemplateImpl.class);
//
//        Tshirt tshirt = new Tshirt();
//        tshirt.setTshirtId(1);
//        tshirt.setSize("Medium");
//        tshirt.setColor("White");
//        tshirt.setDescription("Premium Cotton");
//        tshirt.setPrice(new BigDecimal("9.99"));
//        tshirt.setQuantity(10);
//
//        Tshirt tshirt1 = new Tshirt();
//        tshirt1.setSize("Medium");
//        tshirt1.setColor("White");
//        tshirt1.setDescription("Premium Cotton");
//        tshirt1.setPrice(new BigDecimal("9.99"));
//        tshirt1.setQuantity(10);
//
//        List<Tshirt> tshirtList = new ArrayList<>();
//        tshirtList.add(tshirt);
//
//        doReturn(tshirt).when(tshirtDao).addTshirt(tshirt1);
//        doReturn(tshirt).when(tshirtDao).getTshirt(1);
//        doReturn(tshirtList).when(tshirtDao).getAllTshirts();
//
//        Tshirt tshirtUpdate = new Tshirt();
//        tshirtUpdate.setTshirtId(2);
//        tshirtUpdate.setSize("Small");
//        tshirtUpdate.setColor("Pink");
//        tshirtUpdate.setDescription("Premium Cotton");
//        tshirtUpdate.setPrice(new BigDecimal("11.99"));
//        tshirtUpdate.setQuantity(15);
//
//        doNothing().when(tshirtDao).updateTshirt(tshirtUpdate);
//        doReturn(tshirtUpdate).when(tshirtDao).getTshirt(2);
//
//        Tshirt tshirt3 = new Tshirt();
//        tshirt3.setTshirtId(3);
//        tshirt3.setSize("Small");
//        tshirt3.setColor("Black");
//        tshirt3.setDescription("Polyester");
//        tshirt3.setPrice(new BigDecimal("9.99"));
//        tshirt3.setQuantity(10);
//
//        tshirtList.add(tshirt3);
//
//        List<Tshirt> mediumWhiteTshirts = new ArrayList<>();
//        mediumWhiteTshirts.add(tshirt);
//
//        doNothing().when(tshirtDao).deleteTshirt(3);
//        doReturn(null).when(tshirtDao).getTshirt(3);
//        doReturn(mediumWhiteTshirts).when(tshirtDao).getTshirtsBySize("Medium");
//        doReturn(mediumWhiteTshirts).when(tshirtDao).getTshirtsByColor("White");
//
//    }
//
//    private void setUpInvoiceDaoMocks() {
//        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceId(1);
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        Invoice invoice1 = new Invoice();
//        invoice1.setName("Sandy Yeung");
//        invoice1.setStreet("189th St");
//        invoice1.setCity("Fresh Meadows");
//        invoice1.setState("NY");
//        invoice1.setZipcode("11365");
//        invoice1.setItemType("game");
//        invoice1.setItemId(1);
//        invoice1.setUnitPrice(new BigDecimal("39.99"));
//        invoice1.setQuantity(5);
//        invoice1.setSubtotal(new BigDecimal("199.95"));
//        invoice1.setTax(new BigDecimal("0.06"));
//        invoice1.setProcessingFee(new BigDecimal("1.49"));
//        invoice1.setTotal(new BigDecimal("213.4370"));
//
//        List<Invoice> invoiceList = new ArrayList<>();
//        invoiceList.add(invoice);
//
//        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
//        doReturn(invoice).when(invoiceDao).getInvoice(1);
//        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
//
////        Invoice invoice2 = new Invoice();
////        invoice2.setQuantity(10);
//
////        doNothing().when(invoiceDao).updateInvoice(invoice2);
////        doReturn(invoice2).when(invoiceDao).getInvoice(1);
////        doNothing().when(invoiceDao).deleteInvoice(3);
////        doReturn(null).when(invoiceDao).getInvoice(3);
//    }
//
//    private void setUpProcessingFeeDaoMocks() {
//        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
//
//        ProcessingFee processingFee = new ProcessingFee();
//        processingFee.setProductType("games");
//        processingFee.setFee(new BigDecimal("1.49"));
//
//        ProcessingFee processingFee1 = new ProcessingFee();
//        processingFee.setProductType("games");
//        processingFee.setFee(new BigDecimal("1.49"));
//
//        List<ProcessingFee> pfList = new ArrayList<>();
//        pfList.add(processingFee);
//
//        doReturn(processingFee).when(processingFeeDao).addProcessingFee(processingFee1);
//        doReturn(processingFee).when(processingFeeDao).getProcessingFee("games");
//    }
//
//    private void setUpSalesTaxRateDaoMocks() {
//        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
//
//        SalesTaxRate salesTaxRate = new SalesTaxRate();
//        salesTaxRate.setState("NY");
//        salesTaxRate.setRate(new BigDecimal("0.06"));
//
//        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
//        salesTaxRate1.setState("NY");
//        salesTaxRate1.setRate(new BigDecimal("0.06"));
//
//        List<SalesTaxRate> salesTaxList = new ArrayList<>();
//        salesTaxList.add(salesTaxRate);
//
//        doReturn(salesTaxRate).when(salesTaxRateDao).addSalesTaxRate(salesTaxRate1);
//        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NY");
//    }
//
//    @Test
//    public void saveFindInvoice() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        InvoiceViewModel fromService = invoiceService.findInvoice(invoice.getInvoiceId());
//        assertEquals(invoice, fromService);
////        List<InvoiceViewModel> fromServiceList = invoiceService.findAllInvoices();
////        assertEquals(fromServiceList.size(), 1);
////        invoiceService.deleteInvoice(2);
////        assertNull(invoiceService.findInvoice(2));
//    }
//
//
//    @Test
//    public void saveFindConsole() {
//        ConsoleViewModel console = new ConsoleViewModel();
//        console.setModel("PS4");
//        console.setManufacturer("Sony");
//        console.setMemoryAmount("512 MB");
//        console.setProcessor("APU");
//        console.setPrice(new BigDecimal("299.99"));
//        console.setQuantity(8);
//
//        console = invoiceService.saveConsole(console);
//        ConsoleViewModel fromService = invoiceService.findConsole(console.getConsoleId());
//        assertEquals(console, fromService);
//    }
//
//    @Test
//    public void deleteConsole(){
//        invoiceService.deleteConsole(3);
//        ConsoleViewModel fromService = invoiceService.findConsole(3);
//        assertNull(fromService);
//    }
//
//    @Test
//    public void updateConsole() {
//        ConsoleViewModel console = new ConsoleViewModel();
//        Console consoleUpdate = new Console();
//
//        consoleUpdate.setConsoleId(2);
//        consoleUpdate.setModel("Updated Model");
//        consoleUpdate.setManufacturer("Updated Manufacturer");
//        consoleUpdate.setMemoryAmount("512 MB");
//        consoleUpdate.setProcessor("APU");
//        consoleUpdate.setPrice(new BigDecimal("299.99"));
//        consoleUpdate.setQuantity(10);
//
//        console.setConsoleId(consoleUpdate.getConsoleId());
//        console.setModel(consoleUpdate.getModel());
//        console.setManufacturer(consoleUpdate.getManufacturer());
//        console.setMemoryAmount(consoleUpdate.getMemoryAmount());
//        console.setProcessor(consoleUpdate.getProcessor());
//        console.setPrice(consoleUpdate.getPrice());
//        console.setQuantity(consoleUpdate.getQuantity());
//
//        invoiceService.updateConsole(console);
//        ConsoleViewModel fromService = invoiceService.findConsole(2);
//
//        Console console3 = new Console();
//        console3.setConsoleId(fromService.getConsoleId());
//        console3.setModel(fromService.getModel());
//        console3.setManufacturer(fromService.getManufacturer());
//        console3.setMemoryAmount(fromService.getMemoryAmount());
//        console3.setProcessor(fromService.getProcessor());
//        console3.setPrice(fromService.getPrice());
//        console3.setQuantity(fromService.getQuantity());
//
//        assertEquals(consoleUpdate, console3);
//    }
//
//    @Test
//    public void getConsolesByManufacturer() {
//        ConsoleViewModel console = new ConsoleViewModel();
//        console.setModel("PS4");
//        console.setManufacturer("Sony");
//        console.setMemoryAmount("512 MB");
//        console.setProcessor("APU");
//        console.setPrice(new BigDecimal("299.99"));
//        console.setQuantity(8);
//
//        console = invoiceService.saveConsole(console);
//        List<ConsoleViewModel> fromService = invoiceService.getConsolesByManufacturer("Sony");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void saveFindGame() {
//        GameViewModel game = new GameViewModel();
//        game.setTitle("Rayman Raving Rabbids");
//        game.setEsrbRating("E");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Ubisoft Motion Pictures");
//        game.setQuantity(25);
//
//        game = invoiceService.saveGame(game);
//        GameViewModel fromService = invoiceService.findGame(game.getGameId());
//        assertEquals(game, fromService);
//    }
//
//    @Test
//    public void deleteGame(){
//        invoiceService.deleteGame(3);
//        GameViewModel fromService = invoiceService.findGame(3);
//        assertNull(fromService);
//    }
//
//    @Test
//    public void updateGame(){
//        GameViewModel game = new GameViewModel();
//        Game gameUpdate = new Game();
//
//        gameUpdate.setGameId(2);
//        gameUpdate.setTitle("Rayman Raving Rabbids");
//        gameUpdate.setEsrbRating("E");
//        gameUpdate.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        gameUpdate.setPrice(new BigDecimal("39.99"));
//        gameUpdate.setStudio("Ubisoft Motion Pictures");
//        gameUpdate.setQuantity(30);
//
//        game.setGameId(gameUpdate.getGameId());
//        game.setTitle(gameUpdate.getTitle());
//        game.setEsrbRating(gameUpdate.getEsrbRating());
//        game.setDescription(gameUpdate.getDescription());
//        game.setPrice(gameUpdate.getPrice());
//        game.setStudio(gameUpdate.getStudio());
//        game.setQuantity(gameUpdate.getQuantity());
//
//        invoiceService.updateGame(game);
//        GameViewModel fromService = invoiceService.findGame(2);
//
//        Game game3 = new Game();
//        game3.setGameId(fromService.getGameId());
//        game3.setTitle(fromService.getTitle());
//        game3.setEsrbRating(fromService.getEsrbRating());
//        game3.setDescription(fromService.getDescription());
//        game3.setPrice(fromService.getPrice());
//        game3.setStudio(fromService.getStudio());
//        game3.setQuantity(fromService.getQuantity());
//
//        assertEquals(gameUpdate, game3);
//    }
//
//    @Test
//    public void getGamesByEsrbRating() {
//        GameViewModel game = new GameViewModel();
//        game.setTitle("Rayman Raving Rabbids");
//        game.setEsrbRating("E");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Ubisoft Motion Pictures");
//        game.setQuantity(25);
//
//        game = invoiceService.saveGame(game);
//        List<GameViewModel> fromService = invoiceService.getGamesByEsrbRating("E");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void getGamesByTitle() {
//        GameViewModel game = new GameViewModel();
//        game.setTitle("Rayman Raving Rabbids");
//        game.setEsrbRating("E");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Ubisoft Motion Pictures");
//        game.setQuantity(25);
//
//        game = invoiceService.saveGame(game);
//        List<GameViewModel> fromService = invoiceService.getGamesByTitle("Rayman Raving Rabbids");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void getGamesByStudio() {
//        GameViewModel game = new GameViewModel();
//        game.setTitle("Rayman Raving Rabbids");
//        game.setEsrbRating("E");
//        game.setDescription("The series focuses on wild rabbit-like creatures known as Rabbids, who like to cause havoc and mischief, speak gibberish and yell.");
//        game.setPrice(new BigDecimal("39.99"));
//        game.setStudio("Ubisoft Motion Pictures");
//        game.setQuantity(25);
//
//        game = invoiceService.saveGame(game);
//        List<GameViewModel> fromService = invoiceService.getGamesByStudio("Ubisoft Motion Pictures");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void saveFindTshirt() {
//        TshirtViewModel tshirt = new TshirtViewModel();
//        tshirt.setSize("Medium");
//        tshirt.setColor("White");
//        tshirt.setDescription("Premium Cotton");
//        tshirt.setPrice(new BigDecimal("9.99"));
//        tshirt.setQuantity(10);
//
//        tshirt = invoiceService.saveTshirt(tshirt);
//        TshirtViewModel fromService = invoiceService.findTshirt(tshirt.getTshirtId());
//        assertEquals(tshirt, fromService);
//    }
//
//    @Test
//    public void deleteTshirt() {
//        invoiceService.deleteTshirt(3);
//        TshirtViewModel fromService = invoiceService.findTshirt(3);
//        assertNull(fromService);
//    }
//
//    @Test
//    public void updateTshirt() {
//        TshirtViewModel tshirt = new TshirtViewModel();
//        Tshirt tshirtUpdate = new Tshirt();
//
//        tshirtUpdate.setTshirtId(2);
//        tshirtUpdate.setSize("Small");
//        tshirtUpdate.setColor("Pink");
//        tshirtUpdate.setDescription("Premium Cotton");
//        tshirtUpdate.setPrice(new BigDecimal("11.99"));
//        tshirtUpdate.setQuantity(15);
//
//        tshirt.setTshirtId(tshirtUpdate.getTshirtId());
//        tshirt.setSize(tshirtUpdate.getSize());
//        tshirt.setColor(tshirtUpdate.getColor());
//        tshirt.setDescription(tshirtUpdate.getDescription());
//        tshirt.setPrice(tshirtUpdate.getPrice());
//        tshirt.setQuantity(tshirtUpdate.getQuantity());
//
//        invoiceService.updateTshirt(tshirt);
//        TshirtViewModel fromService = invoiceService.findTshirt(2);
//
//        Tshirt tshirt3 = new Tshirt();
//        tshirt3.setTshirtId(fromService.getTshirtId());
//        tshirt3.setSize(fromService.getSize());
//        tshirt3.setColor(fromService.getColor());
//        tshirt3.setDescription(fromService.getDescription());
//        tshirt3.setPrice(fromService.getPrice());
//        tshirt3.setQuantity(fromService.getQuantity());
//
//        assertEquals(tshirtUpdate, tshirt3);
//    }
//
//    @Test
//    public void getTshirtsByColor() {
//        TshirtViewModel tshirt = new TshirtViewModel();
//        tshirt.setTshirtId(1);
//        tshirt.setSize("Medium");
//        tshirt.setColor("White");
//        tshirt.setDescription("Premium Cotton");
//        tshirt.setPrice(new BigDecimal("9.99"));
//        tshirt.setQuantity(10);
//
//        tshirt = invoiceService.saveTshirt(tshirt);
//        List<TshirtViewModel> fromService = invoiceService.getTshirtsByColor("White");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void getTshirtsBySize() {
//        TshirtViewModel tshirt = new TshirtViewModel();
//        tshirt.setSize("Medium");
//        tshirt.setColor("White");
//        tshirt.setDescription("Premium Cotton");
//        tshirt.setPrice(new BigDecimal("9.99"));
//        tshirt.setQuantity(10);
//
//        tshirt = invoiceService.saveTshirt(tshirt);
//        List<TshirtViewModel> fromService = invoiceService.getTshirtsBySize("Medium");
//        assertEquals(fromService.size(), 1);
//    }
//
//    @Test
//    public void validateState() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals("NY", invoiceService.validateState(invoice));
//    }
//
//    @Test
//    public void validateProductType() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals("game", invoiceService.validateProductType(invoice));
//    }
//
//    @Test
//    public void validateItem() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals(1, invoiceService.validateItem(invoice));
//    }
//
//    @Test
//    public void validateAndUpdateInventory() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals(5, invoiceService.validateAndUpdateInventory(invoice));
//    }
//
//    @Test
//    public void getItemPrice() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//        invoice.setSubtotal(new BigDecimal("199.95"));
//        invoice.setTax(new BigDecimal("0.06"));
//        invoice.setProcessingFee(new BigDecimal("1.49"));
//        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals(new BigDecimal("39.99"), invoiceService.getItemPrice(invoice));
//    }
//
//    @Test
//    public void calculateSubtotal() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
////        invoice.setSubtotal(new BigDecimal("199.95"));
////        invoice.setTax(new BigDecimal("0.06"));
////        invoice.setProcessingFee(new BigDecimal("1.49"));
////        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        assertEquals(new BigDecimal("199.95"), invoiceService.calculateSubtotal(invoice));
//    }
//
//    @Test
//    public void calculateSalesTax() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
////        invoice.setSubtotal(new BigDecimal("199.95"));
////        invoice.setTax(new BigDecimal("0.06"));
////        invoice.setProcessingFee(new BigDecimal("1.49"));
////        invoice.setTotal(new BigDecimal("213.4370"));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        BigDecimal tax = invoiceService.calculateSalesTax(invoice);
//        assertEquals(tax, new BigDecimal("0.06"));
//    }
//
//    @Test
//    public void calculateProcessingFees() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//
//        invoice = invoiceService.saveInvoice(invoice);
//        BigDecimal processingFee = invoiceService.calculateProcessingFees(invoice);
//        assertEquals(processingFee, new BigDecimal("1.49"));
//    }
//
//    @Test
//    public void calculateTotal() {
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setName("Sandy Yeung");
//        invoice.setStreet("189th St");
//        invoice.setCity("Fresh Meadows");
//        invoice.setState("NY");
//        invoice.setZipcode("11365");
//        invoice.setItemType("game");
//        invoice.setItemId(1);
//        invoice.setUnitPrice(new BigDecimal("39.99"));
//        invoice.setQuantity(5);
//
//        invoice = invoiceService.saveInvoice(invoice);
//        BigDecimal total = invoiceService.calculateTotal();
//        assertEquals(total, new BigDecimal("213.4370"));
//    }
//}