package com.company.SandyYeungU1Capstone.dao;

import com.company.SandyYeungU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    List<Invoice> getAllInvoices();

    Invoice getInvoice(int invoiceId);

    Invoice addInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);

    void updateInvoice(Invoice invoice);
}
