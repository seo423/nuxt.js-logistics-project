package kr.co.seoulit.erp.logistic.production.repository;

import kr.co.seoulit.erp.logistic.production.domain.WorkSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkSiteRepository extends JpaRepository<WorkSite, String> {

    /**********************************
     작업장/작업장 로그 = 작업장 조회(JPA)
     **********************************/
//    @Query("select w.productionProcessCode, w.workSiteCode, w.workSiteName from WorkSite w")
//    public List<WorkSite> findList();
}


