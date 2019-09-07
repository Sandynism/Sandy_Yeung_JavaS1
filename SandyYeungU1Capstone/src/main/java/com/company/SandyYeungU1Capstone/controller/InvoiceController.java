package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.exception.NotFoundException;
import com.company.SandyYeungU1Capstone.service.InvoiceServiceLayer;
import com.company.SandyYeungU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InvoiceController {
    @Autowired
    InvoiceServiceLayer invoiceService;

    @RequestMapping(value="/invoices/add", method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel createInvoice(@RequestBody InvoiceViewModel invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @RequestMapping(value="/invoices", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @RequestMapping(value="/invoice/{invoiceId}", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable(name="invoiceId") int invoiceId) {
        InvoiceViewModel invoice = invoiceService.findInvoice(invoiceId);
        if (invoice == null)
            throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
        return invoice;
    }

    @RequestMapping(value="/invoice/{invoiceId}", method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable(name="invoiceId") int invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
    }

    @RequestMapping(value="/invoice/{invoiceId}", method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateInvoice(@RequestBody InvoiceViewModel invoice) {
        invoiceService.updateInvoice(invoice);
    }

}
