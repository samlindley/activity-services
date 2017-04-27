package com.psandchill.client;

import com.psandchill.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class ActivitySearchClient {

    private Client client;

    public ActivitySearchClient(){
        client = ClientBuilder.newClient();
    }

    public List<Activity> search (String param, List<String> searchValues){

        //http://localhost:8080/exercise-services/webapi/search/activities?description=x&description=y

        URI uri = UriBuilder.fromUri("http://localhost:8080/exercise-services/webapi")
                .path("search/activities")
                .queryParam(param, searchValues).build();
        WebTarget target = client.target(uri);

        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});

        System.out.println(response);

        return response;
    }

}