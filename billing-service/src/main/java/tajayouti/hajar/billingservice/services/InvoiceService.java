package tajayouti.hajar.billingservice.services;

import tajayouti.hajar.billingservice.dto.InvoiceRequestDTO;
import tajayouti.hajar.billingservice.dto.InvoiceResponseDTO;
import tajayouti.hajar.billingservice.entities.Invoice;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> InvoiceByCustomerId(String customerId);
    List<InvoiceResponseDTO> getAllInvoice();


}
