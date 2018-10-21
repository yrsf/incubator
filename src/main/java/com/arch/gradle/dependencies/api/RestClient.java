package com.arch.gradle.dependencies.api;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Simple client to initialize file api request to the local repository.
 *
 * @author antony.zhao@chase.com; yuechao.zhao@dieboldnixdorf.com
 * @since Oct, 2018
 */
public class RestClient {

    private static final String ARTIFACTORY_SERVER = "http://w2s6lq22.naeast.ad.jpmorganchase.com:8081/artifactory/api/storage/";

    public String get(String repo, String uri) {

        WebClient client = WebClient.create(ARTIFACTORY_SERVER);

        Mono<ClientResponse> result = client.get()
                .uri(repo + uri)
                .accept(MediaType.TEXT_PLAIN)
                .attribute("stats", "").exchange();

        return result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
