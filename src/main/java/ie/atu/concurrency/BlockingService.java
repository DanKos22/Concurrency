package ie.atu.concurrency;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class BlockingService {

    private RestTemplate restTemplate;

    @Autowired
    public BlockingService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String fetchDataBlocking() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", String.class);
    }
}
