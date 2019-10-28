package demo.cors.evilsite.service;

import demo.cors.evilsite.model.DogFacts;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogFactService {

    private static final String DOG_FACT_URL = "https://dog-api.kinduff.com/api/facts?number=1";

    public String getDogFact() {
        RestTemplate restTemplate = new RestTemplate();
        DogFacts dogFactResponse = restTemplate.getForObject(DOG_FACT_URL, DogFacts.class);
        return dogFactResponse.getFacts()[0];
    }
}
