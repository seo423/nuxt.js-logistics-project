package kr.co.seoulit.erp.logistic.production.servicefacade;

import kr.co.seoulit.erp.logistic.production.dao.ProductionProcessDAO;
import kr.co.seoulit.erp.logistic.production.dao.WorkPlaceDAO;
import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.repository.ProductionPerformanceRepository;
import kr.co.seoulit.erp.logistic.production.to.ProductionProcessTO;
import kr.co.seoulit.erp.logistic.production.to.WorkplaceListTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductionPerformanceServiceFacadeImpl implements ProductionPerformanceServiceFacade {

    @Autowired
    private ProductionPerformanceRepository productionPerformanceRepository;

    @Autowired
    private ProductionProcessDAO productionProcessDAO;

    @Autowired
    private WorkPlaceDAO workPlaceDAO;


    private ModelMap modelMap= new ModelMap();


    @Override
    public List<ProductionPerformance> getProductionPerformanceInfoList() {
        System.out.println("여기 SF impl");
        List<ProductionPerformance> productionPerformanceList = productionPerformanceRepository.findAll();
        return productionPerformanceList;
    }

    @Override
    public ModelMap getProductionProcessList() {
        try {
            ArrayList<ProductionProcessTO> ProductionProcessTOList = productionProcessDAO.ProductionProcessList();
            System.out.println("ProductionPerformanceServiceFacadeImpl.getProductionProcessList 까지 왔구");
            System.out.println("ProductionProcessTOList = " + ProductionProcessTOList );
            modelMap.put("gridRowJson", ProductionProcessTOList);
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
    public ModelMap getWorkplaceList() {
        try {
            ArrayList<WorkplaceListTO> WorkplaceTOTOList = workPlaceDAO.workplaceTOList();
            System.out.println("ProductionPerformanceServiceFacadeImpl.getWorkplaceList 까지 왔구");
            System.out.println("WorkplaceTOTOList = " + WorkplaceTOTOList);
            modelMap.put("gridRowJson", WorkplaceTOTOList);
            modelMap.put("errorCode", 1);
            modelMap.put("errorMsg", "성공");
        } catch (Exception e2) {
            e2.printStackTrace();
            modelMap.put("errorCode", -2);
            modelMap.put("errorMsg", e2.getMessage());
        }
        return modelMap;
    }


//    @Override
//    public List<ProductionPerformance> getItemClassifiction(String itemClassifiction) {
//        List<ProductionPerformance> byItemClassification = productionPerformanceRepository.findByItemClassification(itemClassifiction);
//
//        return byItemClassification;
//    }


}
