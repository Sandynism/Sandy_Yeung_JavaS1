package com.trilogyed.shippingservice.service;

import com.trilogyed.shippingservice.InvoiceServiceClient;
import com.trilogyed.shippingservice.viewModels.Invoice;
import com.trilogyed.shippingservice.viewModels.InvoiceItem;
import com.trilogyed.shippingservice.viewModels.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private InvoiceServiceClient isc;

    @Autowired
    public ServiceLayer(InvoiceServiceClient isc) {
        this.isc = isc;
    }

    public InvoiceViewModel saveInvoice(InvoiceViewModel ivm) {

        Invoice invoice = new Invoice();
        invoice.setCustomerId(ivm.getCustomerId());
        invoice.setShipToZip(ivm.getShipToZip());
        invoice.setPurchaseDate(ivm.getPurchaseDate());
        invoice.setTotalCost(ivm.getTotalCost());
        invoice.setSalesTax(ivm.getSalesTax());
        invoice.setSurcharge(ivm.getSurcharge());

        invoice = isc.saveInvoice(invoice);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();

        invoiceViewModel.setCustomerId(invoice.getCustomerId());
        invoiceViewModel.setShipToZip(invoice.getShipToZip());
        invoiceViewModel.setPurchaseDate(invoice.getPurchaseDate());
        invoiceViewModel.setTotalCost(invoice.getTotalCost());
        invoiceViewModel.setSalesTax(invoice.getSalesTax());
        invoiceViewModel.setSurcharge(invoice.getSurcharge());

//        if (ivm.getInvoiceItemList() == null) {
//            invoiceViewModel.setInvoiceItemList(null);
//        } else {
//            List<InvoiceItem> invoiceItemList = isc.findAllInvoiceItems();
//            List<InvoiceItem> invoiceItemModels = new ArrayList<>();
//
//            for (InvoiceItem i : invoiceItemList) {
//                if (i.getInvoiceId() == invoice.getInvoiceId()) {
//                    invoiceItemModels.add(i);
//                }
//            }
//            invoiceViewModel.setInvoiceItemList(isc.findInvoiceItem());
//        }

        return ivm;

    }
}
