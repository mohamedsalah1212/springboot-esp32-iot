package com.led.esp32;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/esp")
public class EspController {

    private final String ESP_IP = "http://192.168.1.5"; // ضع IP الخاص بـ ESP32

    @GetMapping("/on")
    public String turnOn(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(ESP_IP + "/on", String.class);
        model.addAttribute("response", response); // إضافة الرد إلى Thymeleaf
        return "index"; // اسم ملف HTML
    }

    @GetMapping("/off")
    public String turnOff(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(ESP_IP + "/off", String.class);
        model.addAttribute("response", response); // إضافة الرد إلى Thymeleaf
        return "index"; // اسم ملف HTML
    }
}
