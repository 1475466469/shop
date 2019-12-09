package com.shop.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sys_role", schema = "shop", catalog = "")
public class SysRoleEntity {
    private long roleId;
    private String roleName;
    private String createUserid;
    private Timestamp createDate;
    private String remake;

    public SysRoleEntity(long roleId, String roleName, String createUserid, Timestamp createDate, String remake) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createUserid = createUserid;
        this.createDate = createDate;
        this.remake = remake;
    }

    public SysRoleEntity() {

    }

    @Id
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "create_userid")
    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    @Basic
    @Column(name = "create_Date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "remake")
    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleEntity that = (SysRoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(createUserid, that.createUserid) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(remake, that.remake);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, createUserid, createDate, remake);
    }
}
