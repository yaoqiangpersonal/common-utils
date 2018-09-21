package com.yq.blueray.taobao.entity.blueray;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yq
 * @since 2018-09-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "oid", type = IdType.AUTO)
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

    @TableField("Order_payment_time")
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

    @TableField("privileged_deposit_order_ID")
    private Integer privilegedDepositOrderId;

    private String uploadContractPhotos;

    private String uploadSmallTicket;

    private String whetherToPay;

    private String depositRanking;

    @TableField("modified_SKU")
    private String modifiedSku;

    private String revisedDeliveryAddress;

    private String exceptionInformation;

    private Integer tmallCardDeduction;

    private Integer setPointsTreasureDeduction;

    @TableField("O2Odeal")
    private String O2Odeal;

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


}
