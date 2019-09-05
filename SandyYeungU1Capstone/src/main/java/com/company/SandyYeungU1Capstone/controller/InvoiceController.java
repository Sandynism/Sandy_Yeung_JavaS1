package com.company.SandyYeungU1Capstone.controller;

import com.company.SandyYeungU1Capstone.dao.InvoiceDao;
import com.company.SandyYeungU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceDao invoiceDao;

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody @Valid Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        return invoiceDao.getAllInvoices();
    }

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoice(@PathVariable(name="invoiceId") int invoiceId) {
        return invoiceDao.getInvoice(invoiceId);
    }

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable(name="invoiceId") int invoiceId) {
        invoiceDao.deleteInvoice(invoiceId);
    }

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateInvoice(@RequestBody @Valid Invoice invoice) {
        invoiceDao.updateInvoice(invoice);
    }

}
