package com.shop.shop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_dept", schema = "shop", catalog = "")
public class SysDeptEntity {
    private long deptId;
    private String deptName;
    private Long parentId;
    private Integer orderNum;
    private Byte delFlag;

    @Id
    @Column(name = "dept_id")
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "parent_id")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "order_num")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "del_flag")
    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDeptEntity that = (SysDeptEntity) o;
        return deptId == that.deptId &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(orderNum, that.orderNum) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, parentId, orderNum, delFlag);
    }
}
