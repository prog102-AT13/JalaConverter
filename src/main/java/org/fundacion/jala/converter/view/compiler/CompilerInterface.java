/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Paola Aguilar Quiñones
 */

package org.fundacion.jala.converter.view.compiler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static org.fundacion.jala.converter.models.UserSQL.findUserById;

public class CompilerInterface extends JPanel {
    private static final Logger LOGGER = LogManager.getLogger();
    private CodeTextArea codeArea;
    private Console consoleOutput;
    private LanguageButtons langButtons;
    private CompilerButtons buttonsCompiler;

    /**
     * Initializes the graphics elements of the Main Compiler Interface.
     */
    public CompilerInterface() {
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new LanguageButtons();
        codeArea = new CodeTextArea();
        langButtons.getJava().setEnabled(false);
        ProjectTab projectTab = new ProjectTab();
        projectTab.setFont(new Font("Barlow", 0, 11));
        projectTab.add(codeArea);
        JPanel pnl = new JPanel();
        pnl.setLayout(new FlowLayout());
        pnl.setOpaque(false);
        JLabel label=new JLabel("Main");
        label.setFont(new Font("Barlow", 0, 11));
        pnl.add(label);
        projectTab.setTabComponentAt(projectTab.getTabCount() - 1, pnl);
        projectTab.start();
        setLayout(new GridBagLayout());
        GridBagConstraints panelConstraint = new GridBagConstraints();
        panelConstraint.gridx = 0;
        panelConstraint.gridy = 1;
        panelConstraint.gridheight = 3;
        panelConstraint.gridwidth = 1;
        panelConstraint.weighty = 1;
        panelConstraint.fill = GridBagConstraints.BOTH;
        add(langButtons, panelConstraint);
        panelConstraint.gridx = 1;
        panelConstraint.gridy = 1;
        panelConstraint.gridheight = 2;
        panelConstraint.gridwidth = 4;
        add(projectTab, panelConstraint);
        panelConstraint.gridx = 3;
        panelConstraint.gridy = 7;
        panelConstraint.gridheight = 1;
        panelConstraint.gridwidth = 2;
        panelConstraint.weighty = 0;
        add(buttonsCompiler, panelConstraint);
        panelConstraint.gridx = 1;
        panelConstraint.gridy = 8;
        panelConstraint.gridheight = 2;
        panelConstraint.gridwidth = 4;
        add(consoleOutput, panelConstraint);
        buttonsCompiler.getRunButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.info("start");
                String url = "";
                if (!langButtons.getPython().isEnabled()){
                    url = "http://localhost:8080/api/compilePython";
                }
                if (!langButtons.getJava().isEnabled()) {
                    url = "http://localhost:8080/api/compileJava";

                }
                HttpPost httpPost = new HttpPost(url);
                String code1 = projectTab.getSelectedPane().getText();
                MultipartEntityBuilder builder;
                builder = MultipartEntityBuilder.create();
                builder.addTextBody("code", code1, ContentType.TEXT_PLAIN);
                HttpEntity multipart;
                multipart = builder.build();
                try {
                    LOGGER.info("Execute Try");
                    httpPost.setEntity(multipart);
                    httpPost.setHeader("Authorization", "Bearer " + findUserById(1).getToken());
                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    CloseableHttpResponse response = httpClient.execute(httpPost);
                    HttpEntity responseEntity = response.getEntity();
                    String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
                    consoleOutput.getConsole().setText(sResponse);
                    LOGGER.info("finish");
                } catch (Exception exception) {
                    LOGGER.error("Execute Exception" + exception.getMessage());
                }
            }
        });
        langButtons.getJava().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langButtons.getJava().setEnabled(false);
                langButtons.getPython().setEnabled(true);
            }
        });
        langButtons.getPython().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                langButtons.getPython().setEnabled(false);
                langButtons.getJava().setEnabled(true);
            }
        });
    }
}
