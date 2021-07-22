package az.bank.mscustomer.repository.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractAuditingEntity {

    @CreatedDate
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdDate=Instant.now();

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant lastModifiedDate=Instant.now();
}
