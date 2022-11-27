package ee.taltech.iti0302.controller;


import ee.taltech.iti0302.service.MemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemeController {

    private final MemeService memeService;

    @GetMapping("/api/public/meme")
    public String getMeme() {
        return memeService.getMemeUrl();
    }
}
