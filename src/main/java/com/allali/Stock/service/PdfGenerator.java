package com.allali.Stock.service;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.entitie.Transition;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfGenerator {

    public byte[] generatePDF(Client client) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf, PageSize.A4)) {

            // Add header
            Paragraph header = new Paragraph("Stock Manager")
                    .setBold()
                    .setFontSize(16)
                    .setMarginBottom(20);
            document.add(header);

            // Add client information
            document.add(new Paragraph("Client Information:").setBold());
            Table clientInfoTable = new Table(2);
            clientInfoTable.addCell("ID:");
            clientInfoTable.addCell(client.getId().toString());
            clientInfoTable.addCell("First Name:");
            clientInfoTable.addCell(client.getFirstName());
            clientInfoTable.addCell("Last Name:");
            clientInfoTable.addCell(client.getLastName());
            clientInfoTable.addCell("Email:");
            clientInfoTable.addCell(client.getEmail());
            clientInfoTable.addCell("Address:");
            clientInfoTable.addCell(client.getAddress());
            clientInfoTable.addCell("Phone:");
            clientInfoTable.addCell(client.getPhoneNumber());
            document.add(clientInfoTable);

            // Add transaction history
            document.add(new Paragraph("\nTransaction History:").setBold());
            Table transactionTable = new Table(4);
            transactionTable.addCell("Transaction ID");
            transactionTable.addCell("Date");
            transactionTable.addCell("Description");
            transactionTable.addCell("Amount");

            List<Transition> transitionList = client.getTransitionList();
            for (Transition transition : transitionList) {
                transactionTable.addCell(String.valueOf(transition.getId()));
                transactionTable.addCell(transition.getTransactionDate().toString()); // Adjust date format as needed
                transactionTable.addCell(transition.getTransitionType().name());
                transactionTable.addCell(String.valueOf(transition.getTotalAmount()));
            }
            document.add(transactionTable);

            // Add footer
            Paragraph footer = new Paragraph("\nContact Information\nPhone: [06661201254] | Email: stockmanager@gmail.com\n")
                    .setFontSize(10);
            document.add(footer);

            // Close the document
            document.close();

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}