package com.maalexs.englishpiglatinconverter.web.controller;

import com.maalexs.englishpiglatinconverter.TestDataProvider;
import com.maalexs.englishpiglatinconverter.application.service.PigLatinService;
import com.maalexs.englishpiglatinconverter.web.dto.EnglishTextDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test for Pig Latin endpoints.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public final class PigLatinControllerTest {

    private static String PIG_LATIN_BASIC_URL = "/api/pl";

    @MockBean
    private PigLatinService pigLatinService;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    /**
     * Init test data.
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        given(pigLatinService.convertEnglishToPigLatin(TestDataProvider.TEST_STRING_VALUE))
                .willReturn(TestDataProvider.TEST_STRING_VALUE + TestDataProvider.TEST_STRING_VALUE);
    }

    @Test
    public void shouldReturnEnglishText() throws Exception {
        mockMvc
                .perform(post(PIG_LATIN_BASIC_URL + "/english")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new EnglishTextDto(TestDataProvider.TEST_STRING_VALUE).toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pigLatinText").exists())
                .andExpect(jsonPath("$.pigLatinText")
                        .value(TestDataProvider.TEST_STRING_VALUE + TestDataProvider.TEST_STRING_VALUE));

    }

    @Test
    public void shouldReturnBadRequestOnEmptyRequest() throws Exception {
        mockMvc
                .perform(post(PIG_LATIN_BASIC_URL + "/english").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequestOnEmptyEnglishString() throws Exception {
        mockMvc
                .perform(post(PIG_LATIN_BASIC_URL + "/english")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new EnglishTextDto("").toString()))
                .andExpect(status().isBadRequest());
    }
}
