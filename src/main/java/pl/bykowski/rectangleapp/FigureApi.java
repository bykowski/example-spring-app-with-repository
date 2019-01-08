package pl.bykowski.rectangleapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureApi {

    @GetMapping("/calculate")
    public int calculate(@RequestParam String figrue, @RequestParam int siteA, @RequestParam int siteB, @RequestParam(required = false) Integer siteC) {
        if (figrue.equalsIgnoreCase("RECTANGE")) {
            return 2 * siteA + 2 * siteB;
        }
        else if (figrue.equalsIgnoreCase("TRIANGLE")) {
            return siteA + siteB + siteC;
        }
        return -1;
    }

}
