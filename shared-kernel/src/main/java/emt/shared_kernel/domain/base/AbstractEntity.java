package emt.shared_kernel.domain.base;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity <ID extends DomainObjectId> {

    @EmbeddedId
    private ID id;
}
