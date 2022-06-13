package org.acme.cache.resources;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.cache.services.MeuServicoDemorado;

@Path("/cache")
@Produces(MediaType.TEXT_PLAIN)
public class CacheResource {

    private static final Object OBJ = new Object();

    @Inject
    MeuServicoDemorado servico;

    @GET
    @Path("{id}")
    public String primeiro(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, new Object());
    }

    @GET
    @Path("mesmo-objeto/{id}")
    public String segundo(@PathParam("id") String id) {
        return servico.primeiroCacheavel(id, OBJ);
    }

    @DELETE
    @Path("tudo")
    public void limpeTudo() {
        servico.limpePrimeiroCacheTodo();
    }

    @DELETE
    @Path("{id}")
    public void limpeUm(@PathParam("id") String id) {
        servico.limpePrimeiroCache(id, OBJ);
    }

    @GET
    @Path("put-mesmo-objeto/{id}")
    public String segundoCache(@PathParam("id") String id) {
        return servico.segundoCacheavel(id, OBJ);
    }

}
