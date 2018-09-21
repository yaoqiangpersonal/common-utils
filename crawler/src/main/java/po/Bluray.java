package po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yq
 * @Date: 2018-09-21 15:00
 * @Description:
 */
@Data
public class Bluray {
    private String title;
    private String state;
    private String studio;
    private String years;
    private String runtime;
    private String uptime;
    private String codec;
    private String resoultion;
    private String audio;
    private String subtitles;
    private String playback;
    private String asin;
    private Integer id;
    private BigDecimal currentPrice;
    private BigDecimal highestPrice;
    private BigDecimal lowestPrice;
    private Date updateTime;

}
