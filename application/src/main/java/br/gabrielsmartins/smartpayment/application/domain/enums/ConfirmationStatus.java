package br.gabrielsmartins.smartpayment.application.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfirmationStatus {

    RECEIVED("RECEIVED"),
    STARTED("STARTED"),
    ACCEPTED("ACCEPTED"),
    REJECTED("REJECTED");

    private final String description;


}
