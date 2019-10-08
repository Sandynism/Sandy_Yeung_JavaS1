package com.trilogyed.shippingservice;

import com.trilogyed.shippingservice.viewModels.Invoice;
import com.trilogyed.shippingservice.viewModels.InvoiceItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="invoice-service")
public interface InvoiceServiceClient {

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.GET)
    public Invoice findInvoice(@PathVariable Integer invoiceId);

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> findAllInvoices();

    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
    public Invoice saveInvoice(@RequestBody Invoice invoice);

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.PUT)
    public void updateInvoice(@RequestBody Invoice invoice, @PathVariable Integer invoiceId);

    @RequestMapping(value = "/invoices/{invoiceId}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable Integer invoiceId);


    @RequestMapping(value = "/invoiceItems/{invoiceItemId}",method = RequestMethod.GET)
    public InvoiceItem findInvoiceItem(@PathVariable Integer invoiceItemId);

    @RequestMapping(value = "/invoiceItems",method = RequestMethod.GET)
    public List<InvoiceItem> findAllInvoiceItems();

    @RequestMapping(value = "/invoiceItems",method = RequestMethod.POST)
    public InvoiceItem saveInvoiceItem(@RequestBody InvoiceItem invoiceItem);

    @RequestMapping(value = "/invoiceItems/{invoiceItemId}",method = RequestMethod.PUT)
    public void updateInvoiceItem(@RequestBody InvoiceItem invoiceItem, @PathVariable Integer invoiceItemId);

    @RequestMapping(value = "/invoiceItems/{invoiceItemId}",method = RequestMethod.DELETE)
    public void deleteInvoiceItem(@PathVariable Integer invoiceItemId);

}
