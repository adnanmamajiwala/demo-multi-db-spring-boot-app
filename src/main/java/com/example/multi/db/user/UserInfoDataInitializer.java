package com.example.multi.db.user;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@Profile("dev")
public class UserInfoDataInitializer {

    @Bean
    public CommandLineRunner runForTestUsers(UserInfoRepository repository) {
        return args -> repository.saveAll(generateTestUsers());
    }

    private List<UserInfo> generateTestUsers() {
        Lorem lorem = LoremIpsum.getInstance();
        List<UserInfo> result = new ArrayList<>();
        Random random = new Random();
        long max = 24 * 60 * 60 * 1000;
        for (int i = 0; i < 20; i++) {
            boolean isMale = random.nextInt(2) == 1;
            result.add(UserInfo.builder()
                    .name(isMale ? lorem.getNameMale() : lorem.getNameFemale())
                    .gender(isMale ? "Male" : "Female")
                    .email(lorem.getEmail())
                    .title(lorem.getTitle(random.nextInt(2) + 1))
                    .birthDate(Instant.ofEpochSecond((random.nextInt(4) + 14) * max))
                    .height(getDouble(random.nextDouble(), 1))
                    .weight(getDouble(random.nextDouble(), 3))
                    .build());
        }
        return result;
    }

    private double getDouble(double val, int power) {
        return Math.round(val * Math.pow(10, power) * 100) / 100.0;
    }
}
