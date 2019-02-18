package com.maalexs.englishpiglatinconverter.web.dto;

import java.io.Serializable;

/**
 * Data transfer object  for english text.
 */
public class EnglishTextDto implements Serializable {

    private String englishText;

    /**
     * Default c-tor.
     */
    public EnglishTextDto() {
    }

    /**
     * C-tor.
     *
     * @param englishText English text
     */
    public EnglishTextDto(String englishText) {
        this.englishText = englishText;
    }

    /**
     * G-r for englishText.
     *
     * @return englishText
     */
    public String getEnglishText() {
        return englishText;
    }

    /**
     * S-r for englishText.
     *
     * @param englishText English text
     */
    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }

    /**
     * Override default toString method with returning of JSON string
     *
     * @return Json String
     */
    @Override
    public String toString() {
        return "{\"englishText\": \"" + englishText + "\"}"; // simplifier for example
    }
}
