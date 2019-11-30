package com.shop.shop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_role_user", schema = "shop", catalog = "")
public class SysRoleUserEntity {
    private long id;
    private long userid;
    private Long roleId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleUserEntity that = (SysRoleUserEntity) o;
        return id == that.id &&
                userid == that.userid &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, roleId);
    }
}
