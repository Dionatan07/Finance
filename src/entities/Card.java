package entities;

import java.util.Date;

public class Card {

    private Integer id;
    private String description;
    private String flag;
    private Double limitCard;
    private Date closingDay;
    private Date paymentDay;

    public Card() {
    }

    public Card(Integer id, String description, String flag, Double limitCard, Date closingDay, Date paymentDay) {
        this.id = id;
        this.description = description;
        this.flag = flag;
        this.limitCard = limitCard;
        this.closingDay = closingDay;
        this.paymentDay = paymentDay;
    }

    public Card(String description, String flag, Double limitCard, Date closingDay, Date paymentDay) {
        this.description = description;
        this.flag = flag;
        this.limitCard = limitCard;
        this.closingDay = closingDay;
        this.paymentDay = paymentDay;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Double getLimitCard() {
        return limitCard;
    }

    public void setLimitCard(Double limitCard) {
        this.limitCard = limitCard;
    }

    public Date getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(Date closingDay) {
        this.closingDay = closingDay;
    }

    public Date getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(Date paymentDay) {
        this.paymentDay = paymentDay;
    }
}
