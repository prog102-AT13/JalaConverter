package org.fundacion.jala.converter.models.parameter;

import org.springframework.stereotype.Service;

@Service
public class ExtractTextParameter extends Parameter{
    private String language;
    private String resultFile;
    public ExtractTextParameter(String newFilePath) {
        super(newFilePath);
    }
    public ExtractTextParameter(final String newFilePath, final String language,final String resultFile){
        super(newFilePath);
        this.language = language;
        this.resultFile = resultFile;
    }
    public ExtractTextParameter() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getResultFile() {
        return resultFile;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }
}
