<script setup lang="ts">
import { VDataTable } from "vuetify/labs/VDataTable";

import axios from "axios";
import { productionStore } from "@/store/logi/production";
import type { ContractDetailInMpsAvailableTO } from "@/types/logistic/production/production";

const startDate = ref("");
const endDate = ref("");
const searchCondition = "contractDate";
const item = ref([]);
const selectedItem = ref<ContractDetailInMpsAvailableTO>();

const headers = ref([
  { title: "수주상세일련번호", key: "contractDetailNo" },
  { title: "유형", key: "contractType" },
  { title: "수주일자", key: "contractDate" },
  { title: "견적수량", key: "estimateAmount" },
  { title: "재고사용량", key: "stockAmountUse" },
  { title: "제작필요수량", key: "productionRequirement" },
  { title: "MPS 계획일", key: "mpsPlanDate", width: 165 },
  { title: "출하예정일", key: "scheduledEndDate", width: 150 },
  { title: "납기일", key: "dueDateOfContract" },
  { title: "품목명", key: "itemName" },
]);

// 입력된 데이터를 받아서 요청을 보낸다.
const getMpsData = async () => {
  // 시작일 혹은 종료일을 선택하지 않았으면 경고창을 띄운다.
  if (startDate.value === "" || endDate.value === "") {
    alert("시작일 또는 종료일을 선택해 주세요");
    return;
  }
  //선택된 데이터를 초기화 한다.
  selectedItem.value = undefined;

await productionStore().SEARCH_CONTRACT_AVAILABLE(startDate.value, endDate.value, searchCondition);
item.value = productionStore().SearchContractAvailable;
console.log("SearchContractAvailable item.value!!!!" , item.value)
};

// promise안에 값이 들어있는 객체가있다.
// 2번째로 전달받는 매개변수안에 선택한 열의 데이터가 들어있다.
const selectedRow = (value, item) => {
  console.log(item.item, "item.item 가 머고");
  console.log("toRawed value is : ", toRaw(item.item).contractDetailNo);
  selectedItem.value = item.item;
  console.log("selectedItem.value는 또 먼데!!!!!!!!", toRaw(selectedItem.value)?.contractDetailNo)
  
};

const isValid = (mpsData: any) => {
  console.log(mpsData);
  if (mpsData.mpsPlanDate === null) {
    alert("MPS 계획일자를 선택해 주세요");
    return false;
  } else if (mpsData.scheduledEndDate === null) {
    alert("출하 예정일을 선택해 주세요");
    return false;
  } else if (mpsData === "") {
    alert("수주 항목을 선택해 주세요");
    return false;
  }
  return true;
};

// Mps 계획일 또는 출하 예정일을 선택하지 않았으면은 경고창을 띄운다.
const saveMpsData = async () => {

  const mpsData = selectedItem.value;
  
  const bool = confirm("등록하시겠습니까?");

  if (!bool) return;


  // Mps계획일 또는 출하 예정일 혹은 mps 등록할 행을 
  // 선택했는지의 여부를 확인하는 로직. 
  
  if (!isValid(mpsData)) return;

  // 선택된 데이터를 초기화 한다.
  selectedItem.value = undefined;
  try{
    console.log('mpsData>>, mpsData, ', mpsData);
    await productionStore().CONTRACT_TO_MPS(mpsData);
    const res = productionStore().contractToMps;
    console.log("productionStore().contractToMps res", res) // -> 이부분이 빈배열로 출력 됨.
    getMpsData(); // MPS 등록가능 수주 조회
  } catch (error) {
    console.error('err occurred at saveMpsData:', error);
  }
  
console.log("contractToMps item.value!!!!" , item.value)
};

// console.log("it is work at order mps");

watch([selectedItem], (newValue) => {
  //객체에서 _rawValue객체값을 가지고 온다.
  console.log("selected Item is : ", selectedItem.value);
});
</script>
<template>
  <div class="gap"></div>
  <div class="page_wrapper">
    <div class="header_wrap">
      <input class="date" type="date" v-model="startDate" />
      <input class="date" type="date" v-model="endDate" />
      <v-btn class="btn_search" @click="getMpsData"
        >MPS 등록가능 수주조회</v-btn
      >
      <v-btn class="btn_insert" @click="saveMpsData">MPS 등록</v-btn>
    </div>

    <div class="gap"></div>
    <VDataTable
      :hover="true"
      :headers="headers"
      :items="item"
      :items-per-page="5"
      :select-strategy="'single'"
      @click:row="selectedRow"
    >
      <template #item.mpsPlanDate="{ item }">
        <AppDateTimePicker
          v-model="item.mpsPlanDate"
          placeholder="생산 시작날짜"
        />
      </template>

      <template #item.scheduledEndDate="{ item }">
        <AppDateTimePicker
          v-model="item.scheduledEndDate"
          placeholder="출하예정일"
        />
      </template>
    </VDataTable>
  </div>
</template>

<style scoped>
.page_wrapper {
  /* border: 1px solid red; */
}
.header_wrap {
  position: relative;
  width: auto;
  /* border: 3px solid orange; */
  height: fit-content;
  border-radius: 5px;
}
.date {
  border: none;
  width: 150px;
  height: 40px;
  border-radius: 3px;
  margin-right: 20px;
  border: 1px solid skyblue;
}

.btn_search {
  border: none;
  width: 180px;
  height: 40px;
  border-radius: 3px;
}

.btn_insert {
  position: absolute;
  right: 0px;
  border: none;
  width: 180px;
  height: 40px;
  border-radius: 3px;
}

.gap {
  height: 50px;
}
</style>
