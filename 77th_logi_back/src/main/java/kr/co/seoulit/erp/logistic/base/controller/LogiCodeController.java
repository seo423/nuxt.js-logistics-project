package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.base.servicefacade.LogiCodeServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeDetailTO;
import kr.co.seoulit.erp.logistic.base.to.LogiCodeTO;

@Tag(name = "코드관리")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base")
public class LogiCodeController {
	// 75기 최영현 수정, applicationservice 삭제 및 로직 단순화, 마지막 메서드는 일단 보류
	@Autowired
	private LogiCodeServiceFacade baseSF;
	@Operation(summary = "코드 조회")
	@RequestMapping(value = "/searchCodeList", method = RequestMethod.GET)
	public ModelMap findCodeList() {
		return baseSF.getCodeList();
	}
	@Operation(summary = "코드 추가,수정,삭제")
	@PostMapping("/batchListProcess")
	public void batchListProcess(@RequestBody @Parameter(description = "코드JSON")LogiCodeTO params) {
		baseSF.batchCodeListProcess(params);
	}
	@Operation(summary = "코드리스트 조회")	//77기
	@RequestMapping(value = "/codeList", method = RequestMethod.GET)
	public ModelMap findDetailCodeList(@RequestParam @Parameter(description = "코드번호")String divisionCode) {
		System.out.println("코드리스트 조회 controller  " + divisionCode);

		return baseSF.getDetailCodeList(divisionCode);
	}
	@Operation(summary = "코드리스트 중 1개 조회") //수정모달창 킬 때 값불러오기 77기
	@RequestMapping(value = "/selectCode", method = RequestMethod.GET)
	public ModelMap findSelectCode(@RequestParam @Parameter(description = "코드번호")String divisionCode) {
		return baseSF.getSelectCode(divisionCode);
	}
	@Operation(summary = "코드 수정")	//77기
	@PutMapping("/updateCode")
	public void updateCode(@RequestBody @Parameter(description = "코드JSON") LogiCodeTO logiCodeTO){

		baseSF.updateCode(logiCodeTO);
	}

	@Operation(summary = "코드 삭제")	//77기
	@DeleteMapping (value = "/deleteCode/{divisionCodeNo}")
	public void deleteLogiCode(@PathVariable @Parameter(description = "코드JSON")String divisionCodeNo) {
		baseSF.deleteLogiCode(divisionCodeNo);
	}



//	@Operation(summary = "코드상세 추가,수정,삭제(미구현)")
//	@RequestMapping(value = "/batchDetailListProcess", method = RequestMethod.POST)
//	public void batchDetailListProcess(@RequestBody @Parameter(description = "코드상세JSON")LogiCodeDetailTO batchList) {
//		baseSF.batchDetailCodeListProcess(batchList);
//	}

//	@RequestMapping(value = "/changeCodeUseCheckProcess", method = RequestMethod.GET)
//	public ModelMap changeCodeUseCheckProcess(HttpServletRequest request, HttpServletResponse response) {
//
////		String batchList = request.getParameter("batchList");
//
//		try {
//
////			ArrayList<LogiCodeDetailTO> detailCodeList = null;
////			HashMap<String, Object> resultMap = null;
////
////			detailCodeList = gson.fromJson(batchList, new TypeToken<ArrayList<CodeDetailTO>>() {
////			}.getType());
////
////			resultMap = baseSF.changeCodeUseCheckProcess(detailCodeList);
////
////			modelMap.put("result", resultMap);
////			modelMap.put("errorCode", 1);
//			modelMap.put("errorMsg", "성공");
//
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			modelMap.put("errorCode", -2);
//			modelMap.put("errorMsg", e2.getMessage());
//
//		}
//		return modelMap;
//	}

}
