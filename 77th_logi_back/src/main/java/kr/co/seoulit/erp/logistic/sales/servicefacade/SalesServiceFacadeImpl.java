package kr.co.seoulit.erp.logistic.sales.servicefacade;

import java.text.SimpleDateFormat;
import java.util.*;

import kr.co.seoulit.erp.logistic.sales.applicationservice.*;
import kr.co.seoulit.erp.logistic.sales.dao.EstimateDAO;
import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.entity.SalesPlane;
import kr.co.seoulit.erp.logistic.sales.repository.SalesPlaneRepository;
import kr.co.seoulit.erp.logistic.sales.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import org.springframework.ui.ModelMap;

@Service
public class SalesServiceFacadeImpl implements SalesServiceFacade {

	@Autowired
	private EstimateApplicationService estimateAS;
	@Autowired
	private ContractApplicationService contractAS;
	@Autowired
	private SalesPlanApplicationService salesPlanAS;
	@Autowired
	private DeliveryApplicationService deliveryAS;
	@Autowired
	private OutputApplicationService outputAS;
	@Autowired
	private SalesPlaneRepository salesPlaneRepository;
	@Autowired
	private ClientDeliveryApplicationService clientDeliveryAS;
	@Autowired
	private ReturnApplicationService returnAS;
	@Autowired
	private ReturnStockApplicationService returnStockAS;
	@Autowired
	private EstimateDAO estimateDAO;

	@Override
	public ArrayList<EstimateTO> getEstimateList(String dateSearchCondition, String startDate, String endDate) {

		return estimateAS.getEstimateList(dateSearchCondition, startDate, endDate);
	}

	@Override
	public ArrayList<EstimateDetailTO> getEstimateDetailList(String estimateNo) {

		return estimateAS.getEstimateDetailList(estimateNo);
	}

	@Override
	public ArrayList<logisticExelTO> getLogisticExel(String estimateNo) {

		return estimateAS.getLogisticExel(estimateNo);
	}

	@Override
	public HashMap<String, Object> addNewEstimate(String estimateDate, EstimateTO newEstimateTO) {

		return estimateAS.addNewEstimate(estimateDate, newEstimateTO);
	}

	@Override
	public HashMap<String, Object> batchEstimateDetailListProcess(ArrayList<EstimateDetailTO> estimateDetailTOList) {

		return estimateAS.batchEstimateDetailListProcess(estimateDetailTOList);
	}

	@Override
	public ArrayList<ContractInfoTO> getContractList(String startDate, String endDate) {

		return contractAS.getContractList(startDate, endDate);
	}

	// 출고를 위한 수주조회
	@Override
	public ArrayList<ContractInfoTO> getContractOutputList(String startDate, String endDate) {

		return contractAS.getContractOutputList(startDate, endDate);
	}

	@Override
	public ArrayList<ContractInfoTO> getContractListByCustomer(String customerCode) {
		return contractAS.getContractListByCustomer(customerCode);
	}
	@Override
	public ArrayList<ContractInfoTO> getContractOutputListByCustomer(String customerCode) {
		return contractAS.getContractOutputListByCustomer(customerCode);
	}

	@Override
	public ArrayList<ContractInfoTO> getDeliverableContractList(String searchCondition, String[] paramArray) {
		return contractAS.getDeliverableContractList(searchCondition, paramArray);
	}

	@Override
	public ArrayList<ContractDetailTO> getContractDetailList(String estimateNo) {

		return contractAS.getContractDetailList(estimateNo);
	}

	@Override
	public ArrayList<ContractDetailTO> getContractOutputDetailList(String contractNo) {

		return contractAS.getContractOutputDetailList(contractNo);
	}

	@Override
	public ArrayList<EstimateTO> getEstimateListInContractAvailable(String startDate, String endDate) {

		return contractAS.getEstimateListInContractAvailable(startDate, endDate);
	}

//************************* 2020.09.04 63기 양지훈 수정 시작 *************************
//	description:	파라미터 타입 & 이름 변경

	@Override
	public HashMap<String, Object> addNewContract(String contractDate, String personCodeInCharge,
												  ContractTO workingContractTO, ArrayList<EstimateDetailTO> estimateDetailArray,
												  String shipmentCompletionStatus) {

		return contractAS.addNewContract(contractDate, personCodeInCharge, workingContractTO, estimateDetailArray, shipmentCompletionStatus);
	}

//************************* 2020.09.04 63기 양지훈 수정 종료 *************************

	@Override
	public HashMap<String, Object> batchContractDetailListProcess(ArrayList<ContractDetailTO> contractDetailTOList) {

		return contractAS.batchContractDetailListProcess(contractDetailTOList);

	}

	@Override
	public void changeContractStatusInEstimate(String estimateNo, String contractStatus) {

		contractAS.changeContractStatusInEstimate(estimateNo, contractStatus);
	}

	@Override
	public ArrayList<SalesPlanTO> getSalesPlanList(String dateSearchCondition, String startDate, String endDate) {

		return salesPlanAS.getSalesPlanList(dateSearchCondition, startDate, endDate);
	}

	@Override
	public void batchSalesPlanListProcess(SalesPlanTO salesPlanTOList) {
		System.out.println("batchSalesPlanListProcess =" + salesPlanTOList);
		salesPlanAS.batchSalesPlanListProcess(salesPlanTOList);
	}

	@Override
	public ArrayList<DeliveryInfoTO> getDeliveryInfoList() {

		return deliveryAS.getDeliveryInfoList();
	}

	@Override
	public HashMap<String, Object> batchDeliveryListProcess(List<DeliveryInfoTO> deliveryTOList) {

		return deliveryAS.batchDeliveryListProcess(deliveryTOList);
	}

	@Override
	public HashMap<String, Object> deliver(String contractDetailNo) {

		return deliveryAS.deliver(contractDetailNo);
	}

	// 미노
	@Override
	public Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate(Map<String, ArrayList<DeliveryInfoTO>> deliverUpdate) {

		return deliveryAS.deliverUpdate(deliverUpdate);
	}

	@Override
	public ArrayList<SalesPlanTO> getSalesPlan() {

		ArrayList<SalesPlanTO> SalesPlan = null;

		try {

			SalesPlan = salesPlanAS.getSalesPlan();

		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}

		return SalesPlan;
	}

	@Override
	public void UpdateSalesPlanListProcess(SalesPlanTO salesPlanTOList) {
		salesPlanAS.UpdateSalesPlan(salesPlanTOList);
	}

	public List<SalesPlane> findSalesPlan() {
		List<SalesPlane> all = salesPlaneRepository.findAll();
		return all;
	}

	public List<SalesPlane> findSalesPlanByDate(String startDate, String endDate){
		List<SalesPlane> salesPlanList = salesPlaneRepository.findBySalesPlanDateBetweenAndDueDateOfSalesBetweenAndMpsApplyStatus(startDate,endDate,startDate,endDate,"N");
		return salesPlanList;
	}

	@Override
	public void salesplansave(SalesPlane salesPlan) {
		try {
			// 출고번호 생성
			String lastNo;
			String generatedOutputNumber;

			if (salesPlaneRepository.findMaxSalesPlanNo() == null) {
				// outputDAO.getOutputMaxNo()가 null인 경우 오늘 날짜를 기반으로 생성된 출고번호 생성
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				lastNo = sdf.format(new Date()) + "00";
			} else {
				String getNum = salesPlaneRepository.findMaxSalesPlanNo().substring(2);
				int getNum2 = Integer.parseInt(getNum) + 1;

				if (getNum2 >= 10) {
					lastNo = Integer.toString(getNum2);
				} else {
					lastNo = '0' + Integer.toString(getNum2);
				}
			}

			generatedOutputNumber = "SP" + lastNo;

			salesPlan.setSalesPlanNo(generatedOutputNumber);

			salesPlaneRepository.save(salesPlan);

		} catch (Exception e) {
			System.out.println("errorMsg" + e.getMessage());
		}
	}


	@Override
	public void saelsplanupdate(SalesPlane salesPlan) {
		salesPlaneRepository.save(salesPlan);
	}

	@Override
	public void  deletesalesplan(String sales){
		salesPlaneRepository.deleteById(sales);
	}


	//출고관리
	@Override
	public ModelMap getOutputList() {
		return outputAS.getOutputList();
	}

	@Override
	public ModelMap getOutputDetailList(String outputNumber) {
		return outputAS.getOutputDetailList(outputNumber);
	}

	@Override
	public Map<String, Object> addNewOutput(Map<String, Object> params) {
		System.out.println("params? " + params);
		return outputAS.addNewOutput(params);
	}

//	@Override
//	public void insertOutput(OutputTO outputList) {
//		outputAS.insertOutput(outputList);
//	}

	@Override
	public void deleteOutput(Map<String, String> map) {
		outputAS.deleteOutput(map);
	}

	// 배송 서비스
	@Override
	public ModelMap getClientDeliveryList() {
		return clientDeliveryAS.getClientDeliveryList();
	}

	@Override
	public Map<String, Object> addNewClientDelivery(Map<String, Object> params) {
		return clientDeliveryAS.addNewClientDelivery(params);
	}

	@Override
	public void updateClientDelivery(ClientDelivery clientDelivery) {
		clientDeliveryAS.updateClientDelivery(clientDelivery);
	}

	@Override
	public void deleteClientDelivery(String deliveryNumber) {
		clientDeliveryAS.deleteClientDelivery(deliveryNumber);
	}

	//반품
	@Override
	public HashMap<String, Object> getReturnList(String startDate, String endDate) {
		return returnAS.getReturnList(startDate, endDate);
	}
	@Override
	public ModelMap returnListForStock(){
		return returnAS.returnListForStock();
	}
	@Override
	public void updateReturn(ReturnTO returnList){
		returnAS.updateReturn(returnList);
	}

	@Override
	public void deleteReturn(String returnNo) {
		returnAS.deleteReturn(returnNo);
	}

	@Override
	 public Map<String, Object> addReturn(Map<String, Object> params){
		return returnAS.addReturn(params);
	}

	//반품재고입고
	@Override
	public ArrayList<ReturnStockTO> searchReturnStockList(String itemCode) {
		return returnStockAS.searchReturnStockList(itemCode);
	}

	@Override
	public void deleteReturnStock(String rtrnRecNo) {
		returnStockAS.deleteReturnStock(rtrnRecNo);
	}

	@Override
	 public Map<String, Object> addReturnStock(Map<String, Object> params){
		return returnStockAS.addReturnStock(params);
	}

	@Override
	public int getUnitPriceOfEstimate(String itemCode) {
		return estimateAS.getUnitPriceOfEstimate(itemCode);
	}

	@Override
	public void updateEstimates(UpdateEstimateTO updateEstimateTO) {
		System.out.println("서비스단 updateEstimateTO = " + updateEstimateTO);
		estimateDAO.updateEstimates(updateEstimateTO);
		estimateDAO.updateEstimateDetail(updateEstimateTO);
	}

	@Override
	public void deleteEstimate(String estimateNo) {
		estimateDAO.deleteByEstimate(estimateNo);
		estimateDAO.deleteByEstimateDetail(estimateNo);
	}

	@Override
	public void deleteContract(String contractNo) {
		estimateDAO.deleteByContract(contractNo);
		estimateDAO.deleteByContractDetail(contractNo);
	}


}




