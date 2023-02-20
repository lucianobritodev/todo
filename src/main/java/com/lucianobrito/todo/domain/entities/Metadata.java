package com.lucianobrito.todo.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public abstract class Metadata {

    @Column(name = "status", nullable = false)
    private Boolean status;

    @JsonProperty("created_at")
    @Column(name = "criado_em", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @JsonProperty("modified_at")
    @Column(name = "modificado_em", nullable = false)
    private ZonedDateTime lastModifiedAt;

    @PrePersist
    private void createdAt() {
        if (this.status == null)
            this.status = false;

        if (this.createdAt == null)
            this.createdAt = ZonedDateTime.now();

        if (this.lastModifiedAt == null)
            this.lastModifiedAt = ZonedDateTime.now();
    }

    @PreRemove
    @PreUpdate
    private void lastModifiedAt() {
        if (this.lastModifiedAt == null)
            this.lastModifiedAt = ZonedDateTime.now();
    }
}
