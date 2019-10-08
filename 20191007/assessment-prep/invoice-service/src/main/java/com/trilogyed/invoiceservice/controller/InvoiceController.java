package com.trilogyed.invoiceservice.controller;

import com.trilogyed.invoiceservice.model.Invoice;
import com.trilogyed.invoiceservice.repository.InvoiceItemRepository;
import com.trilogyed.invoiceservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository ir;

    @GetMapping(value = "/{invoiceId}")
    public Invoice findInvoice(@PathVariable Integer invoiceId) {
        Optional<Invoice> invoice = ir.findById(invoiceId);

        return invoice.orElse(null);
    }

    @GetMapping
    public List<Invoice> findAllInvoices() {
        return ir.findAll();
    }

    @PostMapping
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        return ir.save(invoice);
    }

    @PutMapping(value = "/{invoiceId}")
    public void updateInvoice(@RequestBody Invoice invoice, @PathVariable Integer invoiceId) {
        if (invoice.getInvoiceId() == null) {
            invoice.setInvoiceId(invoiceId);
        }

        if (invoice.getInvoiceId() != invoiceId) {
            throw new IllegalArgumentException("Invoice ID must match the parameter given.");
        }

        ir.save(invoice);
    }

    @DeleteMapping(value="/{invoiceId}")
    public void deleteInvoice(@PathVariable Integer invoiceId) {
        ir.deleteById(invoiceId);
    }

}
