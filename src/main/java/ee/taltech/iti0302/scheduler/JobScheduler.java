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

    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void getMemeUrl() {
        Meme response = restTemplate.getForObject("https://dog.ceo/api/breeds/image/random", Meme.class);
        if (response != null) memeService.setMemeUrl(response.getMessage());
    }
}
