package kr.co.seoulit.erp.logistic.sales.applicationservice;

import kr.co.seoulit.erp.logistic.purchase.dao.StockDAO;
import kr.co.seoulit.erp.logistic.sales.dao.ClientDeliveryDAO;
import kr.co.seoulit.erp.logistic.sales.dao.OutputDAO;
import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.to.ClientDeliveryTO;
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
public class ClientDeliveryApplicationServiceImpl implements ClientDeliveryApplicationService {
    private ModelMap modelMap=new ModelMap();
    @Autowired
    private ClientDeliveryDAO clientDeliveryDAO;

    @Autowired
    private OutputDAO outputDAO;

    @Autowired
    private StockDAO stockDAO;

    @Override
    public ModelMap getClientDeliveryList() {
        try {

            ArrayList<ClientDeliveryTO> clientDeliveryList = clientDeliveryDAO.getClientDeliveryList();
            modelMap.put("clientDeliveryList", clientDeliveryList);
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
    public Map<String, Object> addNewClientDelivery(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 배송번호 생성
            String lastNo;
            String generatedClientDeliveryNumber;

            if (clientDeliveryDAO.getClientDeliveryMaxNo() == null) {
                // clientDeliveryDAO.getClientDeliveryMaxNo()가 null인 경우 오늘 날짜를 기반으로 생성된 배송번호 생성
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                lastNo = sdf.format(new Date()) + 00;
            } else {
                String getNum = clientDeliveryDAO.getClientDeliveryMaxNo().substring(2);
                int getNum2 = Integer.parseInt(getNum)+1;

                if (getNum2 >= 10) {
                    lastNo = Integer.toString(getNum2);
                } else {
                    lastNo = '0' + Integer.toString(getNum2);
                }
            }

            generatedClientDeliveryNumber = "DN" + lastNo;

            params.put("deliveryNumber", generatedClientDeliveryNumber);


            clientDeliveryDAO.addNewClientDelivery(params);

            // 결과에 생성된 배송번호 추가
            result.put("generatedClientDeliveryNumber", generatedClientDeliveryNumber);
            result.put("errorCode", 1);
            result.put("errorMsg", "성공");

        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

    @Override
    public void updateClientDelivery(ClientDelivery clientDelivery) {
        System.out.println("clientDelivery.getDeliveryStatus() " + clientDelivery.getDeliveryStatus());

//        if(clientDelivery.getDeliveryStatus().equals("배송완료")){
//            System.out.println("배송완료 조건문 안에 들어옴.");
//            HashMap<String, Object> map = new HashMap<>();
//
//            String outputNum = clientDelivery.getOutputNumber();
//            System.out.println("outputNum " + outputNum);
//            String requestQuantity = outputDAO.selectRequestQuantity(outputNum);
//            System.out.println("requestQuantity " + requestQuantity);
//
//            map.put("itemName",clientDelivery.getItemName());
//            map.put("requestQuantity", requestQuantity);
//
//            System.out.println("map>>>>> " + map);
//
//            stockDAO.updateStockAfterDelivery(map);
//        }

        clientDeliveryDAO.updateClientDelivery(clientDelivery);
    }

    @Override
    public void deleteClientDelivery(String deliveryNumber) {
        clientDeliveryDAO.deleteClientDelivery(deliveryNumber);
    }
}
