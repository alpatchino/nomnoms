package com.patrick.nomnoms.api.tesco;

import com.patrick.nomnoms.api.tesco.response.Result;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class TescoServiceImplTest {

    @Value("${tesco.api.groceries.url}")
    private String TESCO_GROCERIES_URL;

    @MockBean
    static RestTemplateBuilder builder;

    @Autowired
    private TescoService tescoService;


    @TestConfiguration // test only bean
    static class TescoServiceTestConfiguration {

        @Bean
        public TescoService tescoService(){
            return new TescoServiceImpl(builder);
        }
    }

    @Before
    public void setUp() {


    }

    @Test
    void searchGroceries() {
    }

    @Test
    void searchProducts() {

        List<Result> result = tescoService.searchGroceries("Salmon", 0, 10);

        Assert.assertNotNull(result);

    }
}