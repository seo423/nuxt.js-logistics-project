package kr.co.seoulit.erp.logistic.sales.repository;

import kr.co.seoulit.erp.logistic.sales.entity.SalesPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalesPlaneRepository extends JpaRepository<SalesPlane,String> {
    @Query("SELECT MAX(sr.salesPlanNo) FROM SalesPlane sr")
    String findMaxSalesPlanNo();

    List<SalesPlane> findBySalesPlanDateBetweenAndDueDateOfSalesBetweenAndMpsApplyStatus(String startDate1, String endDate1, String startDate2, String endDate2, String mpsApplyStatus);
}
