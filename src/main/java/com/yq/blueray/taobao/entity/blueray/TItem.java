package com.yq.blueray.taobao.entity.blueray;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TItem{

    private static final long serialVersionUID = 1L;

    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    private String shopName;

    private String orderNumber;

    private String title;

    private Double price;

    private Integer buyNumber;

    private String sku;

    private String property;

    private String packageInformation;

    private String remarks;

    private String orderState;

    private Long updateTime;

    private Double discountPrice;

    private Double costAveragePrice;

    private Integer cdStock;

    private String barcode;


}
