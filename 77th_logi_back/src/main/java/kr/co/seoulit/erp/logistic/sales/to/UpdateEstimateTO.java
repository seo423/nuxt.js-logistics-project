package kr.co.seoulit.erp.logistic.sales.to;

import jakarta.persistence.Transient;
import kr.co.seoulit.common.to.BaseTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateEstimateTO extends BaseTO {
	private String estimateNo;
	private String newCustomer;
	private String estimateDate;
	private String estimateRequester;
	private String newEffectiveDate;
	private String newDescription;
	private String itemCode;
	private String itemName;
	private String unitOfEstimate;
	private String newDueDate;
	private int newEstimateAmount;
	private int newUnitPriceOfEstimate;
	private int newSumPriceOfEstimate;

	private String contractStatus;
	@Transient
	private String customerName;

	private String personCodeInCharge;
	private String personNameCharge;

}
