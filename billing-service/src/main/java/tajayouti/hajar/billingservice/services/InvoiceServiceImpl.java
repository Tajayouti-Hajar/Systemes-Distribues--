package tajayouti.hajar.billingservice.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tajayouti.hajar.billingservice.dto.InvoiceRequestDTO;
import tajayouti.hajar.billingservice.dto.InvoiceResponseDTO;
import tajayouti.hajar.billingservice.entities.Customer;
import tajayouti.hajar.billingservice.entities.Invoice;
import tajayouti.hajar.billingservice.exception.CustomerNotFounfException;
import tajayouti.hajar.billingservice.mappers.InvoiceMapper;
import tajayouti.hajar.billingservice.openfeign.CustomerRestClient;
import tajayouti.hajar.billingservice.repositories.InvoiceRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;


    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        //rec un customer
        Customer customer=null;
        try {
            customer=customerRestClient.getCustomer(invoiceRequestDTO.getCustomerID());
        }catch (Exception e)
        {
             throw new CustomerNotFounfException("Customer Not Found");
        }
        Invoice invoice=invoiceMapper.invoiceRequestToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());//
        invoice.setDate(new Date());
        
        Invoice saveInvoice=invoiceRepository.save(invoice);
        invoice.setCustomer(customer); //
        return invoiceMapper.invoiceToInvoiceResponseDTO(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
    }


    @Override
    public List<InvoiceResponseDTO> getAllInvoice() {
       List<Invoice>  invoices=invoiceRepository.findAll();
        for (Invoice invoice: invoices)  //Pour chaque invoice de la list invoices.... je vais recupere invoice de custemer
        {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        List<InvoiceResponseDTO> invoiceResponseDTOS= invoices.stream()
                .map(inv -> invoiceMapper.invoiceToInvoiceResponseDTO(inv)).collect(Collectors.toList());
        return invoiceResponseDTOS;
    }

    @Override
    public List<InvoiceResponseDTO> InvoiceByCustomerId(String customerId) {
        List<Invoice> invoices=invoiceRepository.findByCustomerID(customerId);
        for (Invoice invoice: invoices)
        {
            Customer customer=customerRestClient.getCustomer(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }

        List<InvoiceResponseDTO> invoiceResponseDTOList=invoices.stream()
                .map(inv ->invoiceMapper.invoiceToInvoiceResponseDTO(inv)).collect(Collectors.toList());

        return invoiceResponseDTOList;
    }
}
