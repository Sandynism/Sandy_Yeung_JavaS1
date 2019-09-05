package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsoleController {
    @Autowired
    InvoiceServiceLayer invoiceService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel console) {
        return invoiceService.saveConsole(console);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return invoiceService.findAllConsoles();
    }

    @GetMapping("/{consoleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable(name = "consoleId") int consoleId) {
        ConsoleViewModel console = invoiceService.findConsole(consoleId);
        if (console == null)
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        return console;
    }

    @DeleteMapping("/{consoleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteConsole(@PathVariable(name = "consoleId") int consoleId) {
        invoiceService.deleteConsole(consoleId);
    }

    @PutMapping("/{consoleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel console) {
        invoiceService.updateConsole(console);
    }

    @GetMapping("/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ConsoleViewModel> getConsolesByManufacturer(@PathVariable(name = "manufacturer") String manufacturer) {
        return invoiceService.getConsolesByManufacturer(manufacturer);
    }
}


//@RestController
//@RequestMapping("/invoice")
//public class InvoiceInventoryController {
//
//    @Autowired
//    InvoiceInventoryService inventoryService;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoice) {
//        return inventoryService.saveInvoice(invoice);
//    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    //As per requirement this method is not needed
//    public InvoiceViewModel getInvoice(@PathVariable("id") int id) {
//        InvoiceViewModel invoice = inventoryService.findInvoice(id);
//        if (invoice == null)
//            throw new NotFoundException("Invoice could not be retrieved for id " + id);
//        return invoice;
//    }
//
//    @GetMapping("/customer/{customerId}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceViewModel> getInvoiceByCustomer(@PathVariable("customerId") int customerId) {
//        List<InvoiceViewModel> invoices = inventoryService.findInvoiceByCustomer(customerId);
//        if (invoices != null && invoices.size() == 0)
//            throw new NotFoundException("Invoice could not be retrieved for customer " + customerId);
//        return invoices;
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteInvoice(@PathVariable int id) {
//        inventoryService.removeInvoice(id);
//    }
//}