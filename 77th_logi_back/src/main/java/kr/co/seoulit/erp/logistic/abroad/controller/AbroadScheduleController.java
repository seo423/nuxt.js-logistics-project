package kr.co.seoulit.erp.logistic.abroad.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.seoulit.erp.logistic.abroad.domain.AbroadSchedule;
import kr.co.seoulit.erp.logistic.abroad.servicefacade.AbroadScheduleServiceFacade;
import kr.co.seoulit.erp.logistic.abroad.to.abroadScheduleInfoTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Tag(name = "해외 홍보 일정")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/abroad/*")
public class AbroadScheduleController {

    @Autowired
    private AbroadScheduleServiceFacade abroadScheduleSF;
    private ModelMap modelMap;
    @Operation(summary = "행사 조회")
    @ResponseBody
    @RequestMapping(value = "/abroadScheduleList", method = RequestMethod.GET)
    public ModelMap getAbroadScheduleList() {
        return abroadScheduleSF.getAbroadScheduleList();
    }
    @Operation(summary = "행사 추가")
    @ResponseBody
    @RequestMapping(value = "/addAbroadSchedule", method = RequestMethod.POST)
    public void insertAbroadScheduleCode(@RequestBody @Parameter(description = "행사JSON") AbroadSchedule abroadScheduleInfoTO) {
        abroadScheduleSF.insertAbroadScheduleCode(abroadScheduleInfoTO);
    }
    @Operation(summary = "행사 삭제")
    @ResponseBody
    @RequestMapping(value = "/abroadScheduleCode", method = RequestMethod.DELETE)
    public void deleteAbroadScheduleCode(@RequestParam @Parameter(description = "행사JSON")String abroadScheduleCode) {
        abroadScheduleSF.deleteAbroadScheduleCode(abroadScheduleCode);
    }
    @Operation(summary = "행사 수정")
    @ResponseBody
    @RequestMapping(value = "/updateAbroadSchedule", method = RequestMethod.PUT)
    public void updateAbroadScheduleCode(@RequestBody @Parameter(description = "행사JSON")AbroadSchedule abroadScheduleInfoTO) {
        abroadScheduleSF.updateAbroadScheduleCode(abroadScheduleInfoTO);
    }

}

