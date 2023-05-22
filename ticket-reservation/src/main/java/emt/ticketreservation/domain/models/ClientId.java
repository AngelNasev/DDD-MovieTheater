package emt.ticketreservation.domain.models;

import emt.shared_kernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ClientId extends DomainObjectId {
    private ClientId() {
        super(ClientId.randomId(ClientId.class).getId());
    }

    public ClientId(@NonNull String uuid) {
        super(uuid);
    }
    public static ClientId of(String uuid) {
        ClientId c = new ClientId(uuid);
        return c;
    }
}
