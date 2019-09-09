package com.company.SandyYeungU1Capstone.service;

import com.company.SandyYeungU1Capstone.dao.*;
import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.model.*;
import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
import com.company.SandyYeungU1Capstone.viewModel.GameViewModel;
import com.company.SandyYeungU1Capstone.viewModel.InvoiceViewModel;
import com.company.SandyYeungU1Capstone.viewModel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceServiceLayer {
    private String state;
    private String productType;
    private int productId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
    private BigDecimal salesTax;
    private BigDecimal processingFee;
    private BigDecimal total;

    ConsoleDao consoleDao;
    GameDao gameDao;
    TshirtDao tshirtDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    InvoiceDao invoiceDao;

    @Autowired
    public InvoiceServiceLayer(ConsoleDao consoleDao, GameDao gameDao, TshirtDao tshirtDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, InvoiceDao invoiceDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tshirtDao = tshirtDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.invoiceDao = invoiceDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel ivm) {

        Invoice invoice = new Invoice();
        invoice.setName(ivm.getName());
        invoice.setStreet(ivm.getStreet());
        invoice.setCity(ivm.getCity());
        invoice.setState(validateState(ivm));
//        invoice.setState(ivm.getState());
        invoice.setZipcode(ivm.getZipcode());
        invoice.setItemType(validateProductType(ivm));
        invoice.setItemId(validateItem(ivm));
        invoice.setUnitPrice(getItemPrice(ivm));
        invoice.setQuantity(validateAndUpdateInventory(ivm));
        invoice.setSubtotal(calculateSubtotal(ivm));
        invoice.setTax(calculateSalesTax(ivm));
        invoice.setProcessingFee(calculateProcessingFees(ivm));
        invoice.setTotal(calculateTotal());

        invoice = invoiceDao.addInvoice(invoice);
        ivm.setInvoiceId(invoice.getInvoiceId());

        return ivm;
    }

    public List<InvoiceViewModel> findAllInvoices() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> ivms = new ArrayList<>();

        for (Invoice i : invoiceList) {
            ivms.add(buildInvoiceViewModel(i));
        }
        return ivms;
    }

    public InvoiceViewModel findInvoice(int invoiceId) {
        Invoice invoice = invoiceDao.getInvoice(invoiceId);
        if (invoice == null)
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public void deleteInvoice(int invoiceId) {
        invoiceDao.deleteInvoice(invoiceId);
    }

    public void updateInvoice(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();
        invoice.setName(ivm.getName());
        invoice.setStreet(ivm.getStreet());
        invoice.setCity(ivm.getCity());
        invoice.setState(ivm.getState());
        invoice.setZipcode(ivm.getZipcode());
        invoice.setItemType(ivm.getItemType());
        invoice.setItemId(ivm.getItemId());
        invoice.setQuantity(ivm.getQuantity());
        invoiceDao.updateInvoice(invoice);
    }

    @Transactional
    public ConsoleViewModel saveConsole(ConsoleViewModel cvm) {
        Console console = new Console();
        console.setModel(cvm.getModel());
        console.setManufacturer(cvm.getManufacturer());
        console.setMemoryAmount(cvm.getMemoryAmount());
        console.setProcessor(cvm.getProcessor());
        console.setPrice(cvm.getPrice());
        console.setQuantity(cvm.getQuantity());

        console = consoleDao.addConsole(console);
        cvm.setConsoleId(console.getConsoleId());

        return cvm;
    }

    public List<ConsoleViewModel> findAllConsoles() {
        List<Console> consoleList = consoleDao.getAllConsoles();
        List<ConsoleViewModel> cvms = new ArrayList<>();

        for (Console c : consoleList) {
            cvms.add(buildConsoleViewModel(c));
        }
        return cvms;
    }

    public ConsoleViewModel findConsole(int consoleId) {
        Console console = consoleDao.getConsole(consoleId);
        if (console == null)
            return null;
        else
            return buildConsoleViewModel(console);
    }

    public void deleteConsole(int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    public void updateConsole(ConsoleViewModel cvm) {
        Console console = new Console();
        console.setModel(console.getModel());
        console.setManufacturer(console.getManufacturer());
        console.setMemoryAmount(console.getMemoryAmount());
        console.setProcessor(console.getProcessor());
        console.setPrice(cvm.getPrice());
        console.setQuantity(cvm.getQuantity());

        consoleDao.updateConsole(console);
    }

    public List<ConsoleViewModel> getConsolesByManufacturer(String manufacturer) {
        List<Console> consoleList = consoleDao.getConsolesByManufacturer(manufacturer);
        List<ConsoleViewModel> cvms = new ArrayList<>();

        for (Console c : consoleList) {
            cvms.add(buildConsoleViewModel(c));
        }
        return cvms;
    }

    @Transactional
    public GameViewModel saveGame(GameViewModel gvm) {
        Game game = new Game();
        game.setTitle(gvm.getTitle());
        game.setEsrbRating(gvm.getEsrbRating());
        game.setDescription(gvm.getDescription());
        game.setPrice(gvm.getPrice());
        game.setStudio(gvm.getStudio());
        game.setQuantity(gvm.getQuantity());

        game = gameDao.addGame(game);
        gvm.setGameId(game.getGameId());
        return gvm;
    }

    public List<GameViewModel> findAllGames() {
        List<Game> gameList = gameDao.getAllGames();
        List<GameViewModel> gvms = new ArrayList<>();

        for (Game g : gameList) {
            gvms.add(buildGameViewModel(g));
        }
        return gvms;
    }

    public GameViewModel findGame(int gameId) {
        Game game = gameDao.getGame(gameId);
        if (game == null)
            return null;
        else
            return buildGameViewModel(game);
    }

    public void deleteGame(int gameId) {
        gameDao.deleteGame(gameId);
    }

    public void updateGame(GameViewModel gvm) {
        Game game = new Game();
        game.setTitle(gvm.getTitle());
        game.setEsrbRating(gvm.getEsrbRating());
        game.setDescription(gvm.getDescription());
        game.setPrice(gvm.getPrice());
        game.setStudio(gvm.getStudio());
        game.setQuantity(gvm.getQuantity());
        gameDao.updateGame(game);
    }

    public List<GameViewModel> getGamesByEsrbRating(String esrbRating) {
        List<Game> gameList = gameDao.getGamesByEsrbRating(esrbRating);
        List<GameViewModel> gvms = new ArrayList<>();

        for (Game g : gameList) {
            gvms.add(buildGameViewModel(g));
        }
        return gvms;
    }

    public List<GameViewModel> getGamesByTitle(String title) {
        List<Game> gameList = gameDao.getGamesByTitle(title);
        List<GameViewModel> gvms = new ArrayList<>();

        for (Game g : gameList) {
            gvms.add(buildGameViewModel(g));
        }
        return gvms;
    }

    public List<GameViewModel> getGamesByStudio(String studio) {
        List<Game> gameList = gameDao.getGamesByStudio(studio);
        List<GameViewModel> gvms = new ArrayList<>();

        for (Game g : gameList) {
            gvms.add(buildGameViewModel(g));
        }
        return gvms;
    }

    @Transactional
    public TshirtViewModel saveTshirt(TshirtViewModel tvm) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tvm.getSize());
        tshirt.setColor(tvm.getColor());
        tshirt.setDescription(tvm.getDescription());
        tshirt.setPrice(tvm.getPrice());
        tshirt.setQuantity(tvm.getQuantity());

        tshirt = tshirtDao.addTshirt(tshirt);
        tvm.setTshirtId(tshirt.getTshirtId());
        return tvm;
    }

    public List<TshirtViewModel> findAllTshirts() {
        List<Tshirt> tshirtList = tshirtDao.getAllTshirts();
        List<TshirtViewModel> tvms = new ArrayList<>();

        for (Tshirt t : tshirtList) {
            tvms.add(buildTshirtViewModel(t));
        }
        return tvms;
    }

    public TshirtViewModel findTshirt(int tshirtId) {
        Tshirt tshirt = tshirtDao.getTshirt(tshirtId);
        if (tshirt == null)
            return null;
        else
            return buildTshirtViewModel(tshirt);
    }

    public void deleteTshirt(int tshirtId) {
        tshirtDao.deleteTshirt(tshirtId);
    }

    public void updateTshirt(TshirtViewModel tvm) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tvm.getSize());
        tshirt.setColor(tvm.getColor());
        tshirt.setDescription(tvm.getDescription());
        tshirt.setPrice(tvm.getPrice());
        tshirt.setQuantity(tvm.getQuantity());
        tshirtDao.updateTshirt(tshirt);
    }

    public List<TshirtViewModel> getTshirtsByColor(String color) {
        List<Tshirt> tshirtList = tshirtDao.getTshirtsByColor(color);
        List<TshirtViewModel> tvms = new ArrayList<>();

        for (Tshirt t : tshirtList) {
            tvms.add(buildTshirtViewModel(t));
        }
        return tvms;
    }

    public List<TshirtViewModel> getTshirtsBySize(String size) {
        List<Tshirt> tshirtList = tshirtDao.getTshirtsBySize(size);
        List<TshirtViewModel> tvms = new ArrayList<>();

        for (Tshirt t : tshirtList) {
            tvms.add(buildTshirtViewModel(t));
        }
        return tvms;
    }

    //method to validate state code
    public String validateState(InvoiceViewModel ivm) {
        String userInputState = ivm.getState().toUpperCase();
        String validatedUserInputState = salesTaxRateDao.getSalesTaxRate(userInputState).getState();

        if (validatedUserInputState.equals(userInputState)) {
            state = userInputState;
        } else {
            throw new NotFoundException(userInputState + " is not a valid state.");
        }
        return state;
    }


    //method to validate product type
    public String validateProductType(InvoiceViewModel ivm) {
        String userProductType = ivm.getItemType().toLowerCase();

        if (userProductType.equals("consoles") || userProductType.equals("console")) {
            productType = "console";
        } else if (userProductType.equals("tshirts") || userProductType.equals("tshirt")) {
            productType = "tshirt";
        } else if (userProductType.equals("games") || userProductType.equals("game")) {
            productType = "game";
        } else {
            productType = "null";
        }
        return productType;
    }

    //method to validate product id
    public int validateItem(InvoiceViewModel ivm) {
        productType = validateProductType(ivm);
        productId = ivm.getItemId();

        switch (productType) {
            case "console":
                productId = consoleDao.getConsole(productId).getConsoleId();
                break;
            case "tshirt":
                productId = tshirtDao.getTshirt(productId).getTshirtId();
                break;
            case "game":
                productId = gameDao.getGame(productId).getGameId();
                break;
        }
        return productId;
    }

    //method to validate inventory
    public int validateAndUpdateInventory(InvoiceViewModel ivm) {
        productType = validateProductType(ivm);
        productId = validateItem(ivm);
        quantity = ivm.getQuantity();
        int inventory;

        if (quantity > 1) {
            switch (productType) {
                case "console":
                    inventory = consoleDao.getConsole(productId).getQuantity();
                    if (inventory >= quantity) {
                        Console console = new Console();
                        console.setQuantity(inventory - quantity);
                        consoleDao.updateConsole(console);
                    }
                    break;
                case "tshirt":
                    inventory = tshirtDao.getTshirt(productId).getQuantity();
                    if (inventory >= quantity) {
                        Tshirt tshirt = new Tshirt();
                        tshirt.setQuantity(inventory - quantity);
                        tshirtDao.updateTshirt(tshirt);
                    }
                    break;
                case "game":
                    inventory = gameDao.getGame(productId).getQuantity();
                    if (inventory >= quantity) {
                        Game game = new Game();
                        game.setQuantity(gameDao.getGame(productId).getQuantity() - quantity);
                        gameDao.updateGame(game);
                    }
                    break;
            }
        }
        return quantity;
    }

    //method to talk to database and grab the unit price matching the item id/type
    public BigDecimal getItemPrice(InvoiceViewModel ivm) {
        productType = validateProductType(ivm);
        int id = ivm.getItemId();

        switch (productType) {
            case "console":
                unitPrice = consoleDao.getConsole(id).getPrice();
                break;
            case "tshirt":
                unitPrice = tshirtDao.getTshirt(id).getPrice();
                break;
            case "game":
                unitPrice = gameDao.getGame(id).getPrice();
                break;
        }
        return unitPrice;
    }

    //method for unit price (quantity * productType price)
    public BigDecimal calculateSubtotal(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();
        BigDecimal quantity = new BigDecimal(ivm.getQuantity());
        subtotal = quantity.multiply(unitPrice);

        invoice.setSubtotal(subtotal);
        return subtotal;
    }

    //method to calculate sales tax
    public BigDecimal calculateSalesTax(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();
        state = validateState(ivm);
//        state = ivm.getState();
        salesTax = salesTaxRateDao.getSalesTaxRate(state).getRate();

        invoice.setTax(salesTax);
        return salesTax;
    }

    //method to calculate processing fees, fees is additional 15.49 if more than 10 items
    public BigDecimal calculateProcessingFees(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();

        String type = validateProductType(ivm) + "s";
        int quantity = ivm.getQuantity();

        processingFee = processingFeeDao.getProcessingFee(type).getFee();

        if (quantity > 10) {
            processingFee = processingFee.add(new BigDecimal("15.49"));
        }
        invoice.setProcessingFee(processingFee);
        return processingFee;
    }

    //method to calculate customer total
    public BigDecimal calculateTotal() {
        Invoice invoice = new Invoice();

        BigDecimal tax = subtotal.multiply(salesTax);
        total = subtotal.add(tax).add(processingFee);

        invoice.setTotal(total);
        return total;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        return ivm;
    }

    private ConsoleViewModel buildConsoleViewModel(Console console) {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setConsoleId(console.getConsoleId());
        cvm.setModel(console.getModel());
        cvm.setManufacturer(console.getManufacturer());
        cvm.setMemoryAmount(console.getMemoryAmount());
        cvm.setProcessor(console.getProcessor());
        cvm.setPrice(console.getPrice());
        cvm.setQuantity(console.getQuantity());

        return cvm;
    }

    private GameViewModel buildGameViewModel(Game game) {
        GameViewModel gvm = new GameViewModel();
        gvm.setGameId(game.getGameId());
        gvm.setTitle(game.getTitle());
        gvm.setEsrbRating(game.getEsrbRating());
        gvm.setDescription(game.getDescription());
        gvm.setPrice(game.getPrice());
        gvm.setStudio(game.getStudio());
        gvm.setQuantity(game.getQuantity());

        return gvm;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {
        TshirtViewModel tvm = new TshirtViewModel();
        tvm.setTshirtId(tshirt.getTshirtId());
        tvm.setSize(tshirt.getSize());
        tvm.setColor(tshirt.getColor());
        tvm.setDescription(tshirt.getDescription());
        tvm.setPrice(tshirt.getPrice());
        tvm.setQuantity(tshirt.getQuantity());

        return tvm;
    }

}

//1. Sales tax applies only to the cost of the items.
//2. Sales tax does not apply to any processing fees for an invoice.
//3. The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an *additional* processing fee of $15.49 is applied to the order.
//4. The order process logic must properly update the quantity on hand for the item in the order.
//5. Order quantity must be greater than zero.
//6. Order quantity must be less than or equal to the number of items on hand in inventory.
//7. Order must contain a valid state code.
//8. The REST API must properly handle and report all violations of business rules.