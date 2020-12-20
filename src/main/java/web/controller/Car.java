package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class Car {

    private String color;
    private String model;
    private int series;

    public Car() {
    }

    public Car(String color, String model, int series) {
        this.color = color;
        this.model = model;
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @GetMapping(value = "/cars")
    public String printCarParam(@RequestParam(value = "count", defaultValue = "5") int count,  Model model) {
        List<Car> carList_one = new ArrayList<>();
        carList_one.add(new Car("BMW", "YELLOW", 1));
        carList_one.add(new Car("BMW", "BLACK", 2));
        carList_one.add(new Car("BMW", "RED", 3));
        carList_one.add(new Car("BMW", "GREEN", 4));
        carList_one.add(new Car("BMW", "WHITE", 5));

        if (count < 5 && count > 0) {
           carList_one = carList_one.subList(0,count);
        } else {
           carList_one = carList_one.subList(0,5);
        }

        model.addAttribute("cars", carList_one);
        return "car";
    }
}
