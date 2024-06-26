package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.seoulit.erp.logistic.base.domain.Client;
import kr.co.seoulit.erp.logistic.base.servicefacade.ItemServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemGroupTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.logistic.base.servicefacade.WarehouseServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.ItemTO;

@Tag(name = "품목관리")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/base")
public class ItemController {
	// 75기 3조 물류 최영현 수정
	// 주요 수정내용 : search조건 간략화 및 status를 이용한 batchlistprocess작업 일원화, applicationservice삭제, workplace와 중복 삭제
	// 77기 1조 post로 다 보내기보다 postmapping, deletemapping등으로 나누어서 crud 수정
	@Autowired
	private ItemServiceFacade itemSF;

	@Operation(summary = "품목 전체 조회")
	@RequestMapping(value = "/searchItemList", method = RequestMethod.GET)
	public ModelMap searchItemList(){
		return itemSF.searchItemList();
	}

	@Operation(summary = "품목 1개 조회")   //품목 한개 조회, 수정 모달창 킬 때 값 받아오기위해
	@RequestMapping(value = "/searchItem/{itemCode}", method = RequestMethod.GET)
	public ModelMap searchItem(@PathVariable @Parameter(description = "품목") String itemCode){
		return itemSF.searchItem(itemCode);
	}

	@Operation(summary = "품목 수정")
	@PutMapping("/updateItem")
	public void updateItem(@RequestBody @Parameter(description = "품목JSON") ItemTO batchList){

		itemSF.updateItem(batchList);
	}

	@Operation(summary = "품목 삭제")	//77기
	@DeleteMapping (value = "/deleteSelectedItem/{itemCode}")
	public void deleteSelectedItem(@PathVariable @Parameter(description = "품목JSON")String itemCode) {
		itemSF.deleteSelectedItem(itemCode);
	}

	@Operation(summary = "품목군 조회")
	@RequestMapping(value = "/searchItemGroupList", method = RequestMethod.GET)
	public ModelMap searchItemGroupList(){
		return itemSF.searchItemGroupList();
	}
	@Operation(summary = "품목군 수정")
	@PutMapping("/updateItemGroup")
	public void updateItemGroup(@RequestBody @Parameter(description = "품목군JSON") ItemGroupTO batchList){
		itemSF.updateItemGroup(batchList);
	}
	@Operation(summary = "품목군 삭제")	//77기
	@DeleteMapping (value = "/deleteSelectedItemGroup/{itemCode}")
	public void deleteSelectedItemGroup(@PathVariable @Parameter(description = "품목군JSON")String itemCode) {
		itemSF.deleteSelectedItemGroup(itemCode);
	}
	@Operation(summary = "품목 추가,수정,삭제")
	@PostMapping("/itemBatchListProcess")
	public void batchListProcess(@RequestBody @Parameter(description = "품목JSON")ItemTO batchList) {
		itemSF.batchListProcess(batchList);
	}
	@Operation(summary = "품목군 추가,수정,삭제")
	@PostMapping("/itemGroupBatchListProcess")
	public void itemGroupBatchListProcess(@RequestBody @Parameter(description = "품목군JSON")ItemGroupTO batchList) {
		itemSF.itemGroupBatchListProcess(batchList);
	}
}
