package kr.co.seoulit.erp.logistic.sales.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="SALES_PLAN")
public class SalesPlane {
    @Id
    private String salesPlanNo;

    private String itemCode;

    private String itemName;

    private String unitOfSales;

    private String salesPlanDate;

    private String dueDateOfSales;

    private String salesAmount;

    private String unitPriceOfSales;

    private String sumPriceOfSales;

    private String mpsApplyStatus;

    private String description;




}
