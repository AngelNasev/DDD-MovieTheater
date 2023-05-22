package emt.ticketreservation.service;

import emt.shared_kernel.domain.personal.PersonName;
import emt.ticketreservation.domain.models.Clients;
import emt.ticketreservation.domain.models.ReservationId;
import emt.ticketreservation.domain.service.forms.ClientForm;
import emt.ticketreservation.domain.service.forms.ReservationForm;
import emt.ticketreservation.domain.valueobjects.ProjectionValueObject;
import emt.ticketreservation.domain.valueobjects.TicketValueObject;
import emt.ticketreservation.services.ClientService;
import emt.ticketreservation.services.ReservationService;
import emt.ticketreservation.xport.client.ProjectionClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class ReservationServiceImplTest {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProjectionClient projectionClient;



    @Test
    public void testAddTicketsKafka() throws InterruptedException {

        List<ProjectionValueObject> projections = projectionClient.findAll();
        List<TicketValueObject> tickets = projections.get(0).getTickets();
        int prevNumReserved = (int) tickets.stream().filter(TicketValueObject::isReserved).count();
        TicketValueObject t1 = tickets.stream().filter(t -> t.getSeatNumber()==11).findFirst().get();

        ClientForm clientForm1 = new ClientForm();
        clientForm1.setClientName(new PersonName("Firstname1","Lastname1"));
        clientForm1.setClientUsername("cl1");
        clientForm1.setClientPassword("cl1");

        Clients client = clientService.createClient(clientForm1);

        ReservationForm reservationForm = new ReservationForm();
        reservationForm.setClient(client);

        ReservationId reservationId = reservationService.makeReservation(reservationForm);
        reservationService.addTicket(projections.get(0).getProjectionValueObjectId(),reservationId,t1);

        Thread.sleep(3000);
        List<ProjectionValueObject> updated = projectionClient.findAll();
        int reservedTickets = (int) updated.get(0).getTickets().stream().filter(t -> t.isReserved()).count();
        Assertions.assertEquals(prevNumReserved+1,reservedTickets);
    }

    @Test
    public void testRemoveTicketsKafka() throws InterruptedException {

        List<ProjectionValueObject> projections = projectionClient.findAll();
        List<TicketValueObject> tickets = projections.get(0).getTickets();
        int prevNumReserved = (int) tickets.stream().filter(TicketValueObject::isReserved).count();
        TicketValueObject t1 = tickets.stream().filter(t -> t.getSeatNumber()==1).findFirst().get();


        ReservationId reservationId = reservationService.getAll().get(0).getId();
        reservationService.removeTicket(projections.get(0).getProjectionValueObjectId(),reservationId,t1);

        Thread.sleep(3000);
        List<ProjectionValueObject> updated = projectionClient.findAll();
        int reservedTickets = (int) updated.get(0).getTickets().stream().filter(TicketValueObject::isReserved).count();
        Assertions.assertEquals(prevNumReserved-1,reservedTickets);
    }
}
