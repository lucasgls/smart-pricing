package com.smartpricing.repository;

import com.smartpricing.model.Invoice;
import com.smartpricing.model.enums.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {

}
