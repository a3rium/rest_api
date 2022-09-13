package ui;

import apirequests.APIRequests;
import org.json.JSONArray;

import javax.lang.model.type.ArrayType;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class ClientPage {

    public static void displayClientPage(JFrame frame, int clientId) throws JSONException, IOException {
        // GET PARTS LIST INFO
        JSONArray partsList = new JSONArray();
        // part names from the db
        ArrayList<String> partNamesArray = new ArrayList<>();
        ArrayList<String> orderNames = new ArrayList<>();
        ArrayList<String> orderQuantities = new ArrayList<>();

        try {
            partsList = APIRequests.getPartsList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < partsList.length(); i++) {
            partNamesArray.add(partsList.getJSONObject(i).get("partName010").toString());
        }

        int maxParts = 1000;

        JButton addPartBtn = new JButton("add part");
        JLabel selectPartLbl = new JLabel("Part:");
        JComboBox selectPartComboBox = new JComboBox(partNamesArray.toArray());
        JLabel purchaseOrderNumLbl = new JLabel("Enter a part order number:");
        JTextField purchaseOrderNumTxt = new JTextField("part order number");
        JButton enterOrderNumBtn = new JButton("enter");
        JLabel selectQtyLbl = new JLabel("Quantity:");
        SpinnerModel partCountModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner partCountSpinner = new JSpinner(partCountModel);
        JButton submitPOBtn = new JButton("submit order");
        DefaultListModel<String> partOrderListModel = new DefaultListModel<>();
        JList<String> partOrderList = new JList<>(partOrderListModel);
        DefaultListModel<String> orderDetailsListModel = new DefaultListModel<>();
        JList<String> orderDetailsList = new JList<>(orderDetailsListModel);
        JButton listClientPOsBtn = new JButton("list purchase orders");
        DefaultListModel<String> clientOrdersListModel = new DefaultListModel<>();
        JList<String> clientOrdersList = new JList<>(clientOrdersListModel);
        JButton logoutBtn = new JButton("log out");

        addPartBtn.setBounds(150,130,100, 30);
        selectPartLbl.setBounds(50,50,100, 30);
        selectPartComboBox.setBounds(150,50,100, 30);
        purchaseOrderNumLbl.setBounds(50,270,200, 30);
        purchaseOrderNumTxt.setBounds(50,300,150, 30);
        enterOrderNumBtn.setBounds(220,300,80, 30);
        selectQtyLbl.setBounds(50,90,100, 30);
        partCountSpinner.setBounds(150,90,100, 30);
        submitPOBtn.setBounds(60,200,150, 30);
        partOrderList.setBounds(300,50,300, 200);
        orderDetailsList.setBounds(50,350,250, 200);
        listClientPOsBtn.setBounds(350,300,250, 30);
        clientOrdersList.setBounds(350,350,250, 200);
        logoutBtn.setBounds(500,10,100, 30);

        addPartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                partOrderListModel.addElement(selectPartComboBox.getSelectedItem().toString() + " x " + partCountSpinner.getValue().toString());
                orderNames.add(selectPartComboBox.getSelectedItem().toString());
                orderQuantities.add(partCountSpinner.getValue().toString());
            }
        });

        listClientPOsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JSONArray poList = new JSONArray();
                JSONArray clientList = new JSONArray();
                clientOrdersListModel.removeAllElements();
                try {
                    poList = APIRequests.getPartOrderListForClient(clientId);
                    clientList = APIRequests.getClientsList();
                    for (int i = 0; i < poList.length(); i++) {
                        JSONObject po = poList.getJSONObject(i);
                        clientOrdersListModel.addElement("poNo: " + po.get("poNo010") + "  status: " + po.get("status010"));
                    }

                    for (int i = 0; i < clientList.length(); i++) {
                        JSONObject client = clientList.getJSONObject(i);

                        if (client.get("clientCompId010").toString().equals((String.valueOf(clientId)))) {
                            clientOrdersListModel.addElement("money owed: " + client.get("moneyOwed010"));
                        }
                    }

                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JSONArray finalPartsList = partsList;
        ArrayList<String> partsArrayList = new ArrayList<>();
        submitPOBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < orderNames.size(); i++) {
                    for (int j = 0; j < finalPartsList.length(); j++) {
                        if (finalPartsList.getJSONObject(j).get("partName010").equals(orderNames.get(i))) {
                            for (int k = 0; k < Integer.parseInt(orderQuantities.get(i)); k++) {
                                partsArrayList.add(finalPartsList.getJSONObject(j).get("partNo010").toString());
                            }
                        }
                    }
                }
                String inputJson = "{\n\t\"clientCompId010\": \""+clientId+"\",\n\t\"partsList010\": \"[";
                for (int i = 0; i < partsArrayList.size(); i++) {
                    inputJson+=partsArrayList.get(i);
                    if (i!=partsArrayList.size()-1)
                        inputJson+=",";
                }
                inputJson+="]\"\n}";
                System.out.println(partsArrayList);
                System.out.println(inputJson);
                try {
                    APIRequests.createNewPoTest(inputJson);
                } catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
            }
        });

        enterOrderNumBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JSONArray poList = new JSONArray();
                JSONArray poLineList = new JSONArray();

                try {
                    poList = APIRequests.getPartOrderListForClient(clientId);
                        for (int i = 0; i < poList.length(); i++) {
                            JSONObject po = poList.getJSONObject(i);
                            poLineList = APIRequests.getPartOrderLine(Integer.valueOf(po.get("poNo010").toString()));
                            JSONObject poLine=poLineList.getJSONObject(i);
                            if (po.get("poNo010").toString().equals(purchaseOrderNumTxt.getText()) && poLine.getJSONObject("po").get("poNo010").toString().equals(purchaseOrderNumTxt.getText())){
                                orderDetailsListModel.removeAllElements();
                                orderDetailsListModel.addElement("PoNo: " + po.get("poNo010"));
                                orderDetailsListModel.addElement("Price: " + poLine.get("linePrice010"));
                                orderDetailsListModel.addElement("Date: " + po.get("datePO010"));
                                orderDetailsListModel.addElement("Status: " + po.get("status010"));
                                break;
                            } else {
                                orderDetailsListModel.removeAllElements();
                                orderDetailsListModel.addElement("Please enter a valid PO number");
                            }
                        }
                    }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                addPartBtn.setVisible(false);
                submitPOBtn.setVisible(false);
                selectPartLbl.setVisible(false);
                selectPartComboBox.setVisible(false);
                selectQtyLbl.setVisible(false);
                partCountSpinner.setVisible(false);
                partOrderList.setVisible(false);
                clientOrdersList.setVisible(false);
                purchaseOrderNumLbl.setVisible(false);
                enterOrderNumBtn.setVisible(false);
                listClientPOsBtn.setVisible(false);
                orderDetailsList.setVisible(false);
                purchaseOrderNumTxt.setVisible(false);
                logoutBtn.setVisible(false);


                frame.dispose();
                LoginPage.displayLoginPage();
            }
        });

        frame.add(addPartBtn);
        frame.add(submitPOBtn);
        frame.add(selectPartLbl);
        frame.add(selectPartComboBox);
        frame.add(selectQtyLbl);
        frame.add(partCountSpinner);
        frame.add(partOrderList);
        frame.add(clientOrdersList);
        frame.add(purchaseOrderNumLbl);
        frame.add(enterOrderNumBtn);
        frame.add(listClientPOsBtn);
        frame.add(orderDetailsList);
        frame.add(purchaseOrderNumTxt);
        frame.add(logoutBtn);

        frame.pack();
        frame.setSize(700,700);
        frame.setLayout(null);
        frame.setVisible(true);

    }
}
