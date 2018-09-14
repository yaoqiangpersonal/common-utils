package com.yq.blueray.taobao.entity.blueray;

public class Order {
    private Integer oid;

    private String shopName;

    private String orderNumber;

    private String memberName;

    private String alipay;

    private Double payable;

    private Double postagePayable;

    private Integer payPoints;

    private Double totalAmount;

    private Integer integralRebate;

    private Double actualPaymentAmount;

    private Integer actualPaymentPoints;

    private String orderStates;

    private String buyerMessage;

    private String consigneeName;

    private String deliveryAddress;

    private String transportationMode;

    private String contactNumber;

    private String contactMobilePhone;

    private Long orderCreationTime;

    private Long orderPaymentTime;

    private String babyTitle;

    private String babyKind;

    private String logisticsNumber;

    private String logisticsCompany;

    private String orderNote;

    private Integer babyTotalQuantity;

    private Integer shopId;

    private String shopNameNum;

    private String orderClosingReason;

    private Double sellerServiceCharge;

    private String buyerServiceCharge;

    private String invoiceHeader;

    private String mobilePhoneOrder;

    private String stagedOrderInformation;

    private Integer privilegedDepositOrderId;

    private String uploadContractPhotos;

    private String uploadSmallTicket;

    private String whetherToPay;

    private String depositRanking;

    private String modifiedSku;

    private String revisedDeliveryAddress;

    private String exceptionInformation;

    private Integer tmallCardDeduction;

    private Integer setPointsTreasureDeduction;

    private String o2odeal;

    private Double refundAmount;

    private String bookingStore;

    private String confirmTheDeliveryTime;

    private String merchantMoney;

    private Long updateTime;

    private Integer babyCount;

    private Integer availableQuantity;

    private Double totalCost;

    private Double totalDiscountPrice;

    private Double profit;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public Double getPayable() {
        return payable;
    }

    public void setPayable(Double payable) {
        this.payable = payable;
    }

    public Double getPostagePayable() {
        return postagePayable;
    }

    public void setPostagePayable(Double postagePayable) {
        this.postagePayable = postagePayable;
    }

    public Integer getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getIntegralRebate() {
        return integralRebate;
    }

    public void setIntegralRebate(Integer integralRebate) {
        this.integralRebate = integralRebate;
    }

    public Double getActualPaymentAmount() {
        return actualPaymentAmount;
    }

    public void setActualPaymentAmount(Double actualPaymentAmount) {
        this.actualPaymentAmount = actualPaymentAmount;
    }

    public Integer getActualPaymentPoints() {
        return actualPaymentPoints;
    }

    public void setActualPaymentPoints(Integer actualPaymentPoints) {
        this.actualPaymentPoints = actualPaymentPoints;
    }

    public String getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(String orderStates) {
        this.orderStates = orderStates == null ? null : orderStates.trim();
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName == null ? null : consigneeName.trim();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode == null ? null : transportationMode.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public void setContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone == null ? null : contactMobilePhone.trim();
    }

    public Long getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(Long orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public Long getOrderPaymentTime() {
        return orderPaymentTime;
    }

    public void setOrderPaymentTime(Long orderPaymentTime) {
        this.orderPaymentTime = orderPaymentTime;
    }

    public String getBabyTitle() {
        return babyTitle;
    }

    public void setBabyTitle(String babyTitle) {
        this.babyTitle = babyTitle == null ? null : babyTitle.trim();
    }

    public String getBabyKind() {
        return babyKind;
    }

    public void setBabyKind(String babyKind) {
        this.babyKind = babyKind == null ? null : babyKind.trim();
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber == null ? null : logisticsNumber.trim();
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany == null ? null : logisticsCompany.trim();
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote == null ? null : orderNote.trim();
    }

    public Integer getBabyTotalQuantity() {
        return babyTotalQuantity;
    }

    public void setBabyTotalQuantity(Integer babyTotalQuantity) {
        this.babyTotalQuantity = babyTotalQuantity;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopNameNum() {
        return shopNameNum;
    }

    public void setShopNameNum(String shopNameNum) {
        this.shopNameNum = shopNameNum == null ? null : shopNameNum.trim();
    }

    public String getOrderClosingReason() {
        return orderClosingReason;
    }

    public void setOrderClosingReason(String orderClosingReason) {
        this.orderClosingReason = orderClosingReason == null ? null : orderClosingReason.trim();
    }

    public Double getSellerServiceCharge() {
        return sellerServiceCharge;
    }

    public void setSellerServiceCharge(Double sellerServiceCharge) {
        this.sellerServiceCharge = sellerServiceCharge;
    }

    public String getBuyerServiceCharge() {
        return buyerServiceCharge;
    }

    public void setBuyerServiceCharge(String buyerServiceCharge) {
        this.buyerServiceCharge = buyerServiceCharge == null ? null : buyerServiceCharge.trim();
    }

    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader == null ? null : invoiceHeader.trim();
    }

    public String getMobilePhoneOrder() {
        return mobilePhoneOrder;
    }

    public void setMobilePhoneOrder(String mobilePhoneOrder) {
        this.mobilePhoneOrder = mobilePhoneOrder == null ? null : mobilePhoneOrder.trim();
    }

    public String getStagedOrderInformation() {
        return stagedOrderInformation;
    }

    public void setStagedOrderInformation(String stagedOrderInformation) {
        this.stagedOrderInformation = stagedOrderInformation == null ? null : stagedOrderInformation.trim();
    }

    public Integer getPrivilegedDepositOrderId() {
        return privilegedDepositOrderId;
    }

    public void setPrivilegedDepositOrderId(Integer privilegedDepositOrderId) {
        this.privilegedDepositOrderId = privilegedDepositOrderId;
    }

    public String getUploadContractPhotos() {
        return uploadContractPhotos;
    }

    public void setUploadContractPhotos(String uploadContractPhotos) {
        this.uploadContractPhotos = uploadContractPhotos == null ? null : uploadContractPhotos.trim();
    }

    public String getUploadSmallTicket() {
        return uploadSmallTicket;
    }

    public void setUploadSmallTicket(String uploadSmallTicket) {
        this.uploadSmallTicket = uploadSmallTicket == null ? null : uploadSmallTicket.trim();
    }

    public String getWhetherToPay() {
        return whetherToPay;
    }

    public void setWhetherToPay(String whetherToPay) {
        this.whetherToPay = whetherToPay == null ? null : whetherToPay.trim();
    }

    public String getDepositRanking() {
        return depositRanking;
    }

    public void setDepositRanking(String depositRanking) {
        this.depositRanking = depositRanking == null ? null : depositRanking.trim();
    }

    public String getModifiedSku() {
        return modifiedSku;
    }

    public void setModifiedSku(String modifiedSku) {
        this.modifiedSku = modifiedSku == null ? null : modifiedSku.trim();
    }

    public String getRevisedDeliveryAddress() {
        return revisedDeliveryAddress;
    }

    public void setRevisedDeliveryAddress(String revisedDeliveryAddress) {
        this.revisedDeliveryAddress = revisedDeliveryAddress == null ? null : revisedDeliveryAddress.trim();
    }

    public String getExceptionInformation() {
        return exceptionInformation;
    }

    public void setExceptionInformation(String exceptionInformation) {
        this.exceptionInformation = exceptionInformation == null ? null : exceptionInformation.trim();
    }

    public Integer getTmallCardDeduction() {
        return tmallCardDeduction;
    }

    public void setTmallCardDeduction(Integer tmallCardDeduction) {
        this.tmallCardDeduction = tmallCardDeduction;
    }

    public Integer getSetPointsTreasureDeduction() {
        return setPointsTreasureDeduction;
    }

    public void setSetPointsTreasureDeduction(Integer setPointsTreasureDeduction) {
        this.setPointsTreasureDeduction = setPointsTreasureDeduction;
    }

    public String getO2odeal() {
        return o2odeal;
    }

    public void setO2odeal(String o2odeal) {
        this.o2odeal = o2odeal == null ? null : o2odeal.trim();
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getBookingStore() {
        return bookingStore;
    }

    public void setBookingStore(String bookingStore) {
        this.bookingStore = bookingStore == null ? null : bookingStore.trim();
    }

    public String getConfirmTheDeliveryTime() {
        return confirmTheDeliveryTime;
    }

    public void setConfirmTheDeliveryTime(String confirmTheDeliveryTime) {
        this.confirmTheDeliveryTime = confirmTheDeliveryTime == null ? null : confirmTheDeliveryTime.trim();
    }

    public String getMerchantMoney() {
        return merchantMoney;
    }

    public void setMerchantMoney(String merchantMoney) {
        this.merchantMoney = merchantMoney == null ? null : merchantMoney.trim();
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBabyCount() {
        return babyCount;
    }

    public void setBabyCount(Integer babyCount) {
        this.babyCount = babyCount;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalDiscountPrice() {
        return totalDiscountPrice;
    }

    public void setTotalDiscountPrice(Double totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}