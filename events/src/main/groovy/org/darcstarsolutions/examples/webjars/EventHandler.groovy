package org.darcstarsolutions.examples.webjars

import org.springframework.data.rest.core.annotation.HandleAfterCreate
import org.springframework.data.rest.core.annotation.HandleAfterDelete
import org.springframework.data.rest.core.annotation.HandleAfterSave
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.hateoas.EntityLinks
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

import static org.darcstarsolutions.examples.webjars.WebSocketConfiguration.MESSAGE_PREFIX
/**
 * Created by mharris on 4/19/16.
 */

@Component
@RepositoryEventHandler(Employee.class)
class EventHandler {

    private final SimpMessagingTemplate websocket

    private final EntityLinks entityLinks

    EventHandler(SimpMessagingTemplate websocket, EntityLinks entityLinks) {
        this.websocket = websocket
        this.entityLinks = entityLinks
    }

    @HandleAfterCreate
    void newEmployee(Employee employee){
        websocket.convertAndSend(MESSAGE_PREFIX + "/newEmployee", getPath(employee))
    }

    @HandleAfterDelete
    void deleteEmployee(Employee employee){
        websocket.convertAndSend(MESSAGE_PREFIX + "/deleteEmployee", getPath(employee))
    }

    @HandleAfterSave
    void updateEmployee(Employee employee) {
        websocket.convertAndSend(MESSAGE_PREFIX + "/updateEmployee", getPath(employee))
    }

    private String getPath(Employee employee) {
        return entityLinks.linkForSingleResource(employee.getClass(), employee.id).toUri().getPath()
    }
}
