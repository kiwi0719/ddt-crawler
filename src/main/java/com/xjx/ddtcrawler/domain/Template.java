package com.xjx.ddtcrawler.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XieJiaxing
 * @date 2021/8/1 20:56
 */
@Data
public class Template implements Serializable {
    private static final long serialVersionUID = 6076962907927806205L;

    private Long id;
    private String name;
    private Double price;
    private Long modifyTime;
}
