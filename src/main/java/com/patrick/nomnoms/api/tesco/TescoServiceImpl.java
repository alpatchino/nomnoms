package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.api.tesco.response.GroceriesResponseVO;
import com.patrick.nomnoms.api.tesco.response.Result;
import com.patrick.nomnoms.entity.Product;
import com.patrick.nomnoms.service.AmazonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TescoServiceImpl implements TescoService {

    @Value("${tesco.api.credentials}")
    private String TESCO_CREDENTIALS_LIVE;

    @Value("${tesco.api.groceries.url}")
    private String TESCO_GROCERIES_URL;

    @Value("${tesco.api.products.url}")
    private String TESCO_PRODUCTS_URL;

    private static final Logger log = LoggerFactory.getLogger(TescoServiceImpl.class);

    private RestTemplate restTemplate;
    private AmazonService amazonService;

    public TescoServiceImpl(RestTemplateBuilder restTemplateBuilder,
                            AmazonService amazonService) {
        this.restTemplate = restTemplateBuilder.build();
        this.amazonService = amazonService;
    }

    @Override
    public List<Product> searchGroceries(String query, Integer offset, Integer limit) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TESCO_GROCERIES_URL)
                .queryParam("query", query)
                .queryParam("offset", offset)
                .queryParam("limit", limit);

        log.info("Calling URL: {}", builder.toUriString());

        try {

            GroceriesResponseVO responseVO = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    getHttpEntity(),
                    GroceriesResponseVO.class).getBody();

            return convertToEntity(responseVO.getUk().getGhs().getProducts().getResults());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error calling {}", builder.toUriString(), e);
        } catch (Exception e) {
            log.error("Unknown error calling {}", builder.toUriString(), e);
        }

        return null;
    }

    private List<Product> convertToEntity(List<Result> results) {

        List<Product> formattedProducts = new ArrayList<>();

        for(Result result : results){

            Product product = new Product();

            BeanUtils.copyProperties(result, product);

            if (result.getDescription() != null) {
                product.setDescription(result.getDescription().toString());
            }

            formattedProducts.add(product);
        }

        return formattedProducts;
    }

    @Override
    public String searchProductByTpnc(String tpnc) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TESCO_PRODUCTS_URL)
                .queryParam("tpnc", tpnc);

        log.info("Calling URL: {}", builder.toUriString());

        try {

            String response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    getHttpEntity(),
                    String.class).getBody();

            saveResponseToS3(tpnc, response);

            return response;

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error calling {}", builder.toUriString(), e);
        } catch (Exception e) {
            log.error("Unknown error calling {}", builder.toUriString(), e);
        }

        return null;

    }

    @Override
    public String searchProductByGtin(String gtin) {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(TESCO_PRODUCTS_URL)
                .queryParam("gtin", gtin);

        log.info("Calling URL: {}", builder.toUriString());

        try {

            String response = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    getHttpEntity(),
                    String.class).getBody();

            saveResponseToS3(gtin, response);

            return response;

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error calling {}", builder.toUriString(), e);
        } catch (Exception e) {
            log.error("Unknown error calling {}", builder.toUriString(), e);
        }

        return null;
    }

    private HttpEntity<String> getHttpEntity() {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Ocp-Apim-Subscription-Key", TESCO_CREDENTIALS_LIVE);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return entity;
    }

    private void saveResponseToS3(String fileName, String content) {
        amazonService.putObject("reponses", "tesco-api/" + fileName, content);
    }
}
