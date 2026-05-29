package mg.yoan.yoarith.controller;

import mg.yoan.yoarith.service.ArithService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithController {

    private final ArithService arithService;

    public ArithController(ArithService arithService) {
        this.arithService = arithService;
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        if(a < 0 || b < 0){
            throw new IllegalArgumentException("The given nummber has to be positive");
        }
        return arithService.Addition(a, b);
    }

    @GetMapping("/substract")
    public double substract(@RequestParam double a, @RequestParam double b) {
        return arithService.Substract(a, b);
    }

    @GetMapping("/multiplication")
    public double multiplication(@RequestParam double a, @RequestParam double b) {
        return arithService.Multiplication(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        if(b == 0){
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return arithService.Divide(a, b);
    }
}
