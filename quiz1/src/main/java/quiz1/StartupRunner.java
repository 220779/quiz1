package quiz1;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import quiz1.database.entities.PlayerEntity;
import quiz1.database.repositories.PlayerRepository;
import quiz1.service.QuizDataService;

import java.util.List;

@Configuration
@Component
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    public void run(String...args) throws Exception {
        log.info("Executing startup actions...");
        playerRepository.save(new PlayerEntity("John"));
        playerRepository.save(new PlayerEntity("Harry"));
        playerRepository.save(new PlayerEntity("George"));
        quizDataService.getQuizCategories();
        quizDataService.getQuizQuestions();

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
        for (PlayerEntity player : playersFromDatabase) {
            log.info("Retrieved player: " + player);
        }
    }
}