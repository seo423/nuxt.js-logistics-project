<template>
  <div>
    <VCard class="mb-6" title="견적 등록">
      <VContainer>
        <VForm @submit.prevent="() => {}">
          <VRow>
            <!-- 👉 견적 등록 -->
            <VCol cols="24" md="2" offset-md="">
              <VDialog v-model="isestimateDialogVisible" width="500" persistent>
                <!-- 견적 등록 버튼 -->
                <template #activator="{ props }">
                  <VBtn v-bind="props"> 추가 </VBtn>
                </template>

                <!-- 다이얼로그 닫기 버튼 -->
                <DialogCloseBtn
                  @click="isestimateDialogVisible = !isestimateDialogVisible"
                />

                <!-- 견적등록 다이얼로그 테이블 -->
                <VCard title="견적등록">
                  <VContainer>
                    <VCol>
                      <AppSelect
                        class="mb-3"
                        label="거래처명"
                        :items="infodata"
                        v-model="selectedCustomer"
                        item-text="title"
                        item-value="value"
                        variant="outlined"
                      />
                      <AppDateTimePicker
                        class="mb-3"
                        v-model="esDate"
                        label="견적일자"
                        placeholder="YYYY-MM-DD"
                        :readonly="true"
                      />
                      <AppDateTimePicker
                        class="mb-3"
                        v-model="efDate"
                        label="유효일자"
                        placeholder="YYYY-MM-DD"
                      />
                      <AppTextField
                        class="mb-3"
                        label="견적담당자"
                        v-model="user"
                        readonly
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="견적요청자"
                        v-model="user"
                        readonly
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="비고"
                        v-model="description"
                        variant="outlined"
                      />
                    </VCol>
                  </VContainer>

                  <VCardText class="d-flex justify-end flex-wrap gap-3">
                    <VBtn variant="tonal" color="secondary" @click="closeModal">
                      취소
                    </VBtn>
                    <VBtn @click="modifyCom"> 입력 </VBtn>
                  </VCardText>
                </VCard>
              </VDialog>
              <VBtn @click="addEstimateWithDetails"> 등록 </VBtn>
            </VCol>
          </VRow>
        </VForm>

        <!-- 👉 견적 등록 테이블 -->
        <VDataTable
          class="mt-6"
          :headers="headers"
          :items="estimatedata"
          :items-per-page="5"
        />
      </VContainer>
    </VCard>
  </div>

  <!-- 견적 상세 -->
  <div>
    <VCard class="mb-6" title="견적 상세">
      <VContainer>
        <VForm @submit.prevent="() => {}">
          <VRow>
            <!-- 👉 견적 상세 등록 -->
            <VCol cols="24" md="2" offset-md="">
              <VDialog
                v-model="isestimatedetailDialogVisible"
                width="500"
                persistent
              >
                <!-- 견적 상세 등록 버튼 -->
                <template #activator="{ props }">
                  <VBtn v-bind="props"> 추가 </VBtn>
                </template>

                <!-- 다이얼로그 닫기 버튼 -->
                <DialogCloseBtn
                  @click="
                    isestimatedetailDialogVisible =
                      !isestimatedetailDialogVisible
                  "
                />

                <!-- 견적등록 다이얼로그 테이블 -->
                <VCard title="견적상세등록">
                  <VContainer>
                    <VCol>
                      <AppSelect
                        class="mb-3"
                        label="품목코드"
                        :items="detailCodes"
                        v-model="selectedCode"
                        @change="onItemCodeChange"
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="품목명"
                        v-model="selectedName"
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="단위"
                        value="EA"
                        variant="outlined"
                      />
                      <AppDateTimePicker
                        class="mb-3"
                        v-model="dueDate"
                        label="납기일"
                        placeholder="YYYY-MM-DD"
                      />
                      <AppTextField
                        class="mb-3"
                        label="견적수량"
                        v-model="estimateAmount"
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="견적단가"
                        v-model="unitPriceOfEstimate"
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="합계액"
                        v-model="sumPriceOfEstimate"
                        variant="outlined"
                      />
                      <AppTextField
                        class="mb-3"
                        label="비고"
                        v-model="description1"
                        variant="outlined"
                      />
                    </VCol>
                  </VContainer>

                  <VCardText class="d-flex justify-end flex-wrap gap-3">
                    <VBtn
                      variant="tonal"
                      color="secondary"
                      @click="closeModal1"
                    >
                      취소
                    </VBtn>
                    <VBtn @click="modifyCom1"> 입력 </VBtn>
                  </VCardText>
                </VCard>
              </VDialog>
            </VCol>
          </VRow>
        </VForm>

        <!-- 👉 견적 상세 등록 테이블 -->
        <VDataTable
          class="mt-6"
          :headers="detailheaders"
          :items="detaildata"
          :items-per-page="5"
        />
      </VContainer>
    </VCard>
  </div>
</template>

<script lang="ts" setup>
import { VDataTable } from "vuetify/labs/VDataTable";
import axios from "axios";
import { watch } from "vue";
import { VAlert } from "vuetify/lib/components/index.mjs";
import { salesStore } from '@/store/logi/sales'
import { companyStore } from "@/store/hr/company";
import { baseStore } from "@/store/logi/base";

// Dialog
const isestimateDialogVisible = ref(false);
const isestimatedetailDialogVisible = ref(false);

const divisionCode = "IT-_I"

// DateTimePicker
const date = ref("");

const infodata = ref([]);
const detailCodes = ref([]);
const selectedName = ref([]);
const detailCodeList = ref([]);

const selectedCustomer = ref("");
const selectedCode = ref("");

const user = "GDW";
const description = ref("");
const estimateAmount = ref<number>();
const description1 = ref("");
const unitPriceOfEstimate = ref<number>();
const sumPriceOfEstimate = ref<number>();

// 견적 등록 데이터 객체
const estimatedata = ref([]);
const detaildata = ref([]);

const closeModal = () => {
  isestimateDialogVisible.value = false;
};

const closeModal1 = () => {
  isestimatedetailDialogVisible.value = false;
};

// modifyCom 메서드 내에 데이터 추가 로직 구현
const modifyCom = () => {
  // 작성된 데이터를 객체로 저장
  const newData = {
    customerCode: selectedCustomer.value,
    estimateDate: esDate.value,
    effectiveDate: efDate.value,
    personCodeInCharge: user,
    estimateRequester: user,
    description: description.value,
  };

  // estimatedata 배열에 작성된 데이터 추가
  estimatedata.value.push(newData);

  // 다이얼로그 닫기
  isestimateDialogVisible.value = false;
};

const modifyCom1 = () => {
  // 작성된 데이터를 객체로 저장
  const newData = {
    itemCode: selectedCode.value,
    itemName: selectedName.value,
    unitOfEstimate: "EA",
    dueDateOfEstimate: dueDate.value, // 납기일 추가
    estimateAmount: estimateAmount.value,
    description: description1.value,
    unitPriceOfEstimate: unitPriceOfEstimate.value,
    sumPriceOfEstimate: sumPriceOfEstimate.value,
  };

  // detaildata 배열에 작성된 데이터 추가
  detaildata.value.push(newData);

  // 다이얼로그 닫기
  isestimatedetailDialogVisible.value = false;
};

// 오늘 날짜를 가져오는 함수
const getTodayDate = () => {
  const today = new Date();
  const year = today.getFullYear();
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const day = String(today.getDate()).padStart(2, "0");
  return `${year}-${month}-${day}`;
};

// 유효일자
const getEndDate = () => {
  const date = new Date();
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const lastday = new Date(year, month, 0).getDate();
  return `${year}-${month}-${lastday}`;
};

const esDate = ref(getTodayDate()); // 견적일자
const efDate = ref(getEndDate()); // 유효일자
const dueDate = ref(getEndDate()); //납기일

const searchCondition = ref("");
const workplaceCode = ref("");

// Table Columns
const headers = [
  { title: "거래처명", key: "customerCode" },
  { title: "견적일자", key: "estimateDate" },
  { title: "유효일자", key: "effectiveDate" },
  { title: "견적담당자", key: "personCodeInCharge" },
  { title: "견적요청자", key: "estimateRequester" },
  { title: "비고", key: "description" },
];

const detailheaders = [
  { title: "품목코드", key: "itemCode" },
  { title: "품목명", key: "itemName" },
  { title: "단위", key: "unitOfEstimate" },
  { title: "납기일", key: "dueDateOfEstimate" },
  { title: "견적수량", key: "estimateAmount" },
  { title: "견적단가", key: "unitPriceOfEstimate" },
  { title: "합계액", key: "sumPriceOfEstimate" },
  { title: "비고", key: "description" },
];

// 페이지 로드시 실행
onMounted(async () => {
  infodata.value = await fetchData();
  detailCodes.value = await fetchData1();
});

watch(selectedCode, async (newValue, oldValue) => {
    console.log("selectedCode" + selectedCode);
    await getUnitPrice();
  if (newValue !== oldValue) {
    await onItemCodeChange();
  }
});

// watch([estimateAmount, unitPriceOfEstimate], () => {
  
//    sumPriceOfEstimate.value = estimateAmount.value * unitPriceOfEstimate.value
// });

watch([estimateAmount, unitPriceOfEstimate], () => {
  if(unitPriceOfEstimate.value && estimateAmount.value ){
    sumPriceOfEstimate.value = estimateAmount.value * unitPriceOfEstimate.value
  }
});

// 선택된 거래처명 변경 시 호출되는 함수
const onSelectedCustomerChange = (newValue) => {
  selectedCustomer.value = newValue;
};

// 거래처명 리스트 가져오기
// 고객 데이터를 가져오는 기존 fetchData 함수
const fetchData = async () => {
  try {
    const searchCondition = "ALL";
    const workplaceCode = "BRC-01";

    await companyStore().GET_CUSTOMER_LIST(searchCondition,workplaceCode)

    const response = companyStore().customerInfo
    
    const customerList = response.map((item: any) => ({
      title: item.customerName, // UI에 표시됨
      value: item.customerCode, // 저장되는 값 (code)
    }));

    console.log("거래처명:", customerList);

    infodata.value = customerList;

    return customerList;

  } catch (error) {
    console.error("데이터 불러오기 에러:", error);
    return [];
  }
};

// 품목코드 리스트 가져오기
const fetchData1 = async () => {
  try {
    console.log('품목코드 리스트 가져오기');
    await baseStore().GET_CODELIST(divisionCode)
    detailCodeList.value = baseStore().detailCodeList

    const response = baseStore().detailCodeList
    detailCodes.value = response.map((item: any) => item.detailCode);

    console.log("품목코드 목록:", detailCodes.value);

    return detailCodes.value;
  } catch (error) {
    console.error("품목코드 리스트 가져오기 에러:", error);
    return [];
  }
};

//제품단가 가져오기
const getUnitPrice = async () => {
  try{
  await salesStore().GET_UNITPRICE(selectedCode.value)
  unitPriceOfEstimate.value = salesStore().unitPriceOfEstimate;
  }catch (error) {
    console.error("제품단가 가져오기 에러:", error);
  }
}

// 품목코드를 선택하면 해당 데이터의 품목명이 품목명에 나오게 하기
const onItemCodeChange = () => {

    const selectedItem = detailCodeList.value.find(
      (item: { detailCode: string; }) => item.detailCode === selectedCode.value
    );

    console.log("selectedItem:", selectedItem);

    if (selectedItem) {
      selectedName.value = selectedItem.detailCodeName;
      console.log("선택된 품목명:", selectedItem.detailCodeName);
    } else {
      console.log("해당 품목을 찾을 수 없음");
      selectedName.value = ""; // 품목명 초기화
    }

};

// 견적 등록 및 상세 등록 함수
const addEstimateWithDetails = async () => {
  try {
    // 선택된 거래처 정보 가져오기
    const customerInfo = infodata.value.find(
      (e) => e.value === selectedCustomer.value
    );

    // 상세 견적 데이터 준비
    const detailGridData = detaildata.value.map((e) => ({
      itemCode: e.itemCode,
      itemName: e.itemName,
      unitOfEstimate: "EA",
      dueDateOfEstimate: e.dueDateOfEstimate,
      estimateAmount: e.estimateAmount || 0,
      description: e.description,
      unitPriceOfEstimate: e.unitPriceOfEstimate,
      sumPriceOfEstimate: e.sumPriceOfEstimate,
      status: "INSERT",
    }));

    // 새로운 견적 데이터 구성
    const newEstimateInfo = {
      customerCode: customerInfo.value,
      estimateDate: esDate.value,
      effectiveDate: efDate.value,
      personCodeInCharge: user,
      estimateRequester: user,
      description: description.value,
      estimateDetailTOList: detailGridData,
    };

    console.log("견적 및 상세 등록 데이터:", newEstimateInfo);

    // API 호출을 위해 axios를 사용한다고 가정합니다.
    // const response = await axios.post(
    //   "http://localhost:8282/logi/sales/addNewEstimates",
    //   { newEstimateInfo }
    // );
    await salesStore().ADD_NEW_ESTIMATE(newEstimateInfo)
    alert("등록 완료되었습니다!");
    // 성공적인 제출 후 데이터 초기화
    estimatedata.value = [];
    detaildata.value = [];

  } catch (error) {
    console.error("견적 및 상세 등록 실패:", error);
    // 에러 시나리오 처리

    // 실패 알림 메시지
    alert("등록 실패! 견적을 다시 확인해주세요.");
  }
};
</script>