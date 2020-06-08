package material.tracking;


import app.blockchain.smartcontract.DataItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonali
 */
class SiteUnit implements DataItem
{
     public String ID;
     public String name;
     public String address;
     public String BuilderID;
     
     List<Material> materialList= new ArrayList<>();
}
