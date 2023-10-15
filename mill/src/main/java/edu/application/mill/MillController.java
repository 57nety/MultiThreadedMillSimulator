package edu.application.mill;

import edu.application.mill.bean.MillService;
import edu.application.mill.bean.MillState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mill")
public class MillController {

    private final MillService millService;

    public MillController(MillService millService) {
        this.millService = millService;
    }

    @GetMapping
    public MillState state(){
        return millService.getState();
    }

    @PostMapping("water/{capacity}")
    public String addWater(@PathVariable Integer capacity){
        millService.addWater(capacity);
        return "OK";
    }

    @PostMapping("/millet/{capacity}")
    public String addMillet(@PathVariable Integer capacity){
        millService.addMillet(capacity);
        return "OK";
    }

    @PostMapping("flour/drop")
    public String dropFlour(){
        millService.dropFlour();
        return "OK";
    }

}
