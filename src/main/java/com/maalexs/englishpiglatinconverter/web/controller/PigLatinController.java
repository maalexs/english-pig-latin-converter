package com.maalexs.englishpiglatinconverter.web.controller;

import com.maalexs.englishpiglatinconverter.application.exception.EmptyEnglishTextException;
import com.maalexs.englishpiglatinconverter.application.service.PigLatinService;
import com.maalexs.englishpiglatinconverter.web.dto.EnglishTextDto;
import com.maalexs.englishpiglatinconverter.web.dto.PigLatinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Endpoints for pig latin API.
 */
@Controller
@RequestMapping(value = "/api/pl/", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PigLatinController {

    private final PigLatinService pigLatinService;

    /**
     * C-tor.
     *
     * @param service Pig latin service
     */
    @Autowired
    public PigLatinController(PigLatinService service) {
        pigLatinService = service;
    }

    /**
     * Return string which was converted from english to pig latin.
     *
     * @return String in pig latin
     */
    @PostMapping("/english")
    public @ResponseBody PigLatinDto convertEnglishToPigLatin(@RequestBody EnglishTextDto englishText) {
        if (englishText.getEnglishText().trim().isEmpty()) {
            throw new EmptyEnglishTextException();
        }
        return new PigLatinDto(pigLatinService.convertEnglishToPigLatin(englishText.getEnglishText()));
    }
}
