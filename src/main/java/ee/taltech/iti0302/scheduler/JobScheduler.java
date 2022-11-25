package ee.taltech.iti0302.scheduler;

import ee.taltech.iti0302.scheduler.dto.Meme;
import ee.taltech.iti0302.service.MemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class JobScheduler {

    private final RestTemplate restTemplate;
    private final MemeService memeService;

    @Scheduled(fixedDelay = 10000)
    public void getMemeUrl() {
        Meme response = restTemplate.getForObject("https://meme-api.herokuapp.com/gimme", Meme.class);
        if (response != null) memeService.setMeme(response);
    }
}
