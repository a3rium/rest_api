package restapi;

import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repos.*;

import java.util.List;

@RestController
public class DBOperators {

    @Autowired
    PartRepo010 partRepository;

    @Autowired
    PORepo010 PORepository;

    @Autowired
    UserRepos010 userRepository;

    @Autowired
    AgentRepo010 agentRepository;

    @Autowired
    POLinesRepo010 POLinesRepo010;
    /*
     *  Inputs: None
     *  Method provides agent with all parts in table
     */
    @GetMapping("/agent/getPartsList")
    public List<Parts010> getPartsListAgent010( ) {
        return partRepository.findAll();
    }

    /*
     *  Inputs: Unique Part Number
     *  Method provides agent with detailed information about a specific part.
     */
    @GetMapping("/agent/getDetailedPart")
    public Parts010 getDetailedPartAgent010(@RequestParam(name = "partNo010") int partNo010) {
        return partRepository.findByPartNo010(partNo010);
    }

    /*
     *  Inputs: Unique Client ID, Part Number, Part Order Number
     *  Method provides client ability to post a new order for a specific client
     */
    @PostMapping(path = "/client/postNewOrder")
    public void postNewOrder(@RequestParam(name = "clientCompId010") int clientCompId010,
                             @RequestParam(name = "partNo010") int partNo010,
                             @RequestParam(name = "poNo010", required = false) Integer poNo010) {
        PORepository.createPo010(clientCompId010, partNo010, poNo010);
    }

    /*
     *  Inputs: Unique Client ID, Part Number, Part Order Number
     *  Method provides client ability to post a new order for a specific client
     */
    @PostMapping(path = "/client/postNewOrderTest")
    public void postNewOrderTest(@RequestBody String newOrderInput) {
        PORepository.createPoTest010(newOrderInput);
    }


    /*
     *  Inputs: None
     *  Method provides agent with all parts in table
     */
    @GetMapping("/client/getPartsList")
    public List<Parts010> getPartsListClient010( ) {
        return partRepository.findAll();
    }

    /*
     *  Inputs: Unique Part Number, New Part Name, New Part Description, New Part Price, New Part Quantity
     * Method provides agent ability to update the information for a specific part.
     */
    @PostMapping("/agent/updatePart")
    public void updatePartName010(@RequestParam(name = "partName010", required = false) String partName010,
                                  @RequestParam(name = "partDescription010", required = false) String partDescription010,
                                  @RequestParam(name = "currentPrice010", required = false) Float partPrice010,
                                  @RequestParam(name = "currentQty010", required = false) Integer partQty010,
                                  @RequestParam(name = "partNo010") int partNo010) {
        partRepository.updatePart010(partName010, partDescription010, partPrice010, partQty010, partNo010);
    }

    /*
     *  Inputs: Current Order Status
     *  Method provides client with ability to cancel a PO.
     */
    @PostMapping("/client/cancelPo")
    public void updatePoStatus010(@RequestParam(name = "poNo010")int poNo010) {
        PORepository.cancelPo010(poNo010);
    }

    /*
     *  Inputs: Order Id, Client Id
     *  Function provides clients with a specific PO using poNo and
     */
    @GetMapping("/client/getDetailedPO")
    public POs010 getDetailedPOClient010(@RequestParam(name = "poNo010") int poNo010,
                                         @RequestParam(name = "clientCompId010") int clientCompID010) {
        return PORepository.findByPoNo010AndClientCompId010(poNo010, clientCompID010);
    }
    /*@GetMapping("/client/getDetailedPOByPoNumber")
    public POs010 getDetailedPOClient010(@RequestParam(name = "poNo010") int poNo010) {
        return PORepository.findByPoId010(poNo010);
    }*/

    /*
     *  Inputs: Client Id
     *  Method provides clients with list of POs created by them
     */
    @GetMapping("/client/getPOList")
    public List<POs010> getPOListClient010(@RequestParam(name = "clientCompId010") int clientCompID010) {
        return PORepository.findByClientCompId010(clientCompID010);
    }

    /*
     * Inputs: None
     * Method gets list of all agents and associated passwords.
     */
    @GetMapping("/agent/getAgentList")
    public List<AgentPasswords010> getAgentList010() {
        return agentRepository.findAll();
    }

    /*
     *  Inputs: None
     *  Method provides agent with all parts in table
     */
    @GetMapping("/agent/getPOList")
    public List<POs010> getPOListAgent010( ) {
        return PORepository.findAll();
    }

    /*
     *  Inputs: Unique Part Number
     *  Method provides agent with detailed information about a specific part.
     */
    @GetMapping("/agent/getDetailedPO")
    public POs010 getDetailedPOAgent010(@RequestParam(name = "poNo010") int poNo010) {
        return PORepository.findByPoNo010(poNo010);
    }

    /*
     *  Inputs: None
     *  Method proves agent with all clients in table
     */
    @GetMapping("/agent/getClientList")
    public List<ClientUser010> getClientListAgent010() {
        return userRepository.findAll();
    }

    /*
     *  Inputs: Unique Client ID
     *  Method provides agent with detailed information about a specific client.
     */
    @GetMapping("/agent/getDetailedClient")
    public ClientUser010 getDetailedClientAgent010(@RequestParam(name = "clientCompId010") int clientCompId010) {
        return userRepository.findByClientCompId010(clientCompId010);
    }

    /*
     *  Inputs: Client Name, Client City, Money Owed, Client Password, Unique Client ID
     *  Method provides agent with ability to update detailed information about a specific client.
     */
    @PostMapping("/agent/updateClient")
    public void updateClient010(@RequestParam(name = "clientCompName010", required = false) String clientCompName010,
                                @RequestParam(name = "clientCity010", required = false) String clientCity010,
                                @RequestParam(name = "moneyOwed010", required = false) Float moneyOwed010,
                                @RequestParam(name = "clientCompPassword010", required = false) String clientCompPassword010,
                                @RequestParam(name = "clientCompId010") int clientCompId010) {
        userRepository.updateClient010(clientCompName010, clientCity010, moneyOwed010, clientCompPassword010, clientCompId010);
    }

    /*
     *  Inputs: Order ID, Current Order Status
     *  Method provides agent with ability to update PO status
     */
    @PostMapping("/agent/updatePoStatus")
    public void updatePoStatus010(@RequestParam(name = "status010", required = false) String status010,
                                  @RequestParam(name = "poNo010") int poNo010) {
        PORepository.updatePoStatus010(status010, poNo010);
    }
    @GetMapping("/client/findPoLines")
    public List<PO_LINES010> getPoLine010(@RequestParam(name = "poNo010") int poNo010) {
        return POLinesRepo010.findByPo(poNo010);
    }
}
