package com.kelvin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tangshulei on 2017/9/28.
 */
public class Entity implements Serializable {
    private Integer id;
    private String isDelete;
    private Date dateCreated;
    private String createdBy;
    private Date dateUpdated;
    private String updatedBy;

    public Entity() {
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null?null:createdBy.trim();
    }

    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null?null:updatedBy.trim();
    }

}
