package com.speaking.clock;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.speaking.clock.model.ApiResponseModel;
import com.speaking.clock.service.SpeakingClockService;

@SpringBootTest
class SpeakingClockApplicationTests {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenEnteredMidday_thenShouldReturnItsMidday() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("12:00");
        assertEquals("It's Midday", api.getMsg());
    }

    @Test
    public void whenEnteredMidnight_thenShouldReturnItsMidnight() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("24:00");
        assertEquals("It's Midnight", api.getMsg());
    }

    @Test
    public void whenEnteredTwelveFifty_thenShouldReturnItsTwelveFifty() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("12:50");
        assertEquals("It's twelve fifty", api.getMsg());
    }

    @Test//ss
    public void whenEnteredOne_thenShouldReturnItsOne() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("13:00");
        assertEquals("It's one", api.getMsg());
    }

    @Test//
    public void whenEnteredTwoOhSix_thenShouldReturnItsTwoOhSix() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("14:06");
        assertEquals("It's two six", api.getMsg());
    }

    @Test
    public void whenEnteredFiveFifteen_thenShouldReturnItsFiveFifteen() {
    	SpeakingClockService speakingClock = new SpeakingClockService();
    	ApiResponseModel api = speakingClock.speakingClockFunction("17:15");
        assertEquals("It's five fifteen", api.getMsg());
    }


}
