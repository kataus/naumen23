package ru.itvitality.meetup.naumen.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.itvitality.meetup.naumen.model.AnyData;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataServiceImpl implements DataService{
    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

    @Override
    public AnyData getData( Integer key ) {
        var request = new RequestEntity( null, HttpMethod.GET
                , UriComponentsBuilder.fromUri( loadBalancerClient.choose( "db-service" ).getUri() )
                    .path( "/data/{key}" )
                    .buildAndExpand( key )
                    .toUri()
        );
        var parameterizedTypeReference = new ParameterizedTypeReference<AnyData>() {};
        try {
            var response = restTemplate.exchange( request, parameterizedTypeReference );
            if ( ! response.getStatusCode().is2xxSuccessful() ) {
                log.error( "Can't get sensors meta info, request {}, response status {}", request.getUrl().getQuery(), response.getStatusCode() );
                throw  new RuntimeException("db-server connection error");
            }
            return response.getBody();
        } catch ( Exception e){
            log.error( "Can't get sensors meta info, request {}, response error", request.getUrl().getQuery(), e);
            throw  new RuntimeException("db-server connection error");
        }

    }
}
