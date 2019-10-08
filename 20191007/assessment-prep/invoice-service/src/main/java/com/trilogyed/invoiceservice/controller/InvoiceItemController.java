package com.trilogyed.invoiceservice.controller;

import com.trilogyed.invoiceservice.model.InvoiceItem;
import com.trilogyed.invoiceservice.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/invoiceItems")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemRepository iir;

    @GetMapping(value = "/{invoiceItemId}")
    public InvoiceItem findInvoiceItem(@PathVariable Integer invoiceItemId) {
        Optional<InvoiceItem> invoiceItem = iir.findById(invoiceItemId);

        return invoiceItem.orElse(null);
    }

    @GetMapping
    public List<InvoiceItem> findAllInvoiceItems() {
        return iir.findAll();
    }

    @PostMapping
    public InvoiceItem saveInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
        return iir.save(invoiceItem);
    }

    @PutMapping(value = "/{invoiceItemId}")
    public void updateInvoiceItem(@RequestBody InvoiceItem invoiceItem, @PathVariable Integer invoiceItemId) {
        if (invoiceItem.getInvoiceItemId() == null) {
            invoiceItem.setInvoiceItemId(invoiceItemId);
        }

        if (invoiceItem.getInvoiceItemId() != invoiceItemId) {
            throw new IllegalArgumentException("Invoice Item ID must match the parameter given.");
        }

        iir.save(invoiceItem);
    }

    @DeleteMapping(value="/{invoiceItemId}")
    public void deleteInvoiceItem(@PathVariable Integer invoiceItemId) {
        iir.deleteById(invoiceItemId);
    }


}
