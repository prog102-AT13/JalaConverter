/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package org.fundacion.jala.converter.view.compiler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.fundacion.jala.converter.models.UserSQL.findUserById;

public class CompilerInterface extends JPanel {
    private CodeTextArea codeArea;
    private Console consoleOutput;
    private LanguageButtons langButtons;
    private CompilerButtons buttonsCompiler;

    /**
     * Initilize the graphics elements of the Main Compiler Interface.
     */
    public CompilerInterface() {
        buttonsCompiler = new CompilerButtons();
        consoleOutput = new Console();
        langButtons = new LanguageButtons();
        codeArea = new CodeTextArea();

        /*JTabbedPane mainTabPanel = new JTabbedPane();
        mainTabPanel.setFont(new Font("Barlow", 0, 11));
        mainTabPanel.add("Main", codeArea);
        */
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

        //projectTab.add("Main", codeArea);
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
        //add(mainTabPanel, panelConstraint);

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
                //consoleOutput.getConsole().setText(codeArea.getText());
                //System.out.println(codeArea.getText());

                String url = "http://localhost:8080/api/compilePython";
                HttpPost httpPost = new HttpPost(url);

                /*String code1 = "print(\"Hello world 1\")\n" +
                        "print(\"Hello world 2\")\n" +
                        "print(25%2)\n" +
                        "print(\"Dani piensa mal\")\n" +
                        "print(\"Mariachi\")";
                */
                //String code1 = codeArea.getText();

                String code1 = projectTab.getSelectedPane().getText();
                System.out.println(code1);

                MultipartEntityBuilder builder;
                builder = MultipartEntityBuilder.create();
                builder.addTextBody("code", code1, ContentType.TEXT_PLAIN);
                HttpEntity multipart;
                multipart = builder.build();
                try {
                    httpPost.setEntity(multipart);
                    httpPost.setHeader("Authorization", "Bearer " + findUserById(1).getToken());
                    CloseableHttpClient httpClient = HttpClients.createDefault();

                    CloseableHttpResponse response = httpClient.execute(httpPost);
                    HttpEntity responseEntity = response.getEntity();
                    String sResponse = EntityUtils.toString(responseEntity, "UTF-8");
                    consoleOutput.getConsole().setText(sResponse);
                    System.out.println(sResponse);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });
    }
}
