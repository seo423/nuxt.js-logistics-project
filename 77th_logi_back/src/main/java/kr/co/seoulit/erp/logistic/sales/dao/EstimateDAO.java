package kr.co.seoulit.erp.logistic.sales.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.erp.logistic.sales.to.UpdateEstimateTO;
import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.erp.logistic.sales.to.EstimateTO;

@Mapper
public interface EstimateDAO {

	public EstimateTO selectEstimate(String estimateNo);

	public int selectEstimateCount(String estimateDate);

	public void insertEstimate(EstimateTO TO);

	public void updateEstimate(EstimateTO TO);

	public void changeContractStatusOfEstimate(HashMap<String, String> param);

	public ArrayList<EstimateTO> selectEstimateList(HashMap<String, String> param);

	public void updateEstimates(UpdateEstimateTO updateEstimateTO);

	public void updateEstimateDetail(UpdateEstimateTO updateEstimateTO);

	public void deleteByEstimate(String estimateNo);

	public void deleteByEstimateDetail(String estimateNo);

	public void deleteByContract(String contractNo);

	public void deleteByContractDetail(String contractNo);


}
