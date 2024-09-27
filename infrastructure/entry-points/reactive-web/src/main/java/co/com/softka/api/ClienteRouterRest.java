package co.com.softka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ClienteRouterRest {
    private static final String PATH = "/clientes";

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET(PATH.concat("/{id}")), handler::getClientById)
                .andRoute(POST(PATH), handler::saveClient)
                .andRoute(PUT(PATH.concat("/{id}")), handler::updateClient)
                .andRoute(DELETE(PATH.concat("/{id}")), handler::getAllClients);
    }
}
