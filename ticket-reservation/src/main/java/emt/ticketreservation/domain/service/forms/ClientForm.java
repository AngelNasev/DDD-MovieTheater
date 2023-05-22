package emt.ticketreservation.domain.service.forms;

import emt.shared_kernel.domain.personal.PersonName;
import lombok.Data;

@Data
public class ClientForm {
    private PersonName clientName;
    private String clientUsername;
    private String clientPassword;
}
