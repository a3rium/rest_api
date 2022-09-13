package ui;

import apirequests.APIRequests;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AgentPage {

    private static JTextField processPoTextField;
    public static void displayAgentPage(JFrame frame, String agentUsername) {

        frame.setBounds(100, 100, 600, 700);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("Agent - Order Processing");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 4;
        gbc_lblNewLabel.anchor = GridBagConstraints.ABOVE_BASELINE;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

        JButton logoutBtn = new JButton("Logout");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 13;
        gbc_btnNewButton.gridy = 0;
        frame.getContentPane().add(logoutBtn, gbc_btnNewButton);

        JPanel panel = new JPanel();
        panel.setBackground(UIManager.getColor("Button.background"));
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 14;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        frame.getContentPane().add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{484, 0};
        gbl_panel.rowHeights = new int[]{633, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
        gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
        gbc_tabbedPane.fill = GridBagConstraints.BOTH;
        gbc_tabbedPane.gridx = 0;
        gbc_tabbedPane.gridy = 0;
        panel.add(tabbedPane, gbc_tabbedPane);

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("View All POs", null, panel_1, null);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        GridBagConstraints gbc_textPane = new GridBagConstraints();
        gbc_textPane.gridheight = 2;
        gbc_textPane.gridwidth = 7;
        gbc_textPane.fill = GridBagConstraints.BOTH;
        gbc_textPane.gridx = 0;
        gbc_textPane.gridy = 1;
        panel_1.add(textPane, gbc_textPane);
        refreshPOList(textPane);


        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Process a PO", null, panel_2, null);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_2.setLayout(gbl_panel_2);

        JLabel lblNewLabel_4 = new JLabel("PO Number");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.gridwidth = 2;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 1;
        gbc_lblNewLabel_4.gridy = 0;
        panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

        processPoTextField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.gridwidth = 14;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        panel_2.add(processPoTextField, gbc_textField);
        processPoTextField.setColumns(10);

        JButton btnNewButton_1 = new JButton("Search for PO");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 16;
        gbc_btnNewButton_1.gridy = 1;
        panel_2.add(btnNewButton_1, gbc_btnNewButton_1);

        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.gridwidth = 17;
        gbc_panel_3.gridheight = 16;
        gbc_panel_3.insets = new Insets(0, 0, 5, 5);
        gbc_panel_3.fill = GridBagConstraints.BOTH;
        gbc_panel_3.gridx = 0;
        gbc_panel_3.gridy = 2;
        panel_2.add(panel_3, gbc_panel_3);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_3.rowHeights = new int[]{0, 0, 0};
        gbl_panel_3.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel_3);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setEditable(false);
        GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
        gbc_textPane_1.gridwidth = 11;
        gbc_textPane_1.insets = new Insets(0, 0, 0, 5);
        gbc_textPane_1.fill = GridBagConstraints.BOTH;
        gbc_textPane_1.gridx = 0;
        gbc_textPane_1.gridy = 1;
        panel_3.add(textPane_1, gbc_textPane_1);

        JButton fulfillOrderBtn = new JButton("Fulfill Order");
        GridBagConstraints gbc_btnFulfillOrder = new GridBagConstraints();
        gbc_btnFulfillOrder.gridwidth = 2;
        gbc_btnFulfillOrder.gridx = 15;
        gbc_btnFulfillOrder.gridy = 18;
        panel_2.add(fulfillOrderBtn, gbc_btnFulfillOrder);



        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String orderReadOut = "Line Number\t\tPart Order Number\t\tPart Number\t\tPrice\n";
                JSONArray partOrder = new JSONArray();
                try {
                    partOrder = APIRequests.getPartOrderLine(Integer.parseInt(processPoTextField.getText()));

                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
                for (int i = 0; i < partOrder.length(); i++) {
                    JSONObject orderLine = partOrder.getJSONObject(i);
                    orderReadOut += (orderLine.get("lineNo010") + "\t\t\t" + orderLine.getJSONObject("po").get("poNo010") + "\t\t\t" + orderLine.getJSONObject("part").get("partNo010") + "\t\t" + orderLine.get("linePrice010") + "\n");
                }
                textPane_1.setText(orderReadOut);
            }
        });

        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("View All Clients", null, panel_4, null);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_4.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_4.setLayout(gbl_panel_4);

        JTextPane textPane_2 = new JTextPane();
        textPane_2.setEditable(false);
        GridBagConstraints gbc_textPane_2 = new GridBagConstraints();
        gbc_textPane.gridheight = 2;
        gbc_textPane.gridwidth = 14;
        gbc_textPane.fill = GridBagConstraints.BOTH;
        gbc_textPane.gridx = 0;
        gbc_textPane.gridy = 1;
        panel_4.add(textPane_2, gbc_textPane_2);

        JPanel panel_5 = new JPanel();
        tabbedPane.addTab("View All Parts", null, panel_5, null);
        GridBagLayout gbl_panel_5 = new GridBagLayout();
        gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panel_5.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_5.setLayout(gbl_panel_5);

        JTextPane textPane_3 = new JTextPane();
        textPane_3.setEditable(false);
        GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
        gbc_textPane.gridheight = 2;
        gbc_textPane.gridwidth = 14;
        gbc_textPane.fill = GridBagConstraints.BOTH;
        gbc_textPane.gridx = 0;
        gbc_textPane.gridy = 1;
        panel_5.add(textPane_3, gbc_textPane_3);

        JButton updatePartWindowBtn = new JButton("Update Part");
        GridBagConstraints gbc_updatePart = new GridBagConstraints();
        gbc_updatePart.gridwidth = 2;
        gbc_updatePart.gridx = 15;
        gbc_updatePart.gridy = 18;
        panel_5.add(updatePartWindowBtn, gbc_updatePart);

        updatePartWindowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame updatePartWindow = new JFrame("Update Part");
                updatePartWindow.setLayout(new GridBagLayout());
                updatePartWindow.setVisible(true);
                JTextField partNumberText = new JTextField("Part Number");
                JTextField partNameText = new JTextField("Part Name");
                JTextField partDescriptionText = new JTextField("Part Description");
                JTextField partCurrentPriceText = new JTextField("Current Price");
                JTextField partCurrentQtyText = new JTextField("Current Quantity");

                JButton updatePartBtn = new JButton("Update Part");
                GridBagConstraints gbc_updatePart = new GridBagConstraints();
                gbc_updatePart.gridwidth = 2;
                gbc_updatePart.gridx = 15;
                gbc_updatePart.gridy = 18;

                updatePartWindow.add(partNumberText);
                updatePartWindow.add(partNameText);
                updatePartWindow.add(partDescriptionText);
                updatePartWindow.add(partCurrentPriceText);
                updatePartWindow.add(partCurrentQtyText);
                updatePartWindow.add(updatePartBtn, gbc_updatePart);

                updatePartBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int partNo010 = 0;
                        String partName010 = null;
                        String partDescription010 = null;
                        Float currentPrice010 = null;
                        Integer currentQty010 = null;
                        try {
                            partNo010 = Integer.parseInt(partNumberText.getText());
                            if (!partNameText.getText().equals(""))
                                partName010 = partNameText.getText();
                            if (!partDescriptionText.getText().equals(""))
                                partDescription010 = partDescriptionText.getText();
                            if (!partCurrentPriceText.getText().equals(""))
                                currentPrice010 = Float.parseFloat(partCurrentPriceText.getText());
                            if (!partCurrentQtyText.getText().equals(""))
                                currentQty010 = Integer.parseInt(partCurrentQtyText.getText());

                            APIRequests.updatePart(partNo010, partName010, partDescription010, currentPrice010, currentQty010);
                            refreshPartList(textPane_3);
                        } catch (Exception exception) {
                            System.out.println("Format Exception!");
                        }
                    }
                });

                updatePartWindow.pack();
            }
        });
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (tabbedPane.getSelectedIndex() == 0) {
                    refreshPOList(textPane);
                } else if (tabbedPane.getSelectedIndex() == 2) {
                    refreshClientList(textPane_2);
                } else if (tabbedPane.getSelectedIndex() == 3) {
                    refreshPartList(textPane_3);
                }
            }
        });

        fulfillOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONArray partOrder = new JSONArray();
                try {
                    partOrder = APIRequests.getPartOrderLine(Integer.parseInt(processPoTextField.getText()));

                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
                JSONArray partList = new JSONArray();
                try {
                    partList = APIRequests.getPartsList();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                for (int i = 0; i < partList.length(); i++) {
                    for (int j = 0; j < partOrder.length(); j++) {
                        if (partList.getJSONObject(i).get("partNo010").equals(partOrder.getJSONObject(j).getJSONObject("part").get("partNo010"))) {
                            int qty = Integer.parseInt(partList.getJSONObject(i).get("qty010").toString());
                            qty-=1;
                            if (qty < 0) {
                                //unsuccessful
                                try {
                                    APIRequests.updatePoStatus("Unsuccessful", Integer.parseInt(processPoTextField.getText()));
                                    System.out.println("Order status set to unsuccessful");
                                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                                    unsupportedEncodingException.printStackTrace();
                                }

                                return;
                            }
                        }
                    }
                }
                //confirmed if method does not return after unsuccessful update
                try {
                    APIRequests.updatePoStatus("Confirmed",  Integer.parseInt(processPoTextField.getText()));
                    System.out.println("Order status set to confirmed");
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                logoutBtn.setVisible(false);
                btnNewButton_1.setVisible(false);
                fulfillOrderBtn.setVisible(false);
                textPane.setVisible(false);
                textPane_1.setVisible(false);
                textPane_1.setVisible(false);
                textPane_2.setVisible(false);
                textPane_3.setVisible(false);
                lblNewLabel.setVisible(false);
                lblNewLabel_4.setVisible(false);
                panel.setVisible(false);
                panel_1.setVisible(false);
                panel_2.setVisible(false);
                panel_3.setVisible(false);
                panel_4.setVisible((false));
                panel_5.setVisible(false);
                tabbedPane.setVisible(false);
                frame.dispose();
                LoginPage.displayLoginPage();
            }
        });


        frame.pack();
        frame.setSize(700,700);
        frame.setVisible(true);
    }
    public static void refreshPOList(JTextPane pane){
        JSONArray poList = new JSONArray();
        JSONArray poListClient = new JSONArray();
        String listOfPos="PO Number\t\tStatus\n";

        try {
            poList = APIRequests.getPartOrderListForAgent();

            for (int i = 0; i < poList.length(); i++) {
                JSONObject po = poList.getJSONObject(i);
                listOfPos+=(po.get("poNo010") + "\t\t" + po.get("status010")+"\n");
            }
        }
        catch (IOException | JSONException ioException) {
            ioException.printStackTrace();
        }
        pane.setText(listOfPos);
    }
    public static void refreshClientList(JTextPane pane){
        JSONArray clientList = new JSONArray();
        String listOfClients = "Client ID\t\tCompany\t\tCity\t\tMoney Owed\n";

        try {
            clientList = APIRequests.getClientsList();
            for (int i = 0; i < clientList.length(); i++) {
                JSONObject client = clientList.getJSONObject(i);
                listOfClients += (client.get("clientCompId010") + "\t\t" + client.get("clientCompName010") + "\t" + client.get("clientCity010") + "\t\t" + client.get("moneyOwed010") + "\n");
            }
        } catch (IOException | JSONException ioException) {
            ioException.printStackTrace();
        }
        pane.setText(listOfClients);
    }
    public static void refreshPartList(JTextPane pane){
        JSONArray partList = new JSONArray();
        String listOfParts = "Part ID\t\tName\t\tPrice\t\tQuantity\n";

        try {
            partList = APIRequests.getPartsList();
            for (int i = 0; i < partList.length(); i++) {
                JSONObject part = partList.getJSONObject(i);
                listOfParts += (part.get("partNo010") + "\t\t" + part.get("partName010") + "\t\t" + part.get("currentPrice010") + "\t\t" + part.get("qty010") + "\n");
            }
        } catch (IOException | JSONException ioException) {
            ioException.printStackTrace();
        }

        pane.setText(listOfParts);
    }


}

