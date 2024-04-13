package com.allali.Stock.service;
import com.allali.Stock.entitie.Client;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerator {

        public byte[] generatePDF(Client client) {
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            try {
                PdfWriter.getInstance(document, outputStream);
                document.open();

                // Add client information to the PDF
                document.add(new Paragraph("Client ID: " + client.getId()));
                document.add(new Paragraph("First Name: " + client.getFirstName()));
                document.add(new Paragraph("Last Name: " + client.getLastName()));
                document.add(new Paragraph("Email: " + client.getEmail()));
                document.add(new Paragraph("Address: " + client.getAddress()));
                document.add(new Paragraph("Phone Number: " + client.getPhoneNumber()));

                // Add transaction history
                document.add(new Paragraph("Transaction History:"));
                client.getTransitionList().forEach(transition ->
                {
                    try {
                        document.add(new Paragraph("Transaction ID: " + transition.getId()));
                    } catch (DocumentException e) {
                        throw new RuntimeException(e);
                    }
                });

                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            return outputStream.toByteArray();
        }
    }