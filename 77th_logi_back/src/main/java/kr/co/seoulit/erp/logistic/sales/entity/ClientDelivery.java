package kr.co.seoulit.erp.logistic.sales.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="DELIVERY")
public class ClientDelivery {
    @Id
    private String outputNumber;
    private String deliveryNumber;
    private String itemName;
    private String Name;
    private String Tel;
    private String deliveryDate;
    private String warehouseCode;
    private String endingRoute;
    private String deliveryStatus;
}
