package com.smartpricing.model.enums;

import lombok.Getter;

@Getter
public enum InvoiceStatus {
    PENDENTE,
    PROCESSADA,
    ERRO,
    CANCELADA
}