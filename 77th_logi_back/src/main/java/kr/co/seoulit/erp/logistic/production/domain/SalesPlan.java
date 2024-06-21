package kr.co.seoulit.erp.logistic.production.domain;

import kr.co.seoulit.erp.logistic.production.to.MpsTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Getter @Setter
@ToString
public class SalesPlan {

    @Id
    private String salesPlanNo;
    private int    unitPriceOfSales;
    private int    sumPriceOfSales;
    private String salesAmount;
    private String description;
    private String salesPlanDate;
    private String itemCode;
    private String dueDateOfSales;
    private String unitOfSales;
    private String mpsApplyStatus;
    private String itemName;

    @Transient
    private String PlanClassification;
    @Transient
    private String mpsPlanDate;
    @Transient
    private String scheduledEndDate;


    public SalesPlan() {
    }


}
