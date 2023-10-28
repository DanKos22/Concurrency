package ie.atu.concurrency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingController {

    @Autowired
    private final BlockingService blockingService;

    public BlockingController(BlockingService blockingService){
        this.blockingService = blockingService;
    }

    @GetMapping("/blocking")
    public String getBlockingData(){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < 10; i++){
            blockingService.fetchDataBlocking();
        }
        long endTime = System.currentTimeMillis();
        return "Total execution time: " + (endTime - startTime) + "ms";
    }
}
