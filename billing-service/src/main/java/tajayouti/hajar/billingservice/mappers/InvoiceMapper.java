package tajayouti.hajar.billingservice.mappers;

import org.mapstruct.Mapper;
import tajayouti.hajar.billingservice.dto.InvoiceRequestDTO;
import tajayouti.hajar.billingservice.dto.InvoiceResponseDTO;
import tajayouti.hajar.billingservice.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice invoiceRequestToInvoice(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);


}
