package com.allali.Stock.controllers;

import com.allali.Stock.entitie.Client;
import com.allali.Stock.service.PdfGenerator;
import com.allali.Stock.service.users.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pdf")
@AllArgsConstructor
public class PdfController {

    private UserService userService ;
    private PdfGenerator pdfGenerator ;

    @GetMapping("/download/{clientId}")
    public ResponseEntity<byte[]> downloadPDF(@PathVariable("clientId") Long clientId) {
        // Retrieve client information from the service
        Client client = (Client) userService.getUser(clientId);
        if (client == null) {
            return ResponseEntity.notFound().build(); // Return 404 if client not found
        }

        // Generate PDF byte array
        byte[] pdfBytes = pdfGenerator.generatePDF(client);

        // Set HTTP headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "client_details.pdf");
        headers.setContentLength(pdfBytes.length);

        // Return the PDF as a response entity
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
