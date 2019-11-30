package com.shop.shop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_role_dept", schema = "shop", catalog = "")
public class SysRoleDeptEntity {
    private long id;
    private long roleId;
    private long deptId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "dept_id")
    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleDeptEntity that = (SysRoleDeptEntity) o;
        return id == that.id &&
                roleId == that.roleId &&
                deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, deptId);
    }
}
