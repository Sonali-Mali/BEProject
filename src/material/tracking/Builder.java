package material.tracking;


import app.blockchain.smartcontract.DataItem;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonali
 */
public class Builder implements DataItem
{
     public String ID;
     public String publickey;  //public key
     public String name;
     public String address;
     public String contact;
     public String city;
}
