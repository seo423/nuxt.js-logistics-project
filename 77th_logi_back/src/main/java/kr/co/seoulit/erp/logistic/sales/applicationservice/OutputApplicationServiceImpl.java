package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.purchase.dao.StockDAO;
import kr.co.seoulit.erp.logistic.sales.dao.ContractDAO;
import kr.co.seoulit.erp.logistic.sales.dao.OutputDAO;
import kr.co.seoulit.erp.logistic.sales.to.OutputTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class OutputApplicationServiceImpl implements OutputApplicationService{

    private ModelMap modelMap=new ModelMap();
    @Autowired
    private OutputDAO outputDAO;
    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private ContractDAO contractDAO;

    public ModelMap getOutputList() {
        try {

            ArrayList<OutputTO> outputList = outputDAO.getOutputList();
            modelMap.put("outputList", outputList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");

        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());

        }
        return modelMap;
    }

    @Override
    public ModelMap getOutputDetailList(String outputNumber) {
        Iterable<OutputTO> outputDetailList= outputDAO.getOutputDetailList(outputNumber);
        modelMap.put("outputInfo", outputDetailList);

        return modelMap;
    }

    // 출고번호생성
    @Override
    public Map<String, Object> addNewOutput(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        System.out.println("출고 params: " + params);
        try {
            // 출고번호 생성
            String lastNo;
            String generatedOutputNumber;

            if (outputDAO.getOutputMaxNo() == null) {
                // outputDAO.getOutputMaxNo()가 null인 경우 오늘 날짜를 기반으로 생성된 출고번호 생성
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                lastNo = sdf.format(new Date()) + "00";
            } else {
                String getNum = outputDAO.getOutputMaxNo().substring(2);
                int getNum2 = Integer.parseInt(getNum)+1;

                if (getNum2 >= 10) {
                    lastNo = Integer.toString(getNum2);
                } else {
                    lastNo = '0' + Integer.toString(getNum2);
                }
            }

            generatedOutputNumber = "SR" + lastNo;

            params.put("outputNumber", generatedOutputNumber);

            String contractNo = (String) params.get("contractNo");
            String requestQuantity = (String) params.get("requestQuantity");
            String itemName = (String) params.get("itemName");

            System.out.println("params>>>" + params);
            outputDAO.addNewOutput(params);

            //수주 테이블의 출고완료여부 업데이트
            Map<String, Object> map = new HashMap<>();
            map.put("condition", true);
            map.put("contractNo", contractNo);
            contractDAO.updateShipmentStatusOfContract(map);

            //재고 테이블의 납품및출고예정재고량 업데이트
            HashMap<String, Object> mapForUpdateStock = new HashMap<>();
            mapForUpdateStock.put("itemName",itemName);
            mapForUpdateStock.put("requestQuantity", requestQuantity);
            mapForUpdateStock.put("condition", true);
            stockDAO.updateStockAfterShipment(mapForUpdateStock);

            // 결과에 생성된 출고번호 추가
            result.put("generatedOutputNumber", generatedOutputNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");



        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

//    @Override
//    public void insertOutput(OutputTO outputList) {
//        outputDAO.insertOutput(outputList);
//    }

    @Override
    public void deleteOutput(Map<String, String> map) {
        Map<String, Object> param = new HashMap<>();
        System.out.println("deleteOutput>>>>" + map);
        param.put("condition", false);
        param.put("contractNo", map.get("contractNo"));

        //재고 테이블의 납품및출고예정재고량 업데이트
        HashMap<String, Object> mapForUpdateStock = new HashMap<>();
        mapForUpdateStock.put("itemName", map.get("itemName"));
        mapForUpdateStock.put("requestQuantity", map.get("requestQuantity"));
        mapForUpdateStock.put("condition", false);
        stockDAO.updateStockAfterShipment(mapForUpdateStock);

        //등록되어 있던 출고를 삭제하면 수주의 출고 완료 여부를 다시 업데이트
        contractDAO.updateShipmentStatusOfContract(param);
        outputDAO.deleteOutput(map.get("outputNumber"));
    }
}
