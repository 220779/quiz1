package ee.academy.projektplus.quiz1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HealthcheckDto {
    private boolean status;
    private String message;
}