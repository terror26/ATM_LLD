package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {
    String pin = "1432";
    BankAccount bankAccount;

}
