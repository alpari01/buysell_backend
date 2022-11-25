package ee.taltech.iti0302.service;

import ee.taltech.iti0302.scheduler.dto.Meme;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter @Getter
@RequiredArgsConstructor
@Service
public class MemeService {

    private Meme meme;
}
