package ui;

import apirequests.APIRequests;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class LoginPage {

    public static void displayLoginPage() {

        String[] userTypes = {"Client", "Agent"};

        JFrame frame = new JFrame();

        JComboBox userTypeComboBox = new JComboBox(userTypes);
        userTypeComboBox.setBounds(130,40,100, 30);

        JTextField userNameTxt = new JTextField("user name");
        userNameTxt.setBounds(130,80,100, 30);

        JTextField passwordTxt = new JTextField("password");
        passwordTxt.setBounds(130,120,100, 30);

        JTextArea loginBtnStatus = new JTextArea("text");
        loginBtnStatus.setBounds(130, 160, 100, 30);

        JButton loginBtn = new JButton("login");
        loginBtn.setBounds(130,200,100, 30);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (userTypeComboBox.getSelectedItem().toString().equals("Client")) {
                    try {
                        JSONArray json = null;
                        json = APIRequests.getClientsList();
                        int id;
                        for (int i = 0; i < json.length(); i++) {
                            JSONObject item = json.getJSONObject(i);
                            if (item.get("clientCompName010").equals(userNameTxt.getText()) && item.get("clientCompPassword010").equals(passwordTxt.getText())) {
                                // Make login page elements invisible
                                userTypeComboBox.setVisible(false);
                                userNameTxt.setVisible(false);
                                passwordTxt.setVisible(false);
                                loginBtnStatus.setVisible(false);
                                loginBtn.setVisible(false);
                                id = (int) item.get("clientCompId010");
                                ClientPage.displayClientPage(frame, id);
                            } else {
                                loginBtnStatus.setText("Invalid Username/Password!");
                            }
                        }
                    } catch (IOException | JSONException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else{
                    try {
                        JSONArray json = null;
                        json = APIRequests.getAgentsList();
                        int id;
                        for (int i = 0; i < json.length(); i++) {
                            JSONObject item = json.getJSONObject(i);
                            if (item.get("username010").equals(userNameTxt.getText()) && item.get("password010").equals(passwordTxt.getText())) {
                                // Make login page elements invisible
                                userTypeComboBox.setVisible(false);
                                userNameTxt.setVisible(false);
                                passwordTxt.setVisible(false);
                                loginBtnStatus.setVisible(false);
                                loginBtn.setVisible(false);
                                AgentPage.displayAgentPage(frame, userNameTxt.getText());
                                break;
                            } else {
                                loginBtnStatus.setText("Invalid Username/Password!");
                            }
                        }
                    } catch (JSONException | IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        frame.add(userTypeComboBox);
        frame.add(userNameTxt);
        frame.add(passwordTxt);
        frame.add(loginBtnStatus);
        frame.add(loginBtn);

        frame.setSize(700,700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
