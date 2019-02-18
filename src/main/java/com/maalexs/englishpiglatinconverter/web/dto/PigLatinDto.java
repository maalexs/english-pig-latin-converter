package com.maalexs.englishpiglatinconverter.web.dto;

import java.io.Serializable;

/**
 * Data transfer object for pig latin text.
 */
public class PigLatinDto implements Serializable {

    private String pigLatinText;

    /**
     * Default c-tor.
     */
    public PigLatinDto() {
    }

    /**
     * C-tor.
     *
     * @param pigLatinText Pig latin text
     */
    public PigLatinDto(String pigLatinText) {
        this.pigLatinText = pigLatinText;
    }

    /**
     * G-r for pigLatinText.
     *
     * @return pigLatinText
     */
    public String getPigLatinText() {
        return pigLatinText;
    }

    /**
     * S-r for pigLatinText.
     *
     * @param pigLatinText Pig latin text
     */
    public void setPigLatinText(String pigLatinText) {
        this.pigLatinText = pigLatinText;
    }

    /**
     * Override default toString method with returning of JSON string
     *
     * @return Json String
     */
    @Override
    public String toString() {
        return "{\"pigLatinText\": \"" + pigLatinText + "\"}"; // simplifier for example
    }
}
