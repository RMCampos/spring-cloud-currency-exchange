package com.ricardo.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {

  @Id
  private Long id;

  @Column(name = "currency_from")
  private String from;

  @Column(name = "currency_to")
  private String to;
  private BigDecimal conversionMultiple;
  private String environment;

  public CurrencyExchange() {
    this(0L, "", "", BigDecimal.ZERO);
  }

  public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
    super();
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  @Override
  public String toString() {
    return "CurrencyExchange{" +
        "id=" + id +
        ", from='" + from + '\'' +
        ", to='" + to + '\'' +
        ", conversionMultiple=" + conversionMultiple +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyExchange that = (CurrencyExchange) o;
    return id.equals(that.id) && from.equals(that.from) && to.equals(that.to)
        && conversionMultiple.equals(that.conversionMultiple);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, from, to, conversionMultiple);
  }

  public String getEnvironment() {
    return environment;
  }

  public void setEnvironment(String environment) {
    this.environment = environment;
  }
}
