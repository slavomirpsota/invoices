package org.psota.invoices.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Unit {
  MD("man/day");

  private String value;
}
