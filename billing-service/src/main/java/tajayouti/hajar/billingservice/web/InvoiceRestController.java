package tajayouti.hajar.billingservice.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tajayouti.hajar.billingservice.dto.InvoiceRequestDTO;
import tajayouti.hajar.billingservice.dto.InvoiceResponseDTO;
import tajayouti.hajar.billingservice.services.InvoiceService;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class InvoiceRestController {
private InvoiceService invoiceService;

    @GetMapping(path = "/invoices/{id}")
    InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
    return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable(name = "customerId") String customerId){
    return invoiceService.InvoiceByCustomerId(customerId);
    }


    @PostMapping(path = "/invoices")
    InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO)
    {
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping(path = "/invoices")
    List<InvoiceResponseDTO> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> ex(Exception e)
    {
        return new  ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
