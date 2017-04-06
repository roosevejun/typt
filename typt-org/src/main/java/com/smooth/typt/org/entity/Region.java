package com.smooth.typt.org.entity;

import com.smooth.typt.common.entity.BaseEntity;

import javax.persistence.*;

/**
 * 项目名称：typt
 * 模块名称：com.smooth.typt.org.entity
 * 功能描述：
 * 创建人:倪少君
 * 创建时间:2017/4/6
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Entity
@Table(name = "org_region")
public class Region extends BaseEntity {
    private static final long serialVersionUID = 8774482436481033205L;
    private Long regionId;
    private String regionName;
    private String regionCode;
    private Integer regionType;
    private String parentCode;
    private Integer state;

    @Id
    @Column(name = "region_id", nullable = false, insertable = true, updatable = true)
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "region_name", nullable = true, insertable = true, updatable = true, length = 100)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "region_code", nullable = true, insertable = true, updatable = true, length = 20)
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "region_type", nullable = true, insertable = true, updatable = true)
    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    @Basic
    @Column(name = "parent_code", nullable = true, insertable = true, updatable = true, length = 20)
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "state", nullable = true, insertable = true, updatable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
